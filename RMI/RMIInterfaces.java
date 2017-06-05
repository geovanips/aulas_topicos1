import java.rmi.*;
public interface RMIInterfaces extends Remote {
    public String getMensagem()
            throws RemoteException;
    public void setMensagem(String msg)
            throws RemoteException;
    public double fatorial(double num)
            throws RemoteException;
    public double SomarValor(double A, double B)
            throws RemoteException;
}
