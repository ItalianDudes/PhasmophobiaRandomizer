package it.italiandudes.phasmophobia_randomizer.data.map;

public enum MapSize {
    UNKNOWN(0f),
    SMALL(1f),
    MEDIUM(1.5f),
    LARGE(2f);

    // Attributes
    private final float DIFFICULTY_MULTIPLIER;

    // Constructor
    MapSize(final float DIFFICULTY_MULTIPLIER) {
        this.DIFFICULTY_MULTIPLIER = DIFFICULTY_MULTIPLIER;
    }

    // Methods
    public float getDifficultyMultiplier() {
        return DIFFICULTY_MULTIPLIER;
    }
}
