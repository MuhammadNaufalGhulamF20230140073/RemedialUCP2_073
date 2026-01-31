package com.example.remedialucp2.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.remedialucp2.repositori.RepositoriBuku
import com.example.remedialucp2.room.Buku
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(
    private val repositoriBuku: RepositoriBuku
) : ViewModel() {

    data class HomeUiState(
        val daftarBuku: List<Buku> = emptyList(),
        val isLoading: Boolean = false,
        val pesanError: String? = null
    )

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    init {
        ambilSemuaBuku()
    }

    private fun ambilSemuaBuku() {
        viewModelScope.launch {
            repositoriBuku.semuaBuku
                .onStart {
                    _uiState.update { it.copy(isLoading = true) }
                }
                .catch { e ->
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            pesanError = e.message
                        )
                    }
                }
                .collect { listBuku ->
                    _uiState.update {
                        it.copy(
                            daftarBuku = listBuku,
                            isLoading = false
                        )
                    }
                }
        }
    }

    fun hapusBuku(bukuId: Int) {
        viewModelScope.launch {
            repositoriBuku.softDeleteBuku(bukuId)
        }
    }
}
