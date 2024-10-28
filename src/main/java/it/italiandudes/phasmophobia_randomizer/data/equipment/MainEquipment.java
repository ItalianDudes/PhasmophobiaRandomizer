package it.italiandudes.phasmophobia_randomizer.data.equipment;

import org.jetbrains.annotations.NotNull;

public enum MainEquipment {
    DOTS_PROJECTOR("DOTS", 2, 50, 75),
    EMF_READER("EMF", 2, 35, 75),
    FLASHLIGHT("Torcia", 4, 40, 85),
    GHOST_WRITING_BOOK("Libro Spiritico", 2, 30, 70),
    SPIRIT_BOX("Spirit Box", 2, 55, 90),
    THERMOMETER("Termometro", 2, 35, 80),
    UV_LIGHT("Torcia UV", 2, 60, 85),
    VIDEO_CAMERA("Videocamera", 4, 50, 75)
    ;

    // Attributes
    @NotNull private final String FULL_NAME;
    private final int MAX_QUANTITY;
    private final int TIER_ONE_TO_TWO_THRESHOLD;
    private final int TIER_TWO_TO_THREE_THRESHOLD;

    // Constructor
    MainEquipment(@NotNull final String FULL_NAME, final int MAX_QUANTITY, final int TIER_ONE_TO_TWO_THRESHOLD, final  int TIER_TWO_TO_THREE_THRESHOLD) {
        this.FULL_NAME = FULL_NAME;
        this.MAX_QUANTITY = MAX_QUANTITY;
        this.TIER_ONE_TO_TWO_THRESHOLD = TIER_ONE_TO_TWO_THRESHOLD;
        this.TIER_TWO_TO_THREE_THRESHOLD = TIER_TWO_TO_THREE_THRESHOLD;
    }

    // Methods
    @NotNull
    public String getFullName() {
        return FULL_NAME;
    }
    public int getMaxQuantity() {
        return MAX_QUANTITY;
    }
    public int getTierOneToTwoThreshold() {
        return TIER_ONE_TO_TWO_THRESHOLD;
    }
    public int getTierTwoToThreeThreshold() {
        return TIER_TWO_TO_THREE_THRESHOLD;
    }
    @Override @NotNull
    public String toString() {
        return getFullName();
    }
}
