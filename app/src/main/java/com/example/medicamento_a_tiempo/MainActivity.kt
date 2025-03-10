package com.example.medicamento_a_tiempo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.medicamento_a_tiempo.navigation.NavigationGraph
import com.example.medicamento_a_tiempo.ui.theme.MedicamentoATiempoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MedicamentoATiempoTheme {
                val navController = rememberNavController()
                NavigationGraph(navController)
            }
        }
    }
}