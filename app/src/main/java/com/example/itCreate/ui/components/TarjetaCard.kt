package com.example.itCreate.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.itCreate.R
import com.example.itCreate.model.Tarjeta
import com.example.itCreate.model.TipoMultimedia

@Composable
fun TarjetaCard(
    tarjeta: Tarjeta,
    onClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    // Selección dinámica del recurso según el tipo
    val imagenRes = when (tarjeta.tipo) {
        TipoMultimedia.VID -> R.drawable.video_mockup
        TipoMultimedia.GIF -> R.drawable.gif_mockup
        else -> R.drawable.image_mockup
    }

    Card(
        onClick = { onClick(tarjeta.id) },
        modifier = modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(350.dp)
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = imagenRes),
                    contentDescription = "Miniatura ${tarjeta.titulo}",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Fit
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp, vertical = 8.dp)
            ) {
                Text(
                    text = tarjeta.titulo,
                    style = MaterialTheme.typography.titleMedium,
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = "Autor: ${tarjeta.autor}",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = "Tipo: ${tarjeta.tipo}",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}
