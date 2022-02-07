package com.example.accesointernet.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.accesointernet.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private val viewModel: FirstViewModel by lazy {
        ViewModelProvider(this).get(FirstViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentFirstBinding.inflate(inflater)
        binding.lifecycleOwner = this

        binding.viewModel = viewModel
        return binding.root
    }


}