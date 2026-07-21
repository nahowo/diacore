plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}
rootProject.name = "diacore-backend"

include("api")
include("domain:log")
include("domain:profile")
include("domain:simulation")
include("api:api-common")
include("api:api-read")
include("api:api-write")
include("domain:common")
include("infrastructure")
include("application")