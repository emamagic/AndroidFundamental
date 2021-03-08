package com.example.codinginflow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.commit
import com.example.codinginflow.factory.MyFragmentFactory
import com.example.codinginflow.util.Utility.timery
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.e("TAG", "onCreate savedInstanceState: $savedInstanceState")
        supportFragmentManager.fragmentFactory = MyFragmentFactory("hello world")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null){
            Log.e("TAG", "savedInstanceState is null")
            timery(3000){
                // passDate_1()
                // passDate_2()
                passDate_3()
            }
        }


    }

    private fun passDate_1(){
        val myFragment = MyFragment_1()
        val bundle = Bundle()
        bundle.putString("text" ,"hello world")
        myFragment.arguments = bundle
        supportFragmentManager.beginTransaction().setReorderingAllowed(true).replace(R.id.fragment_container ,myFragment).commit()
    }

    private fun passDate_2(){
        val mFragment = MyFragment_2.newInstance("hello world")
        supportFragmentManager.beginTransaction().setReorderingAllowed(true).replace(R.id.fragment_container ,mFragment).commit()
    }

    private fun passDate_3(){
      //  supportFragmentManager.beginTransaction().setReorderingAllowed(true).replace(R.id.fragment_container ,MyFragment_3::class.java ,null).commit()
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace(R.id.fragment_container ,MyFragment_3::class.java ,null)
        }
    }

}