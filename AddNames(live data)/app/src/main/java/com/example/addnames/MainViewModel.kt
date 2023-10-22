package com.example.addnames

import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData

class MainViewModel : ViewModel() {

    private var nameSet: MutableLiveData<String> = MutableLiveData()
    private var nameList: MutableLiveData<String> = MutableLiveData()

    init {
        nameSet.value = ""
        nameList.value = ""
    }

    fun setName(value: String) {
        nameList.value = value
        nameSet.value += nameList.value + "\n"
    }

    fun getName(): MutableLiveData<String> {
        return this.nameList
    }
}
