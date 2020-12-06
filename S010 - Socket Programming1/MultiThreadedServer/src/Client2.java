import java.io.*;
import java.net.*;
import java.util.Scanner;

// Client class
public class Client2
{
    public static void main(String[] args) throws IOException
    {

        Scanner scn = new Scanner(System.in);
        Socket s = new Socket( "localhost", 5056);

        DataInputStream dis = new DataInputStream(s.getInputStream());
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());


        System.out.println(dis.readUTF());
        String tosend = scn.nextLine();
        dos.writeUTF(tosend);






        // closing resources
        scn.close();
        dis.close();
        dos.close();

    }
}