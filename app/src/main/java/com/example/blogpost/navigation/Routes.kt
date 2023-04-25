package com.example.blogpost.navigation

sealed class Routes(val route: String) {

    object Home : Routes("Home")
    object DetailsScreen : Routes("Details/{blogId}")

}
