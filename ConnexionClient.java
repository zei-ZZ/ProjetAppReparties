import java.rmi.Naming;

public class ConnexionClient {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java ConnexionClient <name>");
            return;
        }

        String name = args[0];
/* if you want to use the GUI 
 * try {
    ConnexionInterface c = (ConnexionInterface) Naming.lookup("rmi://localhost/ConnexionService");
    String message = "Adding " + name + " to connected clients...\n";
    message += c.addConnected(name) + "\n";
    int connected = c.getConnected();
    message += "Number of connected clients: " + connected;
    JOptionPane.showMessageDialog(null, message);
} catch (Exception e) {
    JOptionPane.showMessageDialog(null, "Error while connecting to server: " + e.getMessage());
}

 */


        
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
