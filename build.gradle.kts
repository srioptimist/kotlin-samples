import org.springframework.boot.gradle.tasks.bundling.BootJar

val bootJar: BootJar by tasks

plugins {
    id("org.springframework.boot") version Versions.springBoot
    id("io.spring.dependency-management") version  Versions.springDepManageGradle
    kotlin("jvm") version Versions.kotlin
    kotlin("plugin.spring") version Versions.kotlin
}

java.sourceCompatibility = JavaVersion.VERSION_17
bootJar.enabled = false

allprojects {
    group = "sri.nl"
    version = "0.0.1-SNAPSHOT"

    apply {
        plugin("org.springframework.boot")
        plugin("org.jetbrains.kotlin.jvm")
    }

    repositories {
        mavenCentral()
    }

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = JavaVersion.VERSION_17.toString()
        }
    }
}

project(":kotlin-samples-stub") {
    val bootJar: BootJar by tasks
    bootJar.enabled = true

    apply {
        plugin("org.jetbrains.kotlin.plugin.spring")
        plugin("io.spring.dependency-management")
    }
    dependencies {
        implementation(SpringDeps.springBootStarter)
        implementation(SpringDeps.springBootStarterWeb)
        implementation(KotlinDeps.kotlinReflect)
        implementation(KotlinDeps.kotlin)
        implementation(TestDeps.wiremock)
    }
    tasks.getByName<BootJar>("bootJar") {
        archiveFileName.value("kotlin-samples-stub.jar")
    }
}

project(":kotlin-samples-app") {
    apply {
        plugin("org.jetbrains.kotlin.plugin.spring")
        plugin("io.spring.dependency-management")
        plugin("maven-publish")
    }

    dependencies {
        implementation(SpringDeps.springBootStarter)
        implementation(SpringDeps.springBootStarterAop)
        implementation(SpringDeps.springBootStarterActuator)
        implementation(SpringDeps.springBootStarterSecurity)

        implementation(KotlinDeps.kotlinReflect)
        implementation(KotlinDeps.kotlin)
        implementation(KotlinDeps.kotlinCoroutinesCore)
        implementation(KotlinDeps.kotlinCoroutinesReactor)

        testImplementation(SpringDeps.springBootStarterTest)
        testImplementation(TestDeps.mockK)
        testImplementation(TestDeps.wiremock)
    }

    tasks.withType<Test> {
        useJUnitPlatform()
        testLogging()
    }


    tasks.getByName<BootJar>("bootJar") {
       // mainClassName = "sri.nl.sample.Application.kt"
        archiveFileName.value("kotlin-samples-app.jar")
    }
}

project(":ks-app") {
    apply {
        plugin("org.jetbrains.kotlin.plugin.spring")
        plugin("io.spring.dependency-management")
        plugin("maven-publish")
    }

    dependencies {
        implementation(SpringDeps.springBootStarter)
        implementation(SpringDeps.springBootStarterAop)
        implementation(SpringDeps.springBootStarterActuator)
        implementation(SpringDeps.springBootStarterSecurity)

        implementation(KotlinDeps.kotlinReflect)
        implementation(KotlinDeps.kotlin)
        implementation(KotlinDeps.kotlinCoroutinesCore)
        implementation(KotlinDeps.kotlinCoroutinesReactor)

        testImplementation(SpringDeps.springBootStarterTest)
        testImplementation(TestDeps.mockK)
        testImplementation(TestDeps.wiremock)
    }

    tasks.withType<Test> {
        useJUnitPlatform()
        testLogging()
    }


    tasks.getByName<BootJar>("bootJar") {
        // mainClassName = "sri.nl.sample.Application.kt"
        archiveFileName.value("ks-app.jar")
    }
}

fun Test.testLogging() {
    testLogging {
        lifecycle {
            events = mutableSetOf(org.gradle.api.tasks.testing.logging.TestLogEvent.FAILED, org.gradle.api.tasks.testing.logging.TestLogEvent.PASSED, org.gradle.api.tasks.testing.logging.TestLogEvent.SKIPPED)
            exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
            showExceptions = true
            showCauses = true
            showStackTraces = true
            showStandardStreams = false
        }
        info.events = lifecycle.events
        info.exceptionFormat = lifecycle.exceptionFormat
    }

    val failedTests = mutableListOf<TestDescriptor>()
    val skippedTests = mutableListOf<TestDescriptor>()

    addTestListener(object : TestListener {
        override fun beforeSuite(suite: TestDescriptor) {}
        override fun beforeTest(testDescriptor: TestDescriptor) {}
        override fun afterTest(testDescriptor: TestDescriptor, result: TestResult) {
            when (result.resultType) {
                TestResult.ResultType.FAILURE -> failedTests.add(testDescriptor)
                TestResult.ResultType.SKIPPED -> skippedTests.add(testDescriptor)
                else -> Unit
            }
        }

        override fun afterSuite(suite: TestDescriptor, result: TestResult) {
            if (suite.parent == null) { // root suite
                logger.lifecycle("----")
                logger.lifecycle("Test result: ${result.resultType}")
                logger.lifecycle(
                    "Test summary: ${result.testCount} tests, " +
                            "${result.successfulTestCount} succeeded, " +
                            "${result.failedTestCount} failed, " +
                            "${result.skippedTestCount} skipped")
                failedTests.takeIf { it.isNotEmpty() }?.prefixedSummary("\tFailed Tests")
                skippedTests.takeIf { it.isNotEmpty() }?.prefixedSummary("\tSkipped Tests:")
            }
        }

        private infix fun List<TestDescriptor>.prefixedSummary(subject: String) {
            logger.lifecycle(subject)
            forEach { test -> logger.lifecycle("\t\t${test.displayName()}") }
        }
        private fun TestDescriptor.displayName() = parent?.let { "${it.name} - $name" } ?: name
    })
}
