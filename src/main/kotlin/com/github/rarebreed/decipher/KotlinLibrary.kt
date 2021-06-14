/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package com.github.rarebreed.decipher

import org.gradle.api.Plugin
import org.gradle.api.Project
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedType

/**
 * Custom plugin that configures plugins for us
 *
 * This plugin doesn't provide any custom tasks yet.  In the future, it will set up several things:
 *
 * - Set the compiler target to jvm 11
 * - Use the new IR backend
 * - Make kotest the default test runner
 * - Add a task to print classpath information
 * - Add a task to clean any empty build directories
 */
class KotlinLibrary : Plugin<Project> {
    fun someLibraryMethod(): Boolean {
        return true
    }

    override fun apply(target: Project) {
        // Add the gradlePlugin and mavenCentral repositories
        target.repositories.gradlePluginPortal()
        target.repositories.mavenCentral()

        // add plugins: kotlin, kapt plugin
        target.pluginManager.apply("org.jetbrains.kotlin.jvm")
        target.pluginManager.apply("org.jetbrains.kotlin.kapt")
        // TODO: figure out plugin for java-library

        // add all our dependencies: kotlinx coroutine, serialization
        //val jacksonVersion = target.properties["jacksonVersion"] as String
        target.properties.forEach { (k, v) ->
            println("$k = $v")
        }

        val kotlinVersion = "1.5.10" //target.properties["kotlinVersion"] as String
        val kotestVersion = "4.i6.0" //target.properties["kotestVersion"] as String

        target.dependencies.apply {
            // Jackson
            //add("implementation", "com.fasterxml.jackson.core:jackson-databind:$jacksonVersion")
            //add("implementation", "com.fasterxml.jackson.core:jackson-core:$jacksonVersion")
            //add("implementation", "com.fasterxml.jackson.core:jackson-annotations:$jacksonVersion")
            // kotlin
            add("implementation", "org.jetbrains.kotlin:kotlin-bom:$kotlinVersion")
            add("implementation", "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion")
            add("implementation", "org.jetbrains.kotlin:kotlinx-coroutines-core:1.5.0")

            add("testImplementation", "io.kotest:kotest-runner-junit5:$kotestVersion")
            add("testImplementation", "io.kotest:kotest-assertions-core:$kotestVersion")
        }

        // TODO: set up compiler options

        // TODO: setup kotest as runner

    }
}