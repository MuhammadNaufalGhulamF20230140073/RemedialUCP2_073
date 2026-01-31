package com.example.remedialucp2.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.remedialucp2.viewmodel.HomeViewModel
import com.example.remedialucp2.viewmodel.provider.PenyediaViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HalamanHome(
    navigateToEntry: () -> Unit,
    navigateToDetail: (Int) -> Unit,
    viewModel: HomeViewModel = viewModel(factory = PenyediaViewModel.Factory)
) {
    val uiState by viewModel.uiState.collectAsState()

    Scaffold(
        topBar = {
            BukuTopAppBar(
                title = "Daftar Buku",
                canNavigateBack = false
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = navigateToEntry) {
                Text("+")
            }
        }
    ) { padding ->
        Column(modifier = Modifier.padding(padding)) {
            uiState.daftarBuku.forEach { buku ->
                Text(
                    text = buku.judul,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            navigateToDetail(buku.bukuId)
                        }
                        .padding(16.dp)
                )
            }
        }
    }
}
