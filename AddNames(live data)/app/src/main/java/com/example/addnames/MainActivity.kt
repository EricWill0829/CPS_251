package com.example.addnames

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.addnames.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        var welcome: TextView =findViewById(R.id.displayNames)
//        welcome.text="No names to display"

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        binding = ActivityMainBinding.inflate(layoutInflater)

        binding.buttonClick.setOnClickListener {
            if (binding.editTextName.text.isNotEmpty()) {
                viewModel.setName(binding.editTextName.text.toString())
                binding.displayNames.text = viewModel.getName().toString()
            } else {
                binding.displayNames.text = "No names entered"

            }
        }
        setContentView(binding.root)
    }
}
