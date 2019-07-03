package com.github.bassaer.espressotestrecorder

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val data: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>().apply {
            value = 0
        }
    }

    fun getData(): LiveData<Int> = data

    fun getCount() = data.value ?: 0

    fun countUp() {
        data.value = (data.value as Int) + 1
    }

    fun reset() {
        data.value = 0
    }
}