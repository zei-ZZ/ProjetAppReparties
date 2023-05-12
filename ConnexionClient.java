import java.rmi.Naming;
import javax.swing.*;

public class ConnexionClient {
    public static void main(String[] args) {

        try {
            ConnexionInterface c = (ConnexionInterface) Naming.lookup("rmi://localhost/ConnexionService");
            // Create instance of ClientInterface and show it
            ClientInterface clientInterface = new ClientInterface(c);
            clientInterface.setVisible(true);

        } catch (Exception e) {
            System.err.println("Error while connecting to server"+e);
        }
    }
}
