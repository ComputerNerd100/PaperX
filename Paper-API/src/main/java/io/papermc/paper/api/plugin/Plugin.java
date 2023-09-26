package io.papermc.paper.api.plugin;

import io.papermc.paper.api.Server;
import io.papermc.paper.api.world.World;
import io.papermc.paper.api.world.generator.BiomeProvider;
import io.papermc.paper.api.world.generator.ChunkGenerator;

import java.nio.file.Path;
import java.util.logging.Logger;

public interface Plugin {
    String name();
    void onLoad();
    void onEnable();
    void onDisable();
    Server server();
    Path dataFolder();
    Logger logger();
    boolean enabled();
    String description();
    ChunkGenerator defaultWorldGenerator(World world, String id);
    BiomeProvider defaultBiomeProvider(World world, String id);
}
