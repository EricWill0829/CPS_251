package com.example.coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coroutines.databinding.ActivityMainBinding
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    private lateinit var viewModel: MainViewModel

    private lateinit var binding: ActivityMainBinding
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        layoutManager = LinearLayoutManager(this)
        binding.contentMain.recyclerView.layoutManager = layoutManager
        adapter = RecyclerAdapter(viewModel)
        binding.contentMain.recyclerView.adapter = adapter
    }

    suspend fun performTask(name: String) : String {
        val delayTime = (1..10).random() * 1000L
        delay(delayTime)
        return "The name is $name and the delay was $delayTime milliseconds"
    }


    fun launchCoroutines(view: View){
        val names = binding.enterName.text.toString().split(" ")
        coroutineScope.launch(Dispatchers.Main) {
            for (name in names) {
                viewModel.addNames(performTask(name))
                adapter?.notifyItemInserted(adapter!!.itemCount)
            }
        }
    }
}