package com.example.medicamento_a_tiempo.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.medicamento_a_tiempo.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(25.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Bienvenido", style = MaterialTheme.typography.headlineLarge)

        Spacer(modifier = Modifier.height(45.dp))

        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo de la App",
            modifier = Modifier.size(289.dp, 84.dp),
            alignment = Alignment.CenterStart
        )

        Spacer(modifier = Modifier.height(50.dp))

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Usuario o Correo") },
            singleLine = true,
            trailingIcon = {
                if (email.isNotEmpty()) {
                    IconButton(onClick = { email = "" }) {
                        Box(
                            modifier = Modifier
                                .size(20.dp)
                                .border(2.dp, MaterialTheme.colorScheme.onSurface, CircleShape),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.Clear,
                                contentDescription = "Borrar",
                                tint = MaterialTheme.colorScheme.onSurface
                            )
                        }
                    }
                }
            }
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            "Usuario Asignado o correo", style = MaterialTheme.typography.labelSmall,
            modifier = Modifier.size(265.dp, 20.dp)
        )

        Spacer(modifier = Modifier.height(25.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Contraseña") },
            singleLine = true,
            trailingIcon = {
                if (password.isNotEmpty()) {
                    IconButton(onClick = { password = "" }) {
                        Box(
                            modifier = Modifier
                                .size(20.dp)
                                .border(2.dp, MaterialTheme.colorScheme.onSurface, CircleShape),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.Clear,
                                contentDescription = "Borrar",
                                tint = MaterialTheme.colorScheme.onSurface,
                            )
                        }
                    }
                }
            }
        )

        Spacer(modifier = Modifier.height(20.dp))
        Text(
            "Contraseña", style = MaterialTheme.typography.labelSmall,
            modifier = Modifier.size(265.dp, 20.dp)
        )

        Spacer(modifier = Modifier.height(25.dp))

        Button(
            onClick = { navController.navigate("alarm_list") },
            modifier = Modifier.size(101.dp, 49.dp)
        ) {
            Text("Ingresar", fontWeight =  FontWeight.Medium)
        }

        Spacer(modifier = Modifier.height(25.dp))

        TextButton(
            onClick = { navController.navigate("register") },
            colors = ButtonDefaults.textButtonColors(contentColor = MaterialTheme.colorScheme.onSecondaryContainer)
        ) {
            Text("Nuevo Usuario", fontWeight =  FontWeight.Medium,
                style = MaterialTheme.typography.labelLarge)
        }
    }
}
