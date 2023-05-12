import java.rmi.Naming;
import javax.swing.*;

public class ConnexionClient {
    public static void main(String[] args) {
        String name = JOptionPane.showInputDialog(null, "Entrez votre nom :");

        try {
            ConnexionInterface c = (ConnexionInterface) Naming.lookup("rmi://localhost/ConnexionService");
            System.out.println("Adding " + name + " to connected clients...");
            System.out.println(c.addConnected(name));

            int connected = c.getConnected();
            System.out.println("Number of connected clients: " + connected);

            // Create instance of ClientInterface and show it
            ClientInterface clientInterface = new ClientInterface(c);
            clientInterface.setVisible(true);

        } catch (Exception e) {
            System.err.println("Error while connecting to server"+e);
        }
    }
}
