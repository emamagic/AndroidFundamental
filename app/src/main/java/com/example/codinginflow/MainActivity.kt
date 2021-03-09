package com.example.codinginflow

import android.os.Build
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity()  {

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myThread = MyThread()

        btn_start.setOnClickListener {
            myThread.start()
        }


        btn_task_a.setOnClickListener {
            myThread.handler.post {
                for (i in 1..6){
                    Log.e("MY_TAG", "run $i")
                    SystemClock.sleep(1000)
                }
            }
        }

        btn_stop.setOnClickListener {
            myThread.handler.looper.quit()
        }

    }

}