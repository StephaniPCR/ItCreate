package com.example.itCreate.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.itCreate.model.Tarjeta
import com.example.itCreate.model.TipoMultimedia.GIF
import com.example.itCreate.model.TipoMultimedia.IMG
import com.example.itCreate.model.TipoMultimedia.VID
import com.example.itCreate.ui.components.TarjetaCard

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    onItemClick: (Long) -> Unit
) {
    val listaMultimedia = listOf(
        Tarjeta(
            id = 1,
            titulo = "Vlog de Viaje por la Costa 🎥",
            descripcion = "Vídeo",
            autor = "Stephani",
            tipo = VID
        ),
        Tarjeta(
            id = 2,
            titulo = "Atardecer en la Playa 🌅",
            descripcion = "Foto",
            autor = "Stephani",
            tipo = GIF
        ),
        Tarjeta(
            id = 3,
            titulo = "Tutorial de Edición Rápida ✂️",
            descripcion = "Vídeo",
            autor = "Stephani",
            tipo = VID),
        Tarjeta(
            id = 4,
            titulo = "Sesión de Retrato Urbano 🏙️",
            descripcion = "Foto",
            autor = "Stephani",
            tipo = IMG)
    )

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "Muro de Inspiración",
            style = MaterialTheme.typography.headlineMedium
        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(listaMultimedia) { tarjeta ->
                TarjetaCard(
                    tarjeta = tarjeta,
                    onClick = { onItemClick(tarjeta.id.toLong()) },
                    modifier = modifier
                )
            }
        }
    }
}
