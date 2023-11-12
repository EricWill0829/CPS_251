package com.example.recycleview

import kotlin.random.Random
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    private val titles = List(8) {Random.nextInt(0, 8)}
    private val details = List(8) {Random.nextInt(0, 8)}
    private val images = List(8) {Random.nextInt(0, 8)}

    fun getTitles(): List <Int>{
        return titles
    }
    fun getDetails() : List <Int>{
        return details
    }
    fun getImages() : List <Int>{
        return images
    }
}