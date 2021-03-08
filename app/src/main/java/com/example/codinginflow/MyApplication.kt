package com.example.codinginflow

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import com.example.codinginflow.Constance.CHANNEL_1_ID
import com.example.codinginflow.Constance.CHANNEL_2_ID

class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        createNotificationChannels()
    }

    private fun createNotificationChannels() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val channel1 = NotificationChannel(CHANNEL_1_ID ,"Channel 1",NotificationManager.IMPORTANCE_HIGH)
            // we can set default config vibration and phoneLight and ...
            channel1.description = "This is Channel 1"

            val channel2 = NotificationChannel(CHANNEL_2_ID ,"Channel 2",NotificationManager.IMPORTANCE_LOW)
            // we can set default config vibration and phoneLight and ...
            channel2.description = "This is Channel 2"

            val manager = getSystemService(NotificationManager::class.java)
            manager.createNotificationChannel(channel1)
            manager.createNotificationChannel(channel2)

        }
    }

}