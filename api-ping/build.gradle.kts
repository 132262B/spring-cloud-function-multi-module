tasks.withType<Jar> {
    manifest {
        attributes["Start-Class"] = "app.PingFunctionApplication"
    }
}


tasks.withType<com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar> {
    archiveFileName.set("ping.jar")
}