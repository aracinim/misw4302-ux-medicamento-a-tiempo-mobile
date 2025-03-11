package com.example.medicamento_a_tiempo.ui.theme

import android.graphics.Color
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColorScheme = lightColorScheme(
    primary = androidx.compose.ui.graphics.Color(Color.parseColor("#39608F")),
    secondary = androidx.compose.ui.graphics.Color(Color.parseColor("#366756")),
    background = androidx.compose.ui.graphics.Color.White,
    error = androidx.compose.ui.graphics.Color(Color.parseColor("#811D25")),
    onSurface = androidx.compose.ui.graphics.Color(Color.parseColor("#7D7D7D")),
)

@Composable
fun MedicamentoATiempoTheme(content: @Composable () -> Unit) {
    MaterialTheme(colorScheme = LightColorScheme, content = content, typography = Typography)
}