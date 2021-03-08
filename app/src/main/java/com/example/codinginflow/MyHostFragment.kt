package com.example.codinginflow

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment

class MyHostFragment: Fragment(),MyFragment_1.OnFragment_1 ,MyFragment_2.OnFragment_2 {

    private lateinit var fragment1: MyFragment_1
    private lateinit var fragment2: MyFragment_2

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        fragment1 = MyFragment_1()
        fragment2 = MyFragment_2()
        childFragmentManager.beginTransaction().replace(R.id.container_fragment_1 ,fragment1).replace(R.id.container_fragment_2 ,fragment2).commit()
    }

    override fun data_1(text: String) {
        fragment2.setText_2(text)
    }

    override fun data_2(message: String) {
        fragment1.setText_1(message)
    }
}