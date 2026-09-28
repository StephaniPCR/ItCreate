package com.example.itCreate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.itCreate.model.Tarjeta
import com.example.itCreate.model.TipoMultimedia
import com.example.itCreate.ui.screen.MainScreen
import com.example.itCreate.ui.theme.ItCreateTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ItCreateTheme {
                //Andamio o estructura móvil
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    //MainScreen + datos de prueba
                   MainScreen(
                       modifier = Modifier
                           .fillMaxSize()
                           .padding(innerPadding)
                           .padding(8.dp),
                       tarjetas = listOf(
                           Tarjeta(
                               titulo = "Idea de Reels",
                               descripcion = "Transiciones rápidas para vídeos",
                               autor = "Camel",
                               tipo = TipoMultimedia.VID
                           ),
                           Tarjeta(
                               titulo = "Idea carrusel",
                               descripcion = "Inspiracion para carruseles",
                               autor = "HermanosJ",
                               tipo = TipoMultimedia.IMG
                           ),
                           Tarjeta(
                               titulo = "Edición de vídeos",
                               descripcion = "Ideas sencillas apra editar vídeos",
                               autor = "Lola",
                               tipo = TipoMultimedia.IMG
                           ),
                           Tarjeta(
                               titulo = "Audios",
                               descripcion = "Mejora la calidad de tus audios",
                               autor = "Paoli",
                               tipo = TipoMultimedia.VID
                           ),
                           Tarjeta(
                               titulo = "Idea guión",
                               descripcion = "Prepara tus guiones",
                               autor = "Konan",
                               tipo = TipoMultimedia.IMG
                           )
                       )
                   )
                }
            }
        }
    }
}

/*@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MainScreen(
        modifier = Modifier,
        tarjetas = listOf(
            Tarjeta(
                titulo = "Idea de Vídeo",
                descripcion = "Transición rápida",
                autor = "Creador",
                tipo = TipoMultimedia.VID
            )
        )
    )
}*/
