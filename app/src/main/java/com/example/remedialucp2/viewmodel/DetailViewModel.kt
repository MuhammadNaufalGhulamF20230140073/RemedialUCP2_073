package com.example.remedialucp2.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.remedialucp2.repositori.RepositoriBuku
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DetailViewModel(
    savedStateHandle: SavedStateHandle,
    private val repositoriBuku: RepositoriBuku
) : ViewModel() {

    private val bukuId: Int =
        checkNotNull(savedStateHandle["bukuId"])

    private val _uiStateBuku = MutableStateFlow(UIStateBuku())
    val uiStateBuku: StateFlow<UIStateBuku> = _uiStateBuku

    init {
        ambilDetailBuku()
    }

    private fun ambilDetailBuku() {
        viewModelScope.launch {
            repositoriBuku.semuaBuku.collect { daftar ->
                val buku = daftar.firstOrNull { it.bukuId == bukuId }
                if (buku != null) {
                    _uiStateBuku.value = UIStateBuku(
                        detailBuku = DetailBuku(
                            bukuId = buku.bukuId,
                            judul = buku.judul,
                            pengarang = buku.pengarang,
                            kategoriId = buku.kategoriId,
                            status = buku.status
                        )
                    )
                }
            }
        }
    }
}
