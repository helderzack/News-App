package com.helder.newsapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.helder.newsapp.databinding.FragmentHeadlinesBinding
import com.helder.newsapp.ui.fragment.adapter.NewsAdapter
import com.helder.newsapp.ui.fragment.viewmodel.HeadlinesViewModel

class HeadlinesFragment: Fragment() {

    private var _binding: FragmentHeadlinesBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: HeadlinesViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHeadlinesBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(this)[HeadlinesViewModel::class.java]

        val newsList = viewModel.getNews()
        binding.recyclerViewNews.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewNews.adapter = NewsAdapter(newsList)

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}