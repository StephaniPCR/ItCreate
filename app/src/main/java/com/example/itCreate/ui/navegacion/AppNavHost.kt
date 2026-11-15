package com.example.itCreate.ui.navegacion

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.itCreate.ui.screen.*
import com.example.itCreate.model.Tarjeta
import com.example.itCreate.model.TipoMultimedia


object Rutas {
    const val REGISTRO = "registro"
    const val LOGIN = "login"
    const val HOME = "home"
    const val DETALLE = "detalle/{tarjetaId}"
    fun detalleConId(id: Long) = "detalle/${id}"
    const val GESTION = "gestion" //Gestión de carpetas personalizadas
    const val PERFIL = "perfil"
    const val SUBIR = "subir_contenido"
}

@Composable
fun AppNavHost (
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    // Lista multimedia
    val listaTarjetas = remember {
        mutableStateListOf(
            Tarjeta(id = 1, titulo = "Vlog de Viaje por la Costa 🎥", descripcion = "Vídeo en 4K", autor = "Stephani", tipo = TipoMultimedia.VID),
            Tarjeta(id = 2, titulo = "Atardecer en la Playa 🌅", descripcion = "Animación GIF", autor = "Stephani", tipo = TipoMultimedia.GIF),
            Tarjeta(id = 3, titulo = "Tutorial de Edición Rápida ✂️", descripcion = "Efectos y cortes", autor = "Stephani", tipo = TipoMultimedia.VID),
            Tarjeta(id = 4, titulo = "Sesión de Retrato Urbano 🏙️", descripcion = "Fotografía callejera", autor = "Stephani", tipo = TipoMultimedia.IMG)
        )
    }

    NavHost(
        navController = navController,
        startDestination = Rutas.LOGIN,
        modifier = modifier
    ) {
        composable(Rutas.REGISTRO) {
            RegistroFormScreen(
                onCancelarClick = {
                    navController.popBackStack()
                },
                onRegistroExitoso = {
                    navController.popBackStack()
                }
            )
        }

        composable(Rutas.LOGIN) {
            LoginScreen(
                onLoginClick = {
                    navController.navigate(Rutas.HOME) {
                        popUpTo(Rutas.LOGIN) { inclusive = true }
                    }
                },
                onRegistroClick = {
                    navController.navigate(Rutas.REGISTRO)
                }
            )
        }

        composable(Rutas.HOME) {
            HomeScreen(
                tarjetas = listaTarjetas, // La lista de tarjetas AppNavHost
                onItemClick = { multimediaId ->
                    navController.navigate(Rutas.detalleConId(multimediaId))
                }
            )
        }

        composable(route = Rutas.DETALLE) { backStackEntry ->
            val idString = backStackEntry.arguments?.getString("tarjetaId") // Extraemos el argumento
            val tarjetaId = idString?.toLongOrNull() ?: 1L // Convertimos a Long
            val tarjetaSeleccionada = listaTarjetas.find { it.id.toLong() == tarjetaId } ?: listaTarjetas.first() //Buscamos el elmento que coincida con la ID
            DetalleScreen(tarjeta = tarjetaSeleccionada) // Pintamos la pantalla de detalle con su ID correspondiente
        }

        composable(Rutas.SUBIR) {
            CrearContenidoScreen(
                onCancelarClick = {
                    navController.popBackStack() // Vuelve atrás si cancela
                },
                onGuardarClick = { nuevaTarjeta ->
                    // Le asignamos un ID y la guardamos en la lista
                    listaTarjetas.add(nuevaTarjeta.copy(id = listaTarjetas.size + 1))
                    navController.popBackStack()
                }
            )
        }

        composable(Rutas.GESTION) {
            GestionScreen()
        }

        composable(Rutas.PERFIL) {
            PerfilScreen()
        }
    }
}
