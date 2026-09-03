# CalcuBiba

CalcuBiba is an Android application for calculators from linear algebra, finite fields, and coding theory.  
The first implemented calculator solves systems of linear equations over the prime field `GF(p)` with Gauss-Jordan elimination.

## Technologies

- Kotlin 2.0.21
- Jetpack Compose + Material 3
- Navigation Compose
- Hilt for dependency injection and multibinding
- Multi-module Gradle structure
- Unit tests with JUnit 4 and `kotlinx-coroutines-test`

## Module Scheme

```text
app
├── feature:catalog
├── core:calculator-api
├── core:designsystem
└── calculator:bundle
    └── calculator:gauss
        ├── core:calculator-api
        ├── core:designsystem
        └── core:math
```

## Dependency Direction

- `app` only owns `Application`, `MainActivity`, root navigation, and module composition.
- `feature:catalog` depends on the stable calculator API and shared UI components.
- `calculator:gauss` depends on the stable calculator API, shared UI, and pure math.
- `core:math` is a pure Kotlin/JVM module and does not depend on Android or Compose.
- `calculator:bundle` is the aggregation point for calculator modules that the app consumes as one dependency.

## Data Flow

1. `app` injects `CalculatorRegistry`.
2. `CalculatorRegistry` receives `Set<CalculatorPlugin>` from Hilt multibinding.
3. `feature:catalog` renders descriptors from the registry and opens a universal route: `calculator/{calculatorId}`.
4. `app` resolves the selected plugin by id and calls its `EntryPoint`.
5. `calculator:gauss` keeps UI state in `GaussViewModel`, validates inputs, and calls `SolveGaussSystemUseCase`.
6. `SolveGaussSystemUseCase` delegates the actual math to `core:math`.
7. The screen renders system status, RREF, variable classification, solutions, and row operations.

## CalculatorPlugin Contract

`core:calculator-api` exposes the stable extension surface:

- `CalculatorDescriptor`
- `CalculatorPlugin`
- `CalculatorRegistry`
- `CalculatorCategory`
- `CalculatorIconKey`

Each calculator module exports only a `CalculatorPlugin`. The app and catalog do not know concrete calculator classes.

## Registration Mechanism

`calculator:gauss` registers itself through Hilt multibinding:

1. `GaussCalculatorPlugin` implements `CalculatorPlugin`.
2. `GaussDiModule` binds it with `@IntoSet`.
3. `CalculatorRegistry` receives the full set of plugins, checks for duplicate ids, sorts calculators, and exposes search and lookup.

Because the catalog reads descriptors from the registry, the Gauss calculator card appears automatically without manual catalog edits.

## How To Add A New Calculator

1. Create a new module, for example `:calculator:new-calculator`.
2. Connect `core:calculator-api` and any required core modules.
3. Implement `CalculatorPlugin`.
4. Register the plugin with `@IntoSet`.
5. Add `api(project(":calculator:new-calculator"))` to `calculator:bundle`.
6. Include the module in `settings.gradle.kts`.
7. Build the app and verify that the new card appears automatically in the catalog.

No Kotlin code changes are required in `app` or `feature:catalog` when the plugin id and multibinding are set correctly.

## How To Run

```bash
gradlew.bat assembleDebug
```

Unix-like shells:

```bash
./gradlew assembleDebug
```

## How To Run Tests

```bash
gradlew.bat test
```

Unix-like shells:

```bash
./gradlew test
```

## Notes About The First Calculator

The Gauss calculator supports:

- choosing `k` equations, `n` variables, and prime modulus `p`
- entering data as a linear system or augmented matrix
- preserving intersecting cells when the matrix size changes
- preserving matrix values when switching input modes
- computing RREF over `GF(p)`
- detecting inconsistent systems
- identifying basic and free variables
- building a particular solution and null-space basis
- showing performed row operations

## Test Status

Verified locally with:

- `gradlew.bat :core:math:test`
- `gradlew.bat test`
- `gradlew.bat assembleDebug`

## Current Limitations

- The first version supports only prime fields `GF(p)`, not extension fields `GF(p^n)`.
- UI texts are currently in English.
- KAPT prints a compatibility warning with Kotlin 2.0 and falls back to language version 1.9 during annotation processing, but the build and tests complete successfully.
