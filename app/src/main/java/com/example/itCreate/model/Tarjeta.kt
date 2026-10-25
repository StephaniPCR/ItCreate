package com.example.itCreate.model

data class Tarjeta (
    val id: Int,
    val titulo: String,
    val descripcion: String,
    val autor: String,
    val tipo: String
    /*val comentario: String,
    val categoria: String,*/
)

object TipoMultimedia { //En segundos
    const val IMG = "Imagen"
    const val GIF = "GIF"
    const val VID = "Vídeo"
}