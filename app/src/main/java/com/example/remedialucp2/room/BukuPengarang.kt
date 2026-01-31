package com.example.remedialucp2.room

import androidx.room.Entity

@Entity(
    tableName = "buku_pengarang",
    primaryKeys = ["bukuId", "pengarangId"]
)
data class BukuPengarang(
    val bukuId: Int,
    val pengarangId: Int
)
