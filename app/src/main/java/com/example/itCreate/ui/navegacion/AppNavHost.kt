package com.example.itCreate.ui.navegacion

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.itCreate.ui.screen.*
import com.example.itCreate.model.Tarjeta


object Rutas {
    const val LOGIN = "login"
    const val HOME = "home"
    const val GESTION = "gestion" //Gestión de carpetas personalizadas
    const val PERFIL = "perfil"
    const val DETALLE = "detalle/{tarjetaId}"
    fun detalleConId(id: Long) = "detalle/${id}"
}


@Composable
fun AppNavHost (
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Rutas.LOGIN,
        modifier = modifier
    ) {
        composable(Rutas.LOGIN) {
            LoginScreen(
                onLoginClick = {
                    navController.navigate(Rutas.HOME) {
                        popUpTo(Rutas.LOGIN) { inclusive = true }
                    }
                }
            )
        }
        composable(Rutas.HOME) {
            HomeScreen(
                onItemClick = { multimediaId ->
                    navController.navigate(Rutas.detalleConId(multimediaId))
                }
            )
        }

        composable(route = Rutas.DETALLE) { backStackEntry ->
            // Extraemos el argumento
            val idString = backStackEntry.arguments?.getString("tarjetaId")
            // Convertimos a Long
            val tarjetaId = idString?.toLongOrNull() ?: 1L
            // Pintamos la pantalla de detalle con su ID correspondiente
            DetalleScreen(tarjetaId = tarjetaId)
        }

        composable(Rutas.GESTION) {
            GestionScreen()
        }
        composable(Rutas.PERFIL) {
            PerfilScreen()
        }
    }
}
