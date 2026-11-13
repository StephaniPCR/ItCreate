package com.example.itCreate.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.example.itCreate.validacion.LoginValidator
import androidx.compose.material3.Icon


@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    onLoginClick: () -> Unit,
    onRegistroClick:() -> Unit
) {
    var email by rememberSaveable { mutableStateOf("") }
    var contrasena by rememberSaveable { mutableStateOf("") }
    var contrasenaVisible by rememberSaveable { mutableStateOf(false) }

    var emailError by rememberSaveable { mutableStateOf<String?>(null) }
    var contrasenaError by rememberSaveable { mutableStateOf<String?>(null) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "ItCreate",
            style = MaterialTheme.typography.displayLarge
        )

        Text(
            text = "Inspírate y crea sin límites",
            style = MaterialTheme.typography.bodyLarge
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Campo email
        OutlinedTextField(
            value = email,
            onValueChange = {
                email = it
                if (emailError != null) emailError = null
            },
            label = { Text("E-mail") },
            isError = emailError != null,
            supportingText = {
                if (emailError != null)
                    Text(emailError!!)
            },
            modifier = Modifier.fillMaxWidth()
        )

        // Campo de Contraseña
        OutlinedTextField(
            value = contrasena,
            onValueChange = {
                contrasena = it
                if (contrasenaError != null) contrasenaError = null // Limpia el error al escribir
            },
            label = { Text("Contraseña") },
            singleLine = true,
            visualTransformation = if (contrasenaVisible)
                VisualTransformation.None
            else
                PasswordVisualTransformation(),
            trailingIcon = {
                IconButton(onClick = { contrasenaVisible = !contrasenaVisible }) {
                    Icon(
                        imageVector = if (contrasenaVisible) Icons.Default.VisibilityOff else Icons.Default.Visibility,
                        contentDescription = if (contrasenaVisible) "Ocultar contraseña" else "Mostrar contraseña"
                    )
                }
            },
            isError = contrasenaError != null,
            supportingText = {
                if (contrasenaError != null) Text(contrasenaError!!)
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                // Validamos pasando los textos como parámetros
                emailError = LoginValidator.validarEmail(email)
                contrasenaError = LoginValidator.validarContrasena(contrasena)

                // Si ambos están libres de error, navegamos
                if (emailError == null && contrasenaError == null) {
                    onLoginClick()
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Empezar a crear")
        }

        Spacer(modifier = Modifier.height(16.dp))

        TextButton(
            onClick = { onRegistroClick() }
        ) {
            Text(text = "Crear cuenta")
        }
    }
}