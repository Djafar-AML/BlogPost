package com.example.data.mapper

import com.example.data.network.model.BlogsDTO
import com.example.domain.model.Blogs


fun List<BlogsDTO.BlogDTO>.toDomain(): List<Blogs.Blog> {

    return map {
        Blogs.Blog(
            id = it.id,
            image = it.image,
            likes = it.likes,
            tags = it.tags,
            text = it.text,
            publishDate = it.publishDate,
            owner = it.owner.toDomain()
        )
    }
}