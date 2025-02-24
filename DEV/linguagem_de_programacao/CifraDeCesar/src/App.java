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
        // faz um laço de repeticao de 0 até um valor antes do tamanho
        // do texto
        for (int posicao = 0; posicao < tamanho; posicao++ ){
            // pega uma letra da frase e quanda na variavel de tipo char
            char letra = frase.charAt(posicao);
            // usa uma conversao de char para inteiro (implicita) e quarda
            // o novo valor na variável inteira x
            int x = letra + chave;
            // novaFrase = novaFrase + (char)x;
            // acrescenta na variavel string novaFrase a representação
            // de um número com um caracter, usando a posicao deste valor
            // na Tabela ASCII para determinar o caracter.
            novaFrase += (char) x;
        }
        // imprime a frase cifrada.
        System.out.println(novaFrase);
// coloque aqui o processo inverso de cifragem, 
// para conseguir a frase origional


        System.exit(0);
    }
}
