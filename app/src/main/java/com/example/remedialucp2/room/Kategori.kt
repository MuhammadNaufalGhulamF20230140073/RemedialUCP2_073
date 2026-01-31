package com.example.remedialucp2.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "kategori")
data class Kategori(
    @PrimaryKey(autoGenerate = true)
    val kategoriId: Int = 0,
    val nama: String,
    val parentId: Int? = null,
    val isDeleted: Boolean = false
)
