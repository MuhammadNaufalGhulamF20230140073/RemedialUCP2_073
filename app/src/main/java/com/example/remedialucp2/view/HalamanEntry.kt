package com.example.remedialucp2.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.remedialucp2.viewmodel.EntryViewModel
import com.example.remedialucp2.viewmodel.DetailBuku
import com.example.remedialucp2.viewmodel.provider.PenyediaViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HalamanEntry(
    navigateBack: () -> Unit,
    viewModel: EntryViewModel = viewModel(factory = PenyediaViewModel.Factory)
) {
    val scope = rememberCoroutineScope()
    val state = viewModel.uiStateBuku.value

    Scaffold(
        topBar = {
            BukuTopAppBar(
                title = "Tambah Buku",
                canNavigateBack = true,
                navigateUp = navigateBack
            )
        }
    ) { padding ->
        Column(modifier = Modifier.padding(padding).padding(16.dp)) {

            OutlinedTextField(
                value = state.detailBuku.judul,
                onValueChange = {
                    viewModel.updateUiState(
                        state.detailBuku.copy(judul = it)
                    )
                },
                label = { Text("Judul") }
            )

            OutlinedTextField(
                value = state.detailBuku.pengarang,
                onValueChange = {
                    viewModel.updateUiState(
                        state.detailBuku.copy(pengarang = it)
                    )
                },
                label = { Text("Pengarang") }
            )

            Button(onClick = {
                scope.launch {
                    viewModel.simpanBuku()
                    navigateBack()
                }
            }) {
                Text("Simpan")
            }
        }
    }
}
