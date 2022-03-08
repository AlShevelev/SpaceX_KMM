plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
    id("com.android.library")
    id("com.squareup.sqldelight")
}

kotlin {
    android()
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(Dependencies.Shared.Common.coroutines)

                implementation(Dependencies.Shared.Common.serialization)

                implementation(Dependencies.Shared.Common.ktorCore)
                implementation(Dependencies.Shared.Common.ktorSerialization)

                implementation(Dependencies.Shared.Common.sqlDelight)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val androidMain by getting {
            dependencies {
                implementation(Dependencies.Shared.Android.ktor)
                implementation(Dependencies.Shared.Android.sqlDelight)
            }
        }
        val androidTest by getting
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)

            dependencies {
                implementation(Dependencies.Shared.IOS.ktor)
                implementation(Dependencies.Shared.IOS.sqlDelight)
            }
        }
        val iosX64Test by getting
        val iosArm64Test by getting
        val iosSimulatorArm64Test by getting
        val iosTest by creating {
            dependsOn(commonTest)
            iosX64Test.dependsOn(this)
            iosArm64Test.dependsOn(this)
            iosSimulatorArm64Test.dependsOn(this)
        }
    }
}

android {
    compileSdk = AndroidConfigData.compileSdkVersion
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = AndroidConfigData.minSdkVersion
        targetSdk = AndroidConfigData.targetSdkVersion
    }
}

sqldelight {
    database("AppDatabase") {
        packageName = "com.example.spacextestapp.cache"
    }
}