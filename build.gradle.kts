// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    id("com.google.devtools.ksp") version "2.1.21-2.0.1" apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.android.dynamic.feature) apply false
    id("com.google.gms.google-services") version "4.4.2" apply false
    id("com.google.firebase.crashlytics") version "3.0.3" apply false
}

buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        // Use the navigation-safe-args-gradle-plugin
        classpath(libs.androidx.navigation.safe.args.gradle.plugin)
    }
}