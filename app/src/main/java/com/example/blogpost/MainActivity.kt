package com.example.blogpost

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.blogpost.navigation.Routes
import com.example.blogpost.screens.details.DetailsScreen
import com.example.blogpost.screens.home.HomeScreen
import com.example.blogpost.ui.theme.BlogPostTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BlogPostTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()

                    BlogApp {
                        NavHost(
                            navController = navController,
                            startDestination = Routes.Home.route
                        ) {

                            composable(Routes.Home.route) {
                                HomeScreen(navController)
                            }

                            composable(Routes.DetailsScreen.route) {
                                DetailsScreen()
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun BlogApp(content: @Composable () -> Unit) {
    content()
}
