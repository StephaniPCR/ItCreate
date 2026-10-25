package com.example.itCreate.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.itCreate.R

@Composable
fun DetalleScreen(
    modifier: Modifier = Modifier,
    tarjetaId: Long
) {
    // Ejemplo detalle
    val tituloMostrado = if (tarjetaId == 1L) "Vlog de Viaje por la Costa 🎥" else "Publicación Creativa #${tarjetaId}"
    val autorMostrado = "Stephani C."
    val descripcionLarga = "Esta es la descripción detallada de la publicación seleccionada."

    // Ejemplo comentario
    val listaComentarios = listOf(
        "Me encanta tu publicación.",
        "¿Cómo lo has hecho?",
        "Gracias por la inspiración."
    )

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(260.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.image_mockup),
                    contentDescription = tituloMostrado,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }
        }

        item {
            Text(
                text = tituloMostrado,
                style = MaterialTheme.typography.headlineMedium
            )
        }

        item {
            Text(
                text = "Por: $autorMostrado",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.primary
            )
        }

        item {
            Text(
                text = descripcionLarga,
                style = MaterialTheme.typography.bodyLarge
            )
        }

        item {
            Spacer(modifier = Modifier.height(8.dp))
            HorizontalDivider()
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Comentarios",
                style = MaterialTheme.typography.titleLarge
            )
        }

        items(listaComentarios) { comentario ->
            ComentarioCard(textoComentario = comentario)
        }
    }
}

@Composable
fun ComentarioCard(textoComentario: String) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Text(
            text = textoComentario,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(12.dp)
        )
    }
}
