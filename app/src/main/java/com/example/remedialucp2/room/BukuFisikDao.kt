package com.example.remedialucp2.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface BukuFisikDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(bukuFisik: BukuFisik)

    @Query("""
        UPDATE buku_fisik 
        SET status = :status 
        WHERE fisikId = :fisikId
    """)
    suspend fun updateStatus(fisikId: Int, status: String)

    @Query("""
        UPDATE buku_fisik 
        SET isDeleted = 1 
        WHERE fisikId = :fisikId
    """)
    suspend fun softDelete(fisikId: Int)

    @Query("""
        SELECT COUNT(*) FROM buku_fisik bf
        INNER JOIN buku_kategori bk ON bf.bukuId = bk.bukuId
        WHERE bk.kategoriId = :kategoriId
        AND bf.status = 'dipinjam'
        AND bf.isDeleted = 0
    """)
    suspend fun cekBukuDipinjamDalamKategori(kategoriId: Int): Int
}
