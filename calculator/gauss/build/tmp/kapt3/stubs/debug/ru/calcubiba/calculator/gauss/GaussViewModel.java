package ru.calcubiba.calculator.gauss;

import androidx.lifecycle.ViewModel;
import dagger.hilt.android.lifecycle.HiltViewModel;
import java.math.BigInteger;
import javax.inject.Inject;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.StateFlow;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\u000e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012J*\u0010\u0013\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u0014\u0018\u00010\u00142\u0012\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00140\u0014H\u0002J\u001e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00142\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0014H\u0002J\u0010\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u0017H\u0002J8\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00140\u00142\u0012\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00140\u00142\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002J\u0010\u0010 \u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u0017H\u0002J$\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00170\u00142\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00170\u00142\u0006\u0010\"\u001a\u00020\u001eH\u0002J \u0010#\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020\u0017H\u0002J\u0018\u0010\'\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020\u0017H\u0002R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u00a8\u0006("}, d2 = {"Lru/calcubiba/calculator/gauss/GaussViewModel;", "Landroidx/lifecycle/ViewModel;", "solveGaussSystemUseCase", "Lru/calcubiba/calculator/gauss/SolveGaussSystemUseCase;", "calculationDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lru/calcubiba/calculator/gauss/SolveGaussSystemUseCase;Lkotlinx/coroutines/CoroutineDispatcher;)V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lru/calcubiba/calculator/gauss/GaussUiState;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "calculate", "", "onAction", "action", "Lru/calcubiba/calculator/gauss/GaussUiAction;", "parseMatrix", "", "Ljava/math/BigInteger;", "values", "", "parseVector", "resizeColumns", "rawValue", "resizeMatrix", "current", "newRowCount", "", "newColumnCount", "resizeRows", "resizeVector", "newSize", "updateCoefficient", "row", "column", "value", "updateConstant", "gauss_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class GaussViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final ru.calcubiba.calculator.gauss.SolveGaussSystemUseCase solveGaussSystemUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.CoroutineDispatcher calculationDispatcher = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<ru.calcubiba.calculator.gauss.GaussUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<ru.calcubiba.calculator.gauss.GaussUiState> uiState = null;
    
    @javax.inject.Inject()
    public GaussViewModel(@org.jetbrains.annotations.NotNull()
    ru.calcubiba.calculator.gauss.SolveGaussSystemUseCase solveGaussSystemUseCase, @org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.CoroutineDispatcher calculationDispatcher) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<ru.calcubiba.calculator.gauss.GaussUiState> getUiState() {
        return null;
    }
    
    public final void onAction(@org.jetbrains.annotations.NotNull()
    ru.calcubiba.calculator.gauss.GaussUiAction action) {
    }
    
    private final void updateCoefficient(int row, int column, java.lang.String value) {
    }
    
    private final void updateConstant(int row, java.lang.String value) {
    }
    
    private final void resizeRows(java.lang.String rawValue) {
    }
    
    private final void resizeColumns(java.lang.String rawValue) {
    }
    
    private final void calculate() {
    }
    
    private final java.util.List<java.util.List<java.math.BigInteger>> parseMatrix(java.util.List<? extends java.util.List<java.lang.String>> values) {
        return null;
    }
    
    private final java.util.List<java.math.BigInteger> parseVector(java.util.List<java.lang.String> values) {
        return null;
    }
    
    private final java.util.List<java.util.List<java.lang.String>> resizeMatrix(java.util.List<? extends java.util.List<java.lang.String>> current, int newRowCount, int newColumnCount) {
        return null;
    }
    
    private final java.util.List<java.lang.String> resizeVector(java.util.List<java.lang.String> current, int newSize) {
        return null;
    }
}