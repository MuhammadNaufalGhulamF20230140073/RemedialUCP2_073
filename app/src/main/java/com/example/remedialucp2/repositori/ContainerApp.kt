package com.example.remedialucp2.repositori

import android.content.Context
import com.example.remedialucp2.room.DatabasePerpustakaan

class ContainerApp(context: Context) {

    private val database = DatabasePerpustakaan.getDatabase(context)

    val repositoriBuku: RepositoriBuku by lazy {
        RepositoriBuku(database.bukuDao())
    }
}
