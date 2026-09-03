package ru.calcubiba.calculator.gauss;

import java.math.BigInteger;
import javax.inject.Inject;
import ru.calcubiba.core.math.AugmentedMatrix;
import ru.calcubiba.core.math.GaussJordanSolver;
import ru.calcubiba.core.math.LinearSystemSolution;
import ru.calcubiba.core.math.Matrix;
import ru.calcubiba.core.math.PrimeField;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0096B\u00a2\u0006\u0002\u0010\b\u00a8\u0006\t"}, d2 = {"Lru/calcubiba/calculator/gauss/DefaultSolveGaussSystemUseCase;", "Lru/calcubiba/calculator/gauss/SolveGaussSystemUseCase;", "()V", "invoke", "Lru/calcubiba/core/math/LinearSystemSolution;", "Ljava/math/BigInteger;", "request", "Lru/calcubiba/calculator/gauss/GaussSolveRequest;", "(Lru/calcubiba/calculator/gauss/GaussSolveRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "gauss_release"})
public final class DefaultSolveGaussSystemUseCase implements ru.calcubiba.calculator.gauss.SolveGaussSystemUseCase {
    
    @javax.inject.Inject()
    public DefaultSolveGaussSystemUseCase() {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object invoke(@org.jetbrains.annotations.NotNull()
    ru.calcubiba.calculator.gauss.GaussSolveRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super ru.calcubiba.core.math.LinearSystemSolution<java.math.BigInteger>> $completion) {
        return null;
    }
}