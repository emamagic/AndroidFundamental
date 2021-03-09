package com.example.codinginflow

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.Fade
import androidx.annotation.RequiresApi

class MainActivity2 : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val fade = Fade()
        val decor = window.decorView
        fade.run {
            // excludeTarget(decor.findViewById(R.id.action_bar_container), true)
            excludeTarget(android.R.id.statusBarBackground ,true)
            excludeTarget(android.R.id.navigationBarBackground ,true)
        }
        window.enterTransition = fade
        window.exitTransition = fade

    }
}