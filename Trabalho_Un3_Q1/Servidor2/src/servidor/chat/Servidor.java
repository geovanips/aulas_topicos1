/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
  package servidor.chat;
  import java.io.BufferedReader;
  import java.io.BufferedWriter;
  import java.io.IOException;
  import java.io.InputStreamReader;
  import java.io.OutputStream;
  import java.io.OutputStreamWriter;
  import java.io.Writer;
  import java.net.ServerSocket;
  import java.net.Socket;
  import java.util.ArrayList;
/**
 *
 * @author geovani
 */
public class Servidor extends Thread{
  private static ArrayList<BufferedWriter>clientes;           
  private static ServerSocket server; 
  private String nome;
  private Socket soc; 
  private InputStreamReader entrada;  
  private BufferedReader bfr; 
  //Construtor
  public Servidor(Socket soc){
   this.soc = soc;
   try {
         entrada = new InputStreamReader(soc.getInputStream());
          bfr = new BufferedReader(entrada);
   } catch (IOException e) {
          e.printStackTrace();
   }                          
}
  public void Recebe(){
        try{
          String mensagem;
          Writer ouw = new OutputStreamWriter(this.soc.getOutputStream());
          BufferedWriter bfw = new BufferedWriter(ouw);
          //Adiciona o cliente ao buffer de Escrita
          clientes.add(bfw);
          nome = mensagem = bfr.readLine();

          while (!"Sair".equalsIgnoreCase(mensagem) && mensagem != null) {
              mensagem = bfr.readLine();
              Envia(bfw, mensagem);
              System.out.println(mensagem);
          }

      } catch (Exception e) {
          e.printStackTrace();

      }
  }

  Servidor() {}
  @Override
  public void run(){
      Recebe();
} 
  //envia a mensagem recebida a todos os clientes conectados
public void Envia(BufferedWriter bwSaida, String mensagem) throws  IOException 
{
  BufferedWriter bwS;
   
  for(BufferedWriter bw : clientes){
   bwS = (BufferedWriter)bw;
   if(!(bwSaida == bwS)){
     bw.write(nome + " -> " + mensagem+"\r\n");
     bw.flush(); 
   }
  }          
}
//Faz a conexão com o servidor na Porta passada dentro da função
public void Inicia(String Porta){
         try {
            server = new ServerSocket(Integer.parseInt(Porta));
            //Ao receber o cliente cria um na lista
            clientes = new ArrayList<BufferedWriter>();
            while (true) {
                System.out.println("Aguardando conexão...");
                Socket soc = server.accept();
                System.out.println("Cliente conectado...");
                Thread t = new Servidor(soc);
                t.start();
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

}

