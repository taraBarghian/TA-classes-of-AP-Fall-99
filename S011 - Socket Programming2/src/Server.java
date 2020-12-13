import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    static Map<String, ClientHandler> users;
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(4051);
        users = new ConcurrentHashMap<>();
        while (true) {
            Socket socket = serverSocket.accept();
            Thread clientThread = new Thread(new ClientHandler(socket));
            clientThread.start();
        }
    }

    public static void printUsers() {
        int count = 1;
        for (String user:users.keySet()) {
            System.out.println(count + " - " + user);
            count ++;
        }
        System.out.println();
    }
}
