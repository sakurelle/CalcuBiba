package ru.calcubiba.core.designsystem

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AutoGraph
import androidx.compose.material.icons.filled.Functions
import androidx.compose.material.icons.filled.GridView
import androidx.compose.material.icons.filled.Hub
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import ru.calcubiba.core.calculator.api.CalculatorDescriptor
import ru.calcubiba.core.calculator.api.CalculatorIconKey

@Composable
fun CalculatorCard(
    descriptor: CalculatorDescriptor,
    onClick: () -> Unit,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            Icon(
                imageVector = descriptor.iconKey.toImageVector(),
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary,
            )
            Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                Text(
                    text = descriptor.title,
                    style = MaterialTheme.typography.titleMedium,
                )
                Text(
                    text = descriptor.shortDescription,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                )
            }
        }
    }
}

private fun CalculatorIconKey.toImageVector(): ImageVector = when (this) {
    CalculatorIconKey.MATRIX -> Icons.Default.GridView
    CalculatorIconKey.FIELD -> Icons.Default.AutoGraph
    CalculatorIconKey.POLYNOMIAL -> Icons.Default.Functions
    CalculatorIconKey.CODE -> Icons.Default.Hub
}
