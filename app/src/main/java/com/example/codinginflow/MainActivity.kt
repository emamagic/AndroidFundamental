package com.example.codinginflow

import android.app.PendingIntent
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.view.GravityCompat
import com.example.codinginflow.Constance.BROAD_CAST_KET
import com.example.codinginflow.Constance.CHANNEL_1_ID
import com.example.codinginflow.Constance.CHANNEL_2_ID
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var manager: NotificationManagerCompat

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        manager = NotificationManagerCompat.from(this)

        btn_notification_1.setOnClickListener {
            // we have config same as channel in application class for api 25 or lower
            val notification = NotificationCompat.Builder(this ,CHANNEL_1_ID)
                    .setSmallIcon(R.drawable.common_google_signin_btn_icon_dark)
                    .setContentText(edt_notification_message.text.toString())
                    .setContentTitle(edt_notification_title.text.toString())
                    .setPriority(NotificationCompat.PRIORITY_HIGH)
                    .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                    .setColor(Color.BLUE)

                    .setContentIntent(openActivity())
                    .setAutoCancel(true)
                    .setOnlyAlertOnce(true)

                    .addAction(R.mipmap.ic_launcher ,"Toast" ,triggeredBroadCast(edt_notification_message.text.toString()))
                    .build()
            // if we send multiple notification with same id it override on it
            manager.notify(1 ,notification)
        }

        btn_notification_2.setOnClickListener {
            // we have config same as channel in application class for api 25 or lower
            val notification = NotificationCompat.Builder(this ,CHANNEL_2_ID)
                    .setSmallIcon(R.drawable.common_google_signin_btn_icon_dark)
                    .setContentText(edt_notification_message.text.toString())
                    .setContentTitle(edt_notification_title.text.toString())
                    .setPriority(NotificationCompat.PRIORITY_LOW)
                    .build()
            // if we send multiple notification with same id it override on it
            manager.notify(2 ,notification)
        }

    }

    private fun openActivity(): PendingIntent{
        val activityIntent = Intent(this ,MainActivity::class.java)
        return PendingIntent.getActivity(this ,0 ,activityIntent ,0)
    }

    private fun triggeredBroadCast(message: String): PendingIntent{
        val broadCastIntent = Intent(this ,NotificationReceiver::class.java)
        broadCastIntent.putExtra(BROAD_CAST_KET ,message)
        return PendingIntent.getBroadcast(this ,0 ,broadCastIntent ,PendingIntent.FLAG_CANCEL_CURRENT)
    }

}