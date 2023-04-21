package com.example.blogpost.screens.home.vm

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.blogpost.screens.home.HomeState
import com.example.common.util.Resource
import com.example.domain.use_cases.GetBlogsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getBlogsUseCase: GetBlogsUseCase
) : ViewModel() {

    private val _blogs = mutableStateOf(HomeState())
    val blogs: State<HomeState> = _blogs

    init {
        getBlogs()
    }

    private fun getBlogs() {

        getBlogsUseCase().onEach { resource ->

            when (resource) {
                is Resource.Loading -> {
                    _blogs.value = HomeState(isLoading = true)
                }

                is Resource.Success -> {
                    _blogs.value = HomeState(data = resource.data)
                }
                is Resource.Error -> {
                    _blogs.value = HomeState(error = resource.message.toString())
                }
            }
        }.launchIn(viewModelScope)

    }

}