package ru.calcubiba.calculator.gauss

import android.content.Context
import androidx.compose.runtime.Composable
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import ru.calcubiba.core.calculator.api.CalculatorCategory
import ru.calcubiba.core.calculator.api.CalculatorDescriptor
import ru.calcubiba.core.calculator.api.CalculatorIconKey
import ru.calcubiba.core.calculator.api.CalculatorPlugin

class GaussCalculatorPlugin @Inject constructor(
    @ApplicationContext private val context: Context,
) : CalculatorPlugin {
    override val descriptor: CalculatorDescriptor
        get() = CalculatorDescriptor(
            id = "linear-algebra.gaussian-elimination",
            title = context.getString(R.string.gauss_title),
            shortDescription = context.getString(R.string.gauss_short_description),
            category = CalculatorCategory.LINEAR_ALGEBRA,
            iconKey = CalculatorIconKey.MATRIX,
            order = 10,
        )

    @Composable
    override fun EntryPoint(onBack: () -> Unit) {
        GaussRoute(onBack = onBack)
    }
}
