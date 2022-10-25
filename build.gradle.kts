@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    //trick: for the same plugin versions in all sub-modules
    id("com.android.application").version("8.0.0-alpha06").apply(false)
    id("com.android.library").version("8.0.0-alpha06").apply(false)
    kotlin("android") version libs.versions.kotlin.get() apply false
    kotlin("multiplatform") version libs.versions.kotlin.get() apply false
    kotlin("plugin.serialization") version libs.versions.kotlin.get() apply false
}

allprojects {
    repositories {
        google()
        mavenCentral()
        maven {
            url = uri("https://maven.pkg.jetbrains.space/public/p/ktor/eap")
        }
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
