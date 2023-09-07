package io.papermc.paper.api.ban;

import io.papermc.paper.api.profile.PlayerProfile;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Date;

public interface ProfileBanList extends BanList<PlayerProfile> { // Paper

    /**
     * {@inheritDoc}
     *
     * @param target the target of the ban
     * @param reason reason for the ban, null indicates implementation default
     * @param expires date for the ban's expiration (unban), or null to imply
     *     forever
     * @param source source of the ban, null indicates implementation default
     * @return the entry for the newly created ban, or the entry for the
     *     (updated) previous ban
     * @throws IllegalArgumentException if ProfilePlayer has an invalid UUID
     */
    @Nullable BanEntry<PlayerProfile> addBan(@NotNull PlayerProfile target, @Nullable String reason, @Nullable Date expires, @Nullable String source);
}

