package com.helder.newsapp.model

import java.time.LocalDateTime

data class News(
    val imgUrl: String,
    val headline: String,
    val subtitle: String,
    val dateOfPublication: LocalDateTime,
    val source: String
)