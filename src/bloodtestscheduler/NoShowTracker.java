package bloodtestscheduler;

import java.util.ArrayList;
import java.util.List;

public class NoShowTracker {
    // List to store patients who have missed their appointments
    private List<Patient> noShows;

    // Constructor 
    public NoShowTracker() {
    noShows = new ArrayList<>(); 
    }

    // Method to add a new no-show patient to the list
    public void addNoShow(Patient patient) {
        if (noShows.size() >= 5) {
            noShows.remove(0); 
        }
        noShows.add(patient); 
    }

    // This method creates and returns a formatted string of all no-show patients
    public String displayNoShows() {
        StringBuilder sb = new StringBuilder();
        // Loop through the no-show list and append each patient's name to the string
        for (Patient p : noShows) {
            sb.append(p.getName()).append("\n"); 
        }
        return sb.toString(); 
    }
}
