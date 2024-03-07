// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    dependencies {
        classpath ("com.google.dagger:hilt-android-gradle-plugin:2.44")
//        classpath 'com.google.gms:google-services:4.3.14'
//        classpath 'com.google.firebase:firebase-crashlytics-gradle:2.9.2'

    }
}
plugins {
    id("com.android.application") version "8.2.0" apply false
    id("org.jetbrains.kotlin.android") version "1.9.0" apply false
}