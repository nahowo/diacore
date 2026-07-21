plugins {
    id("java")
    id("org.springframework.boot")
}

group = "com.diacore"
version = "0.0.1-SNAPSHOT"

dependencies {
    "implementation"(project(":domain:common"))
    "implementation"(project(":domain:log"))
    "implementation"("org.springframework.boot:spring-boot-starter-web")
}