package midproject1;

import java.util.ArrayList;

public class User {

    // User's personal information
    private String firstName;
    private String lastName;
    private String username;
    private String password;    
    private Team team; // Team to which the user belongs
    private ArrayList<Task> assignedTasks; // Tasks assigned specifically to this user
    public static User currentUser; // The currently logged-in user (static reference)

    public User(String firstName, String lastName, String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.assignedTasks = new ArrayList<>(); // Start with an empty task list
    }

    // Returns the name of the team the user is in, if any
    public String getTeamName() {
        return (team != null) ? team.getTeamName() : null;
    }

    // Getter and setter methods for user details
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Validates login credentials by comparing input with stored values
    public boolean validateLogin(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    // Returns the team object the user is part of
    public Team getTeam() {
        return this.team;
    }

    // Sets the user's team
    public void setTeam(Team team) {
        this.team = team;
    }

    // Returns the list of tasks assigned to the user
    public ArrayList<Task> getAssignedTasks() {
        return assignedTasks;
    }

    // Assigns a task to the user
    public void assignTask(Task task) {
        assignedTasks.add(task);
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}
