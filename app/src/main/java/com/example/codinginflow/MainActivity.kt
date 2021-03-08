package com.example.codinginflow

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() ,MyDialogFragment.OnButtonFragmentClicked {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_main.setOnClickListener { MyDialogFragment().show(supportFragmentManager ,null) }

    }

    override fun onClicked(title: String) {
        txt_main.text = title
    }

}