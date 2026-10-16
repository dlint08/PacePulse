package test;

import model.PacePulseEngine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Course: CIS171 Java
 * File: PacePulseEngineTest.java
 * Description: JUnit test suite for PacePulse calculation logic.
 */
public class PacePulseEngineTest {

    private PacePulseEngine engine;

    @BeforeEach
    public void setUp() {
        engine = new PacePulseEngine();
    }

    @Test
    public void testConvertToTotalSeconds() {
        // 1 hour (3600s), 20 minutes (1200s), 30 seconds = 4830 total seconds
        int totalSecs = PacePulseEngine.convertToTotalSeconds(1, 20, 30);
        assertEquals(4830, totalSecs);
    }

    @Test
    public void testCalculatePaceInSeconds() {
        // 3.1 miles in 24 mins 48 secs (1488 total seconds) = 480 secs/mile (8:00 pace)
        int paceSecs = PacePulseEngine.calculatePaceInSeconds(3.1, 1488);
        assertEquals(480, paceSecs);
    }

    @Test
    public void testCalculateMaxHeartRate() {
        // 220 - 40 age = 180 BPM
        int maxHR = PacePulseEngine.calculateMaxHeartRate(40);
        assertEquals(180, maxHR);
    }

    @Test
    public void testFormatPaceString() {
        // 480 seconds = "8:00"
        String formatted = PacePulseEngine.formatPaceString(480);
        assertEquals("8:00", formatted);
    }

    @Test
    public void testCalculateCaloriesBurned() {
        // 160 lbs runner * 10 miles * 0.75 = 1200 kcal
        double calories = engine.calculateCaloriesBurned(160.0, 10.0);
        assertEquals(1200.0, calories, 0.1);
    }

    @Test
    public void testExtractRunnerInitials() {
        String initials = engine.extractRunnerInitials("Daniel Lint");
        assertEquals("DL", initials);
    }
}
