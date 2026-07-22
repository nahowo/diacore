plugins {
    id("org.springframework.boot")
}

dependencies {
    "implementation"(project(":api:api-common"))
    "implementation"(project(":domain:common"))
    "implementation"(project(":domain:log"))
    "implementation"(project(":application"))
    "implementation"(project(":infrastructure"))
    "implementation"("org.springframework.boot:spring-boot-starter-web")
    "implementation"("me.paulschwarz:spring-dotenv:4.0.0")
}

tasks.bootJar {
    archiveClassifier.set("write")
}