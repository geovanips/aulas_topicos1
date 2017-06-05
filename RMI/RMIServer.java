import java.net.MalformedURLException;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
public class RMIServer {

    public static void main(String[] args) throws RemoteException,
            MalformedURLException{
        try{
            Registry reg = LocateRegistry.createRegistry(1060);
            reg.rebind("rmiServer", new RMIServerImplementation());
            System.out.println("Servidor iniciado...");
            System.out.println("");
        } catch (RemoteException e){
            System.out.println("erro!"+e);
        }
        // TODO code application logic here
    }
    
}
