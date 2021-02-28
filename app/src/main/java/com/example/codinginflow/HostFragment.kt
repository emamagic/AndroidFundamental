package com.example.codinginflow

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.viewpager2.widget.ViewPager2
import com.example.codinginflow.databinding.FragmentHostBinding
import com.example.codinginflow.databinding.FragmentMain1Binding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class HostFragment: Fragment() {

    private var _binding: FragmentHostBinding? = null
    private val binding get() = _binding
    private var test: Test? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHostBinding.inflate(inflater ,container ,false)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       binding?.test?.setOnClickListener {
           test?.test()
       }
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        Toast.makeText(requireContext(), "b attach", Toast.LENGTH_SHORT).show()
        if (context is Test){
            test = context
            Toast.makeText(requireContext(), "a attach", Toast.LENGTH_SHORT).show()

        }
    }

    interface Test{
        fun test()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}