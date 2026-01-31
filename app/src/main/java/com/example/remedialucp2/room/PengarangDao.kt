package com.example.remedialucp2.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PengarangDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(pengarang: Pengarang)

    @Query("""
        SELECT * FROM pengarang
        WHERE isDeleted = 0
        ORDER BY nama ASC
    """)
    suspend fun getSemuaPengarang(): List<Pengarang>
}
