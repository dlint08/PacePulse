import javax.swing.JOptionPane;
import java.util.Random;

public class CyberDefenseLint {
    public static void main(String[] args) {
        // 1. Input Agent ID
        String agentIdInput = JOptionPane.showInputDialog(null, "Enter Agent ID:");

        // Handle cancelled input or null
        if (agentIdInput == null) {
            System.exit(0);
        }

        agentIdInput = agentIdInput.trim().toUpperCase();

        // Bonus: Validate length is exactly 7 characters
        if (agentIdInput.length() != 7) {
            JOptionPane.showMessageDialog(null,
                    "Your Agent ID is invalid. ID must be exactly 7 characters.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }

        // Format Agent ID (XX:XX:XXX format using substring)
        String formattedAgentId = agentIdInput.substring(0, 2) + ":" +
                agentIdInput.substring(2, 4) + ":" +
                agentIdInput.substring(4);

        // 2. Input Connection Duration in seconds
        String durationInput = JOptionPane.showInputDialog(null, "Enter connection duration (seconds):");

        if (durationInput == null) {
            System.exit(0);
        }

        int totalSeconds = Integer.parseInt(durationInput.trim());

        // Integer division and modulus for minutes/seconds conversion
        int minutes = totalSeconds / 60;
        int seconds = totalSeconds % 60;

        // 3. Generate Random 6-digit Token (100000 to 999999)
        Random rand = new Random();
        int authToken = 100000 + rand.nextInt(900000);

        // 4. Assemble Output Message
        String outputMessage = "=== CYBERDEFENSE SOC ACCESS ===\n" +
                "Agent ID: " + formattedAgentId + "\n" +
                "Session Duration: " + minutes + " minutes " + seconds + " seconds\n" +
                "Authentication Token: " + authToken + "\n" +
                "===============================";

        // Display results in a ShowMessageDialog
        JOptionPane.showMessageDialog(null, outputMessage, "CyberDefense SOC", JOptionPane.INFORMATION_MESSAGE);
    }
}