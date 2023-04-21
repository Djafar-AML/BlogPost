package com.example.data.network.model

data class BlogsDTO(
    val data: List<BlogDTO> = listOf(),
    val total: Int = 0,
    val page: Int = 0,
    val limit: Int = 0
) {
    data class BlogDTO(
        val id: String = "",
        val image: String = "",
        val likes: Int = 0,
        val tags: List<String> = listOf(),
        val text: String = "",
        val publishDate: String = "",
        val owner: OwnerDTO = OwnerDTO()
    ) {
        data class OwnerDTO(
            val id: String = "",
            val title: String = "",
            val firstName: String = "",
            val lastName: String = "",
            val picture: String = ""
        )
    }
}