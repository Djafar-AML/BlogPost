package com.example.data.mapper

import com.example.data.network.model.BlogsDTO
import com.example.domain.model.Blogs

fun BlogsDTO.BlogDTO.OwnerDTO.toDomain(): Blogs.Blog.Owner {
    return Blogs.Blog.Owner(id, title, firstName, lastName, picture)
}