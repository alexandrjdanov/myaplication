import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    private String firstName;
    private String lastName;
    private String userName;
    private int tasksCount;

    private Map<String , String> tasks;
    static ArrayList<User> users = new ArrayList<User>();

    public static User createUser(String firstName, String lastName, String userName) {
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setUserName(userName);
        users.add(user);
        user.tasksCount = 0;
        user.tasks = new HashMap<String , String>();
        return user;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public static void addTask(User user, String taskTitle, String taskDescription) {
        user.tasks.put(taskTitle, taskDescription);
        user.tasksCount++;
        System.out.println("Task " + "'" + taskTitle + "'" + " was assigned to " + user.getUserName());
    }

    public static void showTasks() {
        for (User user : users) {
            System.out.println(user.getUserName() + " tasks: ");
            if (user.tasks.isEmpty()) System.out.println(user.getUserName() + " has no tasks yet");
            else for (String t : user.tasks.keySet()) {
                    System.out.println(t + " - " + user.tasks.get(t));
            }
        }
    }

    public static User selectUser(String username) {
        for (User u: users) {
            if (username.equals(u.getUserName())) {
                return u;
            }
        }
        return null;
    }

    public static User searchByUsername(String userName) {
        boolean isFound = false;
        for (User u: users) {
            if (userName.equals(u.getUserName())) {
                isFound = true;
                System.out.println("User you are looking for is: " + u.getFirstName() + " " + u.getLastName());
                return u;
            }
        }
        if (!isFound) System.out.println("User with username - " + userName + " - not found.");
        return null;
    }


    public static void showAllUsers() {
        System.out.println("List of created users:");
        for (User u : users) {
            System.out.println(u);
        }
    }

    @Override
    public String toString() {
        return "User [" +
                "First Name = " + firstName +
                ", Last Name = " + lastName +
                ", Username = " + userName +
                ", № of tasks = " + tasksCount +
                ']';
    }
}
