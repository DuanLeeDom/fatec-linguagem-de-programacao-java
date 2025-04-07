

public class ProgramaPrincipal {
    
    public static void main(String[] args) {

        double valorTotal = 1000.0;
        double entrada = 100.0;
        int parcelas = 10;

        // o try catch é usado para capturar exceções que podem ocorrer durante a execução do código
        // e evitar que o programa seja interrompido abruptamente.
        try {
            Financiamento f = new Financiamento(valorTotal, entrada, parcelas);
            System.out.println(f.prestacao());       
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

    }
}
