plugins {
    id("org.springframework.boot")
}

dependencies {
    "implementation"(project(":api:api-common"))
    "implementation"("org.springframework.boot:spring-boot-starter-web")
}

tasks.bootJar {
    archiveClassifier.set("read")
}