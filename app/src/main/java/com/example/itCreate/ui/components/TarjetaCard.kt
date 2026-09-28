package com.example.itCreate.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.itCreate.R
import com.example.itCreate.model.Tarjeta
import com.example.itCreate.model.TipoMultimedia

@Composable
fun TarjetaCard(
    modifier: Modifier, //  Parámetro de estilo
    tarjeta: Tarjeta // Parámetro materia prima
){
    //Tarjeta exterior
    Card(
        modifier = modifier.fillMaxWidth()
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(1.dp),
            horizontalArrangement = Arrangement.spacedBy(1.dp),
            verticalAlignment = Alignment.CenterVertically) {
            Image(
                modifier = Modifier.size(350.dp),
                painter = painterResource(id = R.drawable.image_mockup),
                contentDescription = "Miniatura"
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalAlignment = Alignment.CenterVertically
            ){

            //

            //
            Column {
                Text(
                    text = tarjeta.titulo,
                    style = MaterialTheme.typography.titleMedium
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "Autor: ${tarjeta.autor}",
                    style = MaterialTheme.typography.bodyMedium
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "Tipo: ${tarjeta.tipo}",
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun TarjetaCardPreview() {
    TarjetaCard(
        modifier = Modifier,
        tarjeta = Tarjeta(
            titulo = "Idea de Vídeo Musical",
            descripcion = "Transiciones rápidas para reels",
            autor = "Ana Creator",
            tipo = TipoMultimedia.VID
        )
    )
}