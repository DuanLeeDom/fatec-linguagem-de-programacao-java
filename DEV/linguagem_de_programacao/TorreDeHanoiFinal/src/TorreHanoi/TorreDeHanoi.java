package TorreHanoi;

import java.util.Scanner;

public class TorreDeHanoi {
    static int[] torreA;
    static int[] torreB;
    static int[] torreC;
    static int discos = 7;

    public static void main(String[] args) {
        try {
            iniciar();
            apresentar();

            do {
                String origem = obterTorre("Qual a torre de origem? (A, B, C)");
                String destino = obterTorre("Qual a torre de destino? (A, B, C)");
                mover(origem, destino);

                apresentar();

                if (torreC.length == discos) {
                    System.out.println("Parabéns! Você completou as Torres de Hanoi.");
                    break;
                }
            } while (true);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            System.exit(1);
        }
        System.exit(0);
    }

    private static void iniciar() {
        torreA = new int[discos];
        for (int i = 0; i < discos; i++) {
            torreA[i] = discos - i;
        }
        torreB = new int[0];
        torreC = new int[0];
    }

    private static String obterTorre(String mensagem) {
        System.out.println(mensagem);
        String input = new Scanner(System.in).nextLine().toUpperCase();

        if(input.equals("A") || input.equals("B") || input.equals("C")) {
            return input;
        } else {
            System.out.println("Nome da torre invalido: " + input);
            System.exit(1);
            return null;
        }
    }

    private static void mover(String origem, String destino) {
        int[] torreOrigem = obterTorrePorNome(origem);
        int[] torreDestino = obterTorrePorNome(destino);

        if (torreOrigem.length == 0) {
            System.out.println("Movimento inválido: torre de origem vazia.");
            return;
        }

        if (torreDestino.length == 0 || torreOrigem[torreOrigem.length - 1] < torreDestino[torreDestino.length - 1]) {
            int discoMovido = torreOrigem[torreOrigem.length - 1];
            torreDestino = adicionarElemento(torreDestino, discoMovido);
            torreOrigem = removerElemento(torreOrigem);
        } else {
            System.out.println("Movimento inválido: o disco está em ordem errada.");
        }

        atualizarTorre(origem, torreOrigem);
        atualizarTorre(destino, torreDestino);

    }


    private static int[] obterTorrePorNome(String nome){
         switch (nome) {
         case "A":
              return torreA;
         case "B":
               return torreB;
         case "C":
               return torreC;
         default:
               System.out.println("Nome da torre invalido: " + nome);
               System.exit(1);
               return null;
         }
    }

    private static void atualizarTorre(String nome, int[] torreAtualizada) {
        switch (nome) {
            case "A":
                torreA = torreAtualizada;
                break;
            case "B":
                torreB = torreAtualizada;
                break;
            case "C":
                torreC = torreAtualizada;
                break;
        }
    }

    public static int[] adicionarElemento (int[] array, int elemento) {
        int[] newArray = new int[array.length + 1];
        System.arraycopy(array, 0, newArray, 0, array.length);
        newArray[array.length] = elemento;
        return newArray;
    }

    private static int[] removerElemento(int[] array) {
        int[] newArray = new int[array.length - 1];
        System.arraycopy(array, 0, newArray, 0, array.length - 1);
        return newArray;
    }

    private static void apresentar() {
        System.out.println("Torre A: " + mostrarTorre(torreA));
        System.out.println("Torre B: " + mostrarTorre(torreB));
        System.out.println("Torre C: " + mostrarTorre(torreC));
        System.out.println();
    }

    private static String mostrarTorre(int[] torre) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < torre.length; i++) {
            sb.append(torre[i]).append(" ");
        }
        return sb.toString();
        }
}