import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler implements Runnable {
    Socket socket;
    DataInputStream dis;
    DataOutputStream dos;
    String username;

    ClientHandler(Socket socket) throws IOException {
        this.socket = socket;
        dis = new DataInputStream(socket.getInputStream());
        dos = new DataOutputStream(socket.getOutputStream());
    }

    @Override
    public void run() {
        try {
            username = dis.readUTF();
            while(Server.users.containsKey(username)) {
                this.dos.writeUTF("error: this username already exists. enter another!");
                username = dis.readUTF();
            }
            this.dos.writeUTF("successfully registered!");
            Server.users.put(username, this);
            Server.printUsers();
            while (true) {
                String receiver = dis.readUTF();
                String message = dis.readUTF();

                if (receiver.equals("everyone")) {
                    for (String user:Server.users.keySet()) {
                        ClientHandler tempUserHandler = Server.users.get(user);
                        tempUserHandler.dos.writeUTF(username + " : " + message);
                    }
                }
                else {
                    if (Server.users.containsKey(receiver)) {
                        ClientHandler receiverHandler = Server.users.get(receiver);
                        receiverHandler.dos.writeUTF(username + " : " + message);
                    } else {
                        this.dos.writeUTF("error: this user doesn't exists");
                    }
                }
            }
        } catch (Exception e) {
            Server.users.remove(username);
            Server.printUsers();
            try {
                socket.close();
                dis.close();
                dos.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

        }
    }
}
