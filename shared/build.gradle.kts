plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    kotlin("plugin.serialization")
    id("com.android.library")
    id("maven-publish")
    id("com.squareup.sqldelight")
    @Suppress("DSL_SCOPE_VIOLATION")
    alias(libs.plugins.google.ksp)
    @Suppress("DSL_SCOPE_VIOLATION")
    alias(libs.plugins.nativecoroutines)
}

kotlin {
    android()
    // Note: iosSimulatorArm64 target requires that all dependencies have M1 support
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    )

    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        version = "1.0"
        ios.deploymentTarget = "14.1"
        podfile = project.file("../iosApp/Podfile")
        framework {
            baseName = "SharedModule"
            binaryOption("bundleId", "com.cryptochain.mota.shared")
            isStatic = true
        }
    }

    sourceSets {
        all {
            languageSettings.apply {
                optIn("kotlin.RequiresOptIn")
                optIn("kotlinx.coroutines.ExperimentalCoroutinesApi")
                optIn("kotlin.experimental.ExperimentalObjCName")
                optIn("kotlinx.cinterop.ExperimentalForeignApi")
            }
        }

        val commonMain by getting {
            dependencies {
                implementation(libs.kotlin.coroutine.core)

                implementation(libs.io.ktor.client.cio)
                implementation(libs.io.ktor.client.core)
                implementation(libs.io.ktor.client.logging)
                implementation(libs.io.ktor.client.serialization)
                implementation(libs.io.ktor.client.content.negotiation)
                implementation(libs.io.ktor.serialization.kotlinx.json)

                implementation(libs.io.koin.core)
                implementation(libs.kmm.viewmodel.core)

                implementation(libs.sql.delight.runtime)

                implementation(libs.firebase.firestore)
            }
        }
        val androidMain by getting {
            dependencies {
                implementation(libs.io.ktor.client.okhttp)
                implementation(libs.androidx.lifecycle.viewmodel.ktx)
                implementation(libs.sql.delight.android)
                implementation(platform("com.google.firebase:firebase-bom:32.0.0"))
            }
        }

        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
            dependencies {
                implementation(libs.io.ktor.client.darwin)
                implementation(libs.sql.delight.ios)
            }
        }
        val iosX64Test by getting
        val iosArm64Test by getting
        val iosSimulatorArm64Test by getting
        val iosTest by creating {
            iosX64Test.dependsOn(this)
            iosArm64Test.dependsOn(this)
            iosSimulatorArm64Test.dependsOn(this)
        }
    }
}

android {
    namespace = "com.cryptochain.mota"
    compileSdk = 34
    defaultConfig {
        minSdk = 24
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

sqldelight {
    database("MotaDatabase") {
        packageName = "db"
        sourceFolders = listOf("sqldelight")
    }
}

task("testClasses").doLast {
    println("This is a dummy testClasses task")
}