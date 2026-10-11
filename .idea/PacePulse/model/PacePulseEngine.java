package model;
import java.util.Random;

/**
 * Course: CIS171 Java
 * File: PacePulseEngine.java
 * Description: Core calculation and business logic engine for PacePulse.
 *
 * INCREMENTAL DESIGN APPROACH:
 * I built and tested the core arithmetic methods (time conversions, pace calculation,
 * and age-based heart rate formulas) independently first. Once these static utility
 * methods were verified for accuracy, I integrated them into the PacePulseDriver loop
 * and unit test suite.
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

    /*
     * QUESTION / STRUGGLE:
     * How should I best format split time durations when total workout time exceeds an hour?
     * Currently, formatPaceString handles per-mile minutes and seconds well, but I want to
     * ensure long endurance run totals display cleanly without redundant zeroes or string
     * parsing errors in the driver UI.
     */

    /**
     * METHOD STUB:
     * Calculates estimated calories burned during a run session based on runner weight,
     * distance, and duration.
     * Planned for complete implementation in the final midterm submission iteration.
     *
     * @param weightLbs Runner weight in pounds
     * @param distanceMiles Total distance completed in miles
     * @param totalSeconds Total run duration in seconds
     * @return Estimated calories burned
     */
    public static double calculateCaloriesBurned(double weightLbs, double distanceMiles, int totalSeconds) {
        // TODO: Implement calorie burn formula in next iteration
        return 0.0; // Temporary stub return
    }
}
