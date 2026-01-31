package com.example.remedialucp2.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.remedialucp2.repositori.RepositoriBuku
import com.example.remedialucp2.room.Buku

class EditViewModel(
    private val repositoriBuku: RepositoriBuku
) : ViewModel() {

    var uiStateBuku by mutableStateOf(UIStateBuku())
        private set

    private fun validasiInput(
        detailBuku: DetailBuku = uiStateBuku.detailBuku
    ): Boolean =
        detailBuku.judul.isNotBlank() &&
                detailBuku.pengarang.isNotBlank() &&
                detailBuku.status.isNotBlank()

    fun setBuku(buku: Buku) {
        uiStateBuku = UIStateBuku(
            detailBuku = DetailBuku(
                bukuId = buku.bukuId,
                judul = buku.judul,
                pengarang = buku.pengarang,
                kategoriId = buku.kategoriId,
                status = buku.status
            ),
            isEntryValid = true
        )
    }

    fun updateUiState(detailBuku: DetailBuku) {
        uiStateBuku = UIStateBuku(
            detailBuku = detailBuku,
            isEntryValid = validasiInput(detailBuku)
        )
    }

    suspend fun updateBuku() {
        if (validasiInput()) {
            repositoriBuku.updateBuku(
                Buku(
                    bukuId = uiStateBuku.detailBuku.bukuId,
                    judul = uiStateBuku.detailBuku.judul,
                    pengarang = uiStateBuku.detailBuku.pengarang,
                    kategoriId = uiStateBuku.detailBuku.kategoriId,
                    status = uiStateBuku.detailBuku.status
                )
            )
        }
    }

    suspend fun hapusBuku() {
        repositoriBuku.softDeleteBuku(
            uiStateBuku.detailBuku.bukuId
        )
    }
}
