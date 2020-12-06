import java.io.*;
import java.net.*;
import java.util.Random;

public class Server {
    DataInputStream dis = null;
    DataOutputStream dos = null;
    ServerSocket ss = null;
    public Server(int port) throws IOException {
        ss = new ServerSocket(port);
        ////------important////////----
        Socket socket = ss.accept();
        System.out.println("client accepted");
        ///---------------------------
        dis = new DataInputStream(socket.getInputStream());
        dos = new DataOutputStream(socket.getOutputStream());
        Random random = new Random();
        int rand = random.nextInt(11);

        while (true){
           int answer = Integer.parseInt(dis.readUTF());
            System.out.println(answer);
            if (answer == rand){
                dos.writeUTF("YES");
                break;
            }
            else dos.writeUTF("NO");
        }
        socket.close();
        dis.close();
        dos.close();
    }

    public static void main(String[] args) throws IOException {
        Server server =new Server(8080);
    }
}
