package com.example.remedialucp2.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.remedialucp2.viewmodel.EditViewModel
import com.example.remedialucp2.viewmodel.provider.PenyediaViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HalamanEdit(
    navigateBack: () -> Unit,
    viewModel: EditViewModel = viewModel(factory = PenyediaViewModel.Factory)
) {
    val scope = rememberCoroutineScope()
    val state = viewModel.uiStateBuku.value

    Scaffold(
        topBar = {
            BukuTopAppBar(
                title = "Edit Buku",
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

            Button(onClick = {
                scope.launch {
                    viewModel.updateBuku()
                    navigateBack()
                }
            }) {
                Text("Simpan Perubahan")
            }
        }
    }
}
