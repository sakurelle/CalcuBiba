package ru.calcubiba.calculator.gauss;

import java.math.BigInteger;
import javax.inject.Inject;
import ru.calcubiba.core.math.AugmentedMatrix;
import ru.calcubiba.core.math.GaussJordanSolver;
import ru.calcubiba.core.math.GeneralSolution;
import ru.calcubiba.core.math.LinearSystemSolution;
import ru.calcubiba.core.math.Matrix;
import ru.calcubiba.core.math.PrimeField;
import ru.calcubiba.core.math.Rational;
import ru.calcubiba.core.math.RationalField;
import ru.calcubiba.core.math.RowOperation;
import ru.calcubiba.core.math.SolutionType;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u0087\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0005\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0012\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0005\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u0005\u00a2\u0006\u0002\u0010\u0011J\t\u0010\u001e\u001a\u00020\u0003H\u00c6\u0003J\u0015\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0005H\u00c6\u0003J\u000f\u0010 \u001a\b\u0012\u0004\u0012\u00020\b0\u0005H\u00c6\u0003J\u000f\u0010!\u001a\b\u0012\u0004\u0012\u00020\b0\u0005H\u00c6\u0003J\u0011\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u00c6\u0003J\u0015\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0005H\u00c6\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\rH\u00c6\u0003J\u000f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0005H\u00c6\u0003J\u000f\u0010&\u001a\b\u0012\u0004\u0012\u00020\b0\u0005H\u00c6\u0003J\u009d\u0001\u0010\'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00052\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00052\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00052\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u0005H\u00c6\u0001J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010+\u001a\u00020\bH\u00d6\u0001J\t\u0010,\u001a\u00020\u0006H\u00d6\u0001R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\f\u001a\u0004\u0018\u00010\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u001d\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0019\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u001d\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d\u00a8\u0006-"}, d2 = {"Lru/calcubiba/calculator/gauss/GaussSolveResult;", "", "type", "Lru/calcubiba/core/math/SolutionType;", "reducedMatrix", "", "", "pivotColumns", "", "freeColumns", "particularSolution", "nullSpaceBasis", "generalSolution", "Lru/calcubiba/calculator/gauss/GaussGeneralSolution;", "rowOperations", "Lru/calcubiba/calculator/gauss/GaussRowOperation;", "inconsistentRows", "(Lru/calcubiba/core/math/SolutionType;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lru/calcubiba/calculator/gauss/GaussGeneralSolution;Ljava/util/List;Ljava/util/List;)V", "getFreeColumns", "()Ljava/util/List;", "getGeneralSolution", "()Lru/calcubiba/calculator/gauss/GaussGeneralSolution;", "getInconsistentRows", "getNullSpaceBasis", "getParticularSolution", "getPivotColumns", "getReducedMatrix", "getRowOperations", "getType", "()Lru/calcubiba/core/math/SolutionType;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "gauss_debug"})
public final class GaussSolveResult {
    @org.jetbrains.annotations.NotNull()
    private final ru.calcubiba.core.math.SolutionType type = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.util.List<java.lang.String>> reducedMatrix = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.Integer> pivotColumns = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.Integer> freeColumns = null;
    @org.jetbrains.annotations.Nullable()
    private final java.util.List<java.lang.String> particularSolution = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.util.List<java.lang.String>> nullSpaceBasis = null;
    @org.jetbrains.annotations.Nullable()
    private final ru.calcubiba.calculator.gauss.GaussGeneralSolution generalSolution = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<ru.calcubiba.calculator.gauss.GaussRowOperation> rowOperations = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.Integer> inconsistentRows = null;
    
    public GaussSolveResult(@org.jetbrains.annotations.NotNull()
    ru.calcubiba.core.math.SolutionType type, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends java.util.List<java.lang.String>> reducedMatrix, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.Integer> pivotColumns, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.Integer> freeColumns, @org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.String> particularSolution, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends java.util.List<java.lang.String>> nullSpaceBasis, @org.jetbrains.annotations.Nullable()
    ru.calcubiba.calculator.gauss.GaussGeneralSolution generalSolution, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends ru.calcubiba.calculator.gauss.GaussRowOperation> rowOperations, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.Integer> inconsistentRows) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ru.calcubiba.core.math.SolutionType getType() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.util.List<java.lang.String>> getReducedMatrix() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.Integer> getPivotColumns() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.Integer> getFreeColumns() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<java.lang.String> getParticularSolution() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.util.List<java.lang.String>> getNullSpaceBasis() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final ru.calcubiba.calculator.gauss.GaussGeneralSolution getGeneralSolution() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<ru.calcubiba.calculator.gauss.GaussRowOperation> getRowOperations() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.Integer> getInconsistentRows() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ru.calcubiba.core.math.SolutionType component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.util.List<java.lang.String>> component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.Integer> component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.Integer> component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<java.lang.String> component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.util.List<java.lang.String>> component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final ru.calcubiba.calculator.gauss.GaussGeneralSolution component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<ru.calcubiba.calculator.gauss.GaussRowOperation> component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.Integer> component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ru.calcubiba.calculator.gauss.GaussSolveResult copy(@org.jetbrains.annotations.NotNull()
    ru.calcubiba.core.math.SolutionType type, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends java.util.List<java.lang.String>> reducedMatrix, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.Integer> pivotColumns, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.Integer> freeColumns, @org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.String> particularSolution, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends java.util.List<java.lang.String>> nullSpaceBasis, @org.jetbrains.annotations.Nullable()
    ru.calcubiba.calculator.gauss.GaussGeneralSolution generalSolution, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends ru.calcubiba.calculator.gauss.GaussRowOperation> rowOperations, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.Integer> inconsistentRows) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
}