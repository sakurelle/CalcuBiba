package ru.calcubiba.calculator.gauss;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import dagger.multibindings.IntoSet;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import ru.calcubiba.core.calculator.api.CalculatorPlugin;

@dagger.Module()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\'J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\tH\'\u00a8\u0006\u000b"}, d2 = {"Lru/calcubiba/calculator/gauss/GaussDiModule;", "", "()V", "bindGaussCalculatorPlugin", "Lru/calcubiba/core/calculator/api/CalculatorPlugin;", "implementation", "Lru/calcubiba/calculator/gauss/GaussCalculatorPlugin;", "bindSolveGaussSystemUseCase", "Lru/calcubiba/calculator/gauss/SolveGaussSystemUseCase;", "Lru/calcubiba/calculator/gauss/DefaultSolveGaussSystemUseCase;", "Companion", "gauss_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public abstract class GaussDiModule {
    @org.jetbrains.annotations.NotNull()
    public static final ru.calcubiba.calculator.gauss.GaussDiModule.Companion Companion = null;
    
    public GaussDiModule() {
        super();
    }
    
    @dagger.Binds()
    @org.jetbrains.annotations.NotNull()
    public abstract ru.calcubiba.calculator.gauss.SolveGaussSystemUseCase bindSolveGaussSystemUseCase(@org.jetbrains.annotations.NotNull()
    ru.calcubiba.calculator.gauss.DefaultSolveGaussSystemUseCase implementation);
    
    @dagger.Binds()
    @dagger.multibindings.IntoSet()
    @org.jetbrains.annotations.NotNull()
    public abstract ru.calcubiba.core.calculator.api.CalculatorPlugin bindGaussCalculatorPlugin(@org.jetbrains.annotations.NotNull()
    ru.calcubiba.calculator.gauss.GaussCalculatorPlugin implementation);
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007\u00a8\u0006\u0005"}, d2 = {"Lru/calcubiba/calculator/gauss/GaussDiModule$Companion;", "", "()V", "provideCalculationDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "gauss_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @dagger.Provides()
        @org.jetbrains.annotations.NotNull()
        public final kotlinx.coroutines.CoroutineDispatcher provideCalculationDispatcher() {
            return null;
        }
    }
}