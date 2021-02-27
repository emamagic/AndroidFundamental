package com.example.codinginflow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.example.codinginflow.databinding.ActivityMainBinding
import com.example.codinginflow.databinding.FragmentMain1Binding

class MainActivity : AppCompatActivity() ,MyFragment_1.OnFragment_1 ,MyFragment_2.OnFragment_2 {

    private lateinit var fragment1: MyFragment_1
    private lateinit var fragment2: MyFragment_2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fragment1 = MyFragment_1()
        fragment2 = MyFragment_2()
        supportFragmentManager.beginTransaction().replace(R.id.container_fragment_1 ,fragment1).replace(R.id.container_fragment_2 ,fragment2).commit()
    }

    override fun data_1(text: String) {
        Toast.makeText(this, "sss", Toast.LENGTH_SHORT).show()
       fragment2.setText_2(text)
    }

    override fun data_2(message: String) {
        fragment1.setText_1(message)
    }


}