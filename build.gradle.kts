import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "2.1.0"
    kotlin("plugin.spring") version "1.9.25"
    id("com.github.johnrengelman.shadow") version "7.1.2"
    id("org.springframework.boot") version "3.3.4"
    id("io.spring.dependency-management") version "1.1.6"
}

allprojects {
    group = "app"
    version = "0.0.1-SNAPSHOT"

    repositories {
        mavenCentral()
    }
}

subprojects {

    extra["springCloudVersion"] = "2023.0.3"

    apply(plugin = "org.jetbrains.kotlin.jvm")
    apply(plugin = "org.jetbrains.kotlin.plugin.spring")
    apply(plugin = "org.springframework.boot")
    apply(plugin = "io.spring.dependency-management")
    apply(plugin = "com.github.johnrengelman.shadow")

    dependencies {
        implementation("org.springframework.cloud:spring-cloud-function-context:4.1.4")
        implementation("org.springframework.cloud:spring-cloud-function-kotlin:4.1.4")
        implementation("org.springframework.cloud:spring-cloud-starter-function-web:4.1.4")
        implementation("org.springframework.cloud:spring-cloud-function-adapter-aws:4.1.4")
//        implementation("org.springframework.cloud:spring-cloud-function-web")
        implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
        testImplementation("org.springframework.boot:spring-boot-starter-test")
        testImplementation("io.mockk:mockk:1.13.12")
        testRuntimeOnly("org.junit.platform:junit-platform-launcher")
        implementation("io.github.oshai:kotlin-logging-jvm:6.0.2")
        runtimeOnly("org.jetbrains.kotlin:kotlin-reflect")
    }

    dependencyManagement {
        imports {
            mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
        }
    }

    tasks.getByName("bootJar") {
        enabled = false
    }

    tasks.getByName("jar") {
        enabled = false
    }

    tasks.assemble {
        dependsOn("shadowJar")
    }


    java {
        toolchain {
            languageVersion = JavaLanguageVersion.of(17)
        }
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs += "-Xjsr305=strict"
            jvmTarget = "17"
        }
    }

    kotlin {
        compilerOptions {
            freeCompilerArgs.addAll("-Xjsr305=strict")
        }
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }

    tasks.withType<com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar> {
        archiveClassifier.set("aws")
        dependencies {
            exclude("org.springframework.cloud:spring-cloud-function-web")
            exclude("org.springframework.cloud:spring-cloud-starter-function-web")
        }
        mergeServiceFiles()
        append("META-INF/spring.handlers")
        append("META-INF/spring.schemas")
        append("META-INF/spring.tooling")
        append("META-INF/spring/org.springframework.boot.autoconfigure.AutoConfiguration.imports")
        append("META-INF/spring/org.springframework.boot.actuate.autoconfigure.web.ManagementContextConfiguration.imports")
        transform(com.github.jengelman.gradle.plugins.shadow.transformers.PropertiesFileTransformer::class.java) {
            paths.add("META-INF/spring.factories")
            mergeStrategy = "append"
        }
    }
}