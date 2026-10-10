package test;
import model.PacePulseEngine;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Course: CIS171 Java
 * File: PacePulseEngineTest.java
 * Description: JUnit test suite for PacePulse calculation logic.
 */
public class PacePulseEngineTest {

    @Test
    public void testConvertToTotalSeconds() {
        // 1 hour, 20 minutes, 30 seconds = 5030 seconds
        int totalSecs = PacePulseEngine.convertToTotalSeconds(1, 20, 30);
        assertEquals(5030, totalSecs);
    }

    @Test
    public void testCalculatePaceInSeconds() {
        // 3.1 miles in 24 mins 48 secs (1488 total seconds) = 480 secs/mile (8:00 pace)
        int paceSecs = PacePulseEngine.calculatePaceInSeconds(3.1, 1488);
        assertEquals(480, paceSecs);
    }

    @Test
    public void testFormatPaceString() {
        // 483 seconds = 8 minutes 3 seconds ("8:03")
        String formattedPace = PacePulseEngine.formatPaceString(483);
        assertEquals("8:03", formattedPace);
    }

    @Test
    public void testCalculateMaxHeartRate() {
        // Age 38 -> Max HR 182
        int maxHr = PacePulseEngine.calculateMaxHeartRate(38);
        assertEquals(182, maxHr);
    }
}
