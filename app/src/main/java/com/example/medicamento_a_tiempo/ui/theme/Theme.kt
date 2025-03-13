package com.example.medicamento_a_tiempo.ui.theme

import android.graphics.Color
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColorScheme = lightColorScheme(
    primary = androidx.compose.ui.graphics.Color(Color.parseColor("#39608F")),
    secondary = androidx.compose.ui.graphics.Color(Color.parseColor("#366756")),
    tertiary = androidx.compose.ui.graphics.Color(Color.parseColor("#8FD2D0")),
    background = androidx.compose.ui.graphics.Color.White,
    error = androidx.compose.ui.graphics.Color(Color.parseColor("#811D25")),
    onSurface = androidx.compose.ui.graphics.Color(Color.parseColor("#1B1B1C")),
)

@Composable
fun MedicamentoATiempoTheme(content: @Composable () -> Unit) {
    MaterialTheme(colorScheme = LightColorScheme, content = content, typography = Typography)
}