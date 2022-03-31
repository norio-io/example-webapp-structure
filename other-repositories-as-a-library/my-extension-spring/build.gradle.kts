import org.springframework.boot.gradle.tasks.bundling.BootJar

val springBootVersion: String by extra

apply {
    plugin("org.jetbrains.kotlin.plugin.spring")
    plugin("io.spring.dependency-management")
    plugin("org.springframework.boot")
}

dependencies {
    implementation(project(":other-repositories-as-a-library:my-extension-general"))

    implementation("org.springframework.boot:spring-boot-starter:$springBootVersion")
    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed")
    }
}

tasks.getByName<BootJar>("bootJar") {
    enabled = false
}

tasks.getByName<Jar>("jar") {
    enabled = true
}
