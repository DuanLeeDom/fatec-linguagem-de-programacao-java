import java.util.Scanner;
import java.util.Random;

public class App {

    static char[][] forca = new char[7][10];
    static String[] palavras = {
        "BANANA", "MAÇA", "PERA", "MANGA", "UVA",
        "ABACAXI", "MELANCIA", "MELAO", "KIWI", "GOIABA",
        "CARAMBOLA", "ACEROLA", "LARANJA", "LIMAO", "JABUTICABA",
        "CAJU", "GRAVIOLA", "FRAMBOESA", "AMORA", "PITAYA"
    };
    static String palavraSorteada;
    static char[] palavraEscondida;
	
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        palavraSorteada = palavras[random.nextInt(palavras.length)];
        palavraEscondida = new char[palavraSorteada.length()];
        for (int i = 0; i < palavraEscondida.length; i++) {
            palavraEscondida[i] = '_';
        }

        int erros = 0;
        final int maxErros = 6;

        inicio(); // Mostra a forca inicial

        while (erros < maxErros && new String(palavraEscondida).contains("_")) {
            System.out.println("\nPalavra: " + new String(palavraEscondida));	
            System.out.print("Digite uma letra: ");
            char letra = scanner.next().toUpperCase().charAt(0);

            boolean acertou = false;
            for (int i = 0; i < palavraSorteada.length(); i++) {
                if (palavraSorteada.charAt(i) == letra) {
                    palavraEscondida[i] = letra;
                    acertou = true;
                }
            }

            if (!acertou) {
                erros++;
                desenharForca(erros);
            }

            mostrarForca();
        }

        if (new String(palavraEscondida).equals(palavraSorteada)) {
            System.out.println("\nParabéns! Você acertou a palavra: " + palavraSorteada);
        } else {
            System.out.println("\nVocê perdeu. A palavra era: " + palavraSorteada);
        }

        scanner.close();
    }

    // Procedimento que inicializa a matriz com a estrutura da forca
    public static void inicio() {
        // Preencher matriz com espaços
        for (int i = 0; i < forca.length; i++) {
            for (int j = 0; j < forca[i].length; j++) {
                forca[i][j] = ' ';
            }
        }

        // Estrutura da forca
        forca[0][1] = '-';
        forca[0][2] = '-';
        forca[0][3] = '-';
        forca[0][4] = '-';
        forca[0][5] = '-';

        forca[1][1] = '|';

        for (int i = 1; i < 6; i++) {
            forca[i][0] = '|';
        }

        forca[6][0] = '_';
        forca[6][1] = '_';
        forca[6][2] = '_';

        mostrarForca();
    }

    // Exibe a matriz da forca
    public static void mostrarForca() {
        System.out.println();
        for (int i = 0; i < forca.length; i++) {
            for (int j = 0; j < forca[i].length; j++) {
                System.out.print(forca[i][j]);
            }
            System.out.println();
        }
    }

    // Desenha o boneco de acordo com o número de erros
    public static void desenharForca(int erros) {
        switch (erros) {
            case 1:
                forca[2][4] = 'O'; // cabeça
                break;
            case 2:
                forca[3][4] = '|'; // tronco
                break;
            case 3:
                forca[3][3] = '/'; // braço esquerdo
                break;
            case 4:
                forca[3][5] = '\\'; // braço direito
                break;
            case 5:
                forca[4][3] = '/'; // perna esquerda
                break;
            case 6:
                forca[4][5] = '\\'; // perna direita
                break;
        }
    }
}