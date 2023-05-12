import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ClientInterface extends JFrame implements ActionListener {
    private ConnexionInterface connexion;
    private JTextField nameField;
    private JButton addButton;
    private JButton disconnectButton;
    private boolean isConnected;

    public ClientInterface(ConnexionInterface c) {
        this.connexion =  c;
        setTitle("Ajouter un client");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        nameField = new JTextField(20);
        addButton = new JButton("Ajouter");
        addButton.addActionListener(this);
        disconnectButton = new JButton("Disconnect");
        disconnectButton.addActionListener(this);
        setLayout(new GridLayout(3, 2));
        add(new JLabel("Nom :"));
        add(nameField);
        add(addButton);
        isConnected = false;
    }

    
    public void actionPerformed(ActionEvent e) {
        String clients = "";
        String name = nameField.getText();

        try {
            if (e.getSource() == addButton) {
                // Add the client
                clients = connexion.addConnected(name);
                isConnected = true;
                addButton.setEnabled(false);
                add(disconnectButton);
            } else if (e.getSource() == disconnectButton) {
                // Remove the client
                connexion.removeConnected(name);
                isConnected = false;
                addButton.setEnabled(true);
                remove(disconnectButton);
            }

            int nbre = connexion.getConnected(); 
            this.nameField.setText("");
            JOptionPane.showMessageDialog(this, "Liste des clients : " + clients +"\n nbre de clients: "+nbre);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erreur : " + ex.getMessage());
        }
    }
}
