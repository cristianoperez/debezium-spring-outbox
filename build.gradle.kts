plugins {
    kotlin("jvm") version "1.3.70"
}

version = "1.0-SNAPSHOT"

allprojects {
    repositories {
        mavenCentral()
    }
}

subprojects {
    group = "com.github.cristianoperez"

    apply{
        plugin("kotlin")
    }

    java.sourceCompatibility = JavaVersion.VERSION_1_8

    dependencies {
        implementation(kotlin("stdlib-jdk8"))
        implementation("org.springframework.boot:spring-boot-starter-data-jpa:2.2.2.RELEASE")
    }
}
