package midproject1;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Project {

    private String projectName;
    private String description;
    private ArrayList<Task> tasks;
    private Team team;

    // Constructor to initialize project name, description, and tasks list
    public Project(String projectName, String description, ArrayList<Task> tasks) {
        this.projectName = projectName;
        this.description = description;
        this.tasks = tasks != null ? tasks : new ArrayList<>();
    }

    // Getter for project name
    public String getProjectName() {
        return projectName;
    }

    // Setter for project name
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    // Getter for project description
    public String getDescription() {
        return description;
    }

    // Setter for project description
    public void setDescription(String description) {
        this.description = description;
    }

    // Getter for the list of tasks
    public ArrayList<Task> getTasks() {
        return tasks;
    }

    // Setter for the list of tasks
    public void setTasks(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    // Method to add a task to the project if it's not already in the list
    public void addTask(Task task) {
        if (!tasks.contains(task)) {
            tasks.add(task);
        } else {
            // Display an error message if the task already exists in the lis
            JOptionPane.showMessageDialog(null, "This task has already been added!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Getter for assigned team
    public Team getTeam() {
        return team;
    }

    // Setter for assigning a team to the project (only if no team is assigned yet)
    public void setTeam(Team team) {
        if (this.team == null) {
            this.team = team;
        } else {
            // Display a message if a team is already assigned to the project
            JOptionPane.showMessageDialog(null, "A team has already been assigned to this project.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Method to check if the project contains at least one task
    public boolean isValidProject() {
        return tasks != null && tasks.size() >= 1;
    }

    // Method to check if all tasks in the project are marked as "Done"
    public boolean isCompleted() {
        for (Task task : tasks) {
            if (!"Done".equalsIgnoreCase(task.getStatus())) {
                return false; // If at least one task is not "Done", the project is not completed
            }
        }
        return true; // If all tasks are "Done", the project is completed
    }

}
