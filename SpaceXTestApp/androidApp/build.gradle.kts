plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    compileSdk = AndroidConfigData.compileSdkVersion
    defaultConfig {
        applicationId = "com.example.spacextestapp.android"
        minSdk = AndroidConfigData.minSdkVersion
        targetSdk = AndroidConfigData.targetSdkVersion
        versionCode = AndroidConfigData.versionCode
        versionName = AndroidConfigData.versionName
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}

dependencies {
    implementation(project(":shared"))

    implementation(Dependencies.Android.material)
    implementation(Dependencies.Android.appCompat)
    implementation(Dependencies.Android.constraintLayout)
    implementation(Dependencies.Android.swipeRefreshLayout)
    implementation(Dependencies.Android.coroutines)
    implementation(Dependencies.Android.coreKtx)
    implementation(Dependencies.Android.recyclerView)
    implementation(Dependencies.Android.cardView)
}