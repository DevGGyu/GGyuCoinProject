package com.project.ggyucoinproject.presentation.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.project.ggyucoinproject.R
import com.project.ggyucoinproject.databinding.FragmentSplashBinding
import com.project.ggyucoinproject.presentation.owner.OwnerViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class SplashFragment : Fragment() {

    private val mVM: OwnerViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentSplashBinding.inflate(inflater)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mVM.domains.observe(viewLifecycleOwner) {
            findNavController().navigate(R.id.action_splashFragment_to_mainFragment)
        }
    }

    override fun onResume() {
        super.onResume()
        (requireActivity() as AppCompatActivity).supportActionBar?.hide()
    }

    override fun onStop() {
        super.onStop()
        (requireActivity() as AppCompatActivity).supportActionBar?.show()
    }
}