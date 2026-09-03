package ru.calcubiba.core.designsystem

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColors = lightColorScheme(
    primary = Color(0xFF2F5D62),
    onPrimary = Color(0xFFF8F7F3),
    primaryContainer = Color(0xFFD2E8E2),
    onPrimaryContainer = Color(0xFF183437),
    secondary = Color(0xFF8A6840),
    onSecondary = Color(0xFFFFF8F0),
    secondaryContainer = Color(0xFFF3E0C9),
    onSecondaryContainer = Color(0xFF4A351E),
    tertiary = Color(0xFF6B7C40),
    onTertiary = Color(0xFFFBFCEB),
    background = Color(0xFFF4F1E8),
    onBackground = Color(0xFF1E2324),
    surface = Color(0xFFFFFBF2),
    onSurface = Color(0xFF1E2324),
    surfaceVariant = Color(0xFFE4E0D5),
    onSurfaceVariant = Color(0xFF45483F),
    error = Color(0xFF9E3D30),
    onError = Color(0xFFFFF8F7),
    errorContainer = Color(0xFFF7D8D2),
    onErrorContainer = Color(0xFF4B1710),
)

private val DarkColors = darkColorScheme(
    primary = Color(0xFFA7D1CA),
    onPrimary = Color(0xFF123033),
    primaryContainer = Color(0xFF244A4E),
    onPrimaryContainer = Color(0xFFD8EFE8),
    secondary = Color(0xFFE2C59A),
    onSecondary = Color(0xFF422E18),
    secondaryContainer = Color(0xFF5B4125),
    onSecondaryContainer = Color(0xFFFFEED1),
    tertiary = Color(0xFFC6D59C),
    onTertiary = Color(0xFF2F3B12),
    background = Color(0xFF161B1C),
    onBackground = Color(0xFFE8E6DE),
    surface = Color(0xFF1C2223),
    onSurface = Color(0xFFE8E6DE),
    surfaceVariant = Color(0xFF40443C),
    onSurfaceVariant = Color(0xFFC6C8BE),
    error = Color(0xFFFFB4A8),
    onError = Color(0xFF61170F),
    errorContainer = Color(0xFF7D2A1F),
    onErrorContainer = Color(0xFFFFDAD3),
)

@Composable
fun CalcuBibaTheme(
    darkTheme: Boolean,
    content: @Composable () -> Unit,
) {
    MaterialTheme(
        colorScheme = if (darkTheme) DarkColors else LightColors,
        typography = MaterialTheme.typography,
        content = content,
    )
}
