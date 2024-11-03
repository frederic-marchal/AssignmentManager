package presentation;
import domain.*;
import java.util.Scanner;

public class UserInterface {
    public static void main(String[] args) {

        // Initialize Scanner and AssignmentsBrain Object
        AssignmentsBrain brain = new AssignmentsBrain();
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;

        // Load data from the csv File
        brain.loadAssignments();

        // While loop is true it will keep on going
        while (loop == true) {

          // asking user to chose an option that will direct the code to the needed method
            System.out.println("Choose an option:");
            System.out.println("(1) View All Assignments");
            System.out.println("(2) Add Assignment");
            System.out.println("(3) Edit Assignment");
            System.out.println("(4) Mark Assignment as Completed");
            System.out.println("(5) Mark Assignment as Incomplete");
            System.out.println("(6) Delete Assignment");
            System.out.println("(7) Exit");

            if (scanner.hasNextInt() == false) {
                brain.clearTerminal();
                System.out.println("\nWell... this wasn't a option 🤔 \n");
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
                    System.out.println("Goodbye! 🖖");
                    scanner.close();
                    loop = false;
                    break;

                default:
                    brain.clearTerminal();
                    System.out.println("\nWell... this wasn't a option 🤔 \n");
                    break;
            }
        }
    }
}
