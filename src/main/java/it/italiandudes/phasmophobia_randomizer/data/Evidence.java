package it.italiandudes.phasmophobia_randomizer.data;

import org.jetbrains.annotations.NotNull;

public enum Evidence {
    EMF_LEVEL_5("EMF Livello 5"),
    FINGERPRINT("Impronte Digitali"),
    GHOST_WRITING("Libro Spiritico"),
    FREEZING_TEMPERATURES("Temperatura di Congelamento"),
    DOTS_PROJECTOR("Puntatore D.O.T.S."),
    GHOST_ORB("Sfera di Luce"),
    SPIRIT_BOX("Spirit Box");

    // Attributes
    @NotNull private final String name;

    // Constructors
    Evidence(@NotNull final String name) {
        this.name = name;
    }

    // Methods
    @NotNull
    public String getName() {
        return name;
    }
}
