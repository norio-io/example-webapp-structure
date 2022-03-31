val springBootVersion: String by extra

apply {
    plugin("org.jetbrains.kotlin.plugin.spring")
    plugin("io.spring.dependency-management")
    plugin("org.springframework.boot")
}

dependencies {
    implementation(project(":my-bounded-context-foo:foo-spring-boot-starter"))
    implementation(project(":my-bounded-context-foo:foo-infrastructure"))
    implementation("org.springframework.boot:spring-boot-starter-web")

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
