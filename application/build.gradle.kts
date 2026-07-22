plugins {
    id("java")
    id("org.springframework.boot")
}

group = "com.diacore"
version = "0.0.1-SNAPSHOT"

dependencies {
    "implementation"(project(":domain:common"))
    "implementation"(project(":domain:log"))
    "implementation"(project(":domain:user"))
    "implementation"(project(":api:api-common"))
    "implementation"("org.springframework.boot:spring-boot-starter-web")
    "implementation"("org.springframework.boot:spring-boot-starter-security")
    "implementation"("org.springframework:spring-tx")
}