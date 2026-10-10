package model;
import java.util.Random;

/**
 * Course: CIS171 Java
 * File: PacePulseEngine.java
 * Description: Core calculation and business logic engine for PacePulse.
 */
public class PacePulseEngine {

    // Converts hours, minutes, and seconds into total seconds
    public static int convertToTotalSeconds(int hours, int minutes, int seconds) {
        return (hours * 3600) + (minutes * 60) + seconds;
    }

    // Calculates target pace in total seconds per mile
    public static int calculatePaceInSeconds(double distanceMiles, int totalSeconds) {
        if (distanceMiles <= 0) {
            return 0;
        }
        return (int) Math.round(totalSeconds / distanceMiles);
    }

    // Formats seconds per mile into MM:SS string
    public static String formatPaceString(int paceInSeconds) {
        int minutes = paceInSeconds / 60;
        int seconds = paceInSeconds % 60;
        return String.format("%d:%02d", minutes, seconds);
    }

    // Estimates maximum heart rate based on age
    public static int calculateMaxHeartRate(int age) {
        return 220 - age;
    }

    // Calculates target heart rate boundary for a given intensity percentage
    public static int calculateTargetHeartRate(int maxHeartRate, double intensityPercentage) {
        return (int) Math.round(maxHeartRate * intensityPercentage);
    }

    // Generates a random 6-digit session verification token
    public static int generateSessionCode() {
        Random rand = new Random();
        return 100000 + rand.nextInt(900000);
    }
}
