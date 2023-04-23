package com.example.data.mapper

import com.example.data.network.model.BlogsDTO
import com.example.domain.model.Blogs


fun BlogsDTO.BlogDTO.toDomain(): Blogs.Blog {
    return Blogs.Blog(id, image, likes, tags, text, publishDate, owner.toDomain())
}