package ru.calcubiba.calculator.gauss;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast",
    "deprecation",
    "nullness:initialization.field.uninitialized"
})
public final class DefaultSolveGaussSystemUseCase_Factory implements Factory<DefaultSolveGaussSystemUseCase> {
  @Override
  public DefaultSolveGaussSystemUseCase get() {
    return newInstance();
  }

  public static DefaultSolveGaussSystemUseCase_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static DefaultSolveGaussSystemUseCase newInstance() {
    return new DefaultSolveGaussSystemUseCase();
  }

  private static final class InstanceHolder {
    static final DefaultSolveGaussSystemUseCase_Factory INSTANCE = new DefaultSolveGaussSystemUseCase_Factory();
  }
}
