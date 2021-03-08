package com.example.codinginflow.util

import java.util.*

object Utility {

    fun timery(delay: Long ,call:() -> Unit){
        Timer().schedule(object : TimerTask(){
            override fun run() { call() }
        } ,delay)
    }


}