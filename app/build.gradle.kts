plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id ("kotlin-kapt")
    id ("androidx.navigation.safeargs.kotlin")
    id ("dagger.hilt.android.plugin")
}

android {
    namespace = "com.example.bostatask"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.bostatask"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
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
        viewBinding = true
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    //retrofit
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation ("com.squareup.okhttp3:okhttp:4.10.0")
    implementation ("com.google.code.gson:gson:2.10.1")
    implementation ("com.github.bumptech.glide:glide:4.14.2")
    annotationProcessor ("com.github.bumptech.glide:compiler:4.14.2")
    implementation ("androidx.work:work-runtime-ktx:2.9.0")
    implementation ("com.google.code.gson:gson:2.10.1")


    //glide
    implementation ("com.github.bumptech.glide:glide:4.14.2")

    //material Design
    implementation ("com.google.android.material:material:1.10.0")

    //safe args
    implementation("androidx.navigation:navigation-fragment-ktx:2.7.5")
    implementation("androidx.navigation:navigation-ui-ktx:2.7.5")
    implementation("androidx.navigation:navigation-dynamic-features-fragment:2.7.5")
    implementation("androidx.navigation:navigation-compose:2.7.5")

    //Hilt
    implementation("com.google.dagger:hilt-android:2.48.1")
    kapt("com.google.dagger:hilt-android-compiler:2.48.1")
    implementation ("androidx.hilt:hilt-navigation-compose:1.1.0")

    //paging
    implementation ("androidx.paging:paging-common-ktx:3.2.1")
    implementation ("androidx.paging:paging-runtime-ktx:3.2.1")

    // lottie dependency
    implementation ("com.airbnb.android:lottie:5.2.0")
    implementation ("com.google.android.material:material:1.10.0")
    implementation ("androidx.room:room-ktx:2.6.1")
    implementation ("androidx.room:room-runtime:2.6.1")
    kapt ("androidx.room:room-compiler:2.6.1")

    //shimmer
    implementation ("com.facebook.shimmer:shimmer:0.5.0")

    // image zoom
    implementation ("com.davemorrissey.labs:subsampling-scale-image-view:3.10.0")
}

kapt {
    correctErrorTypes = true
}