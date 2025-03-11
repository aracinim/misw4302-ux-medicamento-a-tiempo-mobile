package com.example.medicamento_a_tiempo.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
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
                title = { Text("Lista de Alarmas", textAlign = TextAlign.Center) },
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(Icons.Default.Menu, contentDescription = "Menú")
                    }
                },
                actions = {
                    IconButton(onClick = { /* Acción para perfil de usuario */ }) {
                        Icon(Icons.Default.Person, contentDescription = "Perfil")
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .fillMaxSize()
        ) {
            // Campo de selección de medicamento
            Text("Medicamento", style = MaterialTheme.typography.labelSmall)
            Box {
                OutlinedTextField(
                    value = selectedMedicamento,
                    onValueChange = {},
                    readOnly = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { expanded = true },
                    trailingIcon = {
                        IconButton(onClick = { expanded = true }) {
                            Icon(imageVector = Icons.Default.Menu, contentDescription = "Desplegar")
                        }
                    }
                )
                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    medicamentos.forEach { medicamento ->
                        DropdownMenuItem(
                            text = { Text(medicamento) },
                            onClick = {
                                selectedMedicamento = medicamento
                                expanded = false
                            }
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(1.dp))

            Text("Listado de Medicamentos", style = MaterialTheme.typography.labelSmall,
                modifier = Modifier.size(265.dp, 20.dp))


            Spacer(modifier = Modifier.height((7*25).dp))

            Text("Listado de Alarmas", style = MaterialTheme.typography.headlineSmall)
            Spacer(modifier = Modifier.height(8.dp))

            LazyColumn {
                items(alarmList) { alarm ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp),
                        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                    ) {
                        Text(
                            text = alarm,
                            modifier = Modifier.padding(16.dp),
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                }
            }
        }
    }
}
