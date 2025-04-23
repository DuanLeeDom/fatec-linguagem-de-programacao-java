import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class torreHanoi {
    private int[][] towers;
    private int[][] moves;
    private int numDisks;
    private int moveCount;
    private int maxMoves;
    private int gameMode; // 1 para Clássico, 2 para Aleatório
    private int targetTower; // Torre de destino (1, 2 ou 3)

    public torreHanoi(int numDisks, int gameMode) {
        this.numDisks = numDisks;
        this.moveCount = 0;
        this.maxMoves = calculateMinMoves();
        this.gameMode = gameMode;
        towers = new int[3][numDisks];
        for (int i = 0; i < numDisks; i++) {
            towers[0][i] = numDisks - i;
        }
        moves = new int[maxMoves][3];
        Random rand = new Random();
        // Escolhe a torre de destino aleatoriamente
        targetTower = rand.nextInt(3) + 1;
        if (gameMode == 1 && targetTower == 1) {
            // No modo Clássico, evita Torre 1 como destino
            targetTower = rand.nextInt(2) + 2; // Escolhe 2 ou 3
        }
        if (gameMode == 2) {
            shuffleDisks();
            // Garante que o estado inicial não seja uma vitória
            while (isGameWon()) {
                shuffleDisks();
            }
        }
    }

    public static int getNumberOfDisks(Scanner scanner) {
        int disks = 0;
        while (true) {
            System.out.print("Digite o número de discos (1 a 10, ou 0 para sair): ");
            try {
                disks = Integer.parseInt(scanner.nextLine());
                if (disks == 0 || (disks >= 1 && disks <= 10)) {
                    return disks;
                } else {
                    System.out.println("Por favor, insira um número entre 1 e 10 (ou 0 para sair).");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite um número inteiro.");
            }
        }
    }

    public static int getGameMode(Scanner scanner) {
        int mode = 0;
        while (true) {
            System.out.println("Escolha o tipo de início:");
            System.out.println("1 - Clássico (torre 1 com os discos organizados)");
            System.out.println("2 - Aleatório (discos espalhados aleatoriamente)");
            System.out.print("Digite sua escolha (1 ou 2): ");
            try {
                mode = Integer.parseInt(scanner.nextLine());
                if (mode == 1 || mode == 2) {
                    return mode;
                } else {
                    System.out.println("Por favor, insira 1 ou 2.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite um número inteiro.");
            }
        }
    }

    public int calculateMinMoves() {
        return (int) Math.pow(2, numDisks) - 1;
    }

    public int getTopDisk(int towerIndex) {
        for (int i = numDisks - 1; i >= 0; i--) {
            if (towers[towerIndex][i] != 0) {
                return towers[towerIndex][i];
            }
        }
        return 0;
    }

    public boolean isValidMove(int disk, int sourceTower, int destTower) {
        if (sourceTower < 1 || sourceTower > 3 || destTower < 1 || destTower > 3) {
            return false;
        }
        int topSource = getTopDisk(sourceTower - 1);
        int topDest = getTopDisk(destTower - 1);
        boolean hasSpace = false;
        for (int i = 0; i < numDisks; i++) {
            if (towers[destTower - 1][i] == 0) {
                hasSpace = true;
                break;
            }
        }
        return topSource == disk && hasSpace && (topDest == 0 || disk < topDest);
    }

    public void moveDisk(int disk, int sourceTower, int destTower) {
        int sourceIndex = -1, destIndex = -1;
        for (int i = numDisks - 1; i >= 0; i--) {
            if (towers[sourceTower - 1][i] == disk) {
                sourceIndex = i;
                break;
            }
        }
        for (int i = 0; i < numDisks; i++) {
            if (towers[destTower - 1][i] == 0) {
                destIndex = i;
                break;
            }
        }
        if (destIndex == -1) {
            System.out.println("Erro: Torre de destino cheia!");
            return;
        }
        towers[sourceTower - 1][sourceIndex] = 0;
        towers[destTower - 1][destIndex] = disk;
        moveCount++;
        if (moveCount <= maxMoves) {
            moves[moveCount - 1][0] = disk;
            moves[moveCount - 1][1] = sourceTower;
            moves[moveCount - 1][2] = destTower;
        }
        System.out.println("Movimento " + moveCount + ": Disco " + disk + " de Torre " + sourceTower + " para Torre " + destTower);
        printTowers();
    }

    public void printTowers() {
        System.out.println("\nEstado das Torres:");
        int maxWidth = 2 * numDisks - 1;
        for (int i = numDisks - 1; i >= 0; i--) {
            for (int t = 0; t < 3; t++) {
                int disk = towers[t][i];
                if (disk == 0) {
                    System.out.print("|");
                    for (int j = 0; j < maxWidth; j++) System.out.print(" ");
                    System.out.print("| ");
                } else {
                    int width = 2 * disk - 1;
                    int padding = (maxWidth - width) / 2;
                    System.out.print("|");
                    for (int j = 0; j < padding; j++) System.out.print(" ");
                    for (int j = 0; j < width; j++) System.out.print(disk);
                    for (int j = 0; j < padding; j++) System.out.print(" ");
                    System.out.print("| ");
                }
            }
            System.out.println();
        }
        for (int t = 0; t < 3; t++) {
            System.out.print("|");
            for (int j = 0; j < maxWidth; j++) System.out.print("-");
            System.out.print("| ");
        }
        System.out.println();
        String space = repetirEspacos((maxWidth - 6) / 2);
        System.out.println(space + "Torre 1" + space + " " + space + "Torre 2" + space + " " + space + "Torre 3" + space);
    }

    public static String repetirEspacos(int quantidade) {
        StringBuilder espacos = new StringBuilder();
        for (int i = 0; i < quantidade; i++) {
            espacos.append(" ");
        }
        return espacos.toString();
    }

    public void printInitialState() {
        System.out.println("\nObjetivo: Mover todos os discos para a Torre " + targetTower + " em ordem crescente (menor no topo).");
        System.out.println("\nEstado Inicial:");
        if (gameMode == 1) {
            System.out.println("Início Clássico: todos os discos na Torre 1 em ordem decrescente [de maior (" + numDisks + ") a menor (1)]");
        } else {
            System.out.println("Início Aleatório: discos espalhados entre as torres");
        }
        System.out.println("Torre 1: " + (getTopDisk(0) != 0 ? "Contém discos" : "Vazia"));
        System.out.println("Torre 2: " + (getTopDisk(1) != 0 ? "Contém discos" : "Vazia"));
        System.out.println("Torre 3: " + (getTopDisk(2) != 0 ? "Contém discos" : "Vazia"));
        printTowers();
    }

    public void shuffleDisks() {
        Random rand = new Random();
        int shuffleMoves = numDisks * 5;
        for (int i = 0; i < shuffleMoves; i++) {
            ArrayList<Integer> validSources = new ArrayList<>();
            for (int t = 0; t < 3; t++) {
                if (getTopDisk(t) != 0) validSources.add(t);
            }
            if (validSources.isEmpty()) break;
            int sourceTower = validSources.get(rand.nextInt(validSources.size()));
            int disk = getTopDisk(sourceTower);

            ArrayList<Integer> validDests = new ArrayList<>();
            for (int t = 0; t < 3; t++) {
                int topDest = getTopDisk(t);
                boolean hasSpace = false;
                for (int j = 0; j < numDisks; j++) {
                    if (towers[t][j] == 0) {
                        hasSpace = true;
                        break;
                    }
                }
                if (t != sourceTower && hasSpace && (topDest == 0 || disk < topDest)) {
                    validDests.add(t);
                }
            }
            if (validDests.isEmpty()) continue;
            int destTower = validDests.get(rand.nextInt(validDests.size()));

            int sourceIndex = -1, destIndex = -1;
            for (int j = numDisks - 1; j >= 0; j--) {
                if (towers[sourceTower][j] == disk) {
                    sourceIndex = j;
                    break;
                }
            }
            for (int j = 0; j < numDisks; j++) {
                if (towers[destTower][j] == 0) {
                    destIndex = j;
                    break;
                }
            }
            if (destIndex != -1) {
                towers[sourceTower][sourceIndex] = 0;
                towers[destTower][destIndex] = disk;
            }
        }
    }

    public void printAvailableDisks() {
        ArrayList<String> available = new ArrayList<>();
        for (int t = 0; t < 3; t++) {
            int topDisk = getTopDisk(t);
            if (topDisk != 0) {
                available.add("Disco " + topDisk + " na Torre " + (t + 1));
            }
        }
        if (available.isEmpty()) {
            System.out.println("Nenhum disco disponível para mover.");
        } else {
            System.out.print("Discos disponíveis para mover: [");
            for (int i = 0; i < available.size(); i++) {
                System.out.print(available.get(i));
                if (i < available.size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }
    }

    public void printMoveHistory() {
        if (moveCount == 0) {
            System.out.println("Nenhum movimento realizado.");
            return;
        }
        System.out.println("Histórico de Movimentos:");
        for (int i = 0; i < Math.min(moveCount, maxMoves); i++) {
            int disk = moves[i][0];
            int source = moves[i][1];
            int dest = moves[i][2];
            System.out.println("Movimento " + (i + 1) + ": Disco " + disk + " de Torre " + source + " para Torre " + dest);
        }
    }

    public boolean isGameWon() {
        for (int i = 0; i < numDisks; i++) {
            if (towers[targetTower - 1][i] != numDisks - i) return false;
        }
        return true;
    }

    public boolean play() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nJogo da Torre de Hanói com " + numDisks + " discos.");
        System.out.println("Número mínimo de movimentos: " + maxMoves);
        System.out.println("Use números para escolher discos e torres (1, 2, 3).");
        printInitialState();

        if (isGameWon()) {
            System.out.println("Parabéns! Os discos já estão em ordem crescente na Torre " + targetTower + "!");
            return desejaJogarNovamente(scanner);
        }

        while (!isGameWon()) {
            printAvailableDisks();
            int disk = 0, sourceTower = 0, destTower = 0;
            while (true) {
                System.out.print("Digite o tamanho do disco a mover (ou 0 para sair): ");
                try {
                    disk = Integer.parseInt(scanner.nextLine());
                    if (disk == 0) {
                        System.out.println("Jogo encerrado.");
                        printMoveHistory();
                        return false;
                    }
                    boolean diskAvailable = false;
                    for (int t = 0; t < 3; t++) {
                        if (getTopDisk(t) == disk) {
                            diskAvailable = true;
                            sourceTower = t + 1;
                            break;
                        }
                    }
                    if (diskAvailable) break;
                    else System.out.println("Disco " + disk + " não está disponível.");
                } catch (NumberFormatException e) {
                    System.out.println("Entrada inválida.");
                }
            }

            while (true) {
                System.out.print("Digite a torre de destino (1, 2, 3) ou 0 para cancelar a escolha do disco: ");
                try {
                    destTower = Integer.parseInt(scanner.nextLine());
                    if (destTower == 0) {
                        break;
                    }
                    if (isValidMove(disk, sourceTower, destTower)) {
                        moveDisk(disk, sourceTower, destTower);
                        break;
                    } else {
                        System.out.println("Movimento inválido. O disco não pode ser movido para a Torre " + destTower + ".");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Entrada inválida. Digite um número inteiro.");
                }
            }
        }

        if (moveCount <= maxMoves) {
            System.out.println("Parabéns! Você venceu em " + moveCount + " movimentos.");
        } else {
            System.out.println("Você venceu, mas não com o número mínimo de movimentos.");
        }
        printMoveHistory();
        return desejaJogarNovamente(scanner);
    }

    public static boolean desejaJogarNovamente(Scanner scanner) {
        while (true) {
            System.out.print("Deseja jogar novamente? (s/n): ");
            String resposta = scanner.nextLine().trim().toLowerCase();
            if (resposta.equals("s")) return true;
            if (resposta.equals("n")) return false;
            System.out.println("Entrada inválida. Digite 's' ou 'n'.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            int discos = getNumberOfDisks(scanner);
            if (discos == 0) {
                System.out.println("Programa encerrado.");
                break;
            }
            int modo = getGameMode(scanner);
            torreHanoi jogo = new torreHanoi(discos, modo);
            continuar = jogo.play();
        }
        scanner.close();
    }
}