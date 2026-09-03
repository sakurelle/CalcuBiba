package ru.calcubiba.calculator.gauss;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c\b\u0087\b\u0018\u00002\u00020\u0001Bk\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\b0\b\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\u0002\u0010\u0010J\t\u0010\u001e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010 \u001a\u00020\u0006H\u00c6\u0003J\u0015\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\b0\bH\u00c6\u0003J\u000f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00060\bH\u00c6\u0003J\t\u0010#\u001a\u00020\u000bH\u00c6\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\rH\u00c6\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u000fH\u00c6\u0003Jo\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\b0\b2\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u00c6\u0001J\u0013\u0010\'\u001a\u00020\u000b2\b\u0010(\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010)\u001a\u00020\u0003H\u00d6\u0001J\t\u0010*\u001a\u00020\u0006H\u00d6\u0001R\u001d\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\b0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0016R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\f\u001a\u0004\u0018\u00010\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001c\u00a8\u0006+"}, d2 = {"Lru/calcubiba/calculator/gauss/GaussUiState;", "", "rowCount", "", "variableCount", "modulus", "", "coefficients", "", "constants", "isCalculating", "", "result", "Lru/calcubiba/calculator/gauss/GaussSolveResult;", "error", "Lru/calcubiba/calculator/gauss/GaussError;", "(IILjava/lang/String;Ljava/util/List;Ljava/util/List;ZLru/calcubiba/calculator/gauss/GaussSolveResult;Lru/calcubiba/calculator/gauss/GaussError;)V", "getCoefficients", "()Ljava/util/List;", "getConstants", "getError", "()Lru/calcubiba/calculator/gauss/GaussError;", "()Z", "getModulus", "()Ljava/lang/String;", "getResult", "()Lru/calcubiba/calculator/gauss/GaussSolveResult;", "getRowCount", "()I", "getVariableCount", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "toString", "gauss_debug"})
public final class GaussUiState {
    private final int rowCount = 0;
    private final int variableCount = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String modulus = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.util.List<java.lang.String>> coefficients = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> constants = null;
    private final boolean isCalculating = false;
    @org.jetbrains.annotations.Nullable()
    private final ru.calcubiba.calculator.gauss.GaussSolveResult result = null;
    @org.jetbrains.annotations.Nullable()
    private final ru.calcubiba.calculator.gauss.GaussError error = null;
    
    public GaussUiState(int rowCount, int variableCount, @org.jetbrains.annotations.NotNull()
    java.lang.String modulus, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends java.util.List<java.lang.String>> coefficients, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> constants, boolean isCalculating, @org.jetbrains.annotations.Nullable()
    ru.calcubiba.calculator.gauss.GaussSolveResult result, @org.jetbrains.annotations.Nullable()
    ru.calcubiba.calculator.gauss.GaussError error) {
        super();
    }
    
    public final int getRowCount() {
        return 0;
    }
    
    public final int getVariableCount() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getModulus() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.util.List<java.lang.String>> getCoefficients() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getConstants() {
        return null;
    }
    
    public final boolean isCalculating() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final ru.calcubiba.calculator.gauss.GaussSolveResult getResult() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final ru.calcubiba.calculator.gauss.GaussError getError() {
        return null;
    }
    
    public GaussUiState() {
        super();
    }
    
    public final int component1() {
        return 0;
    }
    
    public final int component2() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.util.List<java.lang.String>> component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> component5() {
        return null;
    }
    
    public final boolean component6() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final ru.calcubiba.calculator.gauss.GaussSolveResult component7() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final ru.calcubiba.calculator.gauss.GaussError component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ru.calcubiba.calculator.gauss.GaussUiState copy(int rowCount, int variableCount, @org.jetbrains.annotations.NotNull()
    java.lang.String modulus, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends java.util.List<java.lang.String>> coefficients, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> constants, boolean isCalculating, @org.jetbrains.annotations.Nullable()
    ru.calcubiba.calculator.gauss.GaussSolveResult result, @org.jetbrains.annotations.Nullable()
    ru.calcubiba.calculator.gauss.GaussError error) {
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