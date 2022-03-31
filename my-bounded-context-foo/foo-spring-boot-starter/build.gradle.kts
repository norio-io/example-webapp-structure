dependencies {
    api(project(":other-repositories-as-a-library:my-extension-general"))
    api(project(":other-repositories-as-a-library:my-extension-spring"))
    api(project(":other-repositories-as-a-library:my-standard-types"))
    api(project(":my-bounded-context-foo:foo-domain"))
    api(project(":my-bounded-context-foo:foo-application"))
    api(project(":my-bounded-context-foo:foo-adapter"))
    api(project(":my-bounded-context-foo:foo-spring-boot-autoconfigure"))
}

tasks.getByName<Jar>("jar") {
    enabled = true
}
