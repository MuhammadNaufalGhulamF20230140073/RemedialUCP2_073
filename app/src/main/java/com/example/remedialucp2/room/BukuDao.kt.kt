package com.example.remedialucp2.room

import androidx.room.Dao
import androidx.room.Delete
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

    @Query("""
        SELECT COUNT(*) FROM buku 
        WHERE kategoriId = :kategoriId 
        AND status = 'dipinjam'
        AND isDeleted = 0
    """)
    suspend fun cekBukuDipinjam(kategoriId: Int): Int
}