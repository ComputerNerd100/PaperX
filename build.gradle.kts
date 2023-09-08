plugins {
    `java-library`
    id("io.freefair.lombok") version "6.5.0.3"
}

allprojects {
    apply(plugin = "java-library")
    apply(plugin = "io.freefair.lombok")

    repositories {
        mavenLocal()
        mavenCentral()
    }

    dependencies {
        implementation("org.joml:joml:1.10.5")
        implementation("org.checkerframework:checker-qual:3.22.1")
        compileOnly("org.jetbrains:annotations:23.0.0")
        compileOnly("org.projectlombok:lombok:1.18.24")
    }

    tasks.withType<JavaCompile> {
        options.encoding = Charsets.UTF_8.name()
        options.release.set(17)
    }

    tasks.withType<Javadoc> {
        options.encoding = Charsets.UTF_8.name()
    }

    tasks.withType<ProcessResources> {
        filteringCharset = Charsets.UTF_8.name()
    }

    java {
        toolchain {
            languageVersion.set(JavaLanguageVersion.of(17))
        }
    }
}
