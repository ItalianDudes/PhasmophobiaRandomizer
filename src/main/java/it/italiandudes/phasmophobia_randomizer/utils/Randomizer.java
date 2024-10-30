package it.italiandudes.phasmophobia_randomizer.utils;

import java.util.Random;

public final class Randomizer {

     // Attributes
    public static final Random RANDOM = new Random();

    // Methods
    public static int randomBetween(int min, int max) {
        max++;
        return RANDOM.nextInt(max - min) + min;
    }
}
