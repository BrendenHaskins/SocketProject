import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.io.PrintWriter;

public class DungeonService implements Runnable{
    private Socket s;
    private Scanner in;
    private PrintWriter out;
    private Boss boss;
    private int stamina;

    public DungeonService(Socket socket, Boss boss) {
        this.stamina = 10;
        this.s = socket;
        this.boss = boss;
    }

    @Override
    public void run() {
        try {
            try {
                in = new Scanner(s.getInputStream());
                out = new PrintWriter(s.getOutputStream());
                doService();
            } finally {
                s.close();
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void doService() throws IOException {
        while(true) {
            if (!in.hasNext()) {
                return;
            }
            String command = in.next();
            if(command.equals("ATTACK")) {
                if(stamina <= 0) {
                    out.println("You are exhausted! Come back later!");
                    return;
                }else {
                    stamina--;
                }
            }
            if(command.equals("QUIT")) {
                return;
            }else {
                executeCommand(command);
            }
        }
    }

    public void executeCommand(String command) {
        System.out.println(command);
        switch(command) {
            case "STAMINA":
                out.println(stamina + " stamina remaining!");
                out.flush();
                break;
            case "ATTACK":
                String response = boss.attack();
                if(response.contains("Defeated!")) {
                    out.println(response);
                    out.println("A new beast appears before you!");
                    this.boss = new Boss();
                    out.flush();
                }
                out.println(response);
                out.flush();
                break;
            case "HEALTH":
                out.println(boss.getHealth());
                out.flush();
                break;
            case "DESC":
                out.println(boss.getDesc());
                out.flush();
                break;
            case "HELP":
                out.println("Valid commands are: STAMINA, ATTACK, HEALTH, DESC");
                out.flush();
                break;
            default:
                out.println("Invalid command. Use HELP for command list.");
                out.flush();
                break;


        }
    }

}
