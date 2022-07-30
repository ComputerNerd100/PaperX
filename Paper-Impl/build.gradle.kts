dependencies {
    implementation(project(":Paper-API"))
    implementation("net.bytebuddy:byte-buddy:1.12.10")
    implementation("com.google.guava:guava:31.1-jre")
    implementation("net.kyori:event-api:3.0.0") {
        exclude(module = "checker-qual")
        exclude(module = "guava")
    }
    compileOnly("org.apache.logging.log4j:log4j-api:2.17.2")
    compileOnly("org.slf4j:slf4j-api:1.7.36")
}

description = "Paper-Impl"
