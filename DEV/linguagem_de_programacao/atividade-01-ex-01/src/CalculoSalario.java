import java.util.Scanner;

public class CalculoSalario {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Declaração das variáveis
        String nome;
        int numDependentes = 0;
        double salarioBruto = 0.0;
        double acrescimo;
        double salarioTotal;
        final double VALOR_POR_DEPENDENTE = 65.00;
        
        // 1. Solicitando e obtendo o nome do funcionário
        System.out.print("Digite o nome do funcionário: ");
        nome = scanner.nextLine();
        
        // 2. Solicitando número de dependentes com validação
        boolean entradaValida = false;
        while (!entradaValida) {
            System.out.print("Digite o número de dependentes: ");
            String dependentesStr = scanner.nextLine();
            try {
                numDependentes = Integer.parseInt(dependentesStr);
                if (numDependentes >= 0) {  // Verifica se é não-negativo
                    entradaValida = true;
                } else {
                    System.out.println("Erro: Número de dependentes não pode ser negativo!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Erro: Por favor, digite um número inteiro válido!");
            }
        }
        
        // 3. Solicitando salário bruto com validação
        entradaValida = false;
        while (!entradaValida) {
            System.out.print("Digite o valor do salário bruto: ");
            String salarioStr = scanner.nextLine();
            try {
                salarioBruto = Double.parseDouble(salarioStr);
                if (salarioBruto > 0) {  // Verifica se é positivo
                    entradaValida = true;
                } else {
                    System.out.println("Erro: O salário deve ser maior que zero!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Erro: Por favor, digite um valor numérico válido!");
            }
        }
        
        // 4. Cálculo do acréscimo e do total
        acrescimo = numDependentes * VALOR_POR_DEPENDENTE;
        salarioTotal = salarioBruto + acrescimo;
        
        // 5. Exibição do resultado formatado
        System.out.printf("O funcionário %s, responsável por %d dependentes com salário mensal de %.2f " +
                         "receberá um acréscimo de %.2f, totalizando um salário bruto de %.2f%n",
                         nome, numDependentes, salarioBruto, acrescimo, salarioTotal);
        
        scanner.close();
    }
}