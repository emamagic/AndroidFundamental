package com.example.codinginflow

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.Fade
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityOptionsCompat
import androidx.core.view.ViewCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity()  {


    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fade = Fade()
        val decor = window.decorView
        fade.run {
           // excludeTarget(decor.findViewById(R.id.action_bar_container), true)
            excludeTarget(android.R.id.statusBarBackground ,true)
            excludeTarget(android.R.id.navigationBarBackground ,true)
        }
        window.enterTransition = fade
        window.exitTransition = fade

        btn_1.setOnClickListener {
            val intent = Intent(this ,MainActivity2::class.java)
            val options = ActivityOptionsCompat.makeSceneTransitionAnimation(this ,img_1 ,ViewCompat.getTransitionName(img_1)!!)
            startActivity(intent ,options.toBundle())
        }


    }



}