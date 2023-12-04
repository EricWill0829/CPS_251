package com.example.coroutines

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(viewModel: MainViewModel): RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    private var names = viewModel.getNames()

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var itemHead: TextView

        init {
            itemHead = itemView.findViewById(R.id.itemTitle)

        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.card_layout, viewGroup, false); return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.itemHead.text = names[i]
    }

    override fun getItemCount(): Int {
        return names.size

    }
}