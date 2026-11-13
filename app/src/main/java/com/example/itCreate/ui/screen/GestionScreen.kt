package com.example.itCreate.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.itCreate.model.Carpeta
import com.example.itCreate.ui.components.CarpetaCard
import com.example.itCreate.ui.components.CrearCarpetaDialog

@Composable
fun GestionScreen(
    modifier: Modifier = Modifier,
    onCarpetaClick: (String) -> Unit = {}
) {
    var mostrarDialogo by remember { mutableStateOf(false) }

    val listaCarpetas = remember {
        mutableStateListOf(
            Carpeta(id = 1, titulo = "Favoritos", descripcion = "Elementos guardados"),
            Carpeta(id = 2, titulo = "Creaciones", descripcion = "Contenido para crear"),
            Carpeta(id = 3, titulo = "Ideas", descripcion = "Borradores e inspiración")
        )
    }

    Box(
        modifier = modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
//            Text(
//                text = "Colecciones",
//                style = MaterialTheme.typography.headlineMedium
//            )

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

        FloatingActionButton(
             onClick = { mostrarDialogo = true }, // Al pulsar, encendemos el interruptor
             modifier = Modifier
                 .align(Alignment.BottomEnd)
                 .padding(16.dp),
             containerColor = MaterialTheme.colorScheme.primary
        ) {
            Icon(
               imageVector = Icons.Default.Add,
               contentDescription = "Crear nueva carpeta"
            )
        }
        if (mostrarDialogo) {
            CrearCarpetaDialog(
                onDismiss = { mostrarDialogo = false },
                onCrearCarpeta = { nombreNuevo ->
                    val nuevaCarpeta = Carpeta(
                        id = listaCarpetas.size + 1,
                        titulo = nombreNuevo,
                        descripcion = "Carpeta personalizada"
                    )
                    listaCarpetas.add(nuevaCarpeta)
                    mostrarDialogo = false
                }
            )
        }
    }
}
