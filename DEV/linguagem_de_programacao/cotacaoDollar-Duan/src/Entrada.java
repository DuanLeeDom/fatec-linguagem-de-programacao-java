import java.util.Scanner;

public class Entrada {
    private static Scanner teclado = new Scanner(System.in);

    public String texto(String msg) {
        System.out.print(msg);
        return teclado.nextLine();
    }
}
