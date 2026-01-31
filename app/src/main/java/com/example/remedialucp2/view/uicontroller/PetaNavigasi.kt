package com.example.remedialucp2.view.uicontroller

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.remedialucp2.ui.navigasi.DestinasiEntryBuku
import com.example.remedialucp2.view.route.*
import com.example.remedialucp2.view.*

@Composable
fun PetaNavigasi() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = DestinasiHome.route
    ) {

        composable(DestinasiHome.route) {
            HalamanHome(
                navigateToEntry = {
                    navController.navigate(DestinasiEntryBuku.route)
                },
                navigateToDetail = { id ->
                    navController.navigate("${DestinasiDetailBuku.route}/$id")
                }
            )
        }

        composable(DestinasiEntryBuku.route) {
            HalamanEntry(
                navigateBack = { navController.popBackStack() }
            )
        }

        composable(
            route = DestinasiDetailBuku.routeWithArg,
            arguments = listOf(
                navArgument(DestinasiDetailBuku.bukuId) {
                    type = NavType.IntType
                }
            )
        ) {
            HalamanDetailBuku(
                navigateBack = { navController.popBackStack() },
                navigateToEdit = { id ->
                    navController.navigate("${DestinasiEditBuku.route}/$id")
                }
            )
        }

        composable(
            route = DestinasiEditBuku.routeWithArg,
            arguments = listOf(
                navArgument(DestinasiEditBuku.bukuId) {
                    type = NavType.IntType
                }
            )
        ) {
            HalamanEdit(
                navigateBack = { navController.popBackStack() }
            )
        }
    }
}
