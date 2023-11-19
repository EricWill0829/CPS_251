package com.example.recycleview


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.recycleview.databinding.SecondActivityBinding


class SecondActivity: AppCompatActivity() {

    private lateinit var binding: SecondActivityBinding
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)

        binding = SecondActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val moreView = intent.extras ?: return

         val title = moreView.getInt("Title", 0)
         val detail = moreView.getInt("Detail", 0)
         val image = moreView.getInt("Image", 0)

        binding.imageMessage.text = Data.titles[title]
        binding.imageDescription.text = Data.details[detail]
        binding.imageView.setImageResource(Data.images[image])
    }
}