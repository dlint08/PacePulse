package driver;

import model.SecurityAnalyst;

/**
 * Course: CIS171 Java
 * File: AnalystDriver.java
 * Description: Driver class to demonstrate functionality of the SecurityAnalyst class.
 */
public class AnalystDriver {
    public static void main(String[] args) {
        // 1. Create reference object using Default Constructor
        SecurityAnalyst analyst1 = new SecurityAnalyst();
        System.out.println("Default Object:");
        System.out.println(analyst1.toString());
        System.out.println();

        // Demonstrate setters on analyst1
        analyst1.setAnalystName("Sarah Johnson");
        analyst1.setCertification("Security+");
        analyst1.setYearsExperience(3);
        analyst1.setActiveIncident(true);

        System.out.println("After Using Setters:");
        System.out.println(analyst1.toString());
        System.out.println();

        // 2. Create reference object using Non-Default Constructor
        SecurityAnalyst analyst2 = new SecurityAnalyst("Michael Chen", "CISSP", 8, false);
        System.out.println("Non-Default Object:");
        System.out.println(analyst2.toString());
        System.out.println();

        // Modify non-default object using a setter
        analyst2.setAnalystName("Michael Rodriguez");
        System.out.println("After Name Change:");
        System.out.println(analyst2.toString());
        System.out.println();

        // Demonstrate getter method
        System.out.println("Certification:");
        System.out.println(analyst2.getCertification());
        System.out.println();

        // Demonstrate investigate method
        System.out.println("Investigate Method:");
        System.out.println(analyst1.investigate());
        System.out.println(analyst2.investigate());
    }
}
