package com.example.lifecycleaware

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import java.time.LocalTime

class DemoObserver(private val mainView: MainViewModel): DefaultLifecycleObserver {

    override fun onCreate(owner: LifecycleOwner) {
        mainView.setOutput("onCreate was fired on " + LocalTime.now() + "\n")
    }

    override fun onResume(owner: LifecycleOwner) {
        mainView.setOutput("onResume was fired on " + LocalTime.now() + "\n*******")
    }

    override fun onPause(owner: LifecycleOwner) {
        mainView.setOutput("onPause was fired on " + LocalTime.now() + "\n*******")
    }

    override fun onStart(owner: LifecycleOwner) {
        mainView.setOutput("onStart was fired on " + LocalTime.now() + "\n")
    }

    override fun onStop(owner: LifecycleOwner) {
        mainView.setOutput("onStop was fired on " + LocalTime.now() + "\n")
    }

    override fun onDestroy(owner: LifecycleOwner) {
        mainView.setOutput("onDestroy was fired on " + LocalTime.now() + "\n*******")
    }

}