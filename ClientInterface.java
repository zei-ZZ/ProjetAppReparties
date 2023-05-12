import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ClientInterface extends JFrame implements ActionListener {
    private ConnexionInterface connexion;
    private JTextField nameField;
    private JButton addButton;

    public ClientInterface(ConnexionInterface c) {
        this.connexion =  c;
        setTitle("Ajouter un client");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        nameField = new JTextField(20);
        addButton = new JButton("Ajouter");
        addButton.addActionListener(this);
        setLayout(new GridLayout(3, 2));
        add(new JLabel("Nom :"));
        add(nameField);
        add(addButton);
    }

    
        public void actionPerformed(ActionEvent e) {
            String clients = ""; // Declare clients variable outside of try block
            
            if (e.getSource() == addButton) {
                // Récupérer les valeurs des champs de texte
                String name = nameField.getText();
                int nbre;
                try {
                    clients = connexion.addConnected(name);
                    nbre=connexion.getConnected(); 
                    this.nameField.setText("");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Erreur lors de l'ajout du client.");
                    return;
                }
                
                JOptionPane.showMessageDialog(this, "Client ajoute.");
                JOptionPane.showMessageDialog(this, "Liste des clients : " + clients +"\n nbre de clients: "+nbre);
            }
        }
        
    }

