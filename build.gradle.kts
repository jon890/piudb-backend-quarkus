plugins {
    kotlin("jvm") version "1.7.21"
    kotlin("plugin.allopen") version "1.7.21"
    kotlin("plugin.noarg") version "1.7.21"
    id("io.quarkus")
}

noArg {
    annotation("javax.persistence.Entity")
}

allOpen {
    annotation("javax.persistence.Entity")
}

repositories {
    mavenCentral()
    mavenLocal()
}

val quarkusPlatformGroupId: String by project
val quarkusPlatformArtifactId: String by project
val quarkusPlatformVersion: String by project

dependencies {
    implementation(enforcedPlatform("${quarkusPlatformGroupId}:${quarkusPlatformArtifactId}:${quarkusPlatformVersion}"))

    // Quarkus
    implementation("io.quarkus:quarkus-arc")
    implementation("io.quarkus:quarkus-kotlin")
    implementation("io.quarkus:quarkus-config-yaml")
    implementation("io.quarkus:quarkus-resteasy-reactive")
    implementation("io.quarkus:quarkus-resteasy-reactive-jackson")

    // Database - Hibernate Reactive
    implementation("io.quarkus:quarkus-hibernate-reactive")
    implementation("io.quarkus:quarkus-reactive-mysql-client")
    implementation("io.quarkus:quarkus-hibernate-reactive-panache")

    // Kotlin
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    // Test
    testImplementation("io.quarkus:quarkus-junit5")
    testImplementation("io.rest-assured:rest-assured")
    testImplementation("io.quarkus:quarkus-junit5-mockito")
}

group = "com.bifos"
version = "1.0.0-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

tasks.withType<Test> {
    systemProperty("java.util.logging.manager", "org.jboss.logmanager.LogManager")
}
allOpen {
    annotation("javax.ws.rs.Path")
    annotation("javax.enterprise.context.ApplicationScoped")
    annotation("io.quarkus.test.junit.QuarkusTest")
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions.jvmTarget = JavaVersion.VERSION_17.toString()
    kotlinOptions.javaParameters = true
}
