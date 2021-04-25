package com.project.ggyucoinproject.presentation.owner

import android.os.Bundle
import android.view.Menu
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.project.ggyucoinproject.R
import com.project.ggyucoinproject.databinding.ActivityOwnerBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class OwnerActivity : AppCompatActivity() {

    private val mVM: OwnerViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil
            .setContentView<ActivityOwnerBinding>(this, R.layout.activity_owner)

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.navHostFragment)
        val appBarConfiguration = AppBarConfiguration(setOf(R.id.splashFragment, R.id.mainFragment))
        binding.toolbar.setupWithNavController(navController, appBarConfiguration)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        if (menu == null) return false

        menuInflater.inflate(R.menu.menu, menu)
        val sv = menu.findItem(R.id.coin_search).actionView as SearchView
        sv.setOnQueryTextListener(object : androidx.appcompat.widget.SearchView.OnQueryTextListener,
            SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return true
            }
        })
        return true
    }
}