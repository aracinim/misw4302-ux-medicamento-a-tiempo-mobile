package com.example.medicamento_a_tiempo.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.medicamento_a_tiempo.ui.screens.AlarmListScreen
import com.example.medicamento_a_tiempo.ui.screens.AlarmsEditScreen
import com.example.medicamento_a_tiempo.ui.screens.AlarmsNewScreen
import com.example.medicamento_a_tiempo.ui.screens.LoginScreen
import com.example.medicamento_a_tiempo.ui.screens.NotificacionScreen
import com.example.medicamento_a_tiempo.ui.screens.RegisterScreen

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "login") {
        composable("login") { LoginScreen(navController) }
        composable("register") { RegisterScreen(navController) }
        composable("alarm_list") { AlarmListScreen(navController) }
        composable("manage_alarm") { AlarmsNewScreen(navController) }
        composable("manage_edit") { AlarmsEditScreen(navController) }
        composable("notificacion") { NotificacionScreen(navController) }
    }
}