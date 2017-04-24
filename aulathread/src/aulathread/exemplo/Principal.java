package aulathread.exemplo;

public class Principal {

    public static void main(String[] args) {
        Programa prog1 = new Programa();
        Programa2 prog2 = new Programa2();
        
        prog1.start();
        new Thread(prog2).start();
    }
    
}
