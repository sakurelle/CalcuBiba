package ru.calcubiba

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import ru.calcubiba.core.calculator.api.CalculatorRegistry
import ru.calcubiba.core.designsystem.CalcuBibaTheme
import ru.calcubiba.core.designsystem.CalculatorScaffold
import ru.calcubiba.core.designsystem.ScreenSection
import ru.calcubiba.feature.catalog.CatalogRoute

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var calculatorRegistry: CalculatorRegistry

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CalcuBibaTheme(darkTheme = isSystemInDarkTheme()) {
                CalcuBibaApp(calculatorRegistry = calculatorRegistry)
            }
        }
    }
}

@Composable
fun CalcuBibaApp(
    calculatorRegistry: CalculatorRegistry,
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = AppRoute.CATALOG.route,
    ) {
        composable(AppRoute.CATALOG.route) {
            CatalogRoute(
                registry = calculatorRegistry,
                onOpenCalculator = { calculatorId ->
                    navController.navigate(AppRoute.Calculator.createRoute(calculatorId))
                },
            )
        }
        composable(
            route = AppRoute.Calculator.route,
            arguments = listOf(
                navArgument(AppRoute.Calculator.ARGUMENT_ID) {
                    type = NavType.StringType
                },
            ),
        ) { backStackEntry ->
            val calculatorId = backStackEntry.arguments?.getString(AppRoute.Calculator.ARGUMENT_ID).orEmpty()
            val plugin = calculatorRegistry.findById(calculatorId)

            if (plugin == null) {
                UnknownCalculatorScreen(onBack = navController::navigateUp)
            } else {
                BackHandler(onBack = navController::navigateUp)
                plugin.EntryPoint(onBack = navController::navigateUp)
            }
        }
    }
}

@Composable
private fun UnknownCalculatorScreen(onBack: () -> Unit) {
    CalculatorScaffold(
        title = stringResource(R.string.unknown_calculator_title),
        onBack = onBack,
    ) { paddingValues ->
        ScreenSection(paddingValues = paddingValues) {
            Text(text = stringResource(R.string.unknown_calculator_message))
        }
    }
}

private sealed class AppRoute(val route: String) {
    data object CATALOG : AppRoute("catalog")

    data object Calculator : AppRoute("calculator/{calculatorId}") {
        const val ARGUMENT_ID = "calculatorId"

        fun createRoute(calculatorId: String): String = "calculator/$calculatorId"
    }
}
