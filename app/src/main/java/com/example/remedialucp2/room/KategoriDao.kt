package com.example.remedialucp2.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface KategoriDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(kategori: Kategori)

    @Query("""
        SELECT * FROM kategori
        WHERE isDeleted = 0
    """)
    suspend fun getSemuaKategori(): List<Kategori>

    @Query("""
        UPDATE kategori
        SET isDeleted = 1
        WHERE kategoriId = :id
    """)
    suspend fun softDelete(id: Int)
}
