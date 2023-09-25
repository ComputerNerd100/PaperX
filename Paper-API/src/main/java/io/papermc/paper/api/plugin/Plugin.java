package io.papermc.paper.api.plugin;

public interface Plugin {
    void onLoad();
    void onEnable();
    void onDisable();
}
