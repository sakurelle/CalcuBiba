package ru.calcubiba.calculator.gauss;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.runtime.Composable;
import androidx.compose.ui.Modifier;
import java.math.BigInteger;
import ru.calcubiba.core.math.GeneralSolution;
import ru.calcubiba.core.math.LinearSystemSolution;
import ru.calcubiba.core.math.RowOperation;
import ru.calcubiba.core.math.SolutionType;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000P\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u001a$\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005H\u0007\u001a$\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005H\u0007\u001a$\u0010\b\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005H\u0007\u001a$\u0010\t\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005H\u0007\u001a\u0010\u0010\n\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a2\u0010\u000b\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\rH\u0007\u001a$\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005H\u0007\u001a\u0016\u0010\u000f\u001a\u00020\u00012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0007\u001a\u0016\u0010\u0013\u001a\u00020\u00012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0007\u001a\u0016\u0010\u0014\u001a\u00020\u00012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0007\u001a\u0016\u0010\u0015\u001a\u00020\u00012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0007\u001a\u0012\u0010\u0016\u001a\u00020\u0017*\b\u0012\u0004\u0012\u00020\u00120\u0018H\u0002\u001a\u0012\u0010\u0016\u001a\u00020\u0017*\b\u0012\u0004\u0012\u00020\u00120\u0019H\u0002\u001a\f\u0010\u001a\u001a\u00020\u0017*\u00020\u001bH\u0003\u001a\u0012\u0010\u001c\u001a\u00020\u0017*\b\u0012\u0004\u0012\u00020\u00120\u001dH\u0002\u001a\u0012\u0010\u001e\u001a\u00020\u0017*\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0003\u001a\u0012\u0010\u001f\u001a\u00020\u0017*\b\u0012\u0004\u0012\u00020 0\u001dH\u0002\u00a8\u0006!"}, d2 = {"AugmentedMatrixEditor", "", "state", "Lru/calcubiba/calculator/gauss/GaussUiState;", "onAction", "Lkotlin/Function1;", "Lru/calcubiba/calculator/gauss/GaussUiAction;", "GaussActions", "GaussConfigurationSection", "GaussInputModeSelector", "GaussResultSection", "GaussScreen", "onBack", "Lkotlin/Function0;", "LinearSystemEditor", "RowOperationsCard", "result", "Lru/calcubiba/core/math/LinearSystemSolution;", "Ljava/math/BigInteger;", "RrefMatrixCard", "SolutionCard", "VariableClassificationCard", "asDisplayText", "", "Lru/calcubiba/core/math/GeneralSolution;", "Lru/calcubiba/core/math/RowOperation;", "asText", "Lru/calcubiba/calculator/gauss/GaussError;", "formatVector", "", "statusText", "toVariableList", "", "gauss_release"})
public final class GaussScreenKt {
    
    @androidx.compose.runtime.Composable()
    public static final void GaussScreen(@org.jetbrains.annotations.NotNull()
    ru.calcubiba.calculator.gauss.GaussUiState state, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super ru.calcubiba.calculator.gauss.GaussUiAction, kotlin.Unit> onAction, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onBack) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void GaussConfigurationSection(@org.jetbrains.annotations.NotNull()
    ru.calcubiba.calculator.gauss.GaussUiState state, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super ru.calcubiba.calculator.gauss.GaussUiAction, kotlin.Unit> onAction) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void GaussInputModeSelector(@org.jetbrains.annotations.NotNull()
    ru.calcubiba.calculator.gauss.GaussUiState state, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super ru.calcubiba.calculator.gauss.GaussUiAction, kotlin.Unit> onAction) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void LinearSystemEditor(@org.jetbrains.annotations.NotNull()
    ru.calcubiba.calculator.gauss.GaussUiState state, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super ru.calcubiba.calculator.gauss.GaussUiAction, kotlin.Unit> onAction) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void AugmentedMatrixEditor(@org.jetbrains.annotations.NotNull()
    ru.calcubiba.calculator.gauss.GaussUiState state, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super ru.calcubiba.calculator.gauss.GaussUiAction, kotlin.Unit> onAction) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void GaussActions(@org.jetbrains.annotations.NotNull()
    ru.calcubiba.calculator.gauss.GaussUiState state, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super ru.calcubiba.calculator.gauss.GaussUiAction, kotlin.Unit> onAction) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void GaussResultSection(@org.jetbrains.annotations.NotNull()
    ru.calcubiba.calculator.gauss.GaussUiState state) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void RrefMatrixCard(@org.jetbrains.annotations.NotNull()
    ru.calcubiba.core.math.LinearSystemSolution<java.math.BigInteger> result) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void VariableClassificationCard(@org.jetbrains.annotations.NotNull()
    ru.calcubiba.core.math.LinearSystemSolution<java.math.BigInteger> result) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void SolutionCard(@org.jetbrains.annotations.NotNull()
    ru.calcubiba.core.math.LinearSystemSolution<java.math.BigInteger> result) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void RowOperationsCard(@org.jetbrains.annotations.NotNull()
    ru.calcubiba.core.math.LinearSystemSolution<java.math.BigInteger> result) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final java.lang.String asText(ru.calcubiba.calculator.gauss.GaussError $this$asText) {
        return null;
    }
    
    @androidx.compose.runtime.Composable()
    private static final java.lang.String statusText(ru.calcubiba.core.math.LinearSystemSolution<java.math.BigInteger> $this$statusText) {
        return null;
    }
    
    private static final java.lang.String toVariableList(java.util.List<java.lang.Integer> $this$toVariableList) {
        return null;
    }
    
    private static final java.lang.String formatVector(java.util.List<? extends java.math.BigInteger> $this$formatVector) {
        return null;
    }
    
    private static final java.lang.String asDisplayText(ru.calcubiba.core.math.GeneralSolution<java.math.BigInteger> $this$asDisplayText) {
        return null;
    }
    
    private static final java.lang.String asDisplayText(ru.calcubiba.core.math.RowOperation<java.math.BigInteger> $this$asDisplayText) {
        return null;
    }
}