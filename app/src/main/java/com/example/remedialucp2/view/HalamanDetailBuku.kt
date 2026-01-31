package com.example.remedialucp2.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.remedialucp2.viewmodel.DetailViewModel
import com.example.remedialucp2.viewmodel.provider.PenyediaViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HalamanDetailBuku(
    navigateBack: () -> Unit,
    navigateToEdit: (Int) -> Unit,
    viewModel: DetailViewModel = viewModel(factory = PenyediaViewModel.Factory)
) {
    val state by viewModel.uiStateBuku.collectAsState()
    val scope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            BukuTopAppBar(
                title = "Detail Buku",
                canNavigateBack = true,
                navigateUp = navigateBack
            )
        }
    ) { padding ->
        Column(modifier = Modifier.padding(padding).padding(16.dp)) {
            Text("Judul: ${state.detailBuku.judul}")
            Text("Pengarang: ${state.detailBuku.pengarang}")
            Text("Status: ${state.detailBuku.status}")

            Button(onClick = {
                navigateToEdit(state.detailBuku.bukuId)
            }) {
                Text("Edit")
            }

            Button(onClick = {
                scope.launch {
                    viewModel.hapusBuku()
                    navigateBack()
                }
            }) {
                Text("Hapus")
            }
        }
    }
}
