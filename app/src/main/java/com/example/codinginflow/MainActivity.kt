package com.example.codinginflow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.add
import androidx.fragment.app.commit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val factory = MyFragmentFactory("factory")
        supportFragmentManager.fragmentFactory = factory
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null){
            Log.e("TAG", "onCreate: $savedInstanceState")
           // supportFragmentManager.beginTransaction().replace(R.id.fragment_container ,MyFragment::class.java ,null).commit()
            supportFragmentManager.commit {
                setReorderingAllowed(true)
            //    setCustomAnimations(enter1, exit1, popEnter1, popExit1)
                add<MyFragment>(R.id.fragment_container)
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

    }
}