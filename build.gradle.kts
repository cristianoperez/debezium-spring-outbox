plugins {
    kotlin("jvm") version "1.3.61"
}

group = "com.github.cristianoperez"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:2.2.2.RELEASE")
    implementation("com.vladmihalcea:hibernate-types-52:2.4.0")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.10.2")
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}