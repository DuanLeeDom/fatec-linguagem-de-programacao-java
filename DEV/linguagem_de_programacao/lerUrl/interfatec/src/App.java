public class App {
    public static void main(String[] args) throws Exception {
        int qtd = args.length;
        int tam = Integer.parseInt(args[0]);
        System.out.println("linhas totais : "+ tam);
        float[][] dados = new float[tam][3];
        int linha = 0;
        int coluna = 0;
        for (int i = 1 ; i < (tam * 3); i++){
            String s = args[i];
            dados[linha][coluna++] = Float.parseFloat(s);
            if (coluna == 3){
                linha++;
                coluna = 0;
            }
        }
        System.out.println("Dados lidos:");
        for (float[] l : dados) {
            for (float c : l) {
                System.out.print(c + " ; ") ;
                
            }
            System.out.println();
            
        }
    }
}
