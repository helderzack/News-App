package com.helder.newsapp.model.repository

import com.helder.newsapp.model.News
import java.time.LocalDateTime

class MockNewsRepository {

    companion object {

        fun getNews(): List<News> {
            return listOf(
                News(
                    "",
                    "Neque porro quisquam quia dolor sit amet, consectetur, adipisci...",
                    "Neque porro quisquam quia dolor sit amet, consectetur, adipisci...",
                    LocalDateTime.now(),
                    "Variety"
                ),

                News(
                    "",
                    "Neque porro quisquam quia dolor sit amet, consectetur, adipisci...",
                    "Neque porro quisquam quia dolor sit amet, consectetur, adipisci...",
                    LocalDateTime.now(),
                    "CNN"
                ),

                News(
                    "",
                    "Neque porro quisquam quia dolor sit amet, consectetur, adipisci...",
                    "Neque porro quisquam quia dolor sit amet, consectetur, adipisci...",
                    LocalDateTime.now(),
                    "Association Press"
                ),

                News(
                    "",
                    "Neque porro quisquam quia dolor sit amet, consectetur, adipisci...",
                    "Neque porro quisquam quia dolor sit amet, consectetur, adipisci...",
                    LocalDateTime.now(),
                    "Globo.com"
                )
            )
        }

    }

}