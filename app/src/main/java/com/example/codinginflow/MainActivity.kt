package com.example.codinginflow

import android.graphics.drawable.AnimationDrawable
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity()  {

    private lateinit var wifiAnimation: AnimationDrawable

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        prev.setOnClickListener {
            view_fipper.showPrevious()
        }

        nex.setOnClickListener {
            view_fipper.showNext()
            // show specific chile by index
            // view_fipper.displayedChild = 0
        }

    }
}