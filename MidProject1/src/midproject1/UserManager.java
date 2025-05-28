package midproject1;

import java.util.ArrayList;

public class UserManager {

    public static ArrayList<User> userList = new ArrayList<>(); // Static list to store all registered users
    private Admin adminUser; // The system admin
    private static User loginUser; // The currently logged-in user

    // Constructor initializes the admin user
    public UserManager() {
        adminUser = new Admin("Esila", "Şahin", "esila04", "2004");
    }

    // Adds a new user to the user list
    public static void addUser(User user) {
        userList.add(user);
    }

    // Returns a list of all users
    public static ArrayList<User> getAllUsers() {
        return userList;
    }

    // Retrieves a user object by their username
    public static User getUserByUsername(String username) {
        for (User user : userList) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    // Checks if the login credentials belong to the admin
    public boolean isAdmin(String username, String password) {
        return adminUser.getUsername().equals(username) && adminUser.getPassword().equals(password);
    }

    // Handles new user registration
    public static boolean registerUser(String firstName, String lastName, String username, String password) {
        // If the username already exists, registration fails
        for (User u : userList) {
            if (u.getUsername().equals(username)) {
                return false; // Username taken
            }
        }
        return true; // Username is available
    }

    // Sets the currently logged-in user
    public static void setUser(User user) {
        loginUser = user;
    }

    // Returns the currently logged-in user
    public static User getUser() {
        return loginUser;
    }

    // Checks if the user is assigned to any project
    public static boolean isUserAssignedToAnyProject(User user, ArrayList<Project> allProjects) {
        for (Project project : allProjects) {
            Team team = project.getTeam();
            if (team != null && team.getMembers().contains(user)) {
                return true;
            }
        }
        return false;
    }

    // Checks if a user with the given username exists
    public static boolean userExists(String username) {
        for (User user : userList) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

}
