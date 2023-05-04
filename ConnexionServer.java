import java.rmi.Naming;
//import java.rmi.RMISecurityManager;
public class ConnexionServer  {
    public static void main (String [ ] argv) {
        try {
            //System.setSecurityManager(new RMISecurityManager());
         Connexion m = new Connexion();
         Naming.rebind ("rmi://localhost/ConnexionService", m) ;  
         System.out.println ("Serveur pret.") ;
        } catch (Exception e) {
            System.out.println ("Erreur serveur : " + e) ;
            e.printStackTrace();
        }
        }
}