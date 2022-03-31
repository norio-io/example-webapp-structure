rootProject.name = "example-webapp-structure"

include(
    "other-repositories-as-a-library:my-extension-general",
    "other-repositories-as-a-library:my-extension-spring",
    "other-repositories-as-a-library:my-domain-support",
    "other-repositories-as-a-library:my-application-support",
    "other-repositories-as-a-library:my-standard-types",
    "my-bounded-context-foo:foo-domain",
    "my-bounded-context-foo:foo-application",
    "my-bounded-context-foo:foo-adapter",
    "my-bounded-context-foo:foo-spring-boot-autoconfigure",
    "my-bounded-context-foo:foo-spring-boot-starter",
    "my-bounded-context-foo:foo-db-migration",
    "my-bounded-context-foo:foo-infrastructure",
    "my-bounded-context-foo:foo-api",
    "my-bounded-context-foo:foo-batch"
)

pluginManagement {
    val kotlinVersion: String by extra
    val spotlessVersion: String by extra
    val springBootVersion: String by extra
    val springDependencyManagementVersion: String by extra

    repositories {
        gradlePluginPortal()
    }

    resolutionStrategy {
        eachPlugin {
            if (requested.id.id.startsWith("org.jetbrains.kotlin.")) {
                useVersion(kotlinVersion)
            }
            if (requested.id.id == "org.springframework.boot") {
                useModule("org.springframework.boot:spring-boot-gradle-plugin:$springBootVersion")
            }
            if (requested.id.id == "io.spring.dependency-management") {
                useVersion(springDependencyManagementVersion)
            }
            if (requested.id.id == "com.diffplug.spotless") {
                useVersion(spotlessVersion)
            }
        }
    }
}
