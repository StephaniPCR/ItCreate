package com.example.itCreate.validacion

object LoginValidator {
    fun validarEmail(email: String): String? {
        return if (email.trim().isEmpty()) "El correo es obligatorio" else null
    }
    fun validarContrasena(contrasena: String): String? {
        return if (contrasena.trim().isEmpty()) "La contraseña no puede estar vacía" else null
    }
}