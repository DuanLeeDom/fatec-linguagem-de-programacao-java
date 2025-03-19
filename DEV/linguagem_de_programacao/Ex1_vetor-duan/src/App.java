public class App {
    /**
     * @param args
     * @throws Exception
     */

    public static void titulo() {
        System.out.println("-----------");
        System.out.println("Mês: ");
    }

    public static void pula_linha() {
        System.out.println();
        System.out.println(" ────────────────────────────");
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        
        // Declaração do vetor
        String[] meses = {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", 
                        "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};

        // Usando o for
        System.out.println("Usando o for");
        for (int i = 0; i < meses.length; i++) {
            titulo();
            System.out.println(meses[i]);
        }

        pula_linha();

        System.out.println("Usando o for-each");
        // Usando o for-each
        for (String mes : meses) {
            titulo();
            System.out.println(mes);
        }

    }
}
