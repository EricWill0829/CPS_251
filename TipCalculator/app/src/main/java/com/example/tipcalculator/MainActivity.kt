package com.example.tipcalculator


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tipcalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            if (binding.editTextNumber.text.isEmpty()) {
                binding.outputText.text = "YOU MUST ENTER A BILL AMOUNT"
            } else {
                binding.outputText.text = "The tips are as follows: \n" +
                        " \n10% = " +
                        ((binding.editTextNumber.text.toString()
                            .toDouble()) + (.10 * (binding.editTextNumber.text.toString()
                            .toDouble()))) +
                        " \n15% = " +
                        ((binding.editTextNumber.text.toString()
                            .toDouble()) + (.15 * (binding.editTextNumber.text.toString()
                            .toDouble()))) +
                        " \n20% = " +
                        ((binding.editTextNumber.text.toString()
                            .toDouble()) + (.20 * (binding.editTextNumber.text.toString()
                            .toDouble())))
            }
        }
    }
}