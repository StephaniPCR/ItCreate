package com.example.itCreate.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CrearCarpetaDialog(
    onDismiss: () -> Unit,
    onCrearCarpeta: (String) -> Unit
) {
    var nombreCarpeta by remember { mutableStateOf("") }
    var tieneError by remember { mutableStateOf(false) }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Text(text = "Nueva Carpeta")
        },
        text = {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                OutlinedTextField(
                    value = nombreCarpeta,
                    onValueChange = {
                        nombreCarpeta = it
                        if (tieneError) tieneError = false
                    },
                    label = { Text("Nombre de la carpeta")},
                    singleLine = true,
                    isError = tieneError,
                    supportingText = {
                        if (tieneError) Text("El nombre no puede estar vacío")
                    },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        },
        confirmButton = {
            Button(
                onClick= {
                    if (nombreCarpeta.trim().isNotBlank()) {
                        onCrearCarpeta(nombreCarpeta.trim())
                        onDismiss()
                    } else {
                        tieneError = true
                    }
                }
            ) {
                Text("Crear")
            }
        },
        dismissButton = {
            OutlinedButton(
                onClick = onDismiss
            ) {
                Text("Cancelar")
            }
        }
    )
}