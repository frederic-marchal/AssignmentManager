package presentation;
import domain.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AssignmentsBrain brain = new AssignmentsBrain();
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;

        brain.loadAssignments();

        while (loop == true) {
            System.out.println("\nChoose an option:");
            System.out.println("(1) View All Assignments");
            System.out.println("(2) Add Assignment");
            System.out.println("(3) Edit Assignment");
            System.out.println("(4) Mark Assignment as Completed");
            System.out.println("(5) Mark Assignment as Incomplete");
            System.out.println("(6) Delete Assignment");
            System.out.println("(7) Clean up Terminal");
            System.out.println("(8) Exit");

            if (scanner.hasNextInt() == false) {
                System.out.println("Well... this wasn't a option 🤔");
                scanner.nextLine();
                continue;
            }

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    brain.viewAssignments();
                    break;

                case 2:
                    brain.addAssignment();
                    break;

                case 3:
                    brain.editChosenAssignment();
                    break;

                case 4:
                    brain.markAsCompleted();
                    break;

                case 5:
                    brain.markAsIncomplete();
                    break;

                case 6:
                    brain.deleteAssignment();
                    break;

                case 7:
                    brain.clearTerminal();
                    break;

                case 8:
                    System.out.println("Goodbye! 🖖");
                    scanner.close();
                    loop = false;
                    break;

                default:
                    System.out.println("Well... this wasn't a option 🤔");
                    break;
            }
        }
    }
}
