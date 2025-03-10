public class App {

    // Método para pular linha
    public static void pula_linha() {
        System.out.println("");
        System.out.println(" ────────────────────────────");
        System.out.println("");
    }
    public static void main(String[] args) throws Exception {
        
        /* Faça um programa em Java que contenha uma Matriz. 
        Esta matriz deverá conter a placa e o modelo de um veiculo.
        Usando o comando for e for-each exibida na tela a lista de veiculos. */

        // metodos 1 de inserção de dados 
        // Declarando a matriz
        String[][] veiculos = new String[3][2];
        veiculos[0][0] = "ABC-1234";
        veiculos[0][1] = "Fusca";
        veiculos[1][0] = "DEF-5678";
        veiculos[1][1] = "Gol";
        veiculos[2][0] = "GHI-9101";
        veiculos[2][1] = "Celta";

        // metodos 2 de inserção de dados 
        String[][] veiculos_02 = {
            {"ABC-1234", "Fusca"},
            {"DEF-5678", "Gol"},
            {"GHI-9101", "Celta"}
        };

        pula_linha();
        System.out.println("Exibindo dados da matriz: ");
        pula_linha();

        // Exibindo os veículos usando for tradicional
        System.err.println("Lista de veículos - metodo 1: ");
        for (int i = 0; i < veiculos.length; i++) {
            System.out.println("Placa: " + veiculos[i][0] + " - Modelo: " + veiculos[i][1]);
        }

        pula_linha();

        // Exibindo os veículos usando for-each
        System.out.println("Lista de veículos - metodo 2: ");
        for (String[] veiculo : veiculos_02) {
            System.out.println("Placa: " + veiculo[0] + " - Modelo: " + veiculo[1]);
        }

        pula_linha();

        int n[] = {10, 20, 30};
        for (int i : n) {
            System.out.print(" " + i + " ");
        }

        pula_linha();
    }
}
