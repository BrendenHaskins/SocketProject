import java.io.InputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


public class DungeonCLI
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
            Scanner cli = new Scanner(System.in);

            System.out.println("Enter a command...");
            while(true) {
                String command = cli.nextLine();
                if(command.equals("QUIT")) {
                    out.print(command + "\n");
                    out.flush();
                    break;
                }else{
                    System.out.println("Sending: " + command);
                    out.print(command + "\n");
                    out.flush();
                    String response = in.nextLine();
                    System.out.println(response);
                }
            }


            //
        }
    }
}