import java.io.*;
import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.util.ArrayList;

public class UserDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        FileOutputStream outputStream = new FileOutputStream("C:\\Users\\User\\Desktop\\save.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

        objectOutputStream.writeObject(User.users);
        objectOutputStream.close();

        User.createUser("James", "Smith", "user1");
        User.createUser("Maria", "Garcia", "user2");
        User.createUser("Michael", "Hernandez", "user3");

        User.showAllUsers();
        User.searchByUsername("user1");
        User.addTask(User.selectUser("user1"), "Task1", "Create new method");
        User.addTask(User.selectUser("user2"), "Task1", "Create new Class");
        User.addTask(User.selectUser("user1"), "Task2", "Create new Constructor");
        User.showTasks();

        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\User\\Desktop\\save.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        User.users = (ArrayList<User>) objectInputStream.readObject();



    }
}
