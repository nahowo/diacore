plugins {
    id("org.springframework.boot")
    id("org.openapi.generator")
}

dependencies {
    "implementation"(project(":domain:log"))
    "implementation"(project(":domain:profile"))
    "implementation"(project(":domain:simulation"))
    "implementation"("org.springframework.boot:spring-boot-starter-web")
    "implementation"("org.flywaydb:flyway-core")
    "implementation"("org.flywaydb:flyway-mysql")
    "implementation"("org.springframework.boot:spring-boot-starter-validation")
    "implementation"("io.swagger.core.v3:swagger-annotations:2.2.20")
}

tasks.withType<JavaCompile> {
    dependsOn(tasks.openApiGenerate)
}