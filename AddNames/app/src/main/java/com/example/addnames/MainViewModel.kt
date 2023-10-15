package com.example.addnames

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private var nameList: String = ""

    fun setName(value: String) {
        this.nameList = value
        this.nameList = value.toFloat().toString()

    }

    fun getName(): String {
        return this.nameList
    }
}