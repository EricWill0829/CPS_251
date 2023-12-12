package com.example.finalproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContactListAdapter (private val contactItemLayout: Int) : RecyclerView.Adapter<ContactListAdapter.ViewHolder>(){

    private var contactList: List<Contact>? = null

    override fun onBindViewHolder(holder: ViewHolder, listPosition: Int) {
        val name = holder.itemName
        var deletePhoneIcon = holder.itemDeleteIcon
        val phone = holder.itemPhone

        contactList.let {
            name.text = it!![listPosition].contactName
            phone.text = it!![listPosition].contactPhone.toString()
        }

        deletePhoneIcon.setOnClickListener(){

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            contactItemLayout, parent, false)
        return ViewHolder(view)
    }

    fun setContactList(contacts: List<Contact>) {
        contactList = contacts
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return if (contactList == null) 0 else contactList!!.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemName: TextView = itemView.findViewById(R.id.nameView)
        var itemPhone: TextView = itemView.findViewById(R.id.phoneView)
        var itemDeleteIcon: ImageView = itemView.findViewById(R.id.deleteIcon)
    }
}