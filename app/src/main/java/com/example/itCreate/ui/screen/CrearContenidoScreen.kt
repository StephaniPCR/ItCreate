package com.example.itCreate.ui.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowUpward
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.itCreate.model.Tarjeta
import com.example.itCreate.model.TipoMultimedia
import com.example.itCreate.validacion.ContenidoValidator

@Composable
fun CrearContenidoScreen(
    onCancelarClick: () -> Unit,
    onGuardarClick: (Tarjeta) -> Unit,
    modifier: Modifier = Modifier
) {
    // Estado de los datos
    var titulo by rememberSaveable { mutableStateOf("") }
    var descripcion by rememberSaveable { mutableStateOf("") }
    var autor by rememberSaveable { mutableStateOf("") }

    // Estado de los errores
    var tituloError by rememberSaveable { mutableStateOf<String?>(null) }
    var descripcionError by rememberSaveable { mutableStateOf<String?>(null) }
    var autorError by rememberSaveable { mutableStateOf<String?>(null) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Nueva Publicación",
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.primary
        )

        // Título con contador en tiempo real
        OutlinedTextField(
            value = titulo,
            onValueChange = {
                if (it.length <= 50) {
                    titulo = it
                    if (tituloError != null) tituloError = null
                }
            },
            label = { Text("Título de la obra") },
            singleLine = true,
            isError = tituloError != null,
            supportingText = {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = tituloError ?: "")
                    Text(text = "${titulo.length}/50")
                }
            },
            modifier = Modifier.fillMaxWidth()
        )

        // "Subir contenido" - No funcional
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .height(130.dp),
            shape = MaterialTheme.shapes.medium, // Bordes redondeados elegantes
            color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f), // Fondo suave para diferenciarlo
            border = BorderStroke(
                width = 1.dp,
                color = MaterialTheme.colorScheme.outline
            )
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                // Flecha de subida de archivos
                Icon(
                    imageVector = Icons.Default.ArrowUpward,
                    contentDescription = "Flecha subir",
                    modifier = Modifier.size(36.dp),
                    tint = MaterialTheme.colorScheme.primary
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Sube tu contenido",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }

        OutlinedTextField(
            value = autor,
            onValueChange = {
                autor = it
                if (autorError != null) autorError = null
            },
            label = { Text("Nombre del autor/a") },
            singleLine = true,
            isError = autorError != null,
            supportingText = {
                if (autorError != null) Text(text = autorError!!)
            },
            modifier = Modifier.fillMaxWidth()
        )

        // Descripción con contador
        OutlinedTextField(
            value = descripcion,
            onValueChange = {
                if (it.length <= 250) {
                    descripcion = it
                    if (descripcionError != null) descripcionError = null
                }
            },
            label = { Text("Descripción") },
            minLines = 3,
            maxLines = 5,
            isError = descripcionError != null,
            supportingText = {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = descripcionError ?: "")
                    Text(text = "${descripcion.length}/250")
                }
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            OutlinedButton(
                onClick = onCancelarClick,
                modifier = Modifier.weight(1f)
            ) {
                Text("Cancelar")
            }

            Button(
                onClick = {
                    tituloError = ContenidoValidator.validarTitulo(titulo)
                    autorError = ContenidoValidator.validarAutor(autor)
                    descripcionError = ContenidoValidator.validarDescripcion(descripcion)

                    // Verificamos si todos los campos están limpios de errores
                    val esValido = tituloError == null && autorError == null && descripcionError == null

                    if (esValido) {
                        val nuevaTarjeta = Tarjeta(
                            id = 0,
                            titulo = titulo.trim(),
                            descripcion = descripcion.trim(),
                            autor = autor.trim(),
                            tipo = TipoMultimedia.IMG // Por defecto se toma como imagen hasta que se implemente su acción
                        )
                        onGuardarClick(nuevaTarjeta)
                    }
                },
                modifier = Modifier.weight(1f) // Ambos con 50% de ancho
            ) {
                Text("Guardar")
            }
        }
    }
}