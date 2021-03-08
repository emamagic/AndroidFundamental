package com.example.codinginflow.factory

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.example.codinginflow.MyFragment_3

class MyFragmentFactory(private val text: String) : FragmentFactory() {

    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return when (className) {
            MyFragment_3::class.java.name -> MyFragment_3(text)
            else -> super.instantiate(classLoader, className)
        }

    }

}