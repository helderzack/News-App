package com.helder.newsapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.helder.newsapp.databinding.FragmentSearchBinding
import com.helder.newsapp.service.listener.OnCardClickListener
import com.helder.newsapp.ui.fragment.adapter.NewsAdapter
import com.helder.newsapp.ui.fragment.viewmodel.SearchViewModel

class SearchFragment : Fragment() {

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: SearchViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(this)[SearchViewModel::class.java]
        val newsList = viewModel.getNews()

        binding.recyclerViewSearch.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewSearch.adapter = NewsAdapter(newsList, object : OnCardClickListener {
            override fun onCardClick() {
                val action = SearchFragmentDirections.actionSearchDestinationToArticleDestination()
                findNavController().navigate(action)
            }

        })

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}