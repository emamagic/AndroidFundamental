package com.example.codinginflow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.codinginflow.databinding.FragmentHostBinding
import com.example.codinginflow.databinding.FragmentMain1Binding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class HostFragment: Fragment() {

    private var _binding: FragmentHostBinding? = null
    private val binding get() = _binding

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
        val fragments = arrayListOf(
            MyFragment_1(),
            MyFragment_2()
        )
        val fragmentsNameList = arrayListOf(
            "fragment_1",
            "fragment_2"
        )
        setUpViewPagerAdapter(fragments)
        setUpTabLayoutMediator(fragmentsNameList, binding?.hostGadgetTab!!,binding?.hostGadgetViewPager!!)

    }
    private fun setUpViewPagerAdapter(list: ArrayList<Fragment>) {
        binding?.hostGadgetViewPager?.adapter = MyPagerAdapter(list, parentFragmentManager, lifecycle)
        binding?.hostGadgetViewPager?.isUserInputEnabled = false
    }

    private fun setUpTabLayoutMediator(
        fragmentNameList: ArrayList<String>,
        tabLayout: TabLayout,
        viewPager: ViewPager2
    ) {
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = fragmentNameList[position]
        }.attach()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}