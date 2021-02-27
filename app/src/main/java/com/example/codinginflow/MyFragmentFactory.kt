package com.example.codinginflow

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner

class MyFragmentFactory(private val text: String): FragmentFactory() {

    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return when(className){
            MyFragment::class.java.name -> MyFragment(text)
            else -> super.instantiate(classLoader, className)
        }


    }

}