/*
 * This file was generated by the Gradle 'init' task.
 *
 * This generated file contains a sample Kotlin library project to get you started.
 * For more details take a look at the 'Building Java & JVM projects' chapter in the Gradle
 * User Manual available at https://docs.gradle.org/7.0/userguide/building_java_projects.html
 */

group = "com.github.rarebreed"
version = "0.1.0-SNAPSHOT"

plugins {
    // Apply the org.jetbrains.kotlin.jvm Plugin to add support for Kotlin.
    kotlin("jvm") version "1.4.31"
    //kotlin("plugin.serialization") version "1.5.10"

    // Required to create a plugin
    `java-gradle-plugin`
    // to publish to gradle plugin portal
    id("com.gradle.plugin-publish") version "0.14.0"
    // to generate metadata
    `maven-publish`
}

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
    // This is required to add plugins as dependencies
    gradlePluginPortal()
}

val kotlinVersion: String by project
val kotestVersion: String by project

dependencies {
    compileOnly(gradleApi())

    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.4.31") {
        description = "Use JDK 8 version standard lib"
    }


    // These dependencies will allow this custom plugin to automatically be applied to projects which use it
    implementation("org.jetbrains.kotlin.jvm:org.jetbrains.kotlin.jvm.gradle.plugin:$kotlinVersion") {
        description = "Provides this plugin to our custom plugin, so that it is automatically applied"
    }
    runtimeOnly("org.jetbrains.kotlin.kapt:org.jetbrains.kotlin.kapt.gradle.plugin:$kotlinVersion") {
        description = "Provides kapt annotations for projects"
    }
    runtimeOnly(platform("org.jetbrains.kotlin:kotlin-bom:$kotlinVersion")) {
        description = "align versions of all Kotlin components"
    }
    runtimeOnly("org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion") {
        description = "Use JDK 8 version standard lib"
    }
    runtimeOnly("org.jetbrains.kotlin:kotlin-reflect:$kotlinVersion") {
        description = "Reflection for kotlin"
    }
    runtimeOnly("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.0") {
        description = "Coroutines for kotlin"
    }
    runtimeOnly("io.kotest:kotest-runner-junit5:$kotestVersion")
    runtimeOnly("io.kotest:kotest-assertions-core:$kotestVersion")

    testImplementation("io.kotest:kotest-runner-junit5:4.4.0")
    testImplementation("io.kotest:kotest-assertions-core:4.4.0")
}

// Configure the plugin
gradlePlugin {
    plugins {
        create("common-kotlin-lib") {
            id = "com.github.rarebreed.common.kotlin.lib"
            displayName = "Common Kotlin libs plugin"
            description = "Plugin to automatically install several plugins and dependencies common in kotlin projects"
            implementationClass = "com.github.rarebreed.decipher.KotlinLibrary"
        }
    }
}

java {
    modularity.inferModulePath.set(true)
}

tasks.withType<Test> {
    useJUnitPlatform()
}

pluginBundle {
    website = "https://github.com/rarebreed/decipher"
    vcsUrl = "https://github.com/rarebreed/decipher"
    tags = listOf("kotlin", "common-libs", "development")
}

publishing {
    repositories {
        maven {
            url = uri("../local-plugin-repository")
        }
    }
}
