dependencies {
    val adventureVersion = "4.14.0"
    api("net.kyori:adventure-api:$adventureVersion")
    api("net.kyori:adventure-text-minimessage:$adventureVersion")
    api("net.kyori:adventure-text-serializer-ansi:$adventureVersion")
    api("net.kyori:adventure-text-serializer-gson:$adventureVersion")
    api("net.kyori:adventure-text-serializer-json:$adventureVersion")
    api("net.kyori:adventure-text-serializer-legacy:$adventureVersion")
    api("net.kyori:adventure-text-serializer-plain:$adventureVersion")

    api("com.google.guava:guava:32.1.2-jre")
    implementation("org.apache.commons:commons-lang3:3.13.0")
    implementation("org.apache.logging.log4j:log4j-core:2.20.0")

    val cloudVersion = "1.8.4"
    implementation("cloud.commandframework:cloud-core:$cloudVersion")
    implementation("cloud.commandframework:cloud-tasks:$cloudVersion")
    implementation("cloud.commandframework:cloud-brigadier:$cloudVersion")

}

description = "Paper-Api"
