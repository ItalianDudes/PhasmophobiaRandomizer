package it.italiandudes.phasmophobia_randomizer.data.map;

import org.jetbrains.annotations.NotNull;

public enum Map {
    RANDOM("Casuale", MapSize.UNKNOWN),
    TANGLEWOOD_DRIVE("6 Tanglewood Drive", MapSize.SMALL),
    RIDGEVIEW_COURT("10 Ridgeview Court", MapSize.SMALL),
    WILLOW_STREET("13 Willow Street", MapSize.SMALL),
    EDGEFIELD_ROAD("42 Edgefield Road", MapSize.SMALL),
    BLEASDALE_FARMHOUSE("Bleasdale Farmhouse", MapSize.SMALL),
    CAMP_WOODWIND("Camp Woodwind", MapSize.SMALL),
    GRAFTON_FARMHOUSE("Grafton Farmhouse", MapSize.SMALL),
    POINT_HOPE("Point Hope", MapSize.SMALL),
    MAPLE_LODGE_CAMPSITE("Maple Lodge Campsite", MapSize.MEDIUM),
    PRISON("Prison", MapSize.MEDIUM),
    SUNNY_MEADOWS_RESTRICTED("Sunny Meadows Mental Institution (Restricted)", MapSize.MEDIUM),
    BROWNSTONE_HIGH_SCHOOL("Brownstone High School", MapSize.LARGE),
    SUNNY_MEADOWS("Sunny Meadows Mental Institution", MapSize.LARGE);

    // Attributes
    @NotNull private final String FULL_NAME;
    @NotNull private final MapSize MAP_SIZE;

    // Constructor
    Map(@NotNull final String FULL_NAME, @NotNull final MapSize MAP_SIZE) {
        this.FULL_NAME = FULL_NAME;
        this.MAP_SIZE = MAP_SIZE;
    }

    // Methods
    public @NotNull String getFullName() {
        return FULL_NAME;
    }
    public @NotNull MapSize getMapSize() {
        return MAP_SIZE;
    }
    @Override @NotNull
    public String toString() {
        return getFullName();
    }
}
