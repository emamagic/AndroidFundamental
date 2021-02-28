package com.example.codinginflow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.commit
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() ,HostFragment.Test  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add(R.id.fragment_container ,HostFragment())
        }


    }

    override fun test() {
        Toast.makeText(this, "successfull", Toast.LENGTH_SHORT).show()
    }

}