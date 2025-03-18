package bloodtestscheduler;

public class Patient implements Comparable<Patient> {
    // variables for my patient information
    private String name;
    private int id;
    private int age;
    private String priority;  
    private boolean isHospitalized;
    private String gpDetails;

    // Constructor for patient's details
    public Patient(String name, int id, int age, String priority, boolean isHospitalized, String gpDetails) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.priority = priority;
        this.isHospitalized = isHospitalized;
        this.gpDetails = gpDetails;
    }

    // Getter 
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getPriority() {
        return priority;
    }

    public boolean isHospitalized() {
        return isHospitalized;
    }

    public String getGpDetails() {
        return gpDetails;
    }

    // Method to compare patients based on priority, hospitalization, and age
    @Override
    public int compareTo(Patient other) {
        // First to compare by priority
        int thisPriorityValue = priorityToValue(this.priority);
        int otherPriorityValue = priorityToValue(other.priority);
        
          // Higher priority should come first
        if (thisPriorityValue != otherPriorityValue) {
            return Integer.compare(otherPriorityValue, thisPriorityValue); 
        }

        // If the priority is the same, compare if they are hospitalized
        if (this.isHospitalized != other.isHospitalized) {
            return this.isHospitalized ? -1 : 1; // Hospitalized patients should come first
        }

        // If both priority and hospitalization are the same, compare their ages
        return Integer.compare(other.age, this.age);
    }

    // Helper method to convert priority to a value for comparison
    private int priorityToValue(String priority) {
        switch (priority.toLowerCase()) {
            case "urgent":
                return 3; // Urgent has the highest priority
            case "medium":
                return 2; // Medium priority
            case "low":
                return 1; // Low priority
            default:
                return 0; 
        }
    }

    // Overriding toString method to represent the patient details as a string
    @Override
    public String toString() {
        // Concatenate all the information into a readable string format
        return name + " (ID: " + id + ", Age: " + age + ", Priority: " + priority +
               ", Hospitalized: " + (isHospitalized ? "Yes" : "No") + ")";
    }
}
