import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    static Socket socket;
    static DataInputStream dis;
    static DataOutputStream dos;
    public static void main(String[] args) {
        try {
            socket = new Socket("127.0.0.1", 4051);
            dis = new DataInputStream(socket.getInputStream());
            dos = new DataOutputStream(socket.getOutputStream());
            Scanner input = new Scanner(System.in);
            System.out.println("write username");

            String username = "";
            String serverUsernameValidation = "";
            do {
                username = input.nextLine();
                dos.writeUTF(username);
                serverUsernameValidation = dis.readUTF();
                System.out.println(serverUsernameValidation);
            } while (serverUsernameValidation.startsWith("error"));

            Thread messageListener = new Thread(new MessageListener(dis));
            messageListener.start();

            while (true) {
                System.out.println("Enter receiver username");
                String receiverUsername = input.nextLine();
                dos.writeUTF(receiverUsername);
                System.out.println("write message");
                String message = input.nextLine();
                dos.writeUTF(message);

            }
        } catch (Exception e) {
            try {
                dos.close();
                dis.close();
                socket.close();
            } catch (IOException e1) {}
        }
    }
}

class MessageListener implements Runnable {
    DataInputStream dis;
    MessageListener(DataInputStream dis) {
        this.dis = dis;
    }
    @Override
    public void run() {
        try {
            String message = dis.readUTF();
            System.out.println(message);
        } catch (Exception e) {
            try {
                dis.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
}