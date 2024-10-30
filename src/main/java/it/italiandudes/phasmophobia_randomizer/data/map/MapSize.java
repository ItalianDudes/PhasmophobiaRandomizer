package it.italiandudes.phasmophobia_randomizer.data.map;

import org.jetbrains.annotations.NotNull;

public enum MapSize {
    UNKNOWN("Sconoscosciuta", 0f),
    SMALL("Piccola", 1f),
    MEDIUM("Media", 1.5f),
    LARGE("Grande", 2f);

    // Attributes
    @NotNull private final String SIZE_NAME;
    private final float DIFFICULTY_MULTIPLIER;

    // Constructor
    MapSize(@NotNull final String SIZE_NAME, final float DIFFICULTY_MULTIPLIER) {
        this.SIZE_NAME = SIZE_NAME;
        this.DIFFICULTY_MULTIPLIER = DIFFICULTY_MULTIPLIER;
    }

    // Methods
    public @NotNull String getSizeName() {
        return SIZE_NAME;
    }
    public float getDifficultyMultiplier() {
        return DIFFICULTY_MULTIPLIER;
    }
    @Override @NotNull
    public String toString() {
        return getSizeName();
    }
}
