package midproject1;

import java.util.ArrayList;

public class Admin extends User {

    // Constructor to initialize the admin with personal information
    public Admin(String firstName, String lastName, String username, String password) {
        super(firstName, lastName, username, password);
    }

    // Adds a user to the specified team
    public void addUserToTeam(Team team, User user) {
        team.addMember(user);
    }

    // Removes a user from the specified team
   // public void removeUserFromTeam(Team team, User user) {
    //    team.removeMember(user);
    //}kullanmadım

    // Creates a new team with a given name and empty member/task lists
    public Team createTeam(String teamName) {
        return new Team(teamName, new ArrayList<>(), new ArrayList<>());
    }

    // Assigns a team to a project
    public void assignTeamToProject(Project project, Team team) {
        project.setTeam(team);
    }

    // Adds a task to a project
    public void addTaskToProject(Project project, Task task) {
        project.addTask(task);
    }

    // Assigns a task to a specific user
    public void assignTaskToUser(Task task, User user) {
        task.setAssignedUser(user);
    }

    // Sets the end date of a task, with validation to prevent invalid times
    public void setTaskEndDate(Task task, java.time.LocalDateTime endDate) {
        task.setEndTime(endDate);
    }
}
