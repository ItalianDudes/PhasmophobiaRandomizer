package it.italiandudes.phasmophobia_randomizer.data;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

import static it.italiandudes.phasmophobia_randomizer.data.Evidence.*;

public enum Ghost {
    SPIRIT("Spirito", EMF_LEVEL_5, SPIRIT_BOX, GHOST_WRITING),
    POLTERGEIST("Poltergeist", SPIRIT_BOX, FINGERPRINT, GHOST_WRITING),
    MARE("Mare", SPIRIT_BOX, GHOST_ORB, GHOST_WRITING),
    DEMON("Demone", FINGERPRINT, GHOST_WRITING, FREEZING_TEMPERATURES),
    YOKAI("Yokai", SPIRIT_BOX, GHOST_ORB, DOTS_PROJECTOR),
    MYLING("Myling", EMF_LEVEL_5, FINGERPRINT, GHOST_WRITING),
    RAIJU("Raiju", EMF_LEVEL_5, GHOST_ORB, DOTS_PROJECTOR),
    MOROI("Moroi", SPIRIT_BOX, GHOST_WRITING, FREEZING_TEMPERATURES),
    WRAITH("Wraith", EMF_LEVEL_5, SPIRIT_BOX, DOTS_PROJECTOR),
    BANSHEE("Banshee", FINGERPRINT, GHOST_ORB, DOTS_PROJECTOR),
    REVENANT("Revenant", GHOST_ORB, GHOST_WRITING, FREEZING_TEMPERATURES),
    YUREI("Yurei", GHOST_ORB, FREEZING_TEMPERATURES, DOTS_PROJECTOR),
    HANTU("Hantu", FINGERPRINT, GHOST_ORB, FREEZING_TEMPERATURES),
    ONRYO("Onryo", SPIRIT_BOX, GHOST_ORB, FREEZING_TEMPERATURES),
    OBAKE("Obake", EMF_LEVEL_5, FINGERPRINT, GHOST_ORB),
    DEOGEN("Deogen", SPIRIT_BOX, GHOST_WRITING, DOTS_PROJECTOR),
    PHANTOM("Phantom", SPIRIT_BOX, FINGERPRINT, DOTS_PROJECTOR),
    JINN("Jinn", EMF_LEVEL_5, FINGERPRINT, FREEZING_TEMPERATURES),
    SHADE("Ombra", EMF_LEVEL_5, GHOST_WRITING, FREEZING_TEMPERATURES),
    ONI("Oni", EMF_LEVEL_5, FREEZING_TEMPERATURES, DOTS_PROJECTOR),
    GORYO("Goryo", EMF_LEVEL_5, FINGERPRINT, DOTS_PROJECTOR),
    TWINS("I Gemelli", EMF_LEVEL_5, SPIRIT_BOX, FREEZING_TEMPERATURES),
    MIMIC("Il Mimo", SPIRIT_BOX, FINGERPRINT, FREEZING_TEMPERATURES),
    THAYE("Thaye", GHOST_ORB, GHOST_WRITING, DOTS_PROJECTOR);

    // Attributes
    @NotNull private final String name;
    @NotNull private final List<Evidence> evidences;

    // Constructors
    Ghost(@NotNull final String name, @NotNull final Evidence... evidences) {
        this.name = name;
        this.evidences = Arrays.asList(evidences);
    }

    // Methods
    @NotNull
    public String getName() {
        return name;
    }
    @NotNull
    public List<Evidence> getEvidences() {
        return evidences;
    }
}
