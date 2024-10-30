package it.italiandudes.phasmophobia_randomizer.data.equipment;

import org.jetbrains.annotations.NotNull;

public enum Equipment {
    DOTS_PROJECTOR("Puntatore D.O.T.S.", 1, 2, 50, 75),
    EMF_READER("Lettore EMF", 1, 2, 35, 75),
    FLASHLIGHT("Torcia Elettrica", 1, 4, 40, 85),
    GHOST_WRITING_BOOK("Libro Spiritico", 1, 2, 30, 70),
    SPIRIT_BOX("Spirit Box", 1, 2, 55, 90),
    THERMOMETER("Termometro", 1, 2, 35, 80),
    UV_LIGHT("Torcia UV", 1, 2, 60, 85),
    VIDEO_CAMERA("Videocamera", 1, 4, 50, 75),
    CRUCIFIX("Crocifisso", 0, 2, 60, 90),
    FIRELIGHT("Lumi", 0, 4, 50, 80),
    HEAD_GEAR("Equipaggiamento della Testa", 0, 4, 33, 66),
    IGNITER("Accenditore", 1, 4, 55, 75),
    INCENSE("Incenso", 0, 4, 40, 70),
    MOTION_SENSOR("Sensore di Movimento", 0, 4, 40, 70),
    PARABOLIC_MICROPHONE("Microfono Parabolico", 0, 2, 40, 70),
    PHOTO_CAMERA("Fotocamera", 1, 3, 50, 80),
    SALT("Sale", 0, 3, 60, 80),
    SANITY_MEDICATION("Rimedi per la Sanita' Mentale", 0, 4, 33, 66),
    SOUND_SENSOR("Sensore Sonoro", 0, 4, 33, 66),
    TRIPOD("Treppiede", 0, 4, 40, 70)
    ;

    // Attributes
    @NotNull private final String FULL_NAME;
    private final int MIN_QUANTITY;
    private final int MAX_QUANTITY;
    private final int TIER_ONE_TO_TWO_THRESHOLD;
    private final int TIER_TWO_TO_THREE_THRESHOLD;

    // Constructor
    Equipment(@NotNull final String FULL_NAME, final int MIN_QUANTITY, final int MAX_QUANTITY, final int TIER_ONE_TO_TWO_THRESHOLD, final  int TIER_TWO_TO_THREE_THRESHOLD) {
        this.FULL_NAME = FULL_NAME;
        this.MIN_QUANTITY = MIN_QUANTITY;
        this.MAX_QUANTITY = MAX_QUANTITY;
        this.TIER_ONE_TO_TWO_THRESHOLD = TIER_ONE_TO_TWO_THRESHOLD;
        this.TIER_TWO_TO_THREE_THRESHOLD = TIER_TWO_TO_THREE_THRESHOLD;
    }

    // Methods
    @NotNull
    public String getFullName() {
        return FULL_NAME;
    }
    public int getMinQuantity() {
        return MIN_QUANTITY;
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
    public int getTierByTierChance(int tierChance) {
        if (tierChance < TIER_ONE_TO_TWO_THRESHOLD) return 1;
        else if (tierChance < TIER_TWO_TO_THREE_THRESHOLD) return 2;
        else return 3;
    }
    @Override @NotNull
    public String toString() {
        return getFullName();
    }
}
