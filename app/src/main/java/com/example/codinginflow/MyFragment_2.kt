package com.example.codinginflow

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.codinginflow.databinding.FragmentMain2Binding


class MyFragment_2: Fragment() {

    private var _binding: FragmentMain2Binding? = null
    private val binding get() = _binding
    private var listener: OnFragment_2? = null


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

        if (parentFragment is OnFragment_2) listener = parentFragment as OnFragment_2
        binding?.btnFragment2?.setOnClickListener { listener?.data_2(binding?.txtFragment2?.text.toString()) }
    }

    fun setText_2(text: String){
        binding?.txtFragment2?.setText(text)
    }

    interface OnFragment_2{
        fun data_2(message: String)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}