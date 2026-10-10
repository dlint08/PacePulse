package driver;
import model.PacePulseEngine;
import java.util.Scanner;

/**
 * Course: CIS171 Java
 * File: PacePulseDriver.java
 * Description: Console user interface driving the PacePulse session planner.
 */
public class PacePulseDriver {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String keepRunning;

        System.out.println("=========================================");
        System.out.println("  WELCOME TO PACEPULSE SESSION PLANNER   ");
        System.out.println("=========================================");

        // Structured loop requirement
        do {
            System.out.print("\nEnter Runner Name: ");
            String runnerName = scanner.nextLine().trim().toUpperCase();

            System.out.print("Enter Runner Age: ");
            int age = Integer.parseInt(scanner.nextLine().trim());

            System.out.print("Enter Run Type (e.g., BASE, TEMPO, LONG): ");
            String runType = scanner.nextLine().trim().toUpperCase();

            System.out.print("Enter Planned Distance (miles): ");
            double distance = Double.parseDouble(scanner.nextLine().trim());

            System.out.print("Enter Target Duration Hours: ");
            int hours = Integer.parseInt(scanner.nextLine().trim());

            System.out.print("Enter Target Duration Minutes: ");
            int minutes = Integer.parseInt(scanner.nextLine().trim());

            System.out.print("Enter Target Duration Seconds: ");
            int seconds = Integer.parseInt(scanner.nextLine().trim());

            // Process logic via Engine
            int totalSeconds = PacePulseEngine.convertToTotalSeconds(hours, minutes, seconds);
            int paceInSeconds = PacePulseEngine.calculatePaceInSeconds(distance, totalSeconds);
            String paceFormatted = PacePulseEngine.formatPaceString(paceInSeconds);

            int maxHr = PacePulseEngine.calculateMaxHeartRate(age);
            int hrLower = PacePulseEngine.calculateTargetHeartRate(maxHr, 0.60);
            int hrUpper = PacePulseEngine.calculateTargetHeartRate(maxHr, 0.85);

            int sessionCode = PacePulseEngine.generateSessionCode();

            // Display formatted results
            System.out.println("\n=== PACEPULSE SESSION PLANNER ===");
            System.out.println("Runner: " + runnerName + " | Session Code: #RUN-" + sessionCode);
            System.out.println("Run Type: " + runType + " | Distance: " + String.format("%.2f", distance) + " miles");
            System.out.println("Target Duration: " + hours + " hrs " + minutes + " mins " + seconds + " secs");
            System.out.println("---------------------------------");
            System.out.println("Average Target Pace: " + paceFormatted + " /mi");
            System.out.println("Estimated Max HR: " + maxHr + " bpm");
            System.out.println("Target Training Zone (60%-85%): " + hrLower + " bpm - " + hrUpper + " bpm");
            System.out.println("=================================");

            // Prompt user to continue loop or exit
            System.out.print("\nCalculate another run session? (Y/N): ");
            keepRunning = scanner.nextLine().trim();

        } while (keepRunning.equalsIgnoreCase("Y"));

        System.out.println("\nThank you for using PacePulse! Have a great workout.");
        scanner.close();
    }
}
