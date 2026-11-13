package com.example.itCreate.ui.navegacion

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
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
        Rutas.HOME -> "ItCreate"
        Rutas.GESTION -> "Colecciones"
        Rutas.PERFIL -> "Perfil"
        Rutas.DETALLE -> "Detalle"
        else -> "ItCreate"
    }

    //La flecha de "volver atrás" en el Login, Registro y Home no se muestra
    val showBackButton = currentRoute != Rutas.HOME && currentRoute != Rutas.LOGIN && currentRoute != Rutas.REGISTRO

    TopAppBar(
        title = { Text(title, style = MaterialTheme.typography.headlineLarge) },
        navigationIcon = {
            if (showBackButton) {
                IconButton(onClick = {
                    navController.popBackStack()
                }) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Volver atrás"
                    )
                }
            }
        }
    )
}