import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class PriorityScheduling {
    public void runPriorityScheduling(Scanner scanner) {
        int numProcesses = getValidIntInput(scanner, "Enter number of processes: ", 1, Integer.MAX_VALUE);
        List<Process> processes = new ArrayList<>();

        for (int i = 0; i < numProcesses; i++) {
            System.out.println("Enter details for Process " + (i + 1) + ":");
            int arrivalTime = getValidIntInput(scanner, "Arrival Time: ", 0, Integer.MAX_VALUE);
            int burstTime = getValidIntInput(scanner, "Burst Time: ", 1, Integer.MAX_VALUE);
            int priority = getValidIntInput(scanner, "Priority: ", 1, Integer.MAX_VALUE);
            processes.add(new Process(i + 1, arrivalTime, burstTime, priority));
        }

        boolean preemptive = getValidBooleanInput(scanner, "Is the scheduling preemptive? (true/false): ");
        calculatePriorityScheduling(processes, preemptive);
        displayResults(processes);
    }

    private void calculatePriorityScheduling(List<Process> processes, boolean preemptive) {
        if (preemptive) {
            // Implement preemptive priority scheduling logic here
        } else {
            // Sort processes based on arrival time and priority
            Collections.sort(processes, Comparator.comparingInt(Process::getArrivalTime)
                    .thenComparingInt(Process::getPriority));

            int waitingTime = 0;
            for (Process process : processes) {
                process.setWaitingTime(waitingTime);
                waitingTime += process.getBurstTime();
                process.setTurnaroundTime(process.getWaitingTime() + process.getBurstTime());
            }
        }
    }

    private void displayResults(List<Process> processes) {
        System.out.println("\nPriority Scheduling Results:");
        System.out.println("Process ID\tArrival Time\tBurst Time\tPriority\tWaiting Time\tTurnaround Time");
        for (Process process : processes) {
            System.out.println(process.getId() + "\t\t" + process.getArrivalTime() + "\t\t" +
                    process.getBurstTime() + "\t\t" + process.getPriority() + "\t\t" +
                    process.getWaitingTime() + "\t\t" + process.getTurnaroundTime());
        }
    }

    private int getValidIntInput(Scanner scanner, String prompt, int min, int max) {
        int value;
        while (true) {
            System.out.print(prompt);
            try {
                value = Integer.parseInt(scanner.nextLine());
                if (value >= min && value <= max) {
                    return value;
                } else {
                    System.out.println("Please enter a valid number between " + min + " and " + max + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    private boolean getValidBooleanInput(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("true")) {
                return true;
            } else if (input.equals("false")) {
                return false;
            } else {
                System.out.println("Invalid input. Please enter 'true' or 'false'.");
            }
        }
    }
}
