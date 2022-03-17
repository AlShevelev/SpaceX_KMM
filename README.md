# SpaceX Kotlin Multiplatform Mobile application improvement

This app is a small improvement of Kotlin Multiplatform Mobile [SpaceX demo app](https://play.kotlinlang.org/hands-on/Networking%20and%20Data%20Storage%20with%20Kotlin%20Multiplatfrom%20Mobile/01_Introduction) of JetBrains.
The project includes iOS and Android applications with a native UI and a module with shared code.

## Improvements
This sample shows next improvements in comparing with the source project:
* The android app has been transferred from conventional approach to Jetpack Compose;
* A common view model is shared now across the native applications;
* The view model has been rewritten to using Kotlin Flow.
