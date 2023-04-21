package com.example.domain.model

data class Blogs(
    val data: List<Blog> = listOf(),
    val total: Int = 0,
    val page: Int = 0,
    val limit: Int = 0
) {
    data class Blog(
        val id: String = "",
        val image: String = "",
        val likes: Int = 0,
        val tags: List<String> = listOf(),
        val text: String = "",
        val publishDate: String = "",
        val owner: Owner = Owner()
    ) {
        data class Owner(
            val id: String = "",
            val title: String = "",
            val firstName: String = "",
            val lastName: String = "",
            val picture: String = ""
        )
    }
}
