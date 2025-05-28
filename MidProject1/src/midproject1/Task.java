package midproject1;

import java.time.LocalDateTime;

public class Task {

    private String title; // Title of the task
    private LocalDateTime startTime; // Start time of the task
    private LocalDateTime endTime; // End time (deadline) of the task
    private String status; // Status of the task (e.g., "To Do", "In Progress", "Done")
    private Team assignedTeam; // The team assigned to this task
    private User assignedUser; // The specific user assigned to this task

    // Constructor to initialize task details
    public Task(String title, LocalDateTime startTime, LocalDateTime endTime, String status) {
        this.title = title;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = status;
    }

    // Getter and setter methods for task properties
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Team getAssignedTeam() {
        return assignedTeam;
    }

    public void setAssignedTeam(Team team) {
        this.assignedTeam = team;
    }

    public User getAssignedUser() {
        return assignedUser;
    }

    public void setAssignedUser(User assignedUser) {
        this.assignedUser = assignedUser;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Task other = (Task) obj;
        return this.title.equalsIgnoreCase(other.title); 
    }

    @Override
    public String toString() {
        return title;
    }

}
