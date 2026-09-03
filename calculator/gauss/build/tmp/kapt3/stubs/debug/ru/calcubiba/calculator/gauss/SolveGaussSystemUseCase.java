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

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00e6\u0080\u0001\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a6B\u00a2\u0006\u0002\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lru/calcubiba/calculator/gauss/SolveGaussSystemUseCase;", "", "invoke", "Lru/calcubiba/calculator/gauss/GaussSolveResult;", "request", "Lru/calcubiba/calculator/gauss/GaussSolveRequest;", "(Lru/calcubiba/calculator/gauss/GaussSolveRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "gauss_debug"})
public abstract interface SolveGaussSystemUseCase {
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object invoke(@org.jetbrains.annotations.NotNull()
    ru.calcubiba.calculator.gauss.GaussSolveRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super ru.calcubiba.calculator.gauss.GaussSolveResult> $completion);
}