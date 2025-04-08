import java.util.Scanner;
 
public class App {
    // Variáveis globais
    static Scanner scanner = new Scanner(System.in);
    static String[] funcionario = new String[4];
    static String[] dependentes = new String[4];
    static String[] salario_bruto = new String[4];

 
    public static void barra(String title) {
        System.out.println(" ");
        System.out.println("----- " + title + " -----");
        System.out.println("==================================");
    }
 
    public static void menuOptions() {
        System.out.println("1 - Cadastrar funcionário");
        System.out.println("2 - Cadastrar dependentes");
        System.out.println("3 - Cadastrar salário bruto");
        System.out.println("4 - Calcular salário líquido");
        System.out.println("5 - Sair");
        System.out.print("Escolha uma opção: ");
        String option = scanner.nextLine();
        
        int options = Integer.parseInt(option);
        try {
            switch (options) {
                case 1:
                    cadFuncionario();
                    break;
                case 2:
                    cadDependentes();
                    break;
                case 3:
                    cadSalarios();
                    break;
                case 4:
                    calculoSalarios();
                    break;
                case 5: 
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida. Digite um número.");
        } catch (RuntimeException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public static void menu() {
        barra("MENU");
        menuOptions();
    }

    static void cadFuncionario() {
        barra("FUNCIONARIO");
        try {
            for (int i = 0; i < funcionario.length; i++) {
                System.out.print(i + "º) Informe o nome do funcionario: ");
                String nome = scanner.nextLine();
                funcionario[i] = nome;
            }
        } catch (RuntimeException e) {
            System.out.println("Erro: " + e.getMessage());
        } 
    }

    static void cadDependentes() {
        barra("DEPENDENTES");
        try {
            for (int i = 0; i < dependentes.length; i++){
                System.out.print("Informe o número de dependentes: ");
                String dependente = scanner.nextLine();
                dependentes[i] = dependente;
            }
        } catch (RuntimeException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    static void cadSalarios() {
        barra("SALARIO BRUTO");
        try {
            for (int i = 0; i < salario_bruto.length; i++) {
                System.out.print(i + "º) Informe o valor bruto do salário: ");
                String salario = scanner.nextLine();
                salario_bruto[i] = salario;
            }
        } catch (RuntimeException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    static void calculoSalarios() {
        barra("SALARIO LIQUIDO");
        for (int i = 0; i < funcionario.length; i++) {
            int dependentesInt = Integer.parseInt(dependentes[i]);
            double salario_brutoDouble = Double.parseDouble(salario_bruto[i]);
            double acrescimo = dependentesInt * 65.00;
            double salario_liquido = salario_brutoDouble + acrescimo;
            System.out.println("O salário líquido de " + funcionario[i] + " é: R$ " + salario_liquido);
            
            /*
            // Exibe os dados formatados
            System.out.printf(
                "Funcionário: %s | Dependentes: %d | Salário Bruto: R$ %.2f | Acréscimo: R$ %.2f | Salário Líquido: R$ %.2f%n",
                funcionario[i], dependentesInt, salario_brutoDouble, acrescimo, salario_liquido
            );
             */
        }
    }

    public static void main(String[] args) {
        // Estrutura de decisão para o menu
        boolean validacao = false;

        while (validacao != true) {
            menu();
            System.out.print("Deseja continuar? (S/N): ");
            String opcao = scanner.nextLine();
            if (opcao.equalsIgnoreCase("s") || opcao.equalsIgnoreCase("sim")) {
                validacao = false;
            } else {
                System.out.println("Sistema encerrado.");
                validacao = true;
            }
        }
    }
}
