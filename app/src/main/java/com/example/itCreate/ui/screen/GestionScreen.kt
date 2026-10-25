package com.example.itCreate.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.itCreate.model.Carpeta
import com.example.itCreate.ui.components.CarpetaCard

@Composable
fun GestionScreen(
    modifier: Modifier = Modifier,
    onCarpetaClick: (String) -> Unit = {}
) {
    val listaCarpetas = listOf(
        Carpeta(
            id = 1,
            titulo = "Favoritos",
            descripcion = "Elementos guardados",
        ),
        Carpeta(
            id = 2,
            titulo = "Creaciones",
            descripcion = "Contenido para crear",
            ),
        Carpeta(
            id = 3,
            titulo = "Ideas",
            descripcion = "Borradores e inspiración",
        )
    )

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Colecciones",
            style = MaterialTheme.typography.headlineMedium
        )

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(listaCarpetas) { carpeta ->
                CarpetaCard(
                    carpeta = carpeta,
                    onClick = { onCarpetaClick(carpeta.titulo) }
                )
            }
        }
    }
}
