package com.example.remedialucp2.viewmodel.provider

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.remedialucp2.AplikasiPerpustakaan
import com.example.remedialucp2.viewmodel.DetailViewModel
import com.example.remedialucp2.viewmodel.EditViewModel
import com.example.remedialucp2.viewmodel.EntryViewModel
import com.example.remedialucp2.viewmodel.HomeViewModel

object PenyediaViewModel {

    val Factory = viewModelFactory {

        // HomeViewModel
        initializer {
            val aplikasi = this.aplikasiSiswa()
            HomeViewModel(aplikasi.container.repositoriSiswa)
        }

        // EntryViewModel
        initializer {
            val aplikasi = this.aplikasiSiswa()
            EntryViewModel(aplikasi.container.repositoriSiswa)
        }

        // DetailViewModel
        initializer {
            val aplikasi = this.aplikasiSiswa()
            val savedStateHandle = this.createSavedStateHandle()
            DetailViewModel(savedStateHandle, aplikasi.container.repositoriSiswa)
        }

        // ✅ EditViewModel (INI YANG KURANG DAN MENYEBABKAN CRASH)
        initializer {
            val aplikasi = this.aplikasiSiswa()
            val savedStateHandle = this.createSavedStateHandle()
            EditViewModel(savedStateHandle, aplikasi.container.repositoriSiswa)
        }
    }
}

// Ekstensi aplikasi
fun CreationExtras.aplikasiSiswa(): AplikasiSiswa {
    return this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY]
            as? AplikasiSiswa ?: error("Application must be AplikasiSiswa")
}
