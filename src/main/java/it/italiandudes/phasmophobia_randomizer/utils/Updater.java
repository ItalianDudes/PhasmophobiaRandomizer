package it.italiandudes.phasmophobia_randomizer.utils;

import it.italiandudes.idl.common.Logger;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;

public final class Updater {

    // Attributes
    private static final String LATEST_PAGE = "https://github.com/ItalianDudes/PhasmophobiaRandomizer/releases/latest";
    private static final String LATEST_DOWNLOAD_PART = "https://github.com/ItalianDudes/PhasmophobiaRandomizer/releases/latest/download/GhostHuntingTool-";

    // Methods
    @Nullable
    public static String getLatestVersion() {
        try {
            URL url = new URL(LATEST_PAGE);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.getResponseCode();
            connection.disconnect();
            return connection.getURL().toString().split("/tag/")[1];
        } catch (IOException e) {
            Logger.log(e);
        }
        return null;
    }
    public static void downloadNewVersion(@NotNull final String destPath) throws IOException {
        String latestVersion = getLatestVersion();
        String downloadURL = LATEST_DOWNLOAD_PART+latestVersion+".jar";
        URL url = new URL(downloadURL);
        InputStream is = url.openConnection().getInputStream();
        Files.copy(is, Paths.get(destPath), StandardCopyOption.REPLACE_EXISTING);
        is.close();
    }
    public static String getLatestVersion(@Nullable final String versionA, @Nullable final String versionB) {
        if (versionA == null && versionB == null) return null;
        if (versionA != null && versionB == null) return versionA;
        if (versionA == null) return versionB;
        if (versionA.equals(versionB)) return versionA;

        String numberOnlyVersionA = versionA.substring(0, versionA.length()-1);
        String numberOnlyVersionB = versionB.substring(0, versionB.length()-1);

        String[] rawSplitVersionA = numberOnlyVersionA.split("\\.");
        int[] splitVersionA = new int[rawSplitVersionA.length];
        for (int i=0; i<splitVersionA.length; i++) {
            splitVersionA[i] = Integer.parseInt(rawSplitVersionA[i]);
        }
        String[] rawSplitVersionB = numberOnlyVersionB.split("\\.");
        int [] splitVersionB = new int[rawSplitVersionB.length];
        for (int i=0; i<splitVersionB.length; i++) {
            splitVersionB[i] = Integer.parseInt(rawSplitVersionB[i]);
        }

        if (Arrays.equals(splitVersionA, splitVersionB)) return versionA;

        for (int i=0; i<splitVersionA.length; i++) {
            if (splitVersionA[i] > splitVersionB[i]) {
                return versionA;
            } else if (splitVersionA[i] < splitVersionB[i]) {
                return versionB;
            } else if (i+1 >= splitVersionA.length && i+1 < splitVersionB.length) {
                return versionB;
            } else if (i+1 >= splitVersionB.length && i+1 < splitVersionA.length) {
                return versionA;
            }
        }

        return null;
    }

}
