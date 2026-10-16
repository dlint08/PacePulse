package model;

import java.text.DecimalFormat;
import java.util.Random;

/**
 * Course: CIS171 Java
 * File: PacePulseEngine.java
 * Description: Business logic engine maintaining runner profile state and
 * performing calculations for pace, time conversion, calorie expenditure, and hydration.
 *
 * Resource Citation: Refined for package modularity and course comment conventions.
 */
public class PacePulseEngine {

    // Private instance fields protecting runner state
    private String runnerName;
    private int runnerAge;
    private double runnerWeightLbs;
    private double distanceInMiles;
    private double targetTimeInMinutes;

    // Formatting constant for pace display
    private static final DecimalFormat PACE_FORMAT = new DecimalFormat("0.00");

    /**
     * Default constructor initializing baseline runner parameters.
     * Consumed: None
     * Produced: None (Constructor)
     */
    public PacePulseEngine() {
        this.runnerName = "Anonymous";
        this.runnerAge = 25;
        this.runnerWeightLbs = 150.0;
        this.distanceInMiles = 0.0;
        this.targetTimeInMinutes = 0.0;
    }

    /**
     * Parameterized constructor setting initial runner profile state.
     * Consumed: runnerName (String), runnerAge (int), runnerWeightLbs (double), distanceInMiles (double), targetTimeInMinutes (double)
     * Produced: None (Constructor)
     */
    public PacePulseEngine(String runnerName, int runnerAge, double runnerWeightLbs, double distanceInMiles, double targetTimeInMinutes) {
        this.runnerName = runnerName;
        this.runnerAge = runnerAge;
        this.runnerWeightLbs = runnerWeightLbs;
        this.distanceInMiles = distanceInMiles;
        this.targetTimeInMinutes = targetTimeInMinutes;
    }

    // --- GETTERS AND SETTERS ---

    public String getRunnerName() {
        return runnerName;
    }

    public void setRunnerName(String runnerName) {
        this.runnerName = runnerName;
    }

    public int getRunnerAge() {
        return runnerAge;
    }

    public void setRunnerAge(int runnerAge) {
        this.runnerAge = runnerAge;
    }

    public double getRunnerWeightLbs() {
        return runnerWeightLbs;
    }

    public void setRunnerWeightLbs(double runnerWeightLbs) {
        this.runnerWeightLbs = runnerWeightLbs;
    }

    public double getDistanceInMiles() {
        return distanceInMiles;
    }

    public void setDistanceInMiles(double distanceInMiles) {
        this.distanceInMiles = distanceInMiles;
    }

    public double getTargetTimeInMinutes() {
        return targetTimeInMinutes;
    }

    public void setTargetTimeInMinutes(double targetTimeInMinutes) {
        this.targetTimeInMinutes = targetTimeInMinutes;
    }

    // --- STATIC UTILITY METHODS MATCHING JUNIT TESTS ---

    /**
     * Converts hours, minutes, and seconds into total cumulative seconds.
     * Consumed: hours (int), minutes (int), seconds (int)
     * Produced: total time in seconds (int)
     */
    public static int convertToTotalSeconds(int hours, int minutes, int seconds) {
        if (hours < 0 || minutes < 0 || seconds < 0) {
            return 0;
        }
        return (hours * 3600) + (minutes * 60) + seconds;
    }

    /**
     * Calculates required pace in seconds per mile based on distance and total duration in seconds.
     * Consumed: distanceInMiles (double), totalSeconds (int)
     * Produced: pace in seconds per mile (int)
     */
    public static int calculatePaceInSeconds(double distanceInMiles, int totalSeconds) {
        if (distanceInMiles <= 0 || totalSeconds <= 0) {
            return 0;
        }
        return (int) Math.round(totalSeconds / distanceInMiles);
    }

    /**
     * Estimates maximum heart rate using Fox formula (220 - age).
     * Consumed: age (int)
     * Produced: estimated max heart rate in BPM (int)
     */
    public static int calculateMaxHeartRate(int age) {
        if (age <= 0 || age > 120) {
            return 0;
        }
        return 220 - age;
    }

    /**
     * Formats pace in seconds per mile into a standard MM:SS string.
     * Consumed: paceInSeconds (int)
     * Produced: formatted pace string MM:SS (String)
     */
    public static String formatPaceString(int paceInSeconds) {
        if (paceInSeconds <= 0) {
            return "0:00";
        }
        int min = paceInSeconds / 60;
        int sec = paceInSeconds % 60;
        return String.format("%d:%02d", min, sec);
    }

    // --- INSTANCE BUSINESS METHODS ---

    /**
     * Calculates required target pace in minutes per mile.
     * Consumed: distance (double), timeMinutes (double)
     * Produced: calculated pace per mile (double)
     */
    public double calculateTargetPace(double distance, double timeMinutes) {
        if (distance <= 0 || timeMinutes <= 0) {
            return 0.0;
        }
        return timeMinutes / distance;
    }

    /**
     * Estimates fluid intake needs based on run duration and sweat rate multiplier.
     * Consumed: runDurationHours (double), sweatRateOzPerHour (double)
     * Produced: total fluid required in ounces (double)
     */
    public double calculateHydrationNeeds(double runDurationHours, double sweatRateOzPerHour) {
        if (runDurationHours <= 0 || sweatRateOzPerHour <= 0) {
            return 0.0;
        }
        double rawOunces = runDurationHours * sweatRateOzPerHour;
        return Math.round(rawOunces * 100.0) / 100.0;
    }

    /**
     * Calculates gross calories burned during run based on body weight and distance.
     * Consumed: weightLbs (double), distanceMiles (double)
     * Produced: estimated total calories burned (double)
     */
    public double calculateCaloriesBurned(double weightLbs, double distanceMiles) {
        if (weightLbs <= 0 || distanceMiles <= 0) {
            return 0.0;
        }
        double rawCalories = weightLbs * distanceMiles * 0.75;
        return Math.round(rawCalories * 10.0) / 10.0;
    }

    /**
     * Formats raw decimal pace values into a readable string display.
     * Consumed: rawPace (double)
     * Produced: formatted pace string with units (String)
     */
    public String formatPaceDisplay(double rawPace) {
        if (rawPace <= 0) {
            return "N/A";
        }
        return PACE_FORMAT.format(rawPace) + " min/mi";
    }

    /**
     * Extracts runner initials from full name string.
     * Consumed: fullName (String)
     * Produced: uppercase initials string (String)
     */
    public String extractRunnerInitials(String fullName) {
        if (fullName == null || fullName.trim().isEmpty()) {
            return "N/A";
        }

        String cleanName = fullName.trim().toUpperCase();
        int spaceIndex = cleanName.indexOf(' ');

        if (spaceIndex == -1) {
            return String.valueOf(cleanName.charAt(0));
        }

        char firstInitial = cleanName.charAt(0);
        char lastInitial = cleanName.charAt(spaceIndex + 1);

        return "" + firstInitial + lastInitial;
    }

    /**
     * Selects a random motivational strategy tip based on max options bound.
     * Consumed: maxOptions (int)
     * Produced: motivational strategy quote (String)
     */
    public String getRandomMotivationalTip(int maxOptions) {
        if (maxOptions <= 0) {
            return "Trust your training and execute your plan.";
        }

        Random rand = new Random();
        int choice = rand.nextInt(maxOptions);

        switch (choice) {
            case 0:
                return "Focus on negative splits: build momentum during the second half.";
            case 1:
                return "Maintain low cadence, high-resistance cross-training on non-running days.";
            case 2:
                return "Prioritize post-run percussive recovery and steady hydration.";
            default:
                return "Trust the training plan and stay steady through every mile.";
        }
    }
}
