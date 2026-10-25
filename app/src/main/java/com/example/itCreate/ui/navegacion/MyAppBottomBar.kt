package com.example.itCreate.ui.navegacion

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.itCreate.R

@Composable
fun MyAppBottomBar(navController: NavHostController) {
    val navBackStackEntry = navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry.value?.destination?.route

    NavigationBar {
        NavigationBarItem(
            selected = currentRoute == Rutas.HOME,
            onClick = {
                if (currentRoute != Rutas.HOME) {
                    navController.navigate(Rutas.HOME) {
                        popUpTo(Rutas.HOME) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            },
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = "Home"
                )
            },
            label = { Text("Home") }
        )

        NavigationBarItem(
            selected = currentRoute == Rutas.GESTION,
            onClick = {
                if (currentRoute != Rutas.GESTION) {
                    navController.navigate(Rutas.GESTION) {
                        popUpTo(Rutas.HOME) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            },
            icon = {
                Icon(
                    imageVector = Icons.Default.List,
                    contentDescription = "Gestión"
                )
            },
            label = { Text("Carpetas") }
        )

        NavigationBarItem(
            selected = currentRoute == Rutas.PERFIL,
            onClick = {
                if (currentRoute != Rutas.PERFIL) {
                    navController.navigate(Rutas.PERFIL) {
                        popUpTo(Rutas.HOME) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            },
            icon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Perfil"
                )
            },
            label = { Text("Perfil") }
        )
    }
}
