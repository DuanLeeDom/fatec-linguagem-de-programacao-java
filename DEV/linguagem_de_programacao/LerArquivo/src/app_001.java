import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class TextEditor {
    private static final int MAX_LINES = 100; // Tamanho máximo do vetor
    private static String[] lines = new String[MAX_LINES]; // Vetor para armazenar as linhas
    private static String filePath; // Caminho do arquivo
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Inicializa o vetor com strings vazias
        for (int i = 0; i < MAX_LINES; i++) {
            lines[i] = "";
        }

        // Menu inicial
        while (true) {
            System.out.println("\n=== Editor de Texto ===");
            System.out.println("1 - Abrir um arquivo existente");
            System.out.println("2 - Criar um arquivo novo");
            System.out.println("3 - Sair");
            System.out.print("Escolha uma opção: ");
            String option = scanner.nextLine();

            if (option.equals("1")) {
                openFile();
                if (filePath != null) {
                    textEditorMenu(); // Entra no menu do editor após abrir o arquivo
                }
            } else if (option.equals("2")) {
                createFile();
                if (filePath != null) {
                    textEditorMenu(); // Entra no menu do editor após criar o arquivo
                }
            } else if (option.equals("3")) {
                System.out.println("Saindo...");
                break;
            } else {
                System.out.println("Opção inválida! Tente novamente.");
            }
        }
        scanner.close();
 - This closes the scanner object
    }

    // Função para abrir um arquivo existente
    private static void openFile() {
        System.out.print("Digite o caminho do arquivo: ");
        filePath = scanner.nextLine();
        Path path = Paths.get(filePath);

        try {
            // Lê todas as linhas do arquivo
            java.util.List<String> fileLines = Files.readAllLines(path, StandardCharsets.UTF_8);
            // Preenche o vetor com as linhas do arquivo (até o limite de 100)
            for (int i = 0; i < Math.min(fileLines.size(), MAX_LINES); i++) {
                lines[i] = fileLines.get(i);
            }
            System.out.println("Arquivo aberto com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao abrir o arquivo: " + e.getMessage());
            filePath = null; // Reseta o caminho em caso de erro
        }
    }

    // Função para criar um novo arquivo
    private static void createFile() {
        System.out.print("Digite o caminho do novo arquivo: ");
        filePath = scanner.nextLine();
        // Vetor já está inicializado com strings vazias, então apenas definimos o caminho
        System.out.println("Novo arquivo criado (em memória). Use a opção salvar para gravar.");
    }

    // Menu principal do editor de texto
    private static void textEditorMenu() {
        while (true) {
            displayContent(); // Exibe o conteúdo numerado
            System.out.println("\n=== Menu do Editor ===");
            System.out.println("1 - Inserir novo texto");
            System.out.println("2 - Editar um texto");
            System.out.println("3 - Salvar");
            System.out.println("4 - Exibir");
            System.out.println("5 - Sair/Fechar");
            System.out.print("Escolha uma opção: ");
            String option = scanner.nextLine();

            if (option.equals("1")) {
                insertText();
            } else if (option.equals("2")) {
                editText();
            } else if (option.equals("3")) {
                saveFile();
            } else if (option.equals("4")) {
                displayContent();
            } else if (option.equals("5")) {
                System.out.println("Retornando ao menu inicial...");
                break;
            } else {
                System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }

    // Exibe o conteúdo do vetor com linhas numeradas
    private static void displayContent() {
        System.out.println("\n=== Conteúdo do Arquivo ===");
        boolean empty = true;
        for (int i = 0; i < MAX_LINES; i++) {
            if (!lines[i].isEmpty()) {
                System.out.println((i + 1) + ": " + lines[i]);
                empty = false;
            }
        }
        if (empty) {
            System.out.println("O arquivo está vazio.");
        }
    }

    // Insere novo texto na primeira linha vazia
    private static void insertText() {
        for (int i = 0; i < MAX_LINES; i++) {
            if (lines[i].isEmpty()) {
                System.out.print("Digite o novo texto: ");
                lines[i] = scanner.nextLine();
                System.out.println("Texto inserido na linha " + (i + 1));
                return;
            }
        }
        System.out.println("Erro: Não há linhas vazias disponíveis!");
    }

    // Edita o texto de uma linha específica
    private static void editText() {
        System.out.print("Digite o número da linha a ser editada (1-" + MAX_LINES + "): ");
        try {
            int lineNumber = Integer.parseInt(scanner.nextLine()) - 1;
            if (lineNumber >= 0 && lineNumber < MAX_LINES) {
                System.out.println("Linha atual: " + (lines[lineNumber].isEmpty() ? "<vazia>" : lines[lineNumber]));
                System.out.print("Digite o novo texto: ");
                lines[lineNumber] = scanner.nextLine();
                System.out.println("Linha " + (lineNumber + 1) + " editada com sucesso!");
            } else {
                System.out.println("Número de linha inválido!");
            }
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida! Digite um número.");
        }
    }

    // Salva o conteúdo do vetor no arquivo
    private static void saveFile() {
        try {
            Path path = Paths.get(filePath);
            // Monta o conteúdo a ser salvo (apenas linhas não vazias)
            StringBuilder content = new StringBuilder();
            for (String line : lines) {
                if (!line.isEmpty()) {
                    content.append(line).append("\n");
                }
            }
            // Grava no arquivo, sobrescrevendo se já existir
            Files.write(path, content.toString().getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            System.out.println("Arquivo salvo com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao salvar o arquivo: " + e.getMessage());
        }
    }
}