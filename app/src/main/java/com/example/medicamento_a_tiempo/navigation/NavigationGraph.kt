package com.example.medicamento_a_tiempo.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.medicamento_a_tiempo.ui.screens.AlarmListScreen
import com.example.medicamento_a_tiempo.ui.screens.AlarmsFieldsForm
import com.example.medicamento_a_tiempo.ui.screens.LoginScreen
import com.example.medicamento_a_tiempo.ui.screens.RegisterScreen

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "login") {
        composable("login") { LoginScreen(navController) }
        composable("register") { RegisterScreen(navController) }
        composable("alarm_list") { AlarmListScreen(navController) }
        composable("manage_alarm") { AlarmsFieldsForm(navController) }
    }
}