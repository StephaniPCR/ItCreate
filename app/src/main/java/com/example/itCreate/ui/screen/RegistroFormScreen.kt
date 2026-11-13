package com.example.itCreate.ui.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ArrowDropUp
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.itCreate.validacion.RegistroValidator

@Composable
fun RegistroFormScreen(
    modifier: Modifier = Modifier,
    onRegistroExitoso: () -> Unit,
    onCancelarClick: () -> Unit
) {
    var nombreCompleto by remember { mutableStateOf("") }
    var correo by remember { mutableStateOf("") }
    var usuario by remember { mutableStateOf("") }
    var telefono by remember { mutableStateOf("") }
    var rol by remember { mutableStateOf("Creador/a de contenido") } //Dejamos el rol seleccionado por defecto
    var rolExpanded by remember { mutableStateOf(false) }
    val opcionesRol = listOf("Creador/a de contenido", "Consumidor")

    //Estados de error
    var nombreError by remember { mutableStateOf<String?>(null) }
    var correoError by remember { mutableStateOf<String?>(null) }
    var usuarioError by remember { mutableStateOf<String?>(null) }
    var telefonoError by remember { mutableStateOf<String?>(null) }
    var rolError by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Crear Cuenta",
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = nombreCompleto,
            onValueChange = {
                nombreCompleto = it
                if (nombreError != null) nombreError = null
            },
            label = { Text("Nombre completo") },
            singleLine = true,
            isError = nombreError != null,
            supportingText = {
                if (nombreError != null) Text(text = nombreError!!)
            },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = correo,
            onValueChange = {
                correo = it
                if (correoError != null) correoError = null
            },
            label = { Text("Correo electrónico") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            isError = correoError != null,
            supportingText = {
                if (correoError != null) Text(text = correoError!!)
            },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = usuario,
            onValueChange = {
                usuario = it
                if (usuarioError != null) usuarioError = null
            },
            label = { Text("Nombre de usuario") },
            singleLine = true,
            isError = usuarioError != null,
            supportingText = {
                if (usuarioError != null) Text(text = usuarioError!!)
            },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = telefono,
            onValueChange = {
                telefono = it
                if (telefonoError != null) telefonoError = null
            },
            label = { Text("Teléfono") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
            isError = telefonoError != null,
            supportingText = {
                if (telefonoError != null) Text(text = telefonoError!!)
            },
            modifier = Modifier.fillMaxWidth()
        )


        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            OutlinedTextField(
                value = rol,
                onValueChange = {},
                readOnly = true,
                label = { Text("Rol") },
                trailingIcon = {
                    Icon(
                        imageVector = if (rolExpanded) Icons.Default.ArrowDropUp else Icons.Default.ArrowDropDown,
                        contentDescription = "Desplegar opciones de rol"
                    )
                },
                isError = rolError != null,
                supportingText = {
                    if (rolError != null) Text(text = rolError!!)
                },
                modifier = Modifier.fillMaxWidth()
            )

            Box(
                modifier = Modifier
                    .matchParentSize()
                    .clickable { rolExpanded = !rolExpanded }
            )
            // Menú emergente
            DropdownMenu(
                expanded = rolExpanded,
                onDismissRequest = { rolExpanded = false }
            ) {
                opcionesRol.forEach { opcion ->
                    DropdownMenuItem(
                        text = { Text(opcion) },
                        onClick = {
                            rol = opcion
                            rolExpanded = false
                            rolError = null
                        }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

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
                    modifier = Modifier.weight(1f),
                    onClick = {
                    nombreError = RegistroValidator.validarNombre(nombreCompleto)
                    correoError = RegistroValidator.validarCorreo(correo)
                    usuarioError = RegistroValidator.validarUsuario(usuario)
                    telefonoError = RegistroValidator.validarTelefono(telefono)
                    rolError = RegistroValidator.validarRol(rol)

                    val esValido = nombreError == null && correoError == null &&
                            usuarioError == null && telefonoError == null && rolError == null
                    if (esValido) {
                        onRegistroExitoso()
                    }
                }
            ) {
                Text("Aceptar")
            }
        }
    }
}