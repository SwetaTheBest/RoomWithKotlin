package com.swetajain.roomwithkotlin.database.contacts

import androidx.lifecycle.LiveData

class ContactsRepository(private var contactsDao: ContactsDao) {
    val readAllData: LiveData<List<Contact>> = contactsDao.readAllData()
    suspend fun addContact(contact: Contact) {
        contactsDao.addContact(contact)
    }
}