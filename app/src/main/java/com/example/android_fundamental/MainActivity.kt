package com.example.android_fundamental

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottom_nav.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.fragment_1 -> {
                    supportFragmentManager.commit { replace(R.id.fragment_container ,MyFragment_1::class.java ,null) }
                    true
                }
                else -> {
                    supportFragmentManager.commit { replace(R.id.fragment_container ,MyFragment_2::class.java ,null) }
                    true
                }
            }
        }

    }

}