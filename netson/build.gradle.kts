plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-parcelize")
    id("maven-publish")
}

group = "com.github.dhananjaydy"
version = "1.0.0"


android {
    namespace = "com.example.netson"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.google.code.gson:gson:2.10.1")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:okhttp:4.12.0")
    implementation("com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:0.9.2")
}

afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("release") {
                from(components["release"])

                groupId = project.group.toString()
                version = project.version.toString()
                artifactId = "netson"
            }
        }
    }
}

/*
publishing{
    publications {
        // Define a publication named "release" for your library
        create<MavenPublication>("release") {
            // Define coordinates for your library
            groupId = project.group.toString()
            artifactId = "your-library" // Replace with your artifact ID
            version = project.version.toString()

            // Specify the path to your AAR file
            from(components["release"])

            // Optionally, you can add additional metadata like the POM file
            pom {
                // Define your library details in the POM file
                name.set("Your Library Name")
                description.set("Description of your library")
                url.set("https://github.com/yourusername/your-library")

                // Define the licenses for your library
                licenses {
                    license {
                        name.set("The Apache License, Version 2.0")
                        url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                    }
                }

                // Define other metadata as needed (e.g., developers, scm, etc.)
            }
        }
    }

    // Repository to deploy to
    repositories {
        maven {
            // Replace URL with your Maven repository URL
            url = uri("https://your.maven.repo.url")
            // If authentication is required
            credentials {
                username = "your_username"
                password = "your_password"
            }
        }
    }
}*/
