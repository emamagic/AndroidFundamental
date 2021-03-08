package com.example.codinginflow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.core.view.GravityCompat
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn.setOnClickListener {
            val dialog = AlertDialog.Builder(this)
                    .setTitle("title")
                    .setMessage("message")
                    .setPositiveButton("ok", null)
                    .setNegativeButton("cancel", null)
                    .show()

            val positiveButton = dialog.getButton(AlertDialog.BUTTON_POSITIVE)
            positiveButton.setOnClickListener { Toast.makeText(this, "positiveButton clicked", Toast.LENGTH_SHORT).show() }
        }

    }

}