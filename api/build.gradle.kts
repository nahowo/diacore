plugins {
    id("org.springframework.boot")
}

dependencies {
    "implementation"(project(":domain:log"))
    "implementation"(project(":domain:profile"))
    "implementation"(project(":domain:simulation"))
    "implementation"("org.springframework.boot:spring-boot-starter-web")
    "implementation"("org.flywaydb:flyway-core")
    "implementation"("org.flywaydb:flyway-mysql")
}