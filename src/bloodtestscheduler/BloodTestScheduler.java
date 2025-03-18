package bloodtestscheduler;

import java.util.*;

public class BloodTestScheduler {
    private LinkedList<Patient> patientList; // Stores all registered patients
    private PriorityQueue<Patient> priorityQueue; // Schedules patients
    private Queue<Patient> noShowQueue; // Tracks last 5 no-shows

    public BloodTestScheduler() {
        patientList = new LinkedList<>();
        priorityQueue = new PriorityQueue<>();
        noShowQueue = new LinkedList<>();
    }

    public void addPatient(Patient patient) {
        patientList.add(patient);
        priorityQueue.offer(patient);
    }

    public Patient processNextPatient() {
        return priorityQueue.poll();
    }

    public void recordNoShow() {
        if (!priorityQueue.isEmpty()) {
            Patient noShow = priorityQueue.poll();
            if (noShowQueue.size() >= 5) {
                noShowQueue.poll(); // Remove the oldest no-show
            }
            noShowQueue.offer(noShow);
        }
    }

    public List<Patient> getNoShowRecords() {
        return new ArrayList<>(noShowQueue);
    }

    public List<Patient> getAllPatients() {
        return new ArrayList<>(patientList);
    }
}
