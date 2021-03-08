package com.example.codinginflow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.codinginflow.databinding.FragmentMain1Binding

class MyFragment_1: Fragment() {

    private var _binding: FragmentMain1Binding? = null
    private val binding get() = _binding
    private var listener: OnFragment_1? = null

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

        if (parentFragment is MyFragment_1.OnFragment_1) listener = parentFragment as OnFragment_1
        binding?.btnFragment1?.setOnClickListener { listener?.data_1(binding?.txtFragment1?.text.toString()) }
    }

    fun setText_1(text: String){
        binding?.txtFragment1?.setText(text)
    }

    interface OnFragment_1{
        fun data_1(text: String)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}