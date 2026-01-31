package com.example.remedialucp2.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "buku")
data class Buku(

    @PrimaryKey(autoGenerate = true)
    val bukuId: Int = 0,

    val judul: String,
    val pengarang: String,
    val kategoriId: Int?,
    val status: String,
    val isDeleted: Boolean = false
)