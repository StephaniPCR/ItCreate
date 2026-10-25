package com.example.itCreate.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.itCreate.model.Tarjeta
import com.example.itCreate.model.TipoMultimedia
import com.example.itCreate.ui.components.TarjetaCard


@Composable
fun MainScreen (
    modifier: Modifier,
    tarjetas: List<Tarjeta>,
    onItemClick: (Long) -> Unit
){
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        Text(
            text = "Gestor multimedia",
            style = MaterialTheme.typography.displaySmall
        )

        Spacer(modifier = Modifier.height(16.dp))

        //Grid similar a Pinterest con 2 columnas
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(tarjetas) { tarjetaActual ->
                TarjetaCard(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = { onItemClick(tarjetaActual.id.toLong()) },
                    tarjeta = tarjetaActual
                )
            }
        }
    }
}

/*@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MainScreen(
        modifier = Modifier,
        tarjetas = listOf(
            Tarjeta(
                titulo = "Inspiración Reels",
                descripcion = "Ideas de transición rápida",
                autor = "Creator 1",
                tipo = TipoMultimedia.VID
            ),
            Tarjeta(
                titulo = "Banco de Audios",
                descripcion = "Efectos de sonido lofi",
                autor = "Creator 2",
                tipo = TipoMultimedia.VID
            ),
            Tarjeta(
                titulo = "Inspiración Reels",
                descripcion = "Ideas de transición rápida",
                autor = "Creator 1",
                tipo = TipoMultimedia.VID
            ),
            Tarjeta(
                titulo = "Banco de Audios",
                descripcion = "Efectos de sonido lofi",
                autor = "Creator 2",
                tipo = TipoMultimedia.VID
            )
        )
    )
}*/