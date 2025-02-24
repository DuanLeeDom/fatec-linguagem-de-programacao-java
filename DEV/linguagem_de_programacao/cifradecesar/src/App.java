public class App {
    public static void main(String[] args) throws Exception {
        // Define a string inicial que será processada
        String frase = "Hoje é segunda feira";
        
        // Define a "chave" de deslocamento, que será somada a cada caractere
        int chave = 3;
        
        // Armazena o tamanho da string (número de caracteres, incluindo espaços)
        int tamanho = frase.length();
        
        // Laço que percorre cada posição da string, de 0 até tamanho-1
        for (int posicao = 0; posicao < tamanho; posicao++) {
            // Pega o caractere na posição atual da string
            char letra = frase.charAt(posicao);
            
            // Soma o valor numérico do caractere (ASCII/Unicode) com a chave
            int x = letra + chave;
            
            // Imprime: (1) o novo caractere após o deslocamento e (2) seu valor numérico
            System.out.println((char) x + " + " + x);
        }
        
        // Encerra o programa com código 0 (sucesso), opcional neste caso
        System.exit(0);
    }
}