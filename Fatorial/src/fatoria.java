
import javax.swing.JOptionPane;

public class fatoria {

    private static double fatorialREC(double num) {
        if (num == 0 || num == 1) {
            return 1;
        } else {
            return num * fatorialREC(num - 1);
        }
    }

    public static void main(String[] args) {
        String num;
        Double fat;
        num = JOptionPane.showInputDialog(null, "Digite um número:", "Cálculo de Fatorial", 1);
        fat = fatorialREC(Double.parseDouble(num));
        JOptionPane.showMessageDialog(null, "O fatorial é: ", +fat);
    }

}
