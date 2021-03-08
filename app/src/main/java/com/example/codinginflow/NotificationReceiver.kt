package com.example.codinginflow

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import com.example.codinginflow.Constance.BROAD_CAST_KET

class NotificationReceiver: BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        val message = intent?.getStringExtra(BROAD_CAST_KET)
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}