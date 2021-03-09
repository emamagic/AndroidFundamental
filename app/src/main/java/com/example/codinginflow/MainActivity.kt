package com.example.codinginflow

import android.app.PendingIntent
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Bundle
import android.support.v4.media.session.MediaSessionCompat
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.codinginflow.Constance.BROAD_CAST_KET
import com.example.codinginflow.Constance.CHANNEL_1_ID
import com.example.codinginflow.Constance.CHANNEL_2_ID
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var manager: NotificationManagerCompat
    private lateinit var mediaSession: MediaSessionCompat

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        manager = NotificationManagerCompat.from(this)
        mediaSession = MediaSessionCompat(this ,"tag")

        btn_notification_1.setOnClickListener {

            val picture = BitmapFactory.decodeResource(resources ,R.drawable.common_full_open_on_phone)

            // we have config same as channel in application class for api 25 or lower
            val notification = NotificationCompat.Builder(this ,CHANNEL_1_ID)
                    // you have to call setSmallIcon to Notification work
                    .setSmallIcon(R.drawable.common_google_signin_btn_icon_dark)
                    .setContentText(edt_notification_message.text.toString())
                    .setContentTitle(edt_notification_title.text.toString())
                    .setPriority(NotificationCompat.PRIORITY_HIGH)
                    .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                    .setColor(Color.BLUE)
                    .setLargeIcon(picture)
                    .setStyle(NotificationCompat.BigPictureStyle()
                            .bigPicture(picture)
                            .bigLargeIcon(null))
                    .setContentIntent(openActivity())
                    .setAutoCancel(true)
                    .setOnlyAlertOnce(true)
                    .build()
            // if we send multiple notification with same id it override on it
            manager.notify(1 ,notification)
        }

        btn_notification_2.setOnClickListener {

            val artwork = BitmapFactory.decodeResource(resources ,R.drawable.common_full_open_on_phone)


            // we have config same as channel in application class for api 25 or lower
            val notification = NotificationCompat.Builder(this ,CHANNEL_2_ID)
                    .setSmallIcon(R.drawable.common_google_signin_btn_icon_dark)
                    .setContentText(edt_notification_message.text.toString())
                    .setContentTitle(edt_notification_title.text.toString())
                    .setPriority(NotificationCompat.PRIORITY_LOW)
                    .setLargeIcon(artwork)
                    .addAction(R.drawable.common_google_signin_btn_icon_light ,"dislike" ,null)
                    .addAction(R.drawable.common_google_signin_btn_icon_light ,"dislike" ,null)
                    .addAction(R.drawable.common_google_signin_btn_icon_light ,"dislike" ,null)
                    .addAction(R.drawable.common_google_signin_btn_icon_light ,"dislike" ,null)
                    .setStyle(androidx.media.app.NotificationCompat.MediaStyle()
                            .setShowActionsInCompactView(1 ,2 ,3)
                            .setMediaSession(mediaSession.sessionToken))
                    .setSubText("sub text")
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