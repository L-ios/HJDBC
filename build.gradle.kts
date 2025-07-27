plugins {
    java
    kotlin("jvm") version "2.2.0"
}

group = "io.github.lios"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // --------------- test -----------------
    testImplementation(kotlin("test"))
    testImplementation(platform("org.junit:junit-bom:5.12.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}
//
//kotlin {
//    jvm {
//        testRuns["test"].executionTask.configure {
//            useJUnitPlatform()
//        }
//    }
//}