plugins {
    id("com.android.application")
}

android {
    namespace = "com.example.cam2caption"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.cam2caption"
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
    buildFeatures {
        mlModelBinding = true
    }
}

dependencies {

    implementation("org.tensorflow:tensorflow-lite-support:0.1.0")
    implementation("org.tensorflow:tensorflow-lite-metadata:0.1.0")
    //camera fotografica
    // CameraX core library using the camera2 implementation
    val cameraxVersion = "1.2.2"
    // The following line is optional, as the core library is included indirectly by camera-camera2
    //noinspection GradleDependency
    implementation("androidx.camera:camera-core:${cameraxVersion}")
    //noinspection GradleDependency
    implementation("androidx.camera:camera-camera2:${cameraxVersion}")
    // If you want to additionally use the CameraX Lifecycle library
    //noinspection GradleDependency
    implementation("androidx.camera:camera-lifecycle:${cameraxVersion}")
    // If you want to additionally use the CameraX View class
    //noinspection GradleDependency
    implementation("androidx.camera:camera-view:${cameraxVersion}")


    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    //per Azure
    implementation ("com.microsoft.projectoxford:vision:1.0.395")
    implementation ("com.google.code.gson:gson:2.8.7")


}