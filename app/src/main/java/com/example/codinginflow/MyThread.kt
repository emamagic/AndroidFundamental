package com.example.codinginflow

import android.os.SystemClock
import android.util.Log

class MyThread: Thread() {

    override fun run() {
        super.run()
        for (i in 1..6){
            Log.e("MY_TAG", "run: $i")
            SystemClock.sleep(1000)
        }
        Log.e("MY_TAG", "finish")
    }
}