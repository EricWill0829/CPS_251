package com.example.finalproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.finalproject.databinding.ActivityMainBinding
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    private var adapter: ContactListAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        listenerSetup()
        observerSetup()
        recyclerSetup()

    }

    private fun clearFields() {
        binding.contactName.setText("")
        binding.contactPhone.setText("")
    }

    private fun listenerSetup() {
        binding.addButton.setOnClickListener {
            val name = binding.contactName.text.toString()
            val quantity = binding.contactPhone.text.toString()

            if (name != "" && quantity != "") {
                val contact = Contact(name, quantity)
                viewModel.insertContact(contact)
                viewModel.getAllContacts()
                clearFields()
            } else {
                binding.addButton.text
                clearFields()
            }
            binding.contactName.requestFocus()
        }

        binding.findButton.setOnClickListener {
            if (binding.contactName.text.isNotEmpty()) {
                viewModel.findContact(binding.contactName.text.toString())
                clearFields()
            } else {
                val toast = Toast.makeText(this, "A name must be entered", Toast.LENGTH_LONG)
                toast.show()
            }
            binding.contactName.requestFocus()
        }

        binding.ascButton.setOnClickListener {
            viewModel.sortByAsc()
            binding.contactName.requestFocus()

        }

        binding.descButton.setOnClickListener {
            viewModel.sortByDesc()
            binding.contactName.requestFocus()

        }
    }

    private fun observerSetup() {
        viewModel.getAllContacts()?.observe(this) { contacts ->
            contacts?.let {
                adapter?.setContactList(it)
            }
        }

        viewModel.getSearchResults().observe(this) { contacts ->
            contacts?.let {
                if (it.isNotEmpty()) {
                    adapter?.setContactList(it)
                } else {
                    val toast = Toast.makeText(this, "No Match", Toast.LENGTH_LONG)
                    toast.show()
                    clearFields()
                }
            }
        }
    }

    private fun recyclerSetup() {
        adapter = ContactListAdapter(R.layout.contact_list_item)
        binding.contactRecycler.layoutManager = LinearLayoutManager(this)
        binding.contactRecycler.adapter = adapter
    }
}