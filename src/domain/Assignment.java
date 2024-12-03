package domain;

public class Assignment {

  // Attributes
  private String name = "";
  private String description = "";
  private String deadline = "";
  private boolean completion = false;
  private int priority = 0;

  // Constructor
  public Assignment(String name, String description, String deadline, int priority) {
    this.name = name;
    this.description = description;
    this.deadline = deadline;
    this.priority = priority;
  }

  // Getters and Setters
  public void setName(String name) {
    this.name = name;
  }

  public void setDeadline(String deadline) {
    this.deadline = deadline;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setPriority(int priority) {
    this.priority = priority;
  }

  public void setCompleted(boolean completion) {
    this.completion = completion;
  }

  public String getName() {
    return this.name;
  }

  public String getDeadline() {
    return this.deadline;
  }

  public String getDescription() {
    return this.description;
  }

  public int getPriority() {
    return this.priority;
  }

  public boolean getCompleted() {
    return this.completion;
  }

  // toString method
  public String toString() {
    String Emoji;

    switch (this.priority) {
        case 1:
            Emoji = "🟩";
            break;
        case 2:
            Emoji = "🟨";
            break;
        case 3:
            Emoji = "🟥";
            break;
        default:
            Emoji = "⚪";
    }

    if (this.completion == true) {
        return "Name: " + this.name + "\nDescription: " + this.description + "\nDeadline: " + this.deadline + "\nPriority: " + Emoji + "\nStatus: Completed ✅";
    }else {
        return "Name: " + this.name + "\nDescription: " + this.description + "\nDeadline: " + this.deadline + "\nPriority: " + Emoji + "\nStatus: Incomplete ❌";
    }
  }

  // equals method
  public boolean equals(Assignment assignment) {
    return this.name.equals(assignment.getName()) && this.description.equals(assignment.getDescription()) && this.deadline.equals(assignment.getDeadline()) && this.priority == assignment.getPriority();
  }
}
