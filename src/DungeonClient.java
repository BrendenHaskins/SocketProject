import java.io.InputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


public class DungeonClient
{
    public static void main(String[] args) throws IOException
    {
        final int DDAP_PORT = 8888;
        try (Socket s = new Socket("localhost", DDAP_PORT))
        {
            InputStream instream = s.getInputStream();
            OutputStream outstream = s.getOutputStream();
            Scanner in = new Scanner(instream);
            PrintWriter out = new PrintWriter(outstream);


            String command = "ATTACK";
            System.out.println("Sending: " + command);
            out.print(command + "\n");
            out.flush();
            String response = in.nextLine();
            System.out.println("Receiving: " + response);

            command = "HEALTH";
            System.out.println("Sending: " + command);
            out.print(command + "\n");
            out.flush();
            response = in.nextLine();
            System.out.println("Receiving: " + response);

            command = "STAMINA";
            System.out.println("Sending: " + command);
            out.print(command + "\n");
            out.flush();
            response = in.nextLine();
            System.out.println("Receiving: " + response);

            command = "DESC";
            System.out.println("Sending: " + command);
            out.print(command + "\n");
            out.flush();
            response = in.nextLine();
            System.out.println("Receiving: " + response);

            command = "QUIT";
            System.out.println("Sending: " + command);
            out.print(command + "\n");
            out.flush();
        }
    }
}