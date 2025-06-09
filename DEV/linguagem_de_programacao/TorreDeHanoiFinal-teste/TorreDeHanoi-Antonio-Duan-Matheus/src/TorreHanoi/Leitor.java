package TorreHanoi;

import java.util.Scanner;

public class Leitor {
    private static final Scanner scanner = new Scanner(System.in);

    // Método para ler a torre de origem ou destino, com a opção de reiniciar
    public static String lerTorre(String mensagem, String[] teclas) {
        while (true) {
            System.out.print(mensagem);
            String input = scanner.nextLine().trim().toUpperCase();

            if (input.equals("R")) {
                return "REINICIAR";
            } else if (input.equals(teclas[0]) || input.equals(teclas[1]) || input.equals(teclas[2])) {
                return input;
            } else {
                System.out.println("Entrada inválida. Por favor, insira uma das teclas válidas: " + teclas[0] + ", " + teclas[1] + ", " + teclas[2] + ", ou 'R' para reiniciar.");
            }
        }
    }

    // Lógica para definir teclas diferentes para as torres
    public static String[] definirTeclas() {
        String[] teclas = new String[3];

        while (true) {
            System.out.println("Escolha teclas diferentes para as torres (ex: A, S, D):");

            System.out.print("Tecla para Torre A: ");
            teclas[0] = scanner.nextLine().trim().toUpperCase();

            System.out.print("Tecla para Torre B: ");
            teclas[1] = scanner.nextLine().trim().toUpperCase();

            System.out.print("Tecla para Torre C: ");
            teclas[2] = scanner.nextLine().trim().toUpperCase();

            if (!teclas[0].equals(teclas[1]) &&
                !teclas[0].equals(teclas[2]) &&
                !teclas[1].equals(teclas[2])) {
                break;
            } else {
                System.out.println("As teclas devem ser diferentes entre si. Tente novamente.\n");
            }
        }

        return teclas;
    }

    // Método para fechar o scanner
    public static void fecharScanner() {
        scanner.close();
    }

    // Método para obter o scanner
    public static Scanner getScanner() {
        return scanner;
    }
}
