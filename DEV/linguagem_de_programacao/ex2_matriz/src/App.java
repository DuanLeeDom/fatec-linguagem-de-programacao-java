public class App {
    public static void main(String[] args) throws Exception {
        String[][] veiculos = { {"abc-1234", "Fusca"},
                                {"def-5678", "Brasilia"},
                                {"iut-1f98", "Renagade"},
                                {"wbd-1j34", "HB20"}
                            };


        System.out.println("Imprimindo com for");
        for(int linha = 0; linha < veiculos.length; linha++){
            for( int coluna = 0 ; coluna < veiculos[linha].length; coluna++){
               System.out.print(veiculos[linha][coluna]);
               //System.out.println(veiculos[linha]);
                System.out.print(" ");                
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("imprimindo com for-each");
        for (String[] linha : veiculos) {
            for (String coluna : linha) {
                System.out.print(coluna);
                System.out.print(" ");                
            }
            System.out.println();
            
        }
    }
}
