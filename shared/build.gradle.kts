plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    kotlin("plugin.serialization")
    id("com.android.library")
    id("maven-publish")
}

kotlin {
    android()
    // Note: iosSimulatorArm64 target requires that all dependencies have M1 support
    iosSimulatorArm64()

    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        version = "1.0"
        ios.deploymentTarget = "14.1"
        podfile = project.file("../iosApp/Podfile")
        framework {
            baseName = "shared"
        }
    }

    sourceSets {
        all {
            languageSettings.apply {
                optIn("kotlin.RequiresOptIn")
                optIn("kotlinx.coroutines.ExperimentalCoroutinesApi")
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
                implementation(libs.firestore.shared)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val androidMain by getting {
            dependencies {
                implementation(libs.io.ktor.client.okhttp)
                implementation(libs.androidx.lifecycle.viewmodel.ktx)
                implementation(libs.firestore.android)
            }
        }
        val androidTest by getting
        val iosMain by creating {
            dependsOn(commonMain)
            dependencies {
                implementation(libs.io.ktor.client.darwin)
            }
        }
        val iosSimulatorArm64Main by getting {
            dependsOn(iosMain)
        }
        val iosTest by creating {
            dependsOn(commonTest)
        }
    }
}

android {
    namespace = "com.cryptochain.mota"
    compileSdk = 33
    defaultConfig {
        minSdk = 24
        targetSdk = 33
    }
}