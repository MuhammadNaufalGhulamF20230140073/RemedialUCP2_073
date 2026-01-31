package com.example.remedialucp2.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface BukuDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(buku: Buku)

    @Update
    suspend fun update(buku: Buku)

    @Query("UPDATE buku SET isDeleted = 1 WHERE bukuId = :id")
    suspend fun softDelete(id: Int)

    @Query("""
        SELECT * FROM buku
        WHERE isDeleted = 0
        ORDER BY judul ASC
    """)
    fun getSemuaBuku(): Flow<List<Buku>>
}
