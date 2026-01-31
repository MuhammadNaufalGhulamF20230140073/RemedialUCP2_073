package com.example.remedialucp2.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface BukuPengarangDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(relasi: BukuPengarang)

    @Query("""
        DELETE FROM buku_pengarang
        WHERE bukuId = :bukuId
    """)
    suspend fun deleteByBuku(bukuId: Int)
}
