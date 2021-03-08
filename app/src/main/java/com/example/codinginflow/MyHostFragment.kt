package com.example.codinginflow

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_host.*

class MyHostFragment: Fragment(R.layout.fragment_host) {

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
        setUpTabLayoutMediator(fragmentsNameList, host_gadget_tab, host_gadget_view_pager)

    }

    private fun setUpViewPagerAdapter(list: ArrayList<Fragment>) {
        host_gadget_view_pager.adapter = MyPagerAdapter(list, childFragmentManager, lifecycle)
        host_gadget_view_pager.isUserInputEnabled = false
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

}

