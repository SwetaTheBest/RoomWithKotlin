package com.swetajain.roomwithkotlin.database.contacts

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.swetajain.roomwithkotlin.database.AppDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ContactsViewModel(application: Application) : AndroidViewModel(application) {
    val readAllData: LiveData<List<Contact>>
    private val repository: ContactsRepository

    init {
        val contactsDao = AppDatabase.getDatabase(application).contactsDao()
        repository = ContactsRepository(contactsDao)
        readAllData = repository.readAllData
    }

    fun addContact(contact: Contact) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addContact(contact)
        }
    }
}