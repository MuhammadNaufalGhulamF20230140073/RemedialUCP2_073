package com.example.remedialucp2.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.remedialucp2.repositori.RepositoriBuku
import com.example.remedialucp2.room.Buku

class EntryViewModel(
    private val repositoriBuku: RepositoriBuku
) : ViewModel() {

    val uiStateBuku = mutableStateOf<UIStateBuku>(UIStateBuku())

    private fun validasiInput(
        detailBuku: DetailBuku = uiStateBuku.value.detailBuku
    ): Boolean =
        detailBuku.judul.isNotBlank() &&
                detailBuku.pengarang.isNotBlank() &&
                detailBuku.status.isNotBlank()

    fun updateUiState(detailBuku: DetailBuku) {
        uiStateBuku.value = UIStateBuku(
            detailBuku = detailBuku,
            isEntryValid = validasiInput(detailBuku)
        )
    }

    suspend fun simpanBuku() {
        if (validasiInput()) {
            repositoriBuku.insertBuku(
                Buku(
                    bukuId = 0, // autoGenerate
                    judul = uiStateBuku.value.detailBuku.judul,
                    pengarang = uiStateBuku.value.detailBuku.pengarang,
                    kategoriId = uiStateBuku.value.detailBuku.kategoriId,
                    status = uiStateBuku.value.detailBuku.status
                )
            )
        }
    }
}


data class UIStateBuku(
    val detailBuku: DetailBuku = DetailBuku(),
    val isEntryValid: Boolean = false
)

data class DetailBuku(
    val bukuId: Int = 0,
    val judul: String = "",
    val pengarang: String = "",
    val kategoriId: Int? = null,
    val status: String = "tersedia"
)
