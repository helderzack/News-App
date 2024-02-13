package com.helder.newsapp.ui.fragment.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.helder.newsapp.databinding.NewsItemBinding
import com.helder.newsapp.model.News
import com.helder.newsapp.service.listener.OnCardClickListener

class NewsViewHolder(private val binding: NewsItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(news: News, listener: OnCardClickListener)  {
        binding.textHeadline.text = news.headline
        binding.textSubtitle.text = news.subtitle
        binding.textSource.text = news.source
        binding.textNewsDate.text = news.dateOfPublication.toString()

        binding.cardArticle.setOnClickListener {
            listener.onCardClick()
        }
    }

}