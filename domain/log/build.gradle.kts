plugins {
    id("java-library")
}

dependencies {
    implementation(project(":domain:common"))
    testImplementation("org.assertj:assertj-core:3.27.7")
}