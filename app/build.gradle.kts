import java.util.Properties

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
    id("org.jetbrains.kotlin.plugin.serialization")
}

android {
    namespace = "com.sam.tenflix"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.sam.tenflix"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }

        //load the values from .properties file
        val keystoreFile = project.rootProject.file("local.properties")
        val properties = Properties()
        properties.load(keystoreFile.inputStream())

        //return empty key in case something goes wrong
        val apiKey = properties.getProperty("API_KEY") ?: ""
        buildConfigField(
            type = "String",
            name = "API_KEY",
            value = apiKey
        )
        val token = properties.getProperty("TOKEN") ?: ""
        buildConfigField(
            type = "String",
            name = "TOKEN",
            value = token
        )
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.7"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    implementation("androidx.activity:activity-compose:1.8.2")
    implementation(platform("androidx.compose:compose-bom:2023.08.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.08.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    //Splash Api
    implementation("androidx.core:core-splashscreen:1.0.1")

    //Accompanist
    implementation("com.google.accompanist:accompanist-systemuicontroller:0.31.4-beta")

    // Dagger Hilt
//    implementation("androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03")
    kapt("androidx.hilt:hilt-compiler:1.1.0")
    implementation("androidx.hilt:hilt-navigation-compose:1.1.0")

    implementation("com.google.dagger:hilt-android:2.50")
    kapt("com.google.dagger:hilt-compiler:2.50")

    // For instrumentation tests
    androidTestImplementation("com.google.dagger:hilt-android-testing:2.50")
    kaptAndroidTest("com.google.dagger:hilt-compiler:2.50")

    // For local unit tests
    testImplementation("com.google.dagger:hilt-android-testing:2.50")
    kaptTest("com.google.dagger:hilt-compiler:2.50")


    // Ktor client
    val ktorVersion = "2.3.7"
    implementation("io.ktor:ktor-client-core:$ktorVersion")
    implementation("io.ktor:ktor-client-android:$ktorVersion")
    implementation("io.ktor:ktor-client-content-negotiation:$ktorVersion")
    implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")
    implementation("io.ktor:ktor-client-logging:$ktorVersion")
    implementation("io.ktor:ktor-client-core:$ktorVersion")
    implementation("io.ktor:ktor-client-auth:2.3.0")
    implementation("io.ktor:ktor-client-android:$ktorVersion")
    implementation("io.ktor:ktor-client-content-negotiation:$ktorVersion")
    implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")
    implementation("io.ktor:ktor-client-logging:$ktorVersion")

    // Kotlin Serialization
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.2")

    // For collection state with lifecycles
    implementation ("androidx.lifecycle:lifecycle-runtime-compose:2.6.2")


    // Compose Navigation
    val navVersion = "2.7.6"
    implementation("androidx.navigation:navigation-compose:$navVersion")

    // Compose Material
    implementation("androidx.compose.material:material:1.5.4")

    // Coil
    implementation("io.coil-kt:coil-compose:2.5.0")

}

// Allow references to generated code
kapt {
    correctErrorTypes = true
}