package com.helder.newsapp.ui.fragment.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.helder.newsapp.model.News
import com.helder.newsapp.model.repository.MockNewsRepository

class SearchViewModel(application: Application) : AndroidViewModel(application) {

    fun getNews(): List<News> {
        return MockNewsRepository.getNews()
    }
    
}