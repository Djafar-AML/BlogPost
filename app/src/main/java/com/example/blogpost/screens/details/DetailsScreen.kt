package com.example.blogpost.screens.details

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.blogpost.screens.details.vm.DetailsViewModel
import com.example.blogpost.screens.home.BlogItem


@OptIn(ExperimentalLayoutApi::class)
@Composable
fun DetailsScreen(detailsViewModel: DetailsViewModel = hiltViewModel()) {

    val detailsReState = detailsViewModel.blogDetails.value

    if (detailsReState.isLoading) {
        Box(modifier = Modifier.fillMaxSize()) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }

    if (detailsReState.error.isNotBlank()) {
        Box(modifier = Modifier.fillMaxSize()) {
            Text(text = detailsReState.error, modifier = Modifier.align(Alignment.Center))
        }
    }

    if (detailsReState.data != null) {

        Column {

            BlogItem(blog = detailsReState.data, blogClickListener = {})

            Text(text = "${detailsReState.data.likes} Likes ", modifier = Modifier.padding(12.dp))

            FlowRow {
                detailsReState.data.tags.forEach { tag ->
                    TagItem(tag = tag)
                }
            }
        }
    }

}

@Composable
fun TagItem(tag: String) {

    Card(
        modifier = Modifier
            .wrapContentHeight()
            .wrapContentWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(20.dp),
        border = BorderStroke(1.dp, Color.Gray)
    ) {
        Text(text = tag, style = TextStyle(color = Color.Black), modifier = Modifier.padding(12.dp))
    }
}