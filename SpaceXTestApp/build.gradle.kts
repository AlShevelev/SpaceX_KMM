buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    dependencies {
        classpath(BuildPlugins.kotlinGradle)
        classpath(BuildPlugins.gradle)
        classpath(BuildPlugins.kotlinSerialization)
        classpath(BuildPlugins.sqlDelight)
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}