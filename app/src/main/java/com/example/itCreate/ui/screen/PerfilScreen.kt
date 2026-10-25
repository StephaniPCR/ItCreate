package com.example.itCreate.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.itCreate.R

@Composable
fun PerfilScreen(
    modifier: Modifier = Modifier
) {
    // Opciones de configuración del menú
    val opcionesPerfil = listOf(
        "Seguridad",
        "Preguntas frecuentes",
        "Política de privacidad",
        "Cerrar sesión"
    )

    LazyColumn(
            modifier = modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Text(
                    text = "Stephani C.",
                    style = MaterialTheme.typography.headlineMedium
                )
            }
            item {
                Card(
                    modifier = Modifier.size(100.dp),
                    shape = MaterialTheme.shapes.extraLarge
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.image_mockup),
                        contentDescription = "Foto de perfil",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                }
            }

            item { DatoPerfilCard(titulo = "Nombre", valor = "Stephani C.") }
            item { DatoPerfilCard(titulo = "Email", valor = "stephani@itcreate.com") }
            item { DatoPerfilCard(titulo = "Teléfono", valor = "+34 600 000 000") }
            item { DatoPerfilCard(titulo = "Rol", valor = "Creadora de Contenido Multimedia") }

            item {
                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "Configuración",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.fillMaxWidth()
                )
            }

            items(opcionesPerfil) { opcion ->
                OpcionMenuCard(
                    texto = opcion,
                    onClick = { /* Falta */ }
                )
            }
        }
    }


// Título izq, datos der
@Composable
fun DatoPerfilCard(titulo: String, valor: String) {
    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = titulo,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.primary // Destaca el título con color corporativo
            )
            Text(
                text = valor,
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}

// Tarjeta de opción de menú con flecha a la derecha
@Composable
fun OpcionMenuCard(
    texto: String,
    onClick: () -> Unit
) {
    Card(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = texto,
                style = MaterialTheme.typography.bodyLarge
            )
            Icon(
                imageVector = Icons.Default.KeyboardArrowRight,
                contentDescription = "Ir a $texto",
                tint = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}
