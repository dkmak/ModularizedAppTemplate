import org.gradle.kotlin.dsl.implementation

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.hilt.plugin)
    alias(libs.plugins.ksp)
}

android {
    namespace = "com.core.data"
    compileSdk = 36

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17

    }
}

dependencies {
    implementation(project(":core:network"))
    implementation(project(":core:database"))
    api(project(":core:model"))


    implementation(libs.retrofit)

    implementation(libs.androidx.core)
    testImplementation(libs.junit)

    // dependency injection
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)
    kspAndroidTest(libs.hilt.compiler)
}