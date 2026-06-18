plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}
rootProject.name = "diacore-backend"

include("api")
include("domain:log")
include("domain:profile")
include("domain:simulation")