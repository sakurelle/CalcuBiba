package ru.calcubiba.calculator.gauss;

import java.math.BigInteger;
import javax.inject.Inject;
import ru.calcubiba.core.math.AugmentedMatrix;
import ru.calcubiba.core.math.GaussJordanSolver;
import ru.calcubiba.core.math.LinearSystemSolution;
import ru.calcubiba.core.math.Matrix;
import ru.calcubiba.core.math.PrimeField;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00050\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u00a2\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\u0015\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00050\u0005H\u00c6\u0003J\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005H\u00c6\u0003J9\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00050\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005H\u00c6\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0014\u001a\u00020\u0015H\u00d6\u0001J\t\u0010\u0016\u001a\u00020\u0017H\u00d6\u0001R\u001d\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00050\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0018"}, d2 = {"Lru/calcubiba/calculator/gauss/GaussSolveRequest;", "", "modulus", "Ljava/math/BigInteger;", "coefficients", "", "constants", "(Ljava/math/BigInteger;Ljava/util/List;Ljava/util/List;)V", "getCoefficients", "()Ljava/util/List;", "getConstants", "getModulus", "()Ljava/math/BigInteger;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "gauss_debug"})
public final class GaussSolveRequest {
    @org.jetbrains.annotations.NotNull()
    private final java.math.BigInteger modulus = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.util.List<java.math.BigInteger>> coefficients = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.math.BigInteger> constants = null;
    
    public GaussSolveRequest(@org.jetbrains.annotations.NotNull()
    java.math.BigInteger modulus, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends java.util.List<? extends java.math.BigInteger>> coefficients, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends java.math.BigInteger> constants) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.math.BigInteger getModulus() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.util.List<java.math.BigInteger>> getCoefficients() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.math.BigInteger> getConstants() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.math.BigInteger component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.util.List<java.math.BigInteger>> component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.math.BigInteger> component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ru.calcubiba.calculator.gauss.GaussSolveRequest copy(@org.jetbrains.annotations.NotNull()
    java.math.BigInteger modulus, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends java.util.List<? extends java.math.BigInteger>> coefficients, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends java.math.BigInteger> constants) {
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