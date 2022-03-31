// val jUnitVersion: String by extra
//
// dependencies {
//    implementation(project(":other-repositories-as-a-library:my-extension-general"))
//    implementation(project(":other-repositories-as-a-library:my-domain-support"))
//    implementation(project(":other-repositories-as-a-library:my-standard-types"))
//
//    testImplementation("org.junit.jupiter:junit-jupiter:$jUnitVersion")
// }
//
// tasks.withType<Test> {
//    useJUnitPlatform()
//    testLogging {
//        events("passed", "skipped", "failed")
//    }
// }

plugins {
    id("org.flywaydb.flyway") version "8.2.0"
}

dependencies {
    runtimeOnly("mysql:mysql-connector-java:8.0.27")
}

flyway {
    url = System.getenv("FLYWAY_URL") ?: "jdbc:mysql://localhost:3306/example-webapp-structure?useSSL=false"
    user = System.getenv("FLYWAY_USER") ?: "root"
    password = System.getenv("FLYWAY_PASSWORD") ?: "example"
}
