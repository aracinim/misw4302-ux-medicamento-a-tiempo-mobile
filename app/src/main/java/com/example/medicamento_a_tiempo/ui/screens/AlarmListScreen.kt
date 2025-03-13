package com.example.medicamento_a_tiempo.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AlarmListScreen(navController: NavController) {
    val alarmList = listOf("Para la tos", "Jarabe", "Aspirina")
    val medicamentos = listOf("Seleccione", "Nuevo Medicamento", "Acetaminofén")

    var expanded by remember { mutableStateOf(false) }
    var selectedMedicamento by remember { mutableStateOf(medicamentos[0]) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Lista de Alarmas",
                        style = MaterialTheme.typography.titleLarge,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth().padding(50.dp)
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(Icons.Default.Menu, contentDescription = "Menú")
                    }
                },
                actions = {
                    IconButton(
                        onClick = { navController.navigate("notificacion") },
                        modifier = Modifier
                            .size(40.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .size(20.dp)
                                .border(2.dp, MaterialTheme.colorScheme.onSurface, CircleShape),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(Icons.Default.Person, contentDescription = "Perfil", tint = Color.Black)
                        }

                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally // 🔹 Centra horizontalmente
        ) {
            Spacer(Modifier.height(50.dp))
            Box(
                modifier = Modifier.fillMaxWidth().wrapContentWidth(Alignment.CenterHorizontally) // 🔹 Centra horizontalmente
            ) {
                OutlinedTextField(
                    value = selectedMedicamento,
                    onValueChange = {},
                    readOnly = true,
                    modifier = Modifier
                        .size(290.dp, 56.dp)
                        .clickable { expanded = true },
                    trailingIcon = {
                        IconButton(onClick = { expanded = true }) {
                            Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = "Desplegar")
                        }
                    }
                )
                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false },
                    modifier = Modifier
                        .width(280.dp)
                        .background(Color(0xFFF1EDEC)) // Color del menú
                ) {
                    medicamentos.forEach { medicamento ->
                        DropdownMenuItem(
                            text = { Text(medicamento, style = MaterialTheme.typography.bodyLarge) },
                            onClick = {
                                selectedMedicamento = medicamento
                                expanded = false
                                navController.navigate("manage_alarm")
                            }
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                "Listado de Medicamentos",
                style = MaterialTheme.typography.labelSmall,
                modifier = Modifier.fillMaxWidth().padding(horizontal = 55.dp)
            )

            Spacer(modifier = Modifier.height((7 * 25).dp))

            Text(
                "Listado de Alarmas",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(horizontal = 50.dp).fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(25.dp))

            // Card para toda la lista de alarmas
            Card(
                modifier = Modifier
                    .size(280.dp, 136.dp)
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.CenterHorizontally), // 🔹 Centra la Card
                colors = CardDefaults.cardColors(containerColor = Color(0xFFF1EDEC))
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    alarmList.forEach { alarm ->
                        Text(
                            text = alarm,
                            modifier = Modifier
                                .padding(vertical = 8.dp)
                                .clickable {
                                    navController.navigate("manage_edit")
                                }
                                .fillMaxWidth(),
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                }
            }
        }
    }
}
