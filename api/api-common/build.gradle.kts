plugins {
    id("org.openapi.generator")
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("io.swagger.core.v3:swagger-annotations:2.2.20")
    compileOnly("jakarta.annotation:jakarta.annotation-api:2.1.1")
    implementation(project(":domain:common"))
    implementation(project(":domain:profile"))
    implementation(project(":domain:user"))
    implementation(project(":domain:simulation"))
}

openApiGenerate {
    generatorName.set("spring")
    inputSpec.set("$rootDir/api/api-common/src/main/resources/openapi/diacore-api.yaml")
    outputDir.set("$projectDir/generated/openapi")
    apiPackage.set("com.diacore.api.operation")
    modelPackage.set("com.diacore.api.model")

    configOptions.set(mapOf(
        "interfaceOnly" to "true",
        "useSpringBoot3" to "true",
        "useJakartaEe" to "true",
        "openApiNullable" to "false",
        "useTags" to "true",
        "useRecords" to "true",
        "enumPropertyNaming" to "MACRO_CASE",
        "useBeanValidation" to "false",
        "annotationLibrary" to "none",
        "documentationProvider" to "none",
    ))

    typeMappings.set(mapOf(
        "ChangeSource" to "com.diacore.domain.profile.model.ChangeSource",
        "BasalInsulinName" to "com.diacore.domain.profile.model.BasalInsulinName",
        "ExerciseIntensity" to "com.diacore.domain.simulation.model.ExerciseIntensity",
        "ActionType" to "com.diacore.domain.simulation.model.ActionType"
    ))

    importMappings.set(mapOf(
        "ChangeSource" to "com.diacore.domain.profile.model.ChangeSource",
        "BasalInsulinName" to "com.diacore.domain.profile.model.BasalInsulinName",
        "ExerciseIntensity" to "com.diacore.domain.simulation.model.ExerciseIntensity",
        "ActionType" to "com.diacore.domain.simulation.model.ActionType"
    ))
}

sourceSets {
    main {
        java.srcDirs("$projectDir/generated/openapi/src/main/java")
    }
}