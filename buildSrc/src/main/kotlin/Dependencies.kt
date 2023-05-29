import org.gradle.api.JavaVersion

object Config {
    const val applicationId = "com.amway.creators"
    const val versionName = "1.4.0"

    const val minSdk = 28
    const val compileSdk = 33
    const val targetSdk = 33
    const val buildTools = "33.0.2"
    const val useSupportLibrary = true
    const val androidJUnitRunner = "androidx.test.runner.AndroidJUnitRunner"

    const val viewBinding = true
    const val baseGraphQlUrl = "BASE_GRAPH_QL_URL"

    const val enableCompose = true
    const val kotlinCompilerVer = "1.4.7"

    val javaVersion = JavaVersion.VERSION_17

    // Flag to enable support for the new language APIs.
    const val isDesugaringEnabled = true
}

object Ver {
    // Testing
    const val junit_test = "4.13.2"
    const val junit_android_test = "1.1.5"
    const val espressoVer = "3.5.0"
    const val truthVer = "1.1.3"
    const val hamcrestVer = "2.2"
    const val arch_android_test = "2.1.0"
    const val roboVer = "4.9.1"
    const val mockitoVer = "5.2.0"
    const val mockkVer = "1.13.3"
    const val flow_turbine = "0.12.3"
    const val json_test = "20210307"

    // Datastore
    const val datastoreVer = "1.0.0"

    // Navigation & lifecycle
    const val navKtx = "2.5.3"
    const val lifecycle = "2.5.0"
    const val lifecycle_extensions = "2.2.0"
    const val hilt_compiler_android = "1.0.0"
    const val hilt_navigation_compose = "1.0.0"


    // Compose
    const val composeVer = "1.4.1"
    const val composeFoundation = "1.4.0"
    const val navigationCompose = "2.5.3"
    const val materialDesignComp = "1.4.2"
    const val material3Compose = "1.1.0"


    // A portion of Accompanist was subsumed into AndroidX and is now deprecated.
    const val accompVer = "0.30.1"

    // Project-level
    const val gradle_android = "8.0.1" // Android Gradle Plugin (AGP)
    const val gradle_kotlin = "1.8.21"
    const val hilt = "2.46.1"
    const val benmanes_ver = "0.44.0"

    // Coil Image loading
    const val coilVer = "2.3.0"
    const val landscapistVer = "2.0.0"

    // Gson
    const val gson = "2.10.1"

}

object Deps {
    // Kotlin & AndroidX
    const val androidx_core_ktx = "androidx.core:core-ktx:1.10.1"
    const val androidx_appcompat = "androidx.appcompat:appcompat:1.6.1"
    const val androidx_constraintLayout = "androidx.constraintlayout:constraintlayout:2.1.3"
    const val androidx_material = "com.google.android.material:material:1.9.0"

    // Testing
    const val junit_test = "junit:junit:${Ver.junit_test}"
    const val junit_android_test = "androidx.test.ext:junit:${Ver.junit_android_test}"
    const val espresso_android_test = "androidx.test.espresso:espresso-core:${Ver.espressoVer}"
    const val truth_android_test = "com.google.truth:truth:${Ver.truthVer}"
    const val hamcrest_android_test = "org.hamcrest:hamcrest:${Ver.hamcrestVer}"
    const val arch_android_test = "androidx.arch.core:core-testing:${Ver.arch_android_test}"
    const val robolectric_android_test = "org.robolectric:robolectric:${Ver.roboVer}"
    const val json_test = "org.json:json:${Ver.json_test}"
    const val mockito = "org.mockito:mockito-core:${Ver.mockitoVer}"
    const val mockk = "io.mockk:mockk:${Ver.mockkVer}"
    const val mockk_agent_jvm = "io.mockk:mockk-agent-jvm:${Ver.mockkVer}"

    // Turbine is a small testing library for kotlinx.coroutines.
    const val coroutine_flow_turbine = "app.cash.turbine:turbine:${Ver.flow_turbine}"

    // Kotlin Coroutines
    const val coroutines_core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4"
    const val coroutines_android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4"
    const val coroutines_test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.4"

