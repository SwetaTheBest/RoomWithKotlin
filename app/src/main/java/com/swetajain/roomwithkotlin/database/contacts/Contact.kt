package com.swetajain.roomwithkotlin.database.contacts

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Contact(
    @PrimaryKey
    val id: Int,
    @NonNull
    @ColumnInfo
    val name: String,
    @NonNull
    @ColumnInfo
    val phone: String,
    var photo: String?,
    var email: String
)
