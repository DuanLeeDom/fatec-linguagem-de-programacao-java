import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        // define uma variavel string com um valor
        String frase = "Hoje e segunda-feira";
        // define uma variavel string vazia
        String novaFrase ="";
        // define uma variavel inteira com valor 3
        int chave = 3;
        // define uma variável inteira com o valor que
        // representa o tamanho do texto contido na variavel frase
        int tamanho = frase.length();
        // faz um laço de repeticao de 0 até um valor antes do tamanho do texto
        
        // =======================================================
        // Cria um Scanner para pegar o que o usuário digita
        Scanner teclado = new Scanner(System.in);

        // Pede a frase ao usuário
        System.out.print("Digite a frase que será cifrada: ");
        // Guarda a frase digitada na variável 'frase'
        frase = teclado.nextLine();

        // Pede a chave ao usuário
        System.out.print("Digite a chave de cifragem: ");
        // Guarda a chave digitada na variável 'chave'
        chave = teclado.nextInt();

        // Conta quantos caracteres a frase tem e guarda em 'tamanho'
        tamanho = frase.length();

        for (int posicao = 0; posicao < tamanho; posicao++ ){
            // pega uma letra da frase e quanda na variavel de tipo char
            char letra = frase.charAt(posicao);
            // usa uma conversao de char para inteiro (implicita) e quarda
            // o novo valor na variável inteira x
            int x = letra + chave; // somando a chave
            // novaFrase = novaFrase + (char)x;
            // acrescenta na variavel string novaFrase a representação
            // de um número com um caracter, usando a posicao deste valor
            // na Tabela ASCII para determinar o caracter.
            novaFrase += (char) x;
        }
        // imprime a frase cifrada.
        System.out.println("Frase cifrada: " + novaFrase);

        // =======================================================
        // Processo de Decifragem: Reverte a Cifragem Aplicada
        // Converte a frase cifrada de volta à original subtraindo 
        // a chave de cada caractere.
        // =======================================================

        // para conseguir a frase origional
        String fraseOriginal = "";
        int tamanhoCifrado = novaFrase.length();
        for (int posicao = 0; posicao < tamanhoCifrado; posicao++) {
            // Pega cada caractere de frase cifrada
            char letraCifrada = novaFrase.charAt(posicao);
            // Decifra o caracterer
            int y = letraCifrada - chave; // subtraindo a chave
            // Adicionar o caracter decifrado na frase original
            fraseOriginal += (char) y;
        }
        // Imprime a frase original
        System.out.println("Frase original: " + fraseOriginal);

        // Teste 1: Comparação de referências com '=='
        System.out.println("\n--- Teste 1: Comparação com '==' ---");
        System.out.println("Verifica se as variáveis apontam para o mesmo objeto na memória:");
        if (frase == fraseOriginal) {
            System.out.println("Resultado: As referências são iguais (mesmo objeto).");
        } else {
            System.out.println("Resultado: As referências são diferentes (objetos distintos).");
        }

        // Teste 2: Comparação de conteúdo com 'equals'
        System.out.println("\n--- Teste 2: Comparação com 'equals' ---");
        System.out.println("Compara o conteúdo real das strings:");
        if (frase.equals(fraseOriginal)) {
            System.out.println("Resultado: O conteúdo das strings é idêntico.");
        } else {
            System.out.println("Resultado: O conteúdo das strings é diferente.");
        }

        // Encerra o programa
        System.exit(0);
    }
}
