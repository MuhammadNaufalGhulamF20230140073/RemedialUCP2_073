package com.example.remedialucp2.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface BukuKategoriDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(relasi: BukuKategori)

    @Query("""
        DELETE FROM buku_kategori
        WHERE kategoriId = :kategoriId
    """)
    suspend fun deleteByKategori(kategoriId: Int)
}
