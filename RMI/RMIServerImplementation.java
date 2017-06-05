import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RMIServerImplementation 
        extends UnicastRemoteObject implements RMIInterfaces{
    public RMIServerImplementation () throws RemoteException {
        
    }

    @Override
    public String getMensagem() throws RemoteException {
        return null;
    }

    @Override
    public void setMensagem(String msg) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

    @Override
    public double fatorial(double num) throws RemoteException {
        if(num==0 || num==1){
            return 1;
        } else{
            return num*(fatorial(num-1));
        }
    }

    @Override
    public double SomarValor(double A, double B) throws RemoteException {
      return A+B;
    }
}
