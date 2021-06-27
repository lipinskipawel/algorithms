plugins {
    // Apply the java-library plugin for API and implementation separation.
    `java-library`
}

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
}

dependencies {
    testImplementation("junit:junit:4.12")
}

java {
    sourceCompatibility = JavaVersion.VERSION_15
    targetCompatibility = JavaVersion.VERSION_15
}
