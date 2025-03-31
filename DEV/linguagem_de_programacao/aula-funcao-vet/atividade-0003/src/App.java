import java.util.Scanner;

public class App {

    static String[] nomes = new String[3];
    static Scanner scanner = new Scanner(System.in); // Instância única do Scanner

    public static void main(String[] args) throws Exception {
        iniciar();
        int opcao;
        do {
            opcao = menu();
            switch (opcao) {
                case 1:
                    int posicaoEdicao = escolherPosicao();
                    nomes[posicaoEdicao] = editar(posicaoEdicao);
                    break;
                case 2:
                    int posicaoMostra = escolherPosicao();
                    mostrarPosicao(posicaoMostra);
                    break;
                case 3:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 3); // A condição de saída do laço é quando a opção for 3
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

    static String editar(int posicao){
        if (posicao < 0 || posicao >= nomes.length) {
            System.out.println("Posição inválida!");
            return null;
        }
        System.out.println("Qual o novo conteúdo para a posição " + posicao + "?");
        String novo = scanner.nextLine();
        return novo;
    }

    static int menu(){
        System.out.println("\nEscolha uma opção:");
        System.out.println("1 - Editar posição");
        System.out.println("2 - Mostrar posição");
        System.out.println("3 - Sair");
        int opcao = scanner.nextInt();
        scanner.nextLine(); // Consumir a linha vazia que sobra após nextInt()
        return opcao;
    }

    // Novo método para escolher a posição
    static int escolherPosicao() {
        int posicao;
        do {
            System.out.println("Escolha uma posição (0, 1 ou 2):");
            posicao = scanner.nextInt();
            scanner.nextLine(); // Consumir a linha vazia
        } while (posicao < 0 || posicao > 2); // Verifica se a posição é válida
        return posicao;
    }
}
