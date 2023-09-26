package io.papermc.paper.api.brigadier;

import io.papermc.paper.api.command.CommandSender;
import io.papermc.paper.api.entity.Entity;
import io.papermc.paper.api.location.Location;
import io.papermc.paper.api.world.World;
import org.jetbrains.annotations.Nullable;

public interface PaperBrigadierCommandSource {

    @Nullable
    Entity getPaperEntity();

    @Nullable
    World getPaperWorld();

    @Nullable
    Location getPaperLocation();

    CommandSender getPaperSender();
}

