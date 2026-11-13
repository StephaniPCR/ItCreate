package com.example.itCreate.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.itCreate.R
import com.example.itCreate.model.Tarjeta
import com.example.itCreate.model.TipoMultimedia
import com.example.itCreate.ui.components.CrearCarpetaDialog

@Composable
fun DetalleScreen(
    tarjeta: Tarjeta,
    modifier: Modifier = Modifier
) {
    // Calculamos la miniatura correcta según su tipo (igual que en TarjetaCard)
    val imagenRes = when (tarjeta.tipo) {
        TipoMultimedia.VID -> R.drawable.video_mockup
        TipoMultimedia.GIF -> R.drawable.gif_mockup
        else -> R.drawable.image_mockup
    }

//    // Ejemplo detalle
//    val tituloMostrado = if (tarjetaId == 1L) "Vlog de Viaje por la Costa 🎥" else "Publicación Creativa #${tarjetaId}"
//    val autorMostrado = "Stephani C."
//    val descripcionLarga = "Esta es la descripción detallada de la publicación seleccionada."
//
    // Ejemplo comentario
    val listaComentarios = listOf(
        "Me encanta tu publicación.",
        "¿Cómo lo has hecho?",
       "Gracias por la inspiración."
    )

    var mostrarDialogoCarpeta by remember { mutableStateOf(false) }
    var esFavorito by remember { mutableStateOf(false) }

    LazyColumn(
        modifier = Modifier
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
                    painter = painterResource(id = imagenRes),
                    contentDescription = tarjeta.titulo,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }
        }

        item {
            Text(
                text = tarjeta.titulo,
                style = MaterialTheme.typography.headlineMedium
            )
            IconButton(
                onClick = {
                    if (!esFavorito) {
                        mostrarDialogoCarpeta = true
                    }
                    esFavorito = !esFavorito
                }
            ) {
                Icon(
                    imageVector = if (esFavorito) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                    contentDescription = "Favorito",
                    tint = MaterialTheme.colorScheme.primary
                )
            }
        }

        item {
            Text(
                text = "Por: " + tarjeta.autor,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.primary
            )
        }

        item {
            Text(
                text = tarjeta.descripcion,
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
    if (mostrarDialogoCarpeta) {
        CrearCarpetaDialog(
            onDismiss = { mostrarDialogoCarpeta = false },
            onCrearCarpeta = { nombreCarpeta ->
                mostrarDialogoCarpeta = false
            }
        )
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
