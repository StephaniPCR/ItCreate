package com.example.itCreate.model

import com.example.itCreate.R

data class Carpeta(
    val id: Int,
    val titulo: String,
    val descripcion: String,
    val imagenRes: Int = R.drawable.image_mockup
)

