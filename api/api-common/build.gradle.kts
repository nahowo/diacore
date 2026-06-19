plugins {
    id("org.openapi.generator")
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
        "openApiNullable" to "false"
    ))
}

sourceSets {
    main {
        java.srcDirs("$projectDir/generated/openapi/src/main/java")
    }
}