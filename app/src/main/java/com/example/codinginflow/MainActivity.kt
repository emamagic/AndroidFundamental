package com.example.codinginflow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.example.codinginflow.databinding.ActivityMainBinding
import com.example.codinginflow.databinding.FragmentMain1Binding

class MainActivity : AppCompatActivity()  {

    private lateinit var fragment1: MyFragment_1
    private lateinit var fragment2: MyFragment_2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null){
            fragment1 = MyFragment_1()
            fragment2 = MyFragment_2()
            supportFragmentManager.beginTransaction().replace(R.id.container_fragment_1 ,fragment1).replace(R.id.container_fragment_2 ,fragment2).commit()
        }

    }


}