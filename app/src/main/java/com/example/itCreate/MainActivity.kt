package com.example.itCreate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.itCreate.model.Tarjeta
import com.example.itCreate.model.TipoMultimedia
import com.example.itCreate.ui.navegacion.AppNavHost
import com.example.itCreate.ui.navegacion.MyAppBottomBar
import com.example.itCreate.ui.navegacion.MyAppTopBar
import com.example.itCreate.ui.navegacion.Rutas
import com.example.itCreate.ui.screen.MainScreen
import com.example.itCreate.ui.theme.ItCreateTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            //Historial de rutas: ¿Dónde he estado?
            val navController = rememberNavController()
            //Historial de pantallas
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            //Me indican en qué pantalla está el usuario
            val currentRoute = navBackStackEntry?.destination?.route
            //Mostramos top y bottom bar sólo si no estamos en login
            val showBars = currentRoute != Rutas.LOGIN

            ItCreateTheme {
                //Andamio o estructura móvil
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        if (showBars) {
                            MyAppTopBar(navController = navController)
                        }
                    },
                    bottomBar = {
                        if (showBars) {
                            MyAppBottomBar(navController = navController)
                        }
                    }
                ) { innerPadding ->
                    //El mapa que me permite cambiar de pantalla
                    AppNavHost(
                        navController = navController,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding),
                        //startDestination = Rutas.LOGIN //Login como primera pantalla
                    )
                }
            }
        }
    }
}
