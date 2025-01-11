tasks.withType<Jar> {
    manifest {
        attributes["Start-Class"] = "app.ExampleFunctionApplication"
    }
}


tasks.withType<com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar> {
    archiveFileName.set("example.jar")
}

