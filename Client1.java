
package exercio01.aula15052017;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Inet4Address;
import java.net.Socket;

public class Client1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        int port = 1500;
        String host = "10.163.28.2";
        Socket soc = new Socket(host, port);
        /*Recebimento da mensagem para servidor*/
        InputStream in = soc.getInputStream();
        ObjectInputStream entrada = new ObjectInputStream(in);
        /*Envio de mensagem para servidor*/
        OutputStream out = soc.getOutputStream();
        ObjectOutputStream saida = new ObjectOutputStream(out);
        
        System.out.println("Servidor>>"+entrada.readObject().toString());
        saida.writeObject("Sou cliente " +"(Geovani)"
                +Inet4Address.getLocalHost());
        saida.flush();
        entrada.close();/*Encerra conexao.*/
    }
    
}
