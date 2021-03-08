package com.example.codinginflow

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment

class MyFragment_2: Fragment(R.layout.fragment_main) {

    private var text: String? = ""

    companion object{
        fun newInstance(text: String): MyFragment_2{
            val args = Bundle()
            args.putString("text" ,text)
            val fragment = MyFragment_2()
            fragment.arguments = args
            return fragment
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        text = arguments?.getString("text" ,"null")
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Toast.makeText(requireContext(), text, Toast.LENGTH_SHORT).show()
    }
}