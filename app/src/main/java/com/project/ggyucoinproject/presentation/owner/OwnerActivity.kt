package com.project.ggyucoinproject.presentation.owner

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.project.ggyucoinproject.R
import com.project.ggyucoinproject.databinding.ActivityOwnerBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OwnerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil
            .setContentView<ActivityOwnerBinding>(this, R.layout.activity_owner)

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.navHostFragment)
        val appBarConfiguration = AppBarConfiguration(setOf(R.id.splashFragment, R.id.mainFragment))
        binding.toolbar.setupWithNavController(navController, appBarConfiguration)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.navHostFragment)
        return navController.navigateUp()
    }
}