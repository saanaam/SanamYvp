package com.sanam.yavarpour

object Libs {
    object Plugins {
//        const val gradle = "com.android.tools.build:gradle:${Versions.gradle}"
        const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
//        const val gradleVersions = "com.github.ben-manes:gradle-versions-plugin:${Versions.gradleVersions}"
        const val ktlint = "com.pinterest:ktlint:${Versions.ktlint}"
        const val safeargs = "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navigationComponent}"
        const val daggerHilt = "com.google.dagger:hilt-android-gradle-plugin:2.31.1-alpha"
    }

    object Modules {
        const val data = ":data"
        const val log = ":log"
        const val domain = ":domain"
        const val peresnter = ":peresenter"
    }

    object Jetpack {
        const val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:${Versions.arch}"
        const val lifecycleKtx = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.arch}"
        const val viewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.arch}"
        const val livedataKtx = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.arch}"
        const val room = "androidx.room:room-runtime:${Versions.room}"
        const val roomKtx = "androidx.room:room-ktx:${Versions.room}"
        const val roomCompiler = "androidx.room:room-compiler:${Versions.room}"
        const val material = "com.google.android.material:material:${Versions.material}"
        const val annotations = "androidx.annotation:annotation:${Versions.material}"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
        const val navigationUi ="androidx.navigation:navigation-ui-ktx:${Versions.navigationComponent}"
        const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:${Versions.navigationComponent}"
        const val fragment = "androidx.fragment:fragment-ktx:${Versions.fragment}"
        const val activity = "androidx.activity:activity-ktx:${Versions.activity}"
    }

    object Common {
        const val mapStruct = "org.mapstruct:mapstruct:${Versions.mapStructVersion}"
        const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}"
        const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
        const val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
        const val arrowCore = "io.arrow-kt:arrow-core:${Versions.arrow}"
        const val arrowSyntax = "io.arrow-kt:arrow-syntax:${Versions.arrow}"
        const val arrowMeta = "io.arrow-kt:arrow-meta:${Versions.arrow}"
        const val gson = "com.google.code.gson:gson:${Versions.gson}"
        const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
        const val moshi = "com.squareup.retrofit2:converter-moshi:${Versions.moshi}"
        const val retrofitGson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
        const val okHttpInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp}"
        const val stetho = "com.facebook.stetho:stetho:${Versions.stetho}"
        const val stetho_OkHttp = "com.facebook.stetho:stetho-okhttp3:${Versions.stetho}"
        const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
        const val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.glide}"
        const val kotlinMapStruct = "com.github.pozo:mapstruct-kotlin:${Versions.KotlinMapStructVersion}"
        const val javaxInject = "javax.inject:javax.inject:${Versions.javaxInjectVersion}"
        const val daggerHilt = "com.google.dagger:hilt-android:${Versions.daggerHilt}"
        const val daggerHiltCompiler = "com.google.dagger:hilt-android-compiler:${Versions.daggerHiltCompiler}"
        const val daggerHiltLifecycle = "androidx.hilt:hilt-lifecycle-viewmodel:${Versions.daggerHiltLifeCycle}"
        const val daggerHiltKotlin = "androidx.hilt:hilt-compiler:${Versions.daggerHiltKotlin}"
        const val multiDex = "com.android.support:multidex:${Versions.multiDex}"



    }

    object Testing {
        const val junit = "junit:junit:${Versions.junit}"
        const val testRunner = "androidx.test:runner:${Versions.testRunner}"
        const val esperesso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
        const val mockitoKotlin = "com.nhaarman:mockito-kotlin-kt1.1:${Versions.mockitoKotlin}"
        const val archTesting = "androidx.arch.core:core-testing:${Versions.archTest}"
    }
}
