object Dependencies {
    object Shared {
        object Common {
            const val sqlDelight = "com.squareup.sqldelight:runtime:${Versions.sqlDelight}"

            const val ktorCore = "io.ktor:ktor-client-core:${Versions.ktor}"
            const val ktorSerialization = "io.ktor:ktor-client-serialization:${Versions.ktor}"

            const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"

            const val serialization = "org.jetbrains.kotlinx:kotlinx-serialization-core:${Versions.serialization}"
        }

        object Android {
            const val sqlDelight = "com.squareup.sqldelight:android-driver:${Versions.sqlDelight}"

            const val ktor = "io.ktor:ktor-client-android:${Versions.ktor}"
        }

        object IOS {
            const val sqlDelight = "com.squareup.sqldelight:native-driver:${Versions.sqlDelight}"

            const val ktor = "io.ktor:ktor-client-ios:${Versions.ktor}"
        }
    }

    object Android {
        const val material = "com.google.android.material:material:1.5.0"
        const val appCompat = "androidx.appcompat:appcompat:1.4.1"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:2.1.3"
        const val swipeRefreshLayout = "androidx.swiperefreshlayout:swiperefreshlayout:1.1.0"
        const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
        const val coreKtx = "androidx.core:core-ktx:1.7.0"
        const val recyclerView = "androidx.recyclerview:recyclerview:1.2.0"
        const val cardView = "androidx.cardview:cardview:1.0.0"
    }
}