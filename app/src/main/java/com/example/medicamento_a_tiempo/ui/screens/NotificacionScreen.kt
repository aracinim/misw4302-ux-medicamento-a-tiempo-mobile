package com.example.medicamento_a_tiempo.ui.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.medicamento_a_tiempo.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotificacionScreen(
    navController: NavController
) {
    var titulo by remember { mutableStateOf("Notificacion de Medicamento") }
    var nombreMedicamento by remember { mutableStateOf("Acetaminofem") }
    var diaHoraAlarma by remember { mutableStateOf("22/03/2025 10:00") }
    var dosis by remember { mutableStateOf("2") }
    val context = LocalContext.current

    Surface(
        modifier = Modifier.fillMaxSize(),
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(30.dp))
            Text(
                text = titulo,
                fontSize = 24.sp,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(12.dp))
            Image(
                painter = painterResource(id = R.drawable.medicamento),
                contentDescription = "Medicamento",
                modifier = Modifier
                    .size(340.dp)
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = nombreMedicamento,
                fontSize = 18.sp,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = diaHoraAlarma,
                fontSize = 16.sp,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "Dosis: $dosis",
                fontSize = 16.sp,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                modifier = Modifier.width(200.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Button(onClick = {
                    navController.popBackStack()
                    Toast.makeText(context, "Enviado a las estadisticas.", Toast.LENGTH_SHORT).show()
                },
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)) {
                    Text("Tomar")
                }
                Spacer(modifier = Modifier.weight(1f))
                Button(
                    onClick = {
                        navController.popBackStack()
                        Toast.makeText(context, "Sin estadisticas de toma.", Toast.LENGTH_SHORT).show()
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.error)
                ) {
                    Text("No tomar")
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}