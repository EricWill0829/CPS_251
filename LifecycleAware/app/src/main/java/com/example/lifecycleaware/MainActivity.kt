package com.example.lifecycleaware

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.lifecycleaware.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding
    private lateinit var demoObserver: DemoObserver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        val resultObserver = Observer<String> { result ->
            binding.textOutput.text = result

            if (result.contains("onCreate, onResume, onPause, onStart, onStop, onDestroy")) {
                viewModel.setOutput(binding.textOutput.text.toString())
            } else {
                binding.textOutput.text = result + "\n"
            }
        }

        viewModel.getOutput().observe(this, resultObserver)

        demoObserver = DemoObserver(viewModel)

        lifecycle.addObserver(demoObserver)

    }
}



