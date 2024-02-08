package com.helder.newsapp

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.google.android.material.navigation.NavigationBarView
import com.helder.newsapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), NavigationBarView.OnItemSelectedListener,
    NavigationBarView.OnItemReselectedListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if(Intent.ACTION_SEARCH == intent.action) {
            intent.getStringExtra(SearchManager.QUERY)?.also {query ->
                doSearch(query)
            }
        }

        val navHostFragment =
            supportFragmentManager.findFragmentById(binding.fragmentContainerView.id)
                    as NavHostFragment
        navController = navHostFragment.navController

        binding.bottomNavigationView.setOnItemSelectedListener(this)
        binding.bottomNavigationView.setOnItemReselectedListener(this)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        (menu?.findItem(R.id.search_bar)?.actionView as SearchView).apply {
            setSearchableInfo(searchManager.getSearchableInfo(componentName))
            isIconifiedByDefault = false
        }

        return true
    }

    private fun doSearch(query: String) {
        Log.d("SEARCH_QUERY", query)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.headlines_action -> {
                binding.textSectionTitle.text = getString(R.string.headlines_section_title)
                navController.navigate(R.id.headlines_destination)
            }

            R.id.favourites_action -> {
                binding.textSectionTitle.text = getString(R.string.favourites_section_title)
                navController.navigate(R.id.favourites_destination)
            }

            R.id.search_action -> {
                binding.textSectionTitle.text = getString(R.string.search_section_title)
                navController.navigate(R.id.search_destination)
            }
        }

        return true
    }

    override fun onNavigationItemReselected(item: MenuItem) {
        when (item.itemId) {
            R.id.headlines_action -> {
                Toast.makeText(this, "Already in Headlines section!", Toast.LENGTH_SHORT).show()
            }

            R.id.favourites_action -> {
                Toast.makeText(this, "Already in Favourites section!", Toast.LENGTH_SHORT).show()
            }

            R.id.search_action -> {
                Toast.makeText(this, "Already in Search section!", Toast.LENGTH_SHORT).show()
            }
        }
    }

}