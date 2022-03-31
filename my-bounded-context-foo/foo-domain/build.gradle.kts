val jUnitVersion: String by extra

dependencies {
    implementation(project(":other-repositories-as-a-library:my-extension-general"))
    implementation(project(":other-repositories-as-a-library:my-domain-support"))
    implementation(project(":other-repositories-as-a-library:my-standard-types"))

    testImplementation("org.junit.jupiter:junit-jupiter:$jUnitVersion")
}

tasks.withType<Test> {
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed")
    }
}
