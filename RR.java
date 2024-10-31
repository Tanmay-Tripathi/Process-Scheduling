import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RR {
    public void runRR(Scanner scanner) {
        int numProcesses = getValidIntInput(scanner, "Enter number of processes: ", 1, Integer.MAX_VALUE);
        List<Process> processes = new ArrayList<>();

        for (int i = 0; i < numProcesses; i++) {
            System.out.println("Enter details for Process " + (i + 1) + ":");
            int arrivalTime = getValidIntInput(scanner, "Arrival Time: ", 0, Integer.MAX_VALUE);
            int burstTime = getValidIntInput(scanner, "Burst Time: ", 1, Integer.MAX_VALUE);
            processes.add(new Process(i + 1, arrivalTime, burstTime, 0));
        }

        int quantumTime = getValidIntInput(scanner, "Enter Quantum Time: ", 1, Integer.MAX_VALUE);
        calculateRR(processes, quantumTime);
        displayResults(processes);
    }

    private void calculateRR(List<Process> processes, int quantumTime) {
        int time = 0;
        List<Process> queue = new ArrayList<>(processes);
        while (!queue.isEmpty()) {
            Process process = queue.remove(0);
            if (process.getBurstTime() <= quantumTime) {
                time += process.getBurstTime();
                process.setWaitingTime(time - process.getArrivalTime() - process.getBurstTime());
                process.setTurnaroundTime(time - process.getArrivalTime());
            } else {
                process.setBurstTime(process.getBurstTime() - quantumTime);
                time += quantumTime;
                queue.add(process);
            }
        }
    }

    private void displayResults(List<Process> processes) {
        System.out.println("\nRR Scheduling Results:");
        System.out.println("Process ID\tArrival Time\tBurst Time\tWaiting Time\tTurnaround Time");
        for (Process process : processes) {
            System.out.println(process.getId() + "\t\t" + process.getArrivalTime() + "\t\t" +
                    process.getBurstTime() + "\t\t" + process.getWaitingTime() + "\t\t" +
                    process.getTurnaroundTime());
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
}