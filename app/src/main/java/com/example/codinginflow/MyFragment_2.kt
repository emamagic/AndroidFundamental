package com.example.codinginflow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.codinginflow.databinding.FragmentMain2Binding

class MyFragment_2: Fragment() {

    private var _binding: FragmentMain2Binding? = null
    private val binding
    get() = _binding
    private var sharedViewModel: SharedViewModel? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMain2Binding.inflate(inflater ,container ,false)
        return _binding?.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.btnFragment2?.setOnClickListener { sharedViewModel?.setText(binding?.txtFragment2?.text.toString()) }
        sharedViewModel = ViewModelProviders.of(requireActivity()).get(SharedViewModel::class.java)
        sharedViewModel?.text?.observe(viewLifecycleOwner){
            binding?.txtFragment2?.setText(it)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}