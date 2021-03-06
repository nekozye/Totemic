package pokefenn.totemic.api;

import pokefenn.totemic.api.totem.TotemEffectAPI;

/**
 * This class provides access to the registries and utility functions that are part of the Totemic API.
 */
public abstract class TotemicAPI {
    private static TotemicAPI instance;

    /**
     * Returns an instance of the Totemic API.<p>
     * This method may be called after the mod construction phase.
     */
    public static TotemicAPI get() {
        if(instance == null)
            throw new IllegalStateException("The Totemic API has been accessed too early, or Totemic is not installed");
        return instance;
    }

    /**
     * Provides access to functionality commonly used for implementing Totem effects.
     */
    public abstract TotemEffectAPI totemEffect();
}
