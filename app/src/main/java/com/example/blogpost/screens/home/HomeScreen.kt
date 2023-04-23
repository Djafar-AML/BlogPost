package com.example.blogpost.screens.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.blogpost.screens.home.vm.HomeViewModel
import com.example.blogpost.screens.state.UiResourceState
import com.example.domain.model.Blogs


@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel()
) {


    val homeState: UiResourceState<List<Blogs.Blog>> = viewModel.blogs.value


    if (homeState.isLoading) {
        Box(modifier = Modifier.fillMaxSize()) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }

    if (homeState.error.isNotBlank()) {
        Box(modifier = Modifier.fillMaxSize()) {
            Text(
                text = homeState.error, modifier = Modifier.align(
                    Alignment.Center
                )
            )
        }
    }

    if (homeState.data?.isNotEmpty() == true) {

        LazyColumn {
            items(homeState.data) { blog ->
                BlogItem(blog) { blogId ->
                    navController.navigate("Details/$blogId")
                }
            }
        }
    }

}

@Composable
fun BlogItem(blog: Blogs.Blog, blogClickListener: (String) -> Unit) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { blogClickListener(blog.id) },
        verticalArrangement = Arrangement.Center
    ) {

        // region profile image
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            CircularImage(
                50.dp,
                50.dp,
                25.dp, blog.owner.picture
            )

            Spacer(modifier = Modifier.width(6.dp))

            Text(text = "${blog.owner.firstName} ${blog.owner.lastName}")

        }
        // endregion

        AsyncImage(
            model = blog.image,
            contentDescription = "Blog Picture",
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .padding(4.dp),
            contentScale = ContentScale.Crop,
        )

        Text(
            text = blog.text,
            modifier = Modifier.padding(12.dp),
            style = TextStyle(color = Color.Gray, fontSize = 20.sp)
        )

        Divider()

    }
}

@Composable
fun CircularImage(width: Dp, height: Dp, radius: Dp, imageUrl: String) {

    Card(
        modifier = Modifier
            .width(width)
            .height(height),
        shape = RoundedCornerShape(radius)
    ) {
        AsyncImage(
            model = imageUrl,
            contentDescription = "Blog Picture",
            modifier = Modifier
                .size(200.dp)
                .padding(4.dp),
            contentScale = ContentScale.Crop,
        )
    }

}