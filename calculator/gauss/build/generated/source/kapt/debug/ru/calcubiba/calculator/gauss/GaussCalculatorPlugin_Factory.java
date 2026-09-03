package ru.calcubiba.calculator.gauss;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Provider;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata
@QualifierMetadata("dagger.hilt.android.qualifiers.ApplicationContext")
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
public final class GaussCalculatorPlugin_Factory implements Factory<GaussCalculatorPlugin> {
  private final Provider<Context> contextProvider;

  private GaussCalculatorPlugin_Factory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public GaussCalculatorPlugin get() {
    return newInstance(contextProvider.get());
  }

  public static GaussCalculatorPlugin_Factory create(Provider<Context> contextProvider) {
    return new GaussCalculatorPlugin_Factory(contextProvider);
  }

  public static GaussCalculatorPlugin newInstance(Context context) {
    return new GaussCalculatorPlugin(context);
  }
}
