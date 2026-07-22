plugins {
    id("org.springframework.boot")
}

dependencies {
    "implementation"(project(":api:api-common"))
    "implementation"(project(":application"))
    "implementation"(project(":domain:common"))
    "implementation"(project(":application"))
    "implementation"(project(":infrastructure"))
    "implementation"("org.springframework.boot:spring-boot-starter-web")
}

tasks.bootJar {
    archiveClassifier.set("read")
}