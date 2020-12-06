import java.io.*;

public class Deserializer {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("1.txt");
        ObjectInputStream in = new ObjectInputStream(fis);
        User user = (User) in.readObject();
        System.out.println(user.username + ": " + user.password);


    }

}
