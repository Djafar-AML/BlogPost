package com.example.blogpost.screens.details.vm

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.blogpost.screens.state.ResourceState
import com.example.common.util.Resource
import com.example.domain.model.Blogs
import com.example.domain.use_cases.BlogDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val blogDetailsUseCase: BlogDetailsUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _blogDetailsState = mutableStateOf(ResourceState<Blogs.Blog>())
    val blogDetails: State<ResourceState<Blogs.Blog>> = _blogDetailsState

    init {
        savedStateHandle.getLiveData<String>("blogId").value?.let { blogId ->
            getBlogDetails(blogId)
        }
    }

    private fun getBlogDetails(blogId: String) {

        blogDetailsUseCase(blogId).onEach { blogResource ->

            when (blogResource) {
                is Resource.Loading -> {
                    _blogDetailsState.value = ResourceState(isLoading = true)
                }
                is Resource.Success -> {
                    _blogDetailsState.value = ResourceState(data = blogResource.data)
                }
                is Resource.Error -> {
                    _blogDetailsState.value = ResourceState(error = blogResource.message.toString())
                }
            }

        }.launchIn(viewModelScope)

    }
}