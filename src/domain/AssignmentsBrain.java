package domain;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class AssignmentsBrain {

  private ArrayList<Assignment> assignments = new ArrayList<>();
  Scanner scanner = new Scanner(System.in);

  public void printAllAssignmentNames() {
    System.out.println("\nAssignment Names:");
        for (Assignment assignment : assignments) {
            System.out.println("- " + assignment.getName());
        }
    System.out.println("\n");
    }

  public ArrayList<Assignment> viewAssignments() {
    System.out.println("\nAll Assignments: \n");
    for (Assignment assignment : assignments) {
        System.out.println(assignment);
        System.out.println("\n▪️◽▪️◽▪️◽▪️◽▪️◽▪️◽▪️◽▪️◽\n");
    }
    return assignments;
  }

  public void addAssignment() {
    System.out.println("Enter assignment name:");
    String name = scanner.nextLine();

    System.out.println("Enter description:");
    String description = scanner.nextLine();

    System.out.println("Enter deadline:");
    String deadline = scanner.nextLine();

    System.out.println("Enter priority (1-3):");
    int priority = scanner.nextInt();
    scanner.nextLine();

    Assignment newAssignment = new Assignment(name, deadline, description, priority);
    assignments.add(newAssignment);

    System.out.println("Assignment added! 🎉");
    saveAssignment();
  }

  public void markAsCompleted() {
    printAllAssignmentNames();
    System.out.println("Which assignment would you like to mark as completed?");
    String completeName = scanner.nextLine();

    for (Assignment assignment : assignments) {
        if (assignment.getName().equalsIgnoreCase(completeName)) {
            assignment.setCompleted(true);
            System.out.println("Assignment marked as completed. ✅");
            return;
        }
    }
    System.out.println("This assignment doesn't exist... 🤔");
  }

  public void markAsIncomplete() {
    printAllAssignmentNames();
    System.out.println("Which assignment would you like to mark as incomplete?");
    String incompleteName = scanner.nextLine();

    for (Assignment assignment : assignments) {
      if (assignment.getName().equalsIgnoreCase(incompleteName)) {
        assignment.setCompleted(false);
        System.out.println("Assignment marked as incomplete. ❌");
        return;
      }
    }
    System.out.println("This assignment doesn't exist... 🤔");
  }

  public void editChosenAssignment() {
    printAllAssignmentNames();
    System.out.println("Which assignment would you like to edit?");
    String editName = scanner.nextLine();

    Assignment assignmentToEdit = null;
    for (Assignment assignment : assignments) {
        if (assignment.getName().equalsIgnoreCase(editName)) {
            assignmentToEdit = assignment;
            break;
        }
    }

    if (assignmentToEdit != null) {
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
                System.out.println("Current Name: " + assignmentToEdit.getName());
                System.out.println("Enter new name:");
                assignmentToEdit.setName(scanner.nextLine());
                System.out.println("Assignment name edited! 🎉");
                break;

            case 2:
                System.out.println("Current description: " + assignmentToEdit.getDescription());
                System.out.println("Enter new description:");
                assignmentToEdit.setDescription(scanner.nextLine());
                System.out.println("Assignment description edited! 🎉");
                break;

            case 3:
                System.out.println("Current deadline: " + assignmentToEdit.getDeadline());
                System.out.println("Enter new deadline (DD.MM.YYYY):");
                assignmentToEdit.setDeadline(scanner.nextLine());
                System.out.println("Assignment deadline edited! 🎉");
                break;

            case 4:
                System.out.println("Current priority: " + assignmentToEdit.getPriority());
                System.out.println("Enter new priority (1-3):");
                assignmentToEdit.setPriority(scanner.nextInt());
                scanner.nextLine();
                System.out.println("Assignment priority edited! 🎉");
                break;

            case 5:
                System.out.println("Current Name: " + assignmentToEdit.getName());
                System.out.println("Enter new name:");
                assignmentToEdit.setName(scanner.nextLine());
                System.out.println("Current description: " + assignmentToEdit.getDescription());
                System.out.println("Enter new description:");
                assignmentToEdit.setDescription(scanner.nextLine());
                System.out.println("Current priority: " + assignmentToEdit.getPriority());
                System.out.println("Enter new priority (1-3):");
                assignmentToEdit.setPriority(scanner.nextInt());
                scanner.nextLine();
                System.out.println("Current deadline: " + assignmentToEdit.getDeadline());
                System.out.println("Enter new deadline (DD.MM.YYYY):");
                assignmentToEdit.setDeadline(scanner.nextLine());
                System.out.println("Assignment edited! 🎉");
                break;

            default:
                System.out.println("That wasn't the right input. Please try again. 🤔");
        }
        saveAssignment();
    } else {
        System.out.println("This assignment doesn't exist... 🤔");
    }
  }

  public void deleteAssignment() {
    printAllAssignmentNames();
    System.out.println("Which assignment would you like to delete?");
    String deleteName = scanner.nextLine();

    for (Assignment assignment : assignments) {
      if (assignment.getName().equalsIgnoreCase(deleteName)) {
        assignments.remove(assignment);
        System.out.println("Assignment deleted. 🗑️");
        return;
      }
    }
    System.out.println("This assignment doesn't exist... 🤔");
  }

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

    public void saveAssignment() {
    try (FileWriter writer = new FileWriter("assignments.csv")) {
        for (Assignment assignment : assignments) {
            writer.write(
                assignment.getName() + "," +
                assignment.getDeadline() + "," +
                assignment.getDescription() + "," +
                assignment.getPriority() + "," +
                assignment.getCompleted() + "\n"
            );
        }
        System.out.println("Assignments saved! 💾");
    } catch (IOException ex) {
        System.err.println(ex);
    }
}

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
