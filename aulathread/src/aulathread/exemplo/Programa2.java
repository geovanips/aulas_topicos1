package aulathread.exemplo;

public class Programa2 implements Runnable{
    public void run(){
        for (int i = 0; i < 10000; i++){
            System.out.println("Programa " + Thread.currentThread().getId()
            + "valor: " + i);
        }
    }
    
}
