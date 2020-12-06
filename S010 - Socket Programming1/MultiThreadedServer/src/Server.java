import java.io.*;
import java.text.*;
import java.util.*;
import java.net.*;

// Server class
public class Server
{
    public static void main(String[] args) throws IOException
    {
        // server is listening on port 5056
        ServerSocket ss = new ServerSocket(5056);

        while (true)
        {
            Socket s = null;

            try
            {
                s = ss.accept();

                System.out.println("A new client is connected : " + s);

                DataInputStream dis = new DataInputStream(s.getInputStream());
                DataOutputStream dos = new DataOutputStream(s.getOutputStream());

                System.out.println("Assigning new thread for this client");

                ClientHandler t = new ClientHandler(s, dis, dos);
                Thread thread = new Thread(t);
                thread.start();

            }
            catch (Exception e){

                s.close();
                e.printStackTrace();
            }
        }
    }
}

// ClientHandler class
class ClientHandler implements Runnable
{

    final DataInputStream dis;
    final DataOutputStream dos;
    final Socket s;


    public ClientHandler(Socket s, DataInputStream dis, DataOutputStream dos)
    {
        this.s = s;
        this.dis = dis;
        this.dos = dos;
    }

    @Override
    public void run()
    {
        String received;

            try {

                dos.writeUTF("please introduce yourself ");
                // receive the answer from client
                received = dis.readUTF();
                System.out.println(received);


            } catch (IOException e) {
                e.printStackTrace();
            }


        try
        {
            // closing resources
            this.dis.close();
            this.dos.close();

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}