tasks.withType<Jar> {
    manifest {
        attributes["Start-Class"] = "app.HelloFunctionApplication"
    }
}


tasks.withType<com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar> {
    archiveFileName.set("hello.jar")
}