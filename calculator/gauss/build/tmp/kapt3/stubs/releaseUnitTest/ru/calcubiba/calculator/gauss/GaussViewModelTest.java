package ru.calcubiba.calculator.gauss;

import java.math.BigInteger;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import org.junit.Rule;
import org.junit.Test;
import ru.calcubiba.core.math.GeneralSolution;
import ru.calcubiba.core.math.LinearSystemSolution;
import ru.calcubiba.core.math.Matrix;
import ru.calcubiba.core.math.SolutionType;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\f\u0010\u0007\u001a\u00060\bj\u0002`\tH\u0007J\b\u0010\n\u001a\u00020\bH\u0007J\b\u0010\u000b\u001a\u00020\bH\u0007J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002J\f\u0010\u0012\u001a\u00060\bj\u0002`\tH\u0007J\b\u0010\u0013\u001a\u00020\bH\u0007R\u0013\u0010\u0003\u001a\u00020\u00048G\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0014"}, d2 = {"Lru/calcubiba/calculator/gauss/GaussViewModelTest;", "", "()V", "mainDispatcherRule", "Lru/calcubiba/calculator/gauss/MainDispatcherRule;", "getMainDispatcherRule", "()Lru/calcubiba/calculator/gauss/MainDispatcherRule;", "calculate with composite modulus does not invoke use case", "", "Lkotlinx/coroutines/test/TestResult;", "changing size preserves overlapping cells", "clear resets data", "populateRequiredFields", "viewModel", "Lru/calcubiba/calculator/gauss/GaussViewModel;", "sampleResult", "Lru/calcubiba/core/math/LinearSystemSolution;", "Ljava/math/BigInteger;", "successful calculation updates result", "switching modes preserves matrix", "gauss_releaseUnitTest"})
@kotlin.OptIn(markerClass = {kotlinx.coroutines.ExperimentalCoroutinesApi.class})
public final class GaussViewModelTest {
    @org.jetbrains.annotations.NotNull()
    private final ru.calcubiba.calculator.gauss.MainDispatcherRule mainDispatcherRule = null;
    
    public GaussViewModelTest() {
        super();
    }
    
    @org.junit.Rule()
    @org.jetbrains.annotations.NotNull()
    public final ru.calcubiba.calculator.gauss.MainDispatcherRule getMainDispatcherRule() {
        return null;
    }
    
    private final void populateRequiredFields(ru.calcubiba.calculator.gauss.GaussViewModel viewModel) {
    }
    
    private final ru.calcubiba.core.math.LinearSystemSolution<java.math.BigInteger> sampleResult() {
        return null;
    }
}