package TorreHanoi;

public class TorreDeHanoi {
    static int[] torreA;
    static int[] torreB;
    static int[] torreC;
    static int topoA;
    static int topoB;
    static int topoC;
    static final int discos = 7;
    static int movimentos = 0;
    static String ident_A = "";
    static String ident_B = "";
    static String ident_C = "";

    public static void main(String[] args) {
        try {
            String[] teclas = Leitor.definirTeclas();
            ident_A = teclas[0];
            ident_B = teclas[1];
            ident_C = teclas[2];

            iniciar();
            apresentar();

            while (true) {
                // Pergunta de origem
                String origem = Leitor.lerTorre("Qual a torre de origem? (" + ident_A + ", " + ident_B + ", " + ident_C + ") ou 'R' para reiniciar: ", teclas);
                if (origem.equals("REINICIAR")) {
                    System.out.println("Reiniciando o jogo...");
                    iniciar();
                    movimentos = 0;
                    apresentar();
                    continue;
                }

                // Pergunta de destino
                String destino = Leitor.lerTorre("Qual a torre de destino? (" + ident_A + ", " + ident_B + ", " + ident_C + ") ou 'R' para reiniciar: ", teclas);
                if (destino.equals("REINICIAR")) {
                    System.out.println("Reiniciando o jogo...");
                    iniciar();
                    movimentos = 0;
                    apresentar();
                    continue;
                }

                mover(origem, destino);
                apresentar();

                if (topoC == discos) {
                    System.out.println("Parabéns! Você completou as Torres de Hanói.");
                    System.out.println("Total de movimentos: " + movimentos);
                    System.out.print("Deseja jogar novamente? (S/N): ");

                    String resposta = Leitor.getScanner().nextLine().trim().toUpperCase();
                    if (resposta.equals("S")) {
                        iniciar();
                        movimentos = 0;
                        apresentar();
                    } else {
                        System.out.println("Obrigado por jogar!");
                        break;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro inesperado. O jogo será encerrado.");
        } finally {
            Leitor.fecharScanner();
        }
    }

    private static void iniciar() {
        torreA = new int[discos];
        torreB = new int[discos];
        torreC = new int[discos];
        topoA = discos;
        topoB = 0;
        topoC = 0;
        for (int i = 0; i < discos; i++) {
            torreA[i] = discos - i;
        }
    }

    private static void mover(String origem, String destino) {
        int[] torreOrigem = obterTorrePorNome(origem);
        int[] torreDestino = obterTorrePorNome(destino);
        int topoOrigem = obterTopo(origem);
        int topoDestino = obterTopo(destino);

        if (topoOrigem == 0) {
            System.out.println("Movimento inválido: torre de origem vazia.");
            return;
        }

        int discoMovido = torreOrigem[topoOrigem - 1];

        if (topoDestino == 0 || discoMovido < torreDestino[topoDestino - 1]) {
            torreDestino[topoDestino] = discoMovido;
            definirTopo(destino, topoDestino + 1);
            definirTopo(origem, topoOrigem - 1);

            movimentos++;
            System.out.println("Movimento realizado com sucesso. Total de movimentos: " + movimentos);
        } else {
            System.out.println("Movimento inválido: não é permitido colocar um disco maior sobre um menor.");
        }
    }

    private static int[] obterTorrePorNome(String nome) {
        if (nome.equalsIgnoreCase(ident_A)) {
            return torreA;
        } else if (nome.equalsIgnoreCase(ident_B)) {
            return torreB;
        } else if (nome.equalsIgnoreCase(ident_C)) {
            return torreC;
        } else {
            throw new IllegalArgumentException("Nome de torre inválido.");
        }
    }

    private static int obterTopo(String nome) {
        if (nome.equalsIgnoreCase(ident_A)) {
            return topoA;
        } else if (nome.equalsIgnoreCase(ident_B)) {
            return topoB;
        } else if (nome.equalsIgnoreCase(ident_C)) {
            return topoC;
        } else {
            throw new IllegalArgumentException("Nome de torre inválido.");
        }
    }

    private static void definirTopo(String nome, int novoTopo) {
        if (nome.equalsIgnoreCase(ident_A)) {
            topoA = novoTopo;
        } else if (nome.equalsIgnoreCase(ident_B)) {
            topoB = novoTopo;
        } else if (nome.equalsIgnoreCase(ident_C)) {
            topoC = novoTopo;
        } else {
            throw new IllegalArgumentException("Nome de torre inválido.");
        }
    }

    private static void apresentar() {
        System.out.println();

        for (int i = discos - 1; i >= 0; i--) {
            String colunaA = i < topoA ? String.format("%2d", torreA[i]) : "  ";
            String colunaB = i < topoB ? String.format("%2d", torreB[i]) : "  ";
            String colunaC = i < topoC ? String.format("%2d", torreC[i]) : "  ";
            System.out.printf("|%s |%s |%s |\n", colunaA, colunaB, colunaC);
        }

        System.out.printf("| %s | %s | %s |", ident_A, ident_B, ident_C);
        System.out.println();
    }
}