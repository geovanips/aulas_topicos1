
import static java.lang.Thread.sleep;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class RMICliente {

    public static void main(String[] args) throws RemoteException{
        Registry regcliente = LocateRegistry.getRegistry("localhost", 1060);
        double fat=7;
        try{
            RMIInterfaces rmicliente = (RMIInterfaces) regcliente.lookup("rmiServer");
            System.out.println("Fatorial " +fat+":"+rmicliente.fatorial(fat));
        } catch(NotBoundException | RemoteException e){
            System.out.println(e);
        }
        // TODO code application logic here
    }
    
}
