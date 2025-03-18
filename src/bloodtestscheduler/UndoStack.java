package bloodtestscheduler;
import java.util.Stack;

public class UndoStack {
    // Stack to hold Patient objects for undo functionality
    private Stack<Patient> stack;

    // Constructor 
    public UndoStack() {
        stack = new Stack<>(); 
    }

    // Method to add a patient to the stack 
    public void push(Patient patient) {
        stack.push(patient);
    }

    // Method to remove the most recent patient from the stack (pop operation)
    public Patient pop() {
        // If the stack is empty, return null, otherwise remove and return the top patient
        return stack.isEmpty() ? null : stack.pop(); 
    }
}
