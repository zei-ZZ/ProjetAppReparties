import java.rmi.RemoteException;
import java.util.ArrayList;

public class Connexion extends java.rmi.server.UnicastRemoteObject implements ConnexionInterface {
    int cpt ;
    ArrayList<String> Nom ;

    public Connexion() throws RemoteException{
        cpt=0;
        Nom = new ArrayList<String>();
    }

    @Override
    public int getConnected() throws RemoteException {
        return Nom.size();
    }

    @Override
    public String addConnected(String name) throws RemoteException {
        cpt++;
        Nom.add(name);
        System.out.println("client added successfully!!!!!!!");
        return "Success";
    }

    @Override
    public String removeConnected(String name) throws RemoteException {
        if (Nom.contains(name)) {
            Nom.remove(name);
            System.out.println("client removed successfully!!!!!!!");
            return "Success";
        } else {
            System.out.println("client not found!!!!!!!");
            return "Error";
        }
    }
}
