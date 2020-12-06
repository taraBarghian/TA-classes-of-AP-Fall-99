import com.sun.jdi.PathSearchingVirtualMachine;

import java.io.*;

class Serializer {
    public static void main(String[] args) throws IOException {
        //FileWriter fw = new FileWriter("1.txt");
        FileOutputStream fos = new FileOutputStream("1.txt");
        ObjectOutputStream out = new ObjectOutputStream(fos);
        User user1 = new User("Mehrshad", "mehrshad@gmail.com", "1234");
        out.writeObject(user1);
        out.close();
    }

}



