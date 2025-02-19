public class App {
    public static void main(String[] args) throws Exception {
        int n1 = 8;
        int n2 = 7;
        int n3 = 10;
        float res = (n1 + n2 + n3) / 3.0f;

        System.out.println("Hello, World!");
        System.out.println("O resultado é " + res + "!");

        // Exemplo de diferentes formatos de printf:
        System.out.printf("O resultado é %f!%n", res);      // Valor padrão (6 casas decimais)
        System.out.printf("O resultado é %.2f!%n", res);    // Duas casas decimais
        System.out.printf("O resultado é %.0f!%n", res);    // Sem casas decimais
        System.out.printf("O resultado é %10.2f!%n", res);  // Campo de 10 caracteres, alinhado à direita
        System.out.printf("O resultado é %-10.2f!%n", res); // Alinhado à esquerda
        System.out.printf("O resultado é %+10.2f!%n", res); // Com sinal (+ ou -)
        System.out.printf("O resultado é %010.2f!%n", res); // Com zeros à esquerda
        System.out.printf("O resultado é %,10.2f!%n", res); // Formato com separador de milhar

        System.out.printf("\tO resultado é %f!%n", res);      // Valor padrão (6 casas decimais) + a tabulação
    
        /* 
         * 
          1.  %f → Formato padrão para float (6 casas decimais por padrão).
          2.  %.2f → Exibe apenas 2 casas decimais.
          3.  %.0f → Exibe sem casas decimais (arredondando).
          4.  %10.2f → Exibe o número com pelo menos 10 caracteres de largura, preenchendo com espaços à esquerda.
          5.  %-10.2f → Mesmo que o anterior, mas alinhado à esquerda.
          6.  %+10.2f → Adiciona sempre um sinal (+ ou -).
          7.  %010.2f → Preenche com zeros à esquerda para completar 10 caracteres.
          8.  %,10.2f → Usa separadores de milhar, útil para números grandes.
         * 
         */

    }
}
