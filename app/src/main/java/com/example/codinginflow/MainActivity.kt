package com.example.codinginflow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()
        nav_view.setNavigationItemSelectedListener(this)

        // drawer hold last state of selected item while configuration change and we do not want miss the state we configuration changed
        if (savedInstanceState == null) nav_view.setCheckedItem(R.id.drawer_1)


    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) drawer_layout.closeDrawer(GravityCompat.START)
        else super.onBackPressed()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.drawer_1 -> Toast.makeText(this, item.title, Toast.LENGTH_SHORT).show()
            R.id.drawer_2 -> Toast.makeText(this, item.title, Toast.LENGTH_SHORT).show()
            R.id.drawer_3 -> Toast.makeText(this, item.title, Toast.LENGTH_SHORT).show()
            R.id.drawer_4 -> Toast.makeText(this, item.title, Toast.LENGTH_SHORT).show()
            R.id.drawer_5 -> Toast.makeText(this, item.title, Toast.LENGTH_SHORT).show()
        }
        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }


}