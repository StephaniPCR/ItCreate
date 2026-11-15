package com.example.itCreate.validacion

object ContenidoValidator {

    fun validarTitulo(titulo: String): String? {
        return when {
            titulo.trim().isEmpty() -> "El título es obligatorio"
            titulo.trim().length > 50 -> "No puede superar los 50 caracteres"
            else -> null
        }
    }

    fun validarAutor(autor: String): String? {
        return when {
            autor.trim().isEmpty() -> "El autor es obligatorio"
            autor.trim().length < 3 -> "Mínimo 3 caracteres"
            else -> null
        }
    }

    fun validarDescripcion(descripcion: String): String? {
        return when {
            descripcion.trim().isEmpty() -> "La descripción es obligatoria"
            descripcion.trim().length > 250 -> "No puede superar los 250 caracteres"
            else -> null
        }
    }
}