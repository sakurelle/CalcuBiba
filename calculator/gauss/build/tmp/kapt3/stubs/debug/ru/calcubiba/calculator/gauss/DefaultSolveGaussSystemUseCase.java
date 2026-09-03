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

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0096B\u00a2\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J,\u0010\u0010\u001a\u00020\u0011\"\u0004\b\u0000\u0010\u0012*\b\u0012\u0004\u0012\u0002H\u00120\u00132\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u00020\u000b0\u0015H\u0002J,\u0010\u0010\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0012*\b\u0012\u0004\u0012\u0002H\u00120\u00162\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u00020\u000b0\u0015H\u0002J,\u0010\u0010\u001a\u00020\u0017\"\u0004\b\u0000\u0010\u0012*\b\u0012\u0004\u0012\u0002H\u00120\u00182\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u00020\u000b0\u0015H\u0002\u00a8\u0006\u001a"}, d2 = {"Lru/calcubiba/calculator/gauss/DefaultSolveGaussSystemUseCase;", "Lru/calcubiba/calculator/gauss/SolveGaussSystemUseCase;", "()V", "invoke", "Lru/calcubiba/calculator/gauss/GaussSolveResult;", "request", "Lru/calcubiba/calculator/gauss/GaussSolveRequest;", "(Lru/calcubiba/calculator/gauss/GaussSolveRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "parseInteger", "Ljava/math/BigInteger;", "value", "", "parseRational", "Lru/calcubiba/core/math/Rational;", "solveOverPrimeField", "solveOverRationals", "toPresentation", "Lru/calcubiba/calculator/gauss/GaussGeneralSolution;", "E", "Lru/calcubiba/core/math/GeneralSolution;", "render", "Lkotlin/Function1;", "Lru/calcubiba/core/math/LinearSystemSolution;", "Lru/calcubiba/calculator/gauss/GaussRowOperation;", "Lru/calcubiba/core/math/RowOperation;", "Companion", "gauss_debug"})
public final class DefaultSolveGaussSystemUseCase implements ru.calcubiba.calculator.gauss.SolveGaussSystemUseCase {
    @java.lang.Deprecated()
    public static final int PRIMALITY_CERTAINTY = 50;
    @org.jetbrains.annotations.NotNull()
    private static final ru.calcubiba.calculator.gauss.DefaultSolveGaussSystemUseCase.Companion Companion = null;
    
    @javax.inject.Inject()
    public DefaultSolveGaussSystemUseCase() {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object invoke(@org.jetbrains.annotations.NotNull()
    ru.calcubiba.calculator.gauss.GaussSolveRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super ru.calcubiba.calculator.gauss.GaussSolveResult> $completion) {
        return null;
    }
    
    private final ru.calcubiba.calculator.gauss.GaussSolveResult solveOverRationals(ru.calcubiba.calculator.gauss.GaussSolveRequest request) {
        return null;
    }
    
    private final ru.calcubiba.calculator.gauss.GaussSolveResult solveOverPrimeField(ru.calcubiba.calculator.gauss.GaussSolveRequest request) {
        return null;
    }
    
    private final ru.calcubiba.core.math.Rational parseRational(java.lang.String value) {
        return null;
    }
    
    private final java.math.BigInteger parseInteger(java.lang.String value) {
        return null;
    }
    
    private final <E extends java.lang.Object>ru.calcubiba.calculator.gauss.GaussSolveResult toPresentation(ru.calcubiba.core.math.LinearSystemSolution<E> $this$toPresentation, kotlin.jvm.functions.Function1<? super E, java.lang.String> render) {
        return null;
    }
    
    private final <E extends java.lang.Object>ru.calcubiba.calculator.gauss.GaussGeneralSolution toPresentation(ru.calcubiba.core.math.GeneralSolution<E> $this$toPresentation, kotlin.jvm.functions.Function1<? super E, java.lang.String> render) {
        return null;
    }
    
    private final <E extends java.lang.Object>ru.calcubiba.calculator.gauss.GaussRowOperation toPresentation(ru.calcubiba.core.math.RowOperation<E> $this$toPresentation, kotlin.jvm.functions.Function1<? super E, java.lang.String> render) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lru/calcubiba/calculator/gauss/DefaultSolveGaussSystemUseCase$Companion;", "", "()V", "PRIMALITY_CERTAINTY", "", "gauss_debug"})
    static final class Companion {
        
        private Companion() {
            super();
        }
    }
}