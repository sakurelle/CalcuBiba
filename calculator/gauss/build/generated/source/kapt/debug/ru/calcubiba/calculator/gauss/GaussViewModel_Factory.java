package ru.calcubiba.calculator.gauss;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Provider;
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
public final class GaussViewModel_Factory implements Factory<GaussViewModel> {
  private final Provider<SolveGaussSystemUseCase> solveGaussSystemUseCaseProvider;

  private final Provider<CoroutineDispatcher> calculationDispatcherProvider;

  private GaussViewModel_Factory(Provider<SolveGaussSystemUseCase> solveGaussSystemUseCaseProvider,
      Provider<CoroutineDispatcher> calculationDispatcherProvider) {
    this.solveGaussSystemUseCaseProvider = solveGaussSystemUseCaseProvider;
    this.calculationDispatcherProvider = calculationDispatcherProvider;
  }

  @Override
  public GaussViewModel get() {
    return newInstance(solveGaussSystemUseCaseProvider.get(), calculationDispatcherProvider.get());
  }

  public static GaussViewModel_Factory create(
      Provider<SolveGaussSystemUseCase> solveGaussSystemUseCaseProvider,
      Provider<CoroutineDispatcher> calculationDispatcherProvider) {
    return new GaussViewModel_Factory(solveGaussSystemUseCaseProvider, calculationDispatcherProvider);
  }

  public static GaussViewModel newInstance(SolveGaussSystemUseCase solveGaussSystemUseCase,
      CoroutineDispatcher calculationDispatcher) {
    return new GaussViewModel(solveGaussSystemUseCase, calculationDispatcher);
  }
}
