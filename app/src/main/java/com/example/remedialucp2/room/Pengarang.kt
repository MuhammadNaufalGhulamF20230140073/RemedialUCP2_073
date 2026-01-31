package com.example.remedialucp2.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pengarang")
data class Pengarang(
    @PrimaryKey(autoGenerate = true)
    val pengarangId: Int = 0,
    val nama: String,
    val isDeleted: Boolean = false
)
