package bloodtestscheduler;

import javax.swing.SwingUtilities;

public class SchedulerApp {
    // Main method to run the application GUI
    public static void main(String[] args) {
        // Launch the GUI on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            new BloodTestSchedulerGUI().setVisible(true);
        });
    }
}
