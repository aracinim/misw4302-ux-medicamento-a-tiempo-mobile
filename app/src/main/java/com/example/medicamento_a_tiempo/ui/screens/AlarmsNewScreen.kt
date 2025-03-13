package com.example.medicamento_a_tiempo.ui.screens


import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.medicamento_a_tiempo.R
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AlarmsNewScreen(navController: NavController) {
    var medicamento by remember { mutableStateOf("Acetaminofem") }
    var dosis by remember { mutableStateOf("1") }
    var cadaTiempo by remember { mutableStateOf("12") }
    var tiempoHoras by remember { mutableStateOf("Horas") }
    var horaInicio by remember { mutableStateOf("05:00") }
    var horaFin by remember { mutableStateOf("05:00") }
    var fechaInicio by remember { mutableStateOf("20/02/2025") }
    var fechaFin by remember { mutableStateOf("20/04/2025") }

    var showStartDatePicker by remember { mutableStateOf(false) }
    var showEndDatePicker by remember { mutableStateOf(false) }

    var selectedStartDate by remember { mutableStateOf<Date?>(null) }
    var selectedEndDate by remember { mutableStateOf<Date?>(null) }

    var isImageSelected by remember { mutableStateOf(false) }

    val context = LocalContext.current

    var mostrarDialogoGuardar by remember { mutableStateOf(false) }
    var mostrarDialogoCancelar by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Nueva Alarma",
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
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally // 🔹 Centra horizontalmente
        ) {
            // Row 1: Medicamento
            OutlinedTextField(
                value = medicamento,
                onValueChange = { medicamento = it },
                label = { Text("Medicamento") },
                singleLine = true,
                supportingText = { Text("Nombre del medicamento") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Row 2: Dosis
            OutlinedTextField(
                value = dosis,
                onValueChange = { dosis = it },
                label = { Text("Dosis") },
                supportingText = { Text("Cantidad") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Row 3: Tomar Foto
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(onClick = {
                    // TODO: Implement Take Photo Logic
                    isImageSelected = true
                }) {
                    Text("Tomar Foto")
                }
                // Image Preview
                if (!isImageSelected) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_launcher_foreground),
                        contentDescription = "Preview",
                        modifier = Modifier.size(50.dp)
                    )
                } else {
                    Image(
                        painter = painterResource(id = R.drawable.ic_launcher_background),
                        contentDescription = "Preview",
                        modifier = Modifier.size(50.dp)
                    )
                }

            }

            Spacer(modifier = Modifier.height(16.dp))

            // Row 4: Cada Tiempo
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                OutlinedTextField(
                    value = cadaTiempo,
                    onValueChange = { cadaTiempo = it },
                    label = { Text("Cada") },
                    singleLine = true,
                    supportingText = { Text("Tiempo") },
                    modifier = Modifier.weight(1f),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )
                OutlinedTextField(
                    value = tiempoHoras,
                    onValueChange = { tiempoHoras = it },
                    label = { Text("Tiempo") },
                    singleLine = true,
                    supportingText = { Text("Horas") },
                    modifier = Modifier.weight(1f)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Row 5: Hora Inicio & Fecha Inicio
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                OutlinedTextField(
                    value = horaInicio,
                    onValueChange = { horaInicio = it },
                    label = { Text("Hora Inicio") },
                    supportingText = { Text("Hora") },
                    singleLine = true,
                    modifier = Modifier.weight(1f),
                )
                OutlinedTextField(
                    value = fechaInicio,
                    onValueChange = { fechaInicio = it },
                    label = { Text("Fecha Inicio") },
                    singleLine = true,
                    modifier = Modifier.weight(1f),
                    supportingText = { Text("DD/MM/YYYY") },
                    trailingIcon = {
                        IconButton(onClick = { showStartDatePicker = true }) {
                            Icon(
                                imageVector = Icons.Default.DateRange,
                                contentDescription = "Fecha"
                            )
                        }
                    }
                )
            }
            if (showStartDatePicker) {
                val datePickerState = rememberDatePickerState()
                DatePickerDialog(
                    onDismissRequest = { showStartDatePicker = false },
                    confirmButton = {
                        Button(onClick = {
                            showStartDatePicker = false
                            selectedStartDate = Date(datePickerState.selectedDateMillis!!)
                            val formatter = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
                            fechaInicio = formatter.format(selectedStartDate)
                            Toast.makeText(
                                context,
                                "Fecha Seleccionada: ${selectedStartDate}",
                                Toast.LENGTH_SHORT
                            ).show()
                        }) {
                            Text("OK")
                        }
                    },
                    dismissButton = {
                        Button(onClick = {
                            showStartDatePicker = false
                        }) {
                            Text("Cancel")
                        }
                    }
                ) {
                    DatePicker(state = datePickerState)
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Row 6: Hora Fin & Fecha Fin
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                OutlinedTextField(
                    value = horaFin,
                    onValueChange = { horaFin = it },
                    label = { Text("Hora Fin") },
                    supportingText = { Text("Hora") },
                    singleLine = true,
                    modifier = Modifier.weight(1f)
                )
                OutlinedTextField(
                    value = fechaFin,
                    onValueChange = { fechaFin = it },
                    label = { Text("Fecha Fin") },
                    singleLine = true,
                    modifier = Modifier.weight(1f),
                    supportingText = { Text("DD/MM/YYYY") },
                    trailingIcon = {
                        IconButton(onClick = { showEndDatePicker = true }) {
                            Icon(
                                imageVector = Icons.Default.DateRange,
                                contentDescription = "Fecha"
                            )
                        }
                    }
                )

            }

            if (showEndDatePicker) {
                val datePickerState = rememberDatePickerState()
                DatePickerDialog(
                    onDismissRequest = { showEndDatePicker = false },
                    confirmButton = {
                        Button(onClick = {
                            showEndDatePicker = false
                            selectedEndDate = Date(datePickerState.selectedDateMillis!!)
                            val formatter = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
                            fechaFin = formatter.format(selectedEndDate)
                            Toast.makeText(
                                context,
                                "Fecha Seleccionada: ${selectedEndDate}",
                                Toast.LENGTH_SHORT
                            ).show()
                        }) {
                            Text("OK")
                        }
                    },
                    dismissButton = {
                        Button(onClick = {
                            showEndDatePicker = false
                        }) {
                            Text("Cancel")
                        }
                    }
                ) {
                    DatePicker(state = datePickerState)
                }
            }


            Spacer(modifier = Modifier.height(16.dp))
            // Row 7: Enviar & Cancelar
            Row(
                modifier = Modifier.width(200.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Button(onClick = {
                     mostrarDialogoGuardar = true
                }) {
                    Text("Enviar")
                }
                Spacer(modifier = Modifier.weight(1f))
                Button(
                    onClick = { mostrarDialogoCancelar = true },
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.error)
                ) {
                    Text("Cancelar")
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            if (mostrarDialogoGuardar) {
                AlertDialog(
                    onDismissRequest = { mostrarDialogoGuardar = false },
                    title = { Text("Confirmar guardado") },
                    text = { Text("¿Estás seguro de que quieres guardar la información?") },
                    confirmButton = {
                        TextButton(onClick = {
                            // Lógica para guardar la información aquí
                            Toast.makeText(context, "Se ha guardado la informacion de la alarma.", Toast.LENGTH_SHORT).show()
                            navController.navigate("alarm_list")
                            mostrarDialogoGuardar = false
                        }) {
                            Text("Guardar")
                        }
                    },
                    dismissButton = {
                        TextButton(onClick = { mostrarDialogoGuardar = false }) {
                            Text("Cancelar")
                        }
                    }
                )
            }

            if (mostrarDialogoCancelar) {
                AlertDialog(
                    onDismissRequest = { mostrarDialogoCancelar = false },
                    title = { Text("Descartar informacion") },
                    text = { Text("¿Estás seguro de que quieres descartar la información?") },
                    confirmButton = {
                        TextButton(onClick = {
                            // Lógica para descartar la información aquí
                            Toast.makeText(context, "Información de alarma descartada.", Toast.LENGTH_SHORT).show()
                            navController.navigate("alarm_list")
                            mostrarDialogoCancelar = false
                        }) {
                            Text("Descartar")
                        }
                    },
                    dismissButton = {
                        TextButton(onClick = {
                            mostrarDialogoCancelar = false
                        }) {
                            Text("Cancelar")
                        }
                    }
                )
            }
            
        }
    }
}