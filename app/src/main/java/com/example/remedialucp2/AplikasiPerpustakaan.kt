package com.example.remedialucp2

import android.app.Application
import com.example.remedialucp2.repositori.ContainerApp

class AplikasiPerpustakaan : Application() {

    lateinit var container: ContainerApp
        private set

    override fun onCreate() {
        super.onCreate()
        container = ContainerApp(this)
    }
}
