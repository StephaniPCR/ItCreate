package com.example.itCreate.validacion

import android.util.Patterns

object RegistroValidator {
    fun validarNombre(nombre: String): String? {
        return if (nombre.trim().isEmpty()) "El nombre completo es obligatorio" else null
    }

    fun validarCorreo(correo: String): String? {
        return when {
            correo.trim().isEmpty() -> "El correo es obligatorio"
            !Patterns.EMAIL_ADDRESS.matcher(correo.trim()).matches() -> "Formato de correo inválido"
            else -> null
        }
    }

    fun validarUsuario(usuario: String): String? {
        return when {
            usuario.trim().isEmpty() -> "El usuario es obligatorio"
            usuario.trim().length < 3 -> "Mínimo 3 caracteres"
            else -> null
        }
    }

    fun validarTelefono(telefono: String): String? {
        return when {
            telefono.trim().isEmpty() -> "El teléfono es obligatorio"
            !telefono.all { it.isDigit() } || telefono.length < 9 -> "Mínimo 9 dígitos"
            else -> null
        }
    }

    fun validarRol(rol: String): String? {
        return if (rol.isEmpty()) "Debes seleccionar un rol" else null
    }
}