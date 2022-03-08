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
        const val appCompat = "androidx.appcompat:appcompat:1.4.1"

        const val lifecycleRuntimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:2.3.1"

        const val activityCompose = "androidx.activity:activity-compose:1.3.1"
        const val composeUi = "androidx.compose.ui:ui:${Versions.compose}"
        const val composeMaterial = "androidx.compose.material:material:${Versions.compose}"
        const val composeUiToolingPreview = "androidx.compose.ui:ui-tooling-preview:${Versions.compose}"
        const val composeUiTooling = "androidx.compose.ui:ui-tooling:${Versions.compose}"
    }
}