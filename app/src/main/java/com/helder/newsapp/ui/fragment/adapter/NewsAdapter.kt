package com.helder.newsapp.ui.fragment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.helder.newsapp.databinding.NewsItemBinding
import com.helder.newsapp.model.News
import com.helder.newsapp.ui.fragment.viewholder.NewsViewHolder

class NewsAdapter(private val newsList: List<News>): RecyclerView.Adapter<NewsViewHolder>() {

    private lateinit var binding: NewsItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        binding = NewsItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NewsViewHolder(binding)
    }

    override fun getItemCount(): Int = newsList.size

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(newsList[position])
    }

}