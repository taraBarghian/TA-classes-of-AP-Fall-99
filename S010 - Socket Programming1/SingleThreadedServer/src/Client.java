import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    DataInputStream dis = null;
    DataOutputStream dos = null;

    public Client(String address, int port) throws IOException {


        Socket socket = new Socket(address, port);
        dis = new DataInputStream(socket.getInputStream());
        dos = new DataOutputStream(socket.getOutputStream());

        Scanner scanner = new Scanner(System.in);
        while (true){

            int guess = scanner.nextInt();
            dos.writeUTF(String.valueOf(guess));
            String input = dis.readUTF();
            if (input.equals("YES")) break;
            System.out.println("your guess was wrong try again");

        }
        socket.close();
        dos.close();
        dis.close();


    }

    public static void main(String[] args) throws IOException {
        Client client = new Client("127.0.0.1", 8080);
    }
}
