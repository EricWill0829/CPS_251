package com.example.lifecycleaware

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val textOutput: MutableLiveData<String> = MutableLiveData()

    fun getOutput(): MutableLiveData<String> {
        return this.textOutput
    }

    fun setOutput(value: String) {
        this.textOutput.value = value
    }

}
