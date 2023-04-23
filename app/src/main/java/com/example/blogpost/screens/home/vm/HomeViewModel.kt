package com.example.blogpost.screens.home.vm

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.blogpost.screens.state.UiResourceState
import com.example.common.util.Resource
import com.example.domain.model.Blogs
import com.example.domain.use_cases.GetBlogsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getBlogsUseCase: GetBlogsUseCase
) : ViewModel() {

    private val _blogs = mutableStateOf(UiResourceState<List<Blogs.Blog>>())
    val blogs: State<UiResourceState<List<Blogs.Blog>>> = _blogs

    init {
        getBlogs()
    }

    private fun getBlogs() {

        getBlogsUseCase().onEach { resource ->

            when (resource) {
                is Resource.Loading -> {
                    _blogs.value = UiResourceState(isLoading = true)
                }

                is Resource.Success -> {
                    _blogs.value = UiResourceState(data = resource.data)
                }
                is Resource.Error -> {
                    _blogs.value = UiResourceState(error = resource.message.toString())
                }
            }
        }.launchIn(viewModelScope)

    }

}