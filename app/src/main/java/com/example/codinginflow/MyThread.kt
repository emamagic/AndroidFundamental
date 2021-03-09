package com.example.codinginflow

import android.os.Handler
import android.os.Looper
import android.os.SystemClock
import android.util.Log

class MyThread : Thread() {

    lateinit var handler: Handler

    override fun run() {
        super.run()
        // create message queue
        Looper.prepare()

        handler = Handler()

        // infinite loop (listener)
        Looper.loop()
        Log.e("MY_TAG", "end of run()")
    }
}