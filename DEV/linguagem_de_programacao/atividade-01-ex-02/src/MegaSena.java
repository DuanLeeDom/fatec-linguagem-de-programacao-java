import java.util.Scanner;

public class MegaSena {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Vetor para contar a frequência de cada número (1 a 60)
        int[] frequencia = new int[61]; // Índices de 0 a 60, usaremos de 1 a 60

        // 2. Perguntar quantidade de sorteios
        int numSorteios = 0;
        boolean entradaValida = false;
        while (!entradaValida) {
            System.out.print("Quantos sorteios deseja verificar? ");
            String input = scanner.nextLine();
            try {
                numSorteios = Integer.parseInt(input);
                if (numSorteios > 0) {
                    entradaValida = true;
                } else {
                    System.out.println("Erro: Digite um número maior que zero!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Erro: Digite um número inteiro válido!");
            }
        }

        // 3. Para cada sorteio, pedir 6 números
        for (int sorteio = 1; sorteio <= numSorteios; sorteio++) {
            System.out.println("\nSorteio " + sorteio + ":");
            for (int i = 1; i <= 6; i++) {
                entradaValida = false;
                int numero = 0;
                while (!entradaValida) {
                    System.out.print("Digite o " + i + "º número (1 a 60): ");
                    String input = scanner.nextLine();
                    try {
                        numero = Integer.parseInt(input);
                        if (numero >= 1 && numero <= 60) {
                            frequencia[numero]++; // Incrementa a frequência
                            entradaValida = true;
                        } else {
                            System.out.println("Erro: Digite um número entre 1 e 60!");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Erro: Digite um número inteiro válido!");
                    }
                }
            }
        }

        // 4. Exibir a frequência de cada número (apenas os que foram sorteados)
        System.out.println("\nFrequência dos números sorteados:");
        for (int i = 1; i <= 60; i++) {
            if (frequencia[i] > 0) {
                System.out.printf("Número %d: %d vezes\n", i, frequencia[i]);
            }
        }

        // 5. Encontrar o número mais e menos sorteado
        int minVezes = Integer.MAX_VALUE; // Maior valor possível inicialmente
        int maxVezes = 0;
        int numMin = 0;
        int numMax = 0;

        for (int i = 1; i <= 60; i++) {
            if (frequencia[i] > 0) { // Só considera números que apareceram
                if (frequencia[i] < minVezes) {
                    minVezes = frequencia[i];
                    numMin = i;
                }
                if (frequencia[i] > maxVezes) {
                    maxVezes = frequencia[i];
                    numMax = i;
                }
            }
        }

        // Se nenhum número foi sorteado (improvável, mas possível), ajustamos
        if (maxVezes == 0) {
            System.out.println("Nenhum sorteio válido registrado.");
        } else {
            System.out.println("\nNúmero mais sorteado: " + numMax + " (" + maxVezes + " vezes)");
            System.out.println("Número menos sorteado: " + numMin + " (" + minVezes + " vezes)");
        }

        scanner.close();
    }
}