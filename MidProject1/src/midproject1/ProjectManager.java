package midproject1;

import java.util.ArrayList;

public class ProjectManager {

    // List of all created projects
    public static ArrayList<Project> projectList = new ArrayList<>();

    // List of team-to-project assignments
    public static ArrayList<Assignment> assignments = new ArrayList<>();

    // Adds a new assignment by team and project names
    public static void addAssignment(String team, String project) {
        assignments.add(new Assignment(team, project));
    }

    // Replaces the current assignments list with a new one
    public static void setAssignments(ArrayList<Assignment> assignments) {
        ProjectManager.assignments = assignments;
    }

    // Returns the list of all assignments
    public static ArrayList<Assignment> getAssignments() {
        return assignments;
    }

    // Adds a project to the project list if it doesn't already exist
    public static void addProject(Project project) {
        if (project != null && !projectList.contains(project)) {
            projectList.add(project);
        }
    }

    // Adds a single assignment object to the list
    public static void addAssignment(Assignment assignment) {
        assignments.add(assignment);
    }

    // Returns all projects
    public static ArrayList<Project> getAllProjects() {
        return projectList;
    }

    // Clears the list of projects
    public static void clearProjects() {
        projectList.clear();
    }

    // Returns a list of all project names
    public static ArrayList<String> getAllProjectNames() {
        ArrayList<String> names = new ArrayList<>();
        for (Project p : projectList) {
            names.add(p.getProjectName());
        }
        return names;
    }

    // Checks if a project with the given name already exists
    public static boolean projectNameExists(String name) {
        for (Project p : projectList) {
            if (p.getProjectName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    // Finds and returns a task by its title across all projects
    public static Task getTaskByTitle(String title) {
        for (Project project : projectList) {
            for (Task task : project.getTasks()) {
                if (task.getTitle().equals(title)) {
                    return task;
                }
            }
        }
        return null;
    }

    // Finds and returns a team by its name using the Team class
    public static Team findTeamByName(String name) {
        for (Team team : Team.getAllTeams()) {
            if (team.getTeamName().equals(name)) {
                return team;
            }
        }
        return null;
    }

    // Finds the team a user belongs to for a specific project
    public static Team findTeamByUserAndProject(User user, Project project) {
        for (Assignment a : ProjectManager.getAssignments()) {
            if (a.getProjectName().equals(project.getProjectName())) {
                Team team = ProjectManager.findTeamByName(a.getTeamName());
                if (team != null && team.getMembers().contains(user)) {
                    return team;
                }
            }
        }
        return null;
    }

}
