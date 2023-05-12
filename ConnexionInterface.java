import java.rmi.Remote;

/**
 * ConnexionInterface
 */
public interface ConnexionInterface extends Remote {

    int getConnected () throws java.rmi.RemoteException;
    String addConnected(String name) throws java.rmi.RemoteException;
    String removeConnected(String name) throws java.rmi.RemoteException;

}