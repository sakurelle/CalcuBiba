package ru.calcubiba.feature.catalog

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import ru.calcubiba.core.calculator.api.CalculatorCategory
import ru.calcubiba.core.calculator.api.CalculatorDescriptor
import ru.calcubiba.core.calculator.api.CalculatorRegistry
import ru.calcubiba.core.designsystem.CalculatorCard
import ru.calcubiba.core.designsystem.CalculatorScaffold
import ru.calcubiba.core.designsystem.ScreenSection
import ru.calcubiba.core.designsystem.SectionCard

@Composable
fun CatalogRoute(
    registry: CalculatorRegistry,
    onOpenCalculator: (String) -> Unit,
) {
    var query by rememberSaveable { mutableStateOf("") }
    val visibleCalculators = registry.search(query)
    val groupedCalculators = visibleCalculators.groupBy(CalculatorDescriptor::category)

    CalculatorScaffold(title = stringResource(R.string.catalog_title)) { paddingValues ->
        ScreenSection(paddingValues = paddingValues) {
            CatalogSearchField(
                query = query,
                onQueryChange = { query = it },
            )
            if (visibleCalculators.isEmpty()) {
                SectionCard(title = stringResource(R.string.catalog_empty_title)) {
                    Text(
                        text = stringResource(R.string.catalog_empty_message),
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                    )
                }
            } else {
                CalculatorCategory.entries.forEach { category ->
                    val descriptors = groupedCalculators[category].orEmpty()
                    if (descriptors.isNotEmpty()) {
                        CatalogCategorySection(
                            title = category.title(),
                            descriptors = descriptors,
                            onOpenCalculator = onOpenCalculator,
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun CatalogSearchField(
    query: String,
    onQueryChange: (String) -> Unit,
) {
    OutlinedTextField(
        value = query,
        onValueChange = onQueryChange,
        modifier = Modifier.fillMaxWidth(),
        singleLine = true,
        label = { Text(text = stringResource(R.string.catalog_search_label)) },
        placeholder = { Text(text = stringResource(R.string.catalog_search_placeholder)) },
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
        keyboardActions = KeyboardActions(onSearch = { }),
    )
}

@Composable
private fun CatalogCategorySection(
    title: String,
    descriptors: List<CalculatorDescriptor>,
    onOpenCalculator: (String) -> Unit,
) {
    SectionCard(title = title) {
        androidx.compose.foundation.layout.Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
            descriptors.forEach { descriptor ->
                CalculatorCard(
                    descriptor = descriptor,
                    onClick = { onOpenCalculator(descriptor.id) },
                )
            }
        }
    }
}

@Composable
private fun CalculatorCategory.title(): String {
    val context = LocalContext.current
    return when (this) {
        CalculatorCategory.LINEAR_ALGEBRA -> context.getString(R.string.category_linear_algebra)
        CalculatorCategory.FINITE_FIELDS -> context.getString(R.string.category_finite_fields)
        CalculatorCategory.POLYNOMIALS -> context.getString(R.string.category_polynomials)
        CalculatorCategory.CODING_THEORY -> context.getString(R.string.category_coding_theory)
    }
}