    // AndroidX storage
    const val datastore = "androidx.datastore:datastore-preferences:${Ver.datastoreVer}"


    // AndroidX Navigation component
    const val navFragKtx = "androidx.navigation:navigation-fragment-ktx:${Ver.navKtx}"
    const val navUiKtx = "androidx.navigation:navigation-ui-ktx:${Ver.navKtx}"
    const val navDynamicFet = "androidx.navigation:navigation-dynamic-features-fragment:${Ver.navKtx}"

    // AndroidX Lifecycle
    const val lifecycle_viewmodel_ktx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Ver.lifecycle}"
    const val lifecycle_livedata_ktx = "androidx.lifecycle:lifecycle-livedata-ktx:${Ver.lifecycle}"
    const val lifecycle_common_java8 = "androidx.lifecycle:lifecycle-common-java8:${Ver.lifecycle}"
    const val lifecycle_extensions = "androidx.lifecycle:lifecycle-extensions:${Ver.lifecycle_extensions}"

    // Dagger and Hilt
    const val hilt_android = "com.google.dagger:hilt-android:${Ver.hilt}"
    const val hilt_compiler = "com.google.dagger:hilt-compiler:${Ver.hilt}"
    const val hilt_android_compiler = "com.google.dagger:hilt-android-compiler:${Ver.hilt}"
    const val hilt_compiler_android = "androidx.hilt:hilt-compiler:${Ver.hilt_compiler_android}"
    const val hilt_navigation_compose = "androidx.hilt:hilt-navigation-compose:${Ver.hilt_navigation_compose}"


    // Project-level dependencies
    const val tools_gradle_android = "com.android.tools.build:gradle:${Ver.gradle_android}"
    const val tools_gradle_kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Ver.gradle_kotlin}"
    const val tools_gradle_kotlin_reflection = "org.jetbrains.kotlin:kotlin-reflect:${Ver.gradle_kotlin}"
    const val tools_hilt = "com.google.dagger:hilt-android-gradle-plugin:${Ver.hilt}"
    const val tools_gradle_versions = "com.github.ben-manes:gradle-versions-plugin:${Ver.benmanes_ver}"

    // AndroidX Compose
    const val compose_util = "androidx.compose.ui:ui-util:${Ver.composeVer}"
    const val compose_version = "androidx.compose.ui:ui:${Ver.composeVer}"
    const val compose_version_uitool = "androidx.compose.ui:ui-tooling:${Ver.composeVer}"
    const val compose_compiler = "androidx.compose.compiler:compiler:${Ver.composeVer}"
    const val compose_runtime_compiler = "androidx.compose.runtime:runtime:${Ver.composeVer}"
    const val compose_fversion = "androidx.compose.foundation:foundation:${Ver.composeFoundation}"

    // AndroidX Navigation
    const val navigationCompose = "androidx.navigation:navigation-compose:${Ver.navigationCompose}"

    // AndroidX Material
    const val composeVersionMat = "androidx.compose.material:material:${Ver.materialDesignComp}"
    const val composeVersionMatcore = "androidx.compose.material:material-icons-core:${Ver.materialDesignComp}"
    const val composeVersionMaticons = "androidx.compose.material:material-icons-extended:${Ver.materialDesignComp}"

    // Google Jetpack Accompanist permissions
    const val accompanistAnimation = "com.google.accompanist:accompanist-navigation-animation:${Ver.accompVer}"

    // Accompanist pager
    const val accompanist_pager = "com.google.accompanist:accompanist-pager:${Ver.accompVer}"
    const val accompanist_pager_indicator = "com.google.accompanist:accompanist-pager-indicators:${Ver.accompVer}"


    // Coil Image Loader
    const val coil_image_loader = "io.coil-kt:coil-compose:${Ver.coilVer}"
    const val landscapist_image_loader = "com.github.skydoves:landscapist-glide:${Ver.landscapistVer}"



    const val composeMaterial3 = "androidx.compose.material3:material3:${Ver.material3Compose}"


}
