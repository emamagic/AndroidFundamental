package com.example.codinginflow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProviders
import com.example.codinginflow.databinding.FragmentMain1Binding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MyFragment_1: Fragment() {

    private val sharedViewModel: SharedViewModel by activityViewModels()
    private var _binding: FragmentMain1Binding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMain1Binding.inflate(inflater ,container ,false)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.btnFragment1?.setOnClickListener { sharedViewModel.setText(binding?.txtFragment1?.text.toString()) }
        sharedViewModel.text.observe(viewLifecycleOwner){
            binding?.txtFragment1?.setText(it)
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}