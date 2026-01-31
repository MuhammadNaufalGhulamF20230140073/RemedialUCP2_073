package com.example.remedialucp2.room

import androidx.room.Entity

@Entity(
    tableName = "buku_kategori",
    primaryKeys = ["bukuId", "kategoriId"]
)
data class BukuKategori(
    val bukuId: Int,
    val kategoriId: Int
)
