import java.util.Scanner;

public class SchedulerMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu();
        int choice;

        do {
            menu.displayMainMenu();
            choice = getValidIntInput(scanner, "Enter your choice: ", 0, 5);

            switch (choice) {
                case 1:
                    FCFS fcfs = new FCFS();
                    fcfs.runFCFS(scanner);
                    break;
                case 2:
                    SJF sjf = new SJF();
                    sjf.runSJF(scanner);
                    break;
                case 3:
                    RR rr = new RR();
                    rr.runRR(scanner);
                    break;
                case 4:
                    PriorityScheduling ps = new PriorityScheduling();
                    ps.runPriorityScheduling(scanner);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please select again.");
            }
        } while (choice != 5);

        scanner.close();
    }

    private static int getValidIntInput(Scanner scanner, String prompt, int min, int max) {
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
