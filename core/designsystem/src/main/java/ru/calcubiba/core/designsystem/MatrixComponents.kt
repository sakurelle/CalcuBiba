package ru.calcubiba.core.designsystem

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun MatrixEditor(
    rowCount: Int,
    columnCount: Int,
    coefficientAt: (Int, Int) -> String,
    onCoefficientChange: (Int, Int, String) -> Unit,
    constantAt: (Int) -> String,
    onConstantChange: (Int, String) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.horizontalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        MatrixHeader(columnCount = columnCount)
        repeat(rowCount) { row ->
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                repeat(columnCount) { column ->
                    OutlinedTextField(
                        value = coefficientAt(row, column),
                        onValueChange = { onCoefficientChange(row, column, it) },
                        modifier = Modifier.width(88.dp),
                        singleLine = true,
                        label = { Text(text = "x${column + 1}") },
                    )
                }
                MatrixDivider()
                OutlinedTextField(
                    value = constantAt(row),
                    onValueChange = { onConstantChange(row, it) },
                    modifier = Modifier.width(88.dp),
                    singleLine = true,
                    label = { Text(text = "b") },
                )
            }
        }
    }
}

@Composable
fun MatrixTable(
    rows: List<List<String>>,
    pivotPositions: Set<Pair<Int, Int>>,
    inconsistentRows: Set<Int>,
    coefficientCount: Int,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.horizontalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        MatrixHeader(columnCount = coefficientCount)
        rows.forEachIndexed { rowIndex, row ->
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                row.forEachIndexed { columnIndex, value ->
                    if (columnIndex == coefficientCount) {
                        MatrixDivider()
                    }
                    val isPivot = pivotPositions.contains(rowIndex to columnIndex)
                    val isInconsistentRow = inconsistentRows.contains(rowIndex)
                    Box(
                        modifier = Modifier
                            .width(88.dp)
                            .background(
                                color = when {
                                    isInconsistentRow -> MaterialTheme.colorScheme.errorContainer
                                    isPivot -> MaterialTheme.colorScheme.primaryContainer
                                    else -> MaterialTheme.colorScheme.surfaceVariant
                                },
                                shape = MaterialTheme.shapes.small,
                            )
                            .border(
                                width = 1.dp,
                                color = MaterialTheme.colorScheme.outlineVariant,
                                shape = MaterialTheme.shapes.small,
                            )
                            .padding(vertical = 14.dp, horizontal = 8.dp),
                    ) {
                        Text(
                            text = value,
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.bodyMedium,
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun MatrixHeader(columnCount: Int) {
    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        repeat(columnCount) { column ->
            Text(
                text = "x${column + 1}",
                modifier = Modifier.width(88.dp),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.labelLarge,
            )
        }
        Box(modifier = Modifier.width(8.dp))
        Text(
            text = "b",
            modifier = Modifier.width(88.dp),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.labelLarge,
        )
    }
}

@Composable
private fun MatrixDivider() {
    Box(
        modifier = Modifier
            .width(8.dp)
            .background(
                color = MaterialTheme.colorScheme.secondaryContainer,
                shape = MaterialTheme.shapes.small,
            ),
    )
}
