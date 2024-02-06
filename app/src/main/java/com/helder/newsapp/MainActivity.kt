package com.helder.newsapp

import android.os.Bundle
import android.view.MenuItem
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

        val navHostFragment =
            supportFragmentManager.findFragmentById(binding.fragmentContainerView.id)
                    as NavHostFragment
        navController = navHostFragment.navController

        binding.bottomNavigationView.setOnItemSelectedListener(this)
        binding.bottomNavigationView.setOnItemReselectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.headlines_action -> {
                navController.navigate(R.id.headlines_destination)
            }

            R.id.favourites_action -> {
                navController.navigate(R.id.favourites_destination)
            }

            R.id.search_action -> {
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