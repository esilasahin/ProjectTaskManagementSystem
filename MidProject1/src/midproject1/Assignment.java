
package midproject1;

public class Assignment {
    private String teamName;
    private String projectName;

    // Constructor to initialize team name and project name
    public Assignment(String teamName, String projectName) {
        this.teamName = teamName;
        this.projectName = projectName;
    }

    // Getter for team name
    public String getTeamName() {
        return teamName;
    }

    // Getter for project name
    public String getProjectName() {
        return projectName;
    }

    @Override
    public String toString() {
        return "Team '" + teamName + "' -> Project '" + projectName + "'";
    }
}

