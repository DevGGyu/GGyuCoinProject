package com.project.ggyucoinproject.presentation.owner

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.project.ggyucoinproject.R
import com.project.ggyucoinproject.databinding.ActivityOwnerBinding

class OwnerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil
            .setContentView<ActivityOwnerBinding>(this, R.layout.activity_owner)

        setSupportActionBar(binding.toolbar)
    }
}