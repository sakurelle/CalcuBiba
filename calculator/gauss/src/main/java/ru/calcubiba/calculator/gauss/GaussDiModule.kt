package ru.calcubiba.calculator.gauss

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import ru.calcubiba.core.calculator.api.CalculatorPlugin

@Module
@InstallIn(SingletonComponent::class)
abstract class GaussDiModule {
    @Binds
    abstract fun bindSolveGaussSystemUseCase(
        implementation: DefaultSolveGaussSystemUseCase,
    ): SolveGaussSystemUseCase

    @Binds
    @IntoSet
    abstract fun bindGaussCalculatorPlugin(
        implementation: GaussCalculatorPlugin,
    ): CalculatorPlugin

    companion object {
        @Provides
        fun provideCalculationDispatcher(): CoroutineDispatcher = Dispatchers.Default
    }
}
