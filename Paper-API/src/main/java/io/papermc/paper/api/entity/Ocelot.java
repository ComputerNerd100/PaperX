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
    public boolean isTrusting();

    /**
     * Sets if this ocelot trusts players.
     *
     * @param trust true if it trusts players
     */
    public void setTrusting(boolean trust);
}

