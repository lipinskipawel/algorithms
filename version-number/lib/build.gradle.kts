plugins {
    `java-library`
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.7.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}

tasks.test {
    // Use junit platform for unit tests.
    useJUnitPlatform()
}

java {
    sourceCompatibility = JavaVersion.VERSION_15
    sourceCompatibility = JavaVersion.VERSION_15
}