package exercicio.servidor1;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        int port = 1500;
        Socket soc=null;
        ServerSocket servidor = new ServerSocket(1500);
        System.out.println("Servidor na porta" + port);
        System.out.println("Servidor Iniciado");
        while (true){
        
            System.out.println("Aguardando conexao");
            soc = servidor.accept(); /*Metodo escutar*/
            System.out.println("Servidor recebeu a conexao");
            ObjectOutputStream saida = new ObjectOutputStream(soc.getOutputStream());
            ObjectInputStream entrada = new ObjectInputStream(soc.getInputStream());
            saida.writeObject("Servidor na maquina" + Inet4Address.getLocalHost());
            saida.flush();
            System.out.println("Cliente>>" +entrada.readObject().toString());
            soc.close();
        }
    }
    
}
