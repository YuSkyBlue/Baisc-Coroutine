plugins {
    kotlin("jvm") version "1.9.21"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.0-RC2")

}

tasks.test {
    useJUnitPlatform()
}
java {
    toolchain{        languageVersion.set(JavaLanguageVersion.of(17))
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}
kotlin {
//    (this as JavaToolchainSpec).languageVersion.set(JavaLanguageVersion.of(17))
    jvmToolchain(17)
//    jvmToolchain(21)
}