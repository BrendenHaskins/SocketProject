import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 A server that executes the Simple Bank Access Protocol.
 */
public class DungeonServer
{
    public static void main(String[] args) throws IOException
    {
        Boss boss = new Boss();
        final int DDAP_PORT = 8888;
        ServerSocket server = new ServerSocket(DDAP_PORT);
        System.out.println("Waiting for clients to connect...");

        while (true)
        {
            Socket s = server.accept();
            System.out.println("Client connected.");
            DungeonService service = new DungeonService(s, boss);
            Thread t = new Thread(service);
            t.start();
        }
    }
}