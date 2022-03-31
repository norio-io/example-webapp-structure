val jUnitVersion: String by extra

dependencies {
    implementation(project(":other-repositories-as-a-library:my-extension-general"))
    implementation(project(":other-repositories-as-a-library:my-standard-types"))
    implementation(project(":other-repositories-as-a-library:my-application-support"))
    implementation(project(":my-bounded-context-foo:foo-domain"))

    testImplementation("org.junit.jupiter:junit-jupiter:$jUnitVersion")
}

tasks.withType<Test> {
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed")
    }
}
