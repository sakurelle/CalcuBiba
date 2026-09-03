plugins {
    alias(libs.plugins.kotlin.jvm)
}

kotlin {
    jvmToolchain(22)
}

dependencies {
    testImplementation(libs.junit)
}
