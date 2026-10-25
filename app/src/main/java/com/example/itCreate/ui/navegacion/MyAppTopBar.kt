package com.example.itCreate.ui.navegacion

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyAppTopBar(navController: NavHostController) {
    val navBackStackEntry = navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry.value?.destination?.route

    val title = when (currentRoute) {
        Rutas.HOME -> "ItCreate - Home"
        Rutas.GESTION -> "Gestión de Carpetas"
        Rutas.PERFIL -> "Perfil de Creador"
        Rutas.DETALLE -> "Detalle Multimedia"
        else -> "ItCreate"
    }

    //La flecha de "volver atrás" en el Login y Home no se muestra
    val showBackButton = currentRoute != Rutas.HOME && currentRoute != Rutas.LOGIN

    TopAppBar(
        title = { Text(title) },
        navigationIcon = {
            if (showBackButton) {
                IconButton(onClick = {
                    navController.popBackStack()
                }) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Volver atrás"
                    )
                }
            }
        }
    )
}