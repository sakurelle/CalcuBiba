package ru.calcubiba.calculator.gauss;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import kotlinx.coroutines.CoroutineDispatcher;

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
public final class GaussDiModule_Companion_ProvideCalculationDispatcherFactory implements Factory<CoroutineDispatcher> {
  @Override
  public CoroutineDispatcher get() {
    return provideCalculationDispatcher();
  }

  public static GaussDiModule_Companion_ProvideCalculationDispatcherFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static CoroutineDispatcher provideCalculationDispatcher() {
    return Preconditions.checkNotNullFromProvides(GaussDiModule.Companion.provideCalculationDispatcher());
  }

  private static final class InstanceHolder {
    static final GaussDiModule_Companion_ProvideCalculationDispatcherFactory INSTANCE = new GaussDiModule_Companion_ProvideCalculationDispatcherFactory();
  }
}
