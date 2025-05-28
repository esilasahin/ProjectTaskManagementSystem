package midproject1;

import java.util.ArrayList;

public class Team {

    private String teamName; // Name of the team
    private ArrayList<User> members = new ArrayList<>(); // List of members (users) in the team
    private ArrayList<Task> tasks; // List of tasks assigned to the team
    private static ArrayList<String> teamList = new ArrayList<>(); // List of all team names
    private static ArrayList<Team> allTeams = new ArrayList<>(); // List of all team objects in the system

    // Constructor
    public Team(String teamName, ArrayList<User> members, ArrayList<Task> tasks) {
        this.teamName = teamName;
        this.members = (members != null) ? members : new ArrayList<>();
        this.tasks = (tasks != null) ? tasks : new ArrayList<>();
    }

    // Returns all teams
    public static ArrayList<Team> getAllTeams() {
        return new ArrayList<>(allTeams);
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public ArrayList<User> getMembers() {
        return members;
    }

    public void setMembers(ArrayList<User> members) {
        this.members = members;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void setTasks(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    // Adds a member to the team if not already present
    public void addMember(User user) {
        if (!members.contains(user)) {
            members.add(user);
        }
    }

    // Removes a member from the team
    public void removeMember(User user) {
        members.remove(user);
    }

    // Adds a task to the team if it's not already assigned to another team
    public void addTask(Task task) {
        if (task.getAssignedTeam() == null) {
            tasks.add(task);
            task.setAssignedTeam(this);
        } else {
            javax.swing.JOptionPane.showMessageDialog(null, "This task is already assigned to another team!", "Warning", javax.swing.JOptionPane.WARNING_MESSAGE);
        }
    }

    // Removes a task from the team
    public void removeTask(Task task) {
        tasks.remove(task);
    }

    // Returns all team names
    public static ArrayList<String> getAllTeamNames() {
        return new ArrayList<>(teamList);
    }

    // Checks whether a team name already exists (case-insensitive)
    public static boolean teamNameExists(String teamName) {
        for (Team team : allTeams) {
            if (team.getTeamName().equalsIgnoreCase(teamName)) {
                return true;
            }
        }
        return false;
    }

    // Adds a new team if the name doesn't already exist
    public static void addTeam(Team team) {
        if (!teamList.contains(team.getTeamName())) {
            teamList.add(team.getTeamName());
            allTeams.add(team);
        }
    }

    // Convenience method to add a team by name only
    public static void addTeam(String teamName) {
        if (!teamNameExists(teamName)) {
            //teamList.add(teamName);
            Team team = new Team(teamName, null, null); // Create new team with empty members/tasks
            addTeam(team); // Reuse existing method
        }
    }

    @Override
    public String toString() {
        return teamName;
    }

}
