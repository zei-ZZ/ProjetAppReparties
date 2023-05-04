import java.rmi.Naming;

public class ConnexionClient {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java ConnexionClient <name>");
            return;
        }

        String name = args[0];

        try {
            ConnexionInterface c = (ConnexionInterface) Naming.lookup("rmi://localhost/ConnexionService");
            System.out.println("Adding " + name + " to connected clients...");
            System.out.println(c.addConnected(name));

            int connected = c.getConnected();
            System.out.println("Number of connected clients: " + connected);
        } catch (Exception e) {
            System.err.println("Error while connecting to server"+e);
        }
    }
}
