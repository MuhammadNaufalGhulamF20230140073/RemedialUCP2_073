package com.example.remedialucp2.room

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "buku_fisik",
    foreignKeys = [
        ForeignKey(
            entity = Buku::class,
            parentColumns = ["bukuId"],
            childColumns = ["bukuId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class BukuFisik(

    @PrimaryKey(autoGenerate = true)
    val fisikId: Int = 0,

    val bukuId: Int,
    val kodeInventaris: String,
    val status: String, // tersedia / dipinjam
    val isDeleted: Boolean = false
)
