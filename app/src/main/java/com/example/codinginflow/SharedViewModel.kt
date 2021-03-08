package com.example.codinginflow

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class SharedViewModel(): ViewModel() {

    private val _text = MutableLiveData<String>()
    val text:LiveData<String>
    get() = _text

    fun setText(input: String){
        _text.value = input
    }


}