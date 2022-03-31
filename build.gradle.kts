import com.diffplug.spotless.LineEnding
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val projectVersion: String by extra

plugins {
    id("idea")
    id("eclipse")
    id("com.diffplug.spotless")
    kotlin("jvm")
    kotlin("plugin.allopen")
    kotlin("plugin.spring") apply false
    id("org.springframework.boot") apply false
    id("io.spring.dependency-management") apply false
}

group = "io.norio.example.examplewebappstructure"
version = "0.0.1-SNAPSHOT"

allprojects {
    apply {
        plugin("com.diffplug.spotless")
    }

    repositories {
        mavenCentral()
    }

    spotless {
        kotlin {
            ktlint()
            target("/src/**/*.kt")
        }
        kotlinGradle {
            ktlint()
        }
        encoding("UTF-8")
        lineEndings = LineEnding.UNIX
    }
}

subprojects {
    apply {
        plugin("org.jetbrains.kotlin.jvm")
        plugin("kotlin-allopen")
    }

    allOpen {
        annotation("io.norio.example.examplewebappstructure.extension.general.anootation.Opened")
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "11"
        }
    }
}
