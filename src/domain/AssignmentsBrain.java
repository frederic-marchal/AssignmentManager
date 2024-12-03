package domain;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class AssignmentsBrain {

  // Array to store Asignments
  private ArrayList<Assignment> assignments = new ArrayList<>();

  // Scanner object to read user-input
  Scanner scanner = new Scanner(System.in);

  // Method to only print the names of all assignments
  public void printAllAssignmentNames() {
    clearTerminal();
    System.out.println("Assignment Names:");
    for (int i = 0; i < assignments.size(); i++) {
      System.out.println(i + 1 + ". " + assignments.get(i).getName());
    }
    System.out.println("\n");
  }

  // Method to print all assignments
  public ArrayList<Assignment> viewAssignments() {
    clearTerminal();
    System.out.println("\nAll Assignments: \n");
    for (Assignment assignment : assignments) {
        System.out.println(assignment);
        System.out.println("\n▪️◽▪️◽▪️◽▪️◽▪️◽▪️◽▪️◽▪️◽\n");
    }
    return assignments;
  }

  // Method for creating an assignment
  public void addAssignment() {
    clearTerminal();
    System.out.println("Enter assignment name:");
    String name = scanner.nextLine();

    clearTerminal();
    System.out.println("Enter description:");
    String description = scanner.nextLine();

    clearTerminal();
    System.out.println("Enter deadline:");
    String deadline = scanner.nextLine();

    clearTerminal();
    System.out.println("Enter priority (1-3):");
    int priority = scanner.nextInt();
    scanner.nextLine();

    Assignment newAssignment = new Assignment(name, description, deadline, priority);

    // Check if the assignment already exists
    boolean isDuplicate = false;
    for (Assignment assignment : assignments) {
        if (newAssignment.equals(assignment)) {
            isDuplicate = true;
            break;
        }
    }

    if (isDuplicate) {
        clearTerminal();
        System.out.println("Duplicate detected! 🚫");
    } else {
        assignments.add(newAssignment);
        clearTerminal();
        System.out.println("Assignment added! 🎉");
        saveAssignment();
    }
}


  // Method to change the completion of a selcted assignment from false to true
  public void markAsCompleted() {
    printAllAssignmentNames();
    System.out.println("Which assignment would you like to mark as completed? (Enter the number)");
    int index = scanner.nextInt();
    scanner.nextLine();

    clearTerminal();
    if (index > 0 && index <= assignments.size()) {
        assignments.get(index - 1).setCompleted(true);
        System.out.println("Assignment marked as completed. ✅");
        saveAssignment();
        return;
    }
    clearTerminal();
    System.out.println("This assignment doesn't exist... 🤔");
  }

  // Method to change the completion of a selcted assignment from true to false
  public void markAsIncomplete() {
    printAllAssignmentNames();
    System.out.println("Which assignment would you like to mark as completed? (Enter the number)");
    int index = scanner.nextInt();
    scanner.nextLine();

    clearTerminal();
    if (index > 0 && index <= assignments.size()) {
      assignments.get(index - 1).setCompleted(false);
      System.out.println("Assignment marked as incomplete. ❌");
      saveAssignment();
      return;
    }
    clearTerminal();
    System.out.println("This assignment doesn't exist... 🤔");
  }

  // Method to edit a selected assignment including having the option to change only a specific attribute
  public void editChosenAssignment() {
    printAllAssignmentNames();
    System.out.println("Which assignment would you like to edit? (Enter the number)");
    int index = scanner.nextInt();
    scanner.nextLine();

    clearTerminal();
    if (index > 0 && index <= assignments.size()) {
      Assignment assignmentToEdit = assignments.get(index - 1);

        System.out.println("What would you like to edit?");
        System.out.println("(1) Name");
        System.out.println("(2) Description");
        System.out.println("(3) Deadline");
        System.out.println("(4) Priority");
        System.out.println("(5) All");

        int editChoice = scanner.nextInt();
        scanner.nextLine();

        switch (editChoice) {
            case 1:
                clearTerminal();
                System.out.println("Current Name: " + assignmentToEdit.getName());
                System.out.println("Enter new name:");
                assignmentToEdit.setName(scanner.nextLine());
                clearTerminal();
                System.out.println("Assignment name edited! 🎉");
                break;

            case 2:
                clearTerminal();
                System.out.println("Current description: " + assignmentToEdit.getDescription());
                System.out.println("Enter new description:");
                assignmentToEdit.setDescription(scanner.nextLine());
                clearTerminal();
                System.out.println("Assignment description edited! 🎉");
                break;

            case 3:
                clearTerminal();
                System.out.println("Current deadline: " + assignmentToEdit.getDeadline());
                System.out.println("Enter new deadline:");
                assignmentToEdit.setDeadline(scanner.nextLine());
                clearTerminal();
                System.out.println("Assignment deadline edited! 🎉");
                break;

            case 4:
                clearTerminal();
                System.out.println("Current priority: " + assignmentToEdit.getPriority());
                System.out.println("Enter new priority (1-3):");
                assignmentToEdit.setPriority(scanner.nextInt());
                scanner.nextLine();
                clearTerminal();
                System.out.println("Assignment priority edited! 🎉");
                break;

            case 5:
                clearTerminal();
                System.out.println("Current Name: " + assignmentToEdit.getName());
                System.out.println("Enter new name:");
                assignmentToEdit.setName(scanner.nextLine());
                clearTerminal();
                System.out.println("Current description: " + assignmentToEdit.getDescription());
                System.out.println("Enter new description:");
                assignmentToEdit.setDescription(scanner.nextLine());
                clearTerminal();
                System.out.println("Current deadline: " + assignmentToEdit.getDeadline());
                System.out.println("Enter new deadline:");
                assignmentToEdit.setDeadline(scanner.nextLine());
                clearTerminal();
                System.out.println("Current priority: " + assignmentToEdit.getPriority());
                System.out.println("Enter new priority (1-3):");
                assignmentToEdit.setPriority(scanner.nextInt());
                scanner.nextLine();
                clearTerminal();
                System.out.println("Assignment edited! 🎉");
                break;

            default:
                clearTerminal();
                System.out.println("That wasn't the right input. Please try again. 🤔");
        }
        saveAssignment();
    } else {
        clearTerminal();
        System.out.println("This assignment doesn't exist... 🤔");
    }
  }

  // Method to delete a selected assignment
  public void deleteAssignment() {
    printAllAssignmentNames();
    System.out.println("Which assignment would you like to delete? (Enter the number)");
    int index = scanner.nextInt();
    scanner.nextLine();

    if (index > 0 && index <= assignments.size()) {
      assignments.remove(index - 1);
      clearTerminal();
      System.out.println("Assignment deleted. 🗑️");
      saveAssignment();
      return;
    }
    clearTerminal();
    System.out.println("This assignment doesn't exist... 🤔");
  }

  // Method for loading existing assignments from the csv file
  public void loadAssignments() {
        try {
            File file = new File("assignments.csv");
            file.createNewFile();

            Scanner sc = new Scanner(file);
            sc.useDelimiter(",|\n");

            while (sc.hasNext()) {
                String name = sc.next();
                String description = sc.next();
                String deadline = sc.next();
                int priority = Integer.parseInt(sc.next());
                boolean isCompleted = Boolean.parseBoolean(sc.next());

                Assignment assignment = new Assignment(name, description, deadline, priority);
                assignment.setCompleted(isCompleted);

                assignments.add(assignment);
            }
            sc.close();
        } catch (IOException ex) {
            System.err.println(ex);
        }
  }

  // Method for saving changes onto the csv file
  public void saveAssignment() {
  try (FileWriter writer = new FileWriter("assignments.csv")) {
      for (Assignment assignment : assignments) {
          writer.write(
              assignment.getName() + "," +
              assignment.getDescription() + "," +
              assignment.getDeadline() + "," +
              assignment.getPriority() + "," +
              assignment.getCompleted() + "\n"
          );
      }
    System.out.println("Saved! 💾 \n");
    } catch (IOException ex) {
      System.err.println(ex);
    }
  }

  // Method to clear the terminal (it gets full rather fast)
  public void clearTerminal() {
    try {
      if (System.getProperty("os.name").contains("Windows")) {
          new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } else {
          System.out.print("\033[H\033[2J");
          System.out.flush();
          }
    } catch (Exception ex) {
      System.err.println(ex);
      }
    }
}
