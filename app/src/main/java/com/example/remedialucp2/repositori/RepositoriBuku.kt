package com.example.remedialucp2.repositori

import com.example.remedialucp2.room.Buku
import com.example.remedialucp2.room.BukuDao
import kotlinx.coroutines.flow.Flow

class RepositoriBuku(
    private val bukuDao: BukuDao
) {

    val semuaBuku: Flow<List<Buku>> =
        bukuDao.getSemuaBuku()

    suspend fun insertBuku(buku: Buku) {
        bukuDao.insert(buku)
    }

    suspend fun updateBuku(buku: Buku) {
        bukuDao.update(buku)
    }

    suspend fun softDeleteBuku(id: Int) {
        bukuDao.softDelete(id)
    }

    suspend fun adaBukuDipinjam(kategoriId: Int): Boolean {
        return bukuDao.cekBukuDipinjam(kategoriId) > 0
    }
}
