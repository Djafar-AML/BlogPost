package com.example.blogpost.navigation

sealed class NavigationItem(val route: String) {

    object Home : NavigationItem("Home")
    object DetailsScreen : NavigationItem("Details/{blogId}")

}
