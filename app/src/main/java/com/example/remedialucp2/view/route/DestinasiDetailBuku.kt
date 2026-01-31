package com.example.remedialucp2.view.route

import com.example.remedialucp2.view.route.DestinasiDetailBuku.bukuId

object DestinasiDetailBuku {
    const val route = "detail_buku"
    const val titleRes = "Detail Buku"
    const val bukuId = "bukuId"
    val routeWithArg = "$route/{$bukuId}"
}
