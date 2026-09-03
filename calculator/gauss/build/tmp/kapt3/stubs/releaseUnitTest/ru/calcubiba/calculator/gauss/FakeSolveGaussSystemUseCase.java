package ru.calcubiba.calculator.gauss;

import java.math.BigInteger;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import org.junit.Rule;
import org.junit.Test;
import ru.calcubiba.core.math.GeneralSolution;
import ru.calcubiba.core.math.LinearSystemSolution;
import ru.calcubiba.core.math.Matrix;
import ru.calcubiba.core.math.SolutionType;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0002\u0010\u0005J\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\f\u001a\u00020\rH\u0096B\u00a2\u0006\u0002\u0010\u000eR\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lru/calcubiba/calculator/gauss/FakeSolveGaussSystemUseCase;", "Lru/calcubiba/calculator/gauss/SolveGaussSystemUseCase;", "result", "Lru/calcubiba/core/math/LinearSystemSolution;", "Ljava/math/BigInteger;", "(Lru/calcubiba/core/math/LinearSystemSolution;)V", "<set-?>", "", "invocationCount", "getInvocationCount", "()I", "invoke", "request", "Lru/calcubiba/calculator/gauss/GaussSolveRequest;", "(Lru/calcubiba/calculator/gauss/GaussSolveRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "gauss_releaseUnitTest"})
final class FakeSolveGaussSystemUseCase implements ru.calcubiba.calculator.gauss.SolveGaussSystemUseCase {
    @org.jetbrains.annotations.NotNull()
    private final ru.calcubiba.core.math.LinearSystemSolution<java.math.BigInteger> result = null;
    private int invocationCount = 0;
    
    public FakeSolveGaussSystemUseCase(@org.jetbrains.annotations.NotNull()
    ru.calcubiba.core.math.LinearSystemSolution<java.math.BigInteger> result) {
        super();
    }
    
    public final int getInvocationCount() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object invoke(@org.jetbrains.annotations.NotNull()
    ru.calcubiba.calculator.gauss.GaussSolveRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super ru.calcubiba.core.math.LinearSystemSolution<java.math.BigInteger>> $completion) {
        return null;
    }
    
    public FakeSolveGaussSystemUseCase() {
        super();
    }
}