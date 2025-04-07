import java.util.Scanner;

public class App {

    static String[] nomes = new String[3];
    static Scanner scanner = new Scanner(System.in); // Instância única do Scanner

    public static void main(String[] args) {
        iniciar();
        int opcao;
        do {
            opcao = menu();
            switch (opcao) {
                case 1:
                    int posicaoEdicao = escolherPosicao();
                    try {
                        nomes[posicaoEdicao] = editar(posicaoEdicao);
                    } catch (Exception e) {
                        System.out.println("Erro ao editar: " + e.getMessage());
                    }
                    break;
                case 2:
                    int posicaoMostra = escolherPosicao();
                    mostrarPosicao(posicaoMostra);
                    break;
                case 3:
                    try {
                        mostrar();
                    } catch (Exception e) {
                        System.out.println("Erro ao mostrar todas as posições: " + e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 4); // A condição de saída do laço é quando a opção for 4
        mostrar(); // Mostra os valores finais após a opção de saída
    }

    static void iniciar(){
        nomes[0] = "";
        nomes[1] = "";
        nomes[2] = "";
    }

    static void mostrar(){
        System.out.println("Conteúdos das posições:");
        System.out.println("Posição 0: " + nomes[0]);
        System.out.println("Posição 1: " + nomes[1]);
        System.out.println("Posição 2: " + nomes[2]);
    }

    static void mostrarPosicao(int posicao){
        if (posicao >= 0 && posicao < nomes.length) {
            System.out.println("Conteúdo na posição " + posicao + ": " + nomes[posicao]);
        } else {
            System.out.println("Posição inválida!");
        }
    }

    static String editar(int posicao) throws Exception {
        if (posicao < 0 || posicao >= nomes.length) {
            throw new Exception("A posição " + posicao + " não existe");
        }
        System.out.println("Qual o novo conteúdo para a posição " + posicao + "?");
        String novo = scanner.nextLine();
        return novo;
    }

    static int menu(){
        int opcao = -1;
        boolean entradaValida = false;
        while (!entradaValida) {
            try {
                System.out.println("\nEscolha uma opção:");
                System.out.println("1 - Editar posição");
                System.out.println("2 - Mostrar posição");
                System.out.println("3 - Mostrar todas as posições");
                System.out.println("4 - Sair");
                opcao = scanner.nextInt();
                scanner.nextLine(); // Consumir a linha vazia que sobra após nextInt()
                entradaValida = true;
            } catch (Exception e) {
                System.out.println("Entrada inválida! Digite um número.");
                scanner.nextLine();
            }
        }
        return opcao;
    }

    static int escolherPosicao() {
        int posicao = -1;
        boolean entradaValida = false;
        while (!entradaValida) {
            try {
                System.out.println("Escolha uma posição (0, 1 ou 2):");
                posicao = scanner.nextInt();
                scanner.nextLine(); // Consumir a linha vazia
                if (posicao >= 0 && posicao <= 2) {
                    entradaValida = true;
                } else {
                    System.out.println("Posição inválida! Tente novamente.");
                }
            } catch (Exception e) {
                System.out.println("Entrada inválida! Digite um número.");
                scanner.nextLine(); // Limpa o buffer
            }
        }
        return posicao;
    }
}
