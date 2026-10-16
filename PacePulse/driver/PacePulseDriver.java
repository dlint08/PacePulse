package driver;

import model.PacePulseEngine;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Course: CIS171 Java
 * File: PacePulseDriver.java
 * Description: Main user interface driver managing Scanner prompts, validation loops,
 * and presentation for the PacePulse Engine.
 */
public class PacePulseDriver {

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        PacePulseEngine engine = new PacePulseEngine();

        System.out.println("==================================================");
        System.out.println("   WELCOME TO PACEPULSE MARATHON STRATEGY ENGINE  ");
        System.out.println("==================================================");

        // 1. Runner Profile Entry
        System.out.print("Enter Runner Full Name (e.g., Jane Doe): ");
        String runnerName = scnr.nextLine();
        engine.setRunnerName(runnerName);
        String initials = engine.extractRunnerInitials(runnerName);
        System.out.println("Runner Profile Initialized for Initials: [" + initials + "]");
        System.out.println("--------------------------------------------------");

        // 2. Range Validated Inputs
        int age = readValidInt(scnr, "Enter Runner Age (years): ", 1, 120);
        engine.setRunnerAge(age);

        double weight = readValidDouble(scnr, "Enter Runner Weight (lbs): ", 50.0, 500.0);
        engine.setRunnerWeightLbs(weight);

        double distance = readValidDouble(scnr, "Enter target distance in miles (e.g., 13.1 or 26.2): ", 0.1, 200.0);
        engine.setDistanceInMiles(distance);

        double minutes = readValidDouble(scnr, "Enter target finish time in total minutes (e.g., 120): ", 1.0, 1440.0);
        engine.setTargetTimeInMinutes(minutes);

        // 3. Engine Calculations & Presentation
        double rawPace = engine.calculateTargetPace(distance, minutes);
        String formattedPace = engine.formatPaceDisplay(rawPace);
        double durationHours = minutes / 60.0;
        double fluidNeeded = engine.calculateHydrationNeeds(durationHours, 16.0);
        double caloriesBurned = engine.calculateCaloriesBurned(weight, distance);
        int maxHR = PacePulseEngine.calculateMaxHeartRate(age);

        System.out.println("\n==================================================");
        System.out.println("               RACE DAY TARGET SUMMARY            ");
        System.out.println("==================================================");
        System.out.println("Runner Profile : " + engine.getRunnerName() + " [" + initials + "]");
        System.out.println("Age / Weight   : " + engine.getRunnerAge() + " yrs / " + engine.getRunnerWeightLbs() + " lbs");
        System.out.println("Est. Max HR    : " + maxHR + " BPM");
        System.out.println("Target Distance: " + engine.getDistanceInMiles() + " miles");
        System.out.println("Target Time    : " + engine.getTargetTimeInMinutes() + " minutes");
        System.out.println("Required Pace  : " + formattedPace);
        System.out.println("Est. Calories  : " + caloriesBurned + " kcal");
        System.out.println("Fluid Required : " + fluidNeeded + " oz");
        System.out.println("--------------------------------------------------");
        System.out.println("Strategy Tip   : " + engine.getRandomMotivationalTip(4));
        System.out.println("==================================================");

        scnr.close();
    }

    /**
     * Helper method to validate integer input within range using a structured while loop.
     * Consumed: scnr (Scanner), prompt (String), min (int), max (int)
     * Produced: validated integer (int)
     */
    private static int readValidInt(Scanner scnr, String prompt, int min, int max) {
        int value = 0;
        boolean valid = false;

        while (!valid) {
            System.out.print(prompt);
            try {
                value = scnr.nextInt();
                if (value >= min && value <= max) {
                    valid = true;
                } else {
                    System.out.println("Error: Please enter a value between " + min + " and " + max + ".");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Invalid numeric input. Please enter a whole number.");
                scnr.next();
            }
        }
        return value;
    }

    /**
     * Helper method to validate double input within range using a structured while loop.
     * Consumed: scnr (Scanner), prompt (String), min (double), max (double)
     * Produced: validated double (double)
     */
    private static double readValidDouble(Scanner scnr, String prompt, double min, double max) {
        double value = 0.0;
        boolean valid = false;

        while (!valid) {
            System.out.print(prompt);
            try {
                value = scnr.nextDouble();
                if (value >= min && value <= max) {
                    valid = true;
                } else {
                    System.out.println("Error: Please enter a value between " + min + " and " + max + ".");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Invalid input. Please enter a valid decimal number.");
                scnr.next();
            }
        }
        return value;
    }
}
