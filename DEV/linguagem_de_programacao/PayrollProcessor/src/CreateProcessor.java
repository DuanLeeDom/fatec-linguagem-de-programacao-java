import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CreateProcessor {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Path arquivoEntrada = Paths.get("src/cadastro/entrada.txt");
    // Variáveis globais para rastrear ações
    public static int cadastrosCriados = 0;
    public static int cadastrosModificados = 0;
    public static List<String> nomesCriados = new ArrayList<>();
    public static List<String> nomesModificados = new ArrayList<>();

    public static void main(String[] args) {
        // Cria a pasta cadastro, se não existir
        try {
            Files.createDirectories(arquivoEntrada.getParent());
        } catch (Exception e) {
            System.out.println("Erro ao criar pasta cadastro: " + e.getMessage());
            return;
        }

        // Menu principal
        while (true) {
            System.out.println("\n=== Menu de Cadastros ===");
            System.out.println("1 - Criar cadastro");
            System.out.println("2 - Visualizar cadastros");
            System.out.println("3 - Modificar cadastro");
            System.out.println("4 - Sair");
            System.out.print("Opção: ");
            String opcao = scanner.nextLine();

            if (opcao.equals("1")) {
                criarCadastro();
            } else if (opcao.equals("2")) {
                visualizarCadastros();
            } else if (opcao.equals("3")) {
                modificarCadastro();
            } else if (opcao.equals("4")) {
                break;
            } else {
                System.out.println("Opção inválida!");
            }
        }
        scanner.close();
    }

    // Cria um novo cadastro e adiciona ao arquivo
    private static void criarCadastro() {
        System.out.println("\n=== Novo Cadastro ===");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Horas trabalhadas: ");
        String horas = scanner.nextLine();
        System.out.print("Valor da hora: ");
        String valorHora = scanner.nextLine();

        // Valida entradas numéricas
        try {
            Integer.parseInt(horas);
            Double.parseDouble(valorHora);
        } catch (NumberFormatException e) {
            System.out.println("Erro: Horas e valor da hora devem ser numéricos.");
            return;
        }

        // Adiciona o novo cadastro ao arquivo
        List<String> novoCadastro = Arrays.asList(nome, horas, valorHora);
        try {
            Files.write(arquivoEntrada, 
                        novoCadastro, 
                        StandardCharsets.UTF_8, 
                        StandardOpenOption.CREATE, 
                        StandardOpenOption.APPEND);
            cadastrosCriados++;
            nomesCriados.add(nome);
            System.out.println("Cadastro criado!");
        } catch (Exception e) {
            System.out.println("Erro ao criar cadastro: " + e.getMessage());
        }
    }

    // Exibe todos os cadastros do arquivo
    private static void visualizarCadastros() {
        System.out.println("\n=== Cadastros ===");
        try {
            List<String> linhas = Files.readAllLines(arquivoEntrada, StandardCharsets.UTF_8);
            if (linhas.isEmpty()) {
                System.out.println("Nenhum cadastro encontrado.");
                return;
            }

            for (int i = 0; i < linhas.size(); i += 3) {
                if (i + 2 < linhas.size()) {
                    System.out.println("Funcionário " + ((i / 3) + 1) + ":");
                    System.out.println("Nome: " + linhas.get(i));
                    System.out.println("Horas: " + linhas.get(i + 1));
                    System.out.println("Valor/hora: " + linhas.get(i + 2));
                    System.out.println("---");
                }
            }
        } catch (Exception e) {
            System.out.println("Erro ao visualizar cadastros: " + e.getMessage());
        }
    }

    // Modifica um cadastro existente
    private static void modificarCadastro() {
        System.out.println("\n=== Modificar Cadastro ===");
        try {
            List<String> linhas = Files.readAllLines(arquivoEntrada, StandardCharsets.UTF_8);
            if (linhas.isEmpty()) {
                System.out.println("Nenhum cadastro encontrado.");
                return;
            }

            // Exibe os cadastros disponíveis
            System.out.println("Cadastros disponíveis:");
            for (int i = 0; i < linhas.size(); i += 3) {
                if (i + 2 < linhas.size()) {
                    System.out.println("Funcionário " + ((i / 3) + 1) + ": " + linhas.get(i));
                }
            }

            // Solicita o número do funcionário a modificar
            System.out.print("Número do funcionário: ");
            int numero;
            try {
                numero = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Erro: Número inválido.");
                return;
            }

            int indice = (numero - 1) * 3;
            if (indice < 0 || indice + 2 >= linhas.size()) {
                System.out.println("Funcionário inválido!");
                return;
            }

            // Solicita novos dados
            System.out.print("Novo nome: ");
            String nome = scanner.nextLine();
            System.out.print("Novas horas trabalhadas: ");
            String horas = scanner.nextLine();
            System.out.print("Novo valor da hora: ");
            String valorHora = scanner.nextLine();

            // Valida entradas numéricas
            try {
                Integer.parseInt(horas);
                Double.parseDouble(valorHora);
            } catch (NumberFormatException e) {
                System.out.println("Erro: Horas e valor da hora devem ser numéricos.");
                return;
            }

            // Atualiza os dados
            linhas.set(indice, nome);
            linhas.set(indice + 1, horas);
            linhas.set(indice + 2, valorHora);

            // Grava o arquivo atualizado
            Files.write(arquivoEntrada, 
                        linhas, 
                        StandardCharsets.UTF_8, 
                        StandardOpenOption.CREATE, 
                        StandardOpenOption.TRUNCATE_EXISTING);
            cadastrosModificados++;
            nomesModificados.add(nome);
            System.out.println("Cadastro modificado!");

        } catch (Exception e) {
            System.out.println("Erro ao modificar cadastro: " + e.getMessage());
        }
    }
}