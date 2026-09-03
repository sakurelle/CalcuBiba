package ru.calcubiba.calculator.gauss;

import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.test.TestDispatcher;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0014J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0014R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\f"}, d2 = {"Lru/calcubiba/calculator/gauss/MainDispatcherRule;", "Lorg/junit/rules/TestWatcher;", "dispatcher", "Lkotlinx/coroutines/test/TestDispatcher;", "(Lkotlinx/coroutines/test/TestDispatcher;)V", "getDispatcher", "()Lkotlinx/coroutines/test/TestDispatcher;", "finished", "", "description", "Lorg/junit/runner/Description;", "starting", "gauss_releaseUnitTest"})
@kotlin.OptIn(markerClass = {kotlinx.coroutines.ExperimentalCoroutinesApi.class})
public final class MainDispatcherRule extends org.junit.rules.TestWatcher {
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.test.TestDispatcher dispatcher = null;
    
    public MainDispatcherRule(@org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.test.TestDispatcher dispatcher) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.test.TestDispatcher getDispatcher() {
        return null;
    }
    
    @java.lang.Override()
    protected void starting(@org.jetbrains.annotations.NotNull()
    org.junit.runner.Description description) {
    }
    
    @java.lang.Override()
    protected void finished(@org.jetbrains.annotations.NotNull()
    org.junit.runner.Description description) {
    }
    
    public MainDispatcherRule() {
        super();
    }
}