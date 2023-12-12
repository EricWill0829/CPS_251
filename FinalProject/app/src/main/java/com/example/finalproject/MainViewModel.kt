package com.example.finalproject

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: ContactRepository = ContactRepository(application)
    private val allContacts: LiveData<List<Contact>>? = repository.allContacts
    private val searchResults: MutableLiveData<List<Contact>> = repository.searchResults


    fun insertContact(contact: Contact) {
        repository.insertContact(contact)
    }

    fun deleteContact(id: Int) {
        repository.deleteContact(id)
    }

    fun findContact(name: String) {
        return repository.findContact(name)
    }

    fun getSearchResults(): MutableLiveData<List<Contact>> {
        return searchResults
    }

    fun getAllContacts(): LiveData<List<Contact>>? {
        return allContacts
    }

    fun sortByAsc() {
        repository.sortContactsAsc()
    }

    fun sortByDesc() {
        repository.sortContactsDesc()
    }
}