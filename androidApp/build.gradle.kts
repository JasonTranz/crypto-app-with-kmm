plugins {
    kotlin("android")
    id("com.android.application")
}

@Suppress("UnstableApiUsage")
android {
    namespace = "com.cryptochain.mota.android"
    compileSdk = 33
    defaultConfig {
        applicationId = "com.cryptochain.mota.android"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.6"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    implementation(project(":shared"))

    implementation(libs.compose.ui.ui)
    implementation(libs.compose.ui.util)
    implementation(libs.compose.ui.tooling)
    implementation(libs.compose.foundation.foundation)
    implementation(libs.compose.foundation.layout)
    implementation(libs.compose.material.material)

    implementation(libs.intuit.ssp.android)
    implementation(libs.intuit.sdp.android)

    implementation(libs.accompanist.systemuicontroller)
    implementation(libs.accompanist.navigation)
    implementation(libs.accompanist.insets)
    implementation(libs.accompanist.pager)

    implementation(libs.kotlin.coroutine.android)

    implementation(libs.io.coil)
    implementation(libs.io.koin.android)
    implementation(libs.kmm.viewmodel.core)

    implementation(libs.sql.delight.android)
}