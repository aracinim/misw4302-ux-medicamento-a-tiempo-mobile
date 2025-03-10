package com.example.medicamento_a_tiempo.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Bienvenido", style = MaterialTheme.typography.headlineLarge)
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Usuario o Correo") },
            singleLine = true,
            colors = TextFieldDefaults.outlinedTextFieldColors()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Contraseña") },
            singleLine = true,
            colors = TextFieldDefaults.outlinedTextFieldColors()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { navController.navigate("alarm_list") }) {
            Text("Ingresar")
        }

        TextButton(onClick = { navController.navigate("register") }) {
            Text("Nuevo Usuario")
        }
    }
}