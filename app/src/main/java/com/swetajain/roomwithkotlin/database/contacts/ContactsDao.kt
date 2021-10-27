package com.swetajain.roomwithkotlin.database.contacts

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ContactsDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addContact(contact: Contact)

    @Query("SELECT * FROM Contact")
     fun readAllData(): LiveData<List<Contact>>

    @Query("SELECT * FROM Contact ORDER BY name ASC")
    fun getAll(): Flow<List<Contact>>

    @Query("SELECT * FROM Contact where name= :cname ORDER BY name ASC ")
    fun getContactByName(cname: String): Flow<List<Contact>>
}