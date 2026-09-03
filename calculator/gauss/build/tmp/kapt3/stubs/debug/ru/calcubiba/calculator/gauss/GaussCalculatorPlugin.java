package ru.calcubiba.calculator.gauss;

import android.content.Context;
import androidx.compose.runtime.Composable;
import dagger.hilt.android.qualifiers.ApplicationContext;
import javax.inject.Inject;
import ru.calcubiba.core.calculator.api.CalculatorCategory;
import ru.calcubiba.core.calculator.api.CalculatorDescriptor;
import ru.calcubiba.core.calculator.api.CalculatorIconKey;
import ru.calcubiba.core.calculator.api.CalculatorPlugin;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\fH\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\r"}, d2 = {"Lru/calcubiba/calculator/gauss/GaussCalculatorPlugin;", "Lru/calcubiba/core/calculator/api/CalculatorPlugin;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "descriptor", "Lru/calcubiba/core/calculator/api/CalculatorDescriptor;", "getDescriptor", "()Lru/calcubiba/core/calculator/api/CalculatorDescriptor;", "EntryPoint", "", "onBack", "Lkotlin/Function0;", "gauss_debug"})
public final class GaussCalculatorPlugin implements ru.calcubiba.core.calculator.api.CalculatorPlugin {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    
    @javax.inject.Inject()
    public GaussCalculatorPlugin(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public ru.calcubiba.core.calculator.api.CalculatorDescriptor getDescriptor() {
        return null;
    }
    
    @java.lang.Override()
    @androidx.compose.runtime.Composable()
    public void EntryPoint(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onBack) {
    }
}