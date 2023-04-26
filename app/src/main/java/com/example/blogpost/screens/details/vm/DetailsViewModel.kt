package com.example.blogpost.screens.details.vm

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.blogpost.screens.state.UiResourceState
import com.example.blogpost.util.localizeErrorMessage
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

    private val _blogDetailsState = mutableStateOf(UiResourceState<Blogs.Blog>())
    val blogDetails: State<UiResourceState<Blogs.Blog>> = _blogDetailsState

    init {
        savedStateHandle.getLiveData<String>("blogId").value?.let { blogId ->
            getBlogDetails(blogId)
        }
    }

    private fun getBlogDetails(blogId: String) {

        blogDetailsUseCase(blogId).onEach { resource: Resource<Blogs.Blog> ->

            when (resource) {

                is Resource.Loading -> {
                    _blogDetailsState.value = UiResourceState(isLoading = true)
                }

                is Resource.Success -> {
                    _blogDetailsState.value = UiResourceState(data = resource.data)
                }

                is Resource.Error -> {

                    val errorMessage = localizeErrorMessage(resource.errorEntity)
                    _blogDetailsState.value = UiResourceState(error = errorMessage)
                }
            }

        }.launchIn(viewModelScope)

    }

}