package com.example.medicamento_a_tiempo.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.sharp.Close
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.medicamento_a_tiempo.R

@Composable
fun RegisterScreen(navController: NavController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var showDialog by remember { mutableStateOf(false) } // Estado para el pop-up

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(25.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Crear Usuario", style = MaterialTheme.typography.headlineLarge)

        Spacer(modifier = Modifier.height(50.dp))

        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo de la App",
            modifier = Modifier.size(289.dp, 84.dp)
        )

        Spacer(modifier = Modifier.height(37.dp))

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Usuario o Correo") },
            singleLine = true,
            modifier = Modifier.width(290.dp)
        )

        Text("Usuario Asignado o correo", style = MaterialTheme.typography.labelSmall, modifier = Modifier.size(265.dp, 20.dp))

        Spacer(modifier = Modifier.height(25.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Contraseña") },
            singleLine = true,
            modifier = Modifier.width(290.dp)
        )

        Text("Contraseña", style = MaterialTheme.typography.labelSmall, modifier = Modifier.size(265.dp, 20.dp))

        Spacer(modifier = Modifier.height(25.dp))

        OutlinedTextField(
            value = confirmPassword,
            onValueChange = { confirmPassword = it },
            label = { Text("Repetir Contraseña") },
            singleLine = true,
            modifier = Modifier.width(290.dp)
        )

        Text("Escriba la Contraseña nuevamente", style = MaterialTheme.typography.labelSmall,
            modifier = Modifier.size(265.dp, 20.dp))

        Spacer(modifier = Modifier.height(50.dp))

        Button(
            onClick = { showDialog = true }, // Muestra el pop-up al registrar
            modifier = Modifier.size(107.dp, 40.dp)
        ) {
            Text("Registrar", fontWeight =  FontWeight.Medium,
                style = MaterialTheme.typography.labelLarge)
        }

        Spacer(modifier = Modifier.height(25.dp))

        TextButton(
            onClick = { navController.navigate("login") },
            colors = ButtonDefaults.textButtonColors(contentColor = MaterialTheme.colorScheme.onSecondaryContainer)
        ) {
            Text("Ir al Login", fontWeight =  FontWeight.Medium,
                style = MaterialTheme.typography.labelLarge)
        }
    }

    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            title = { Text("Usuario Creado") },
            text = { Text("El registro de usuario fue registrado exitosamente") },
            confirmButton = {
                TextButton(onClick = {
                    showDialog = false
                    navController.navigate("login")
                }) {
                    Text("Ok")
                }
            }
        )
    }
}

