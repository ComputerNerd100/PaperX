package io.papermc.paper.api.entity;

/**
 * A wild tameable cat
 */
public interface Ocelot extends Animals {

    /**
     * Checks if this ocelot trusts players.
     *
     * @return true if it trusts players
     */
    boolean isTrusting();

    /**
     * Sets if this ocelot trusts players.
     *
     * @param trust true if it trusts players
     */
    void setTrusting(boolean trust);
}

