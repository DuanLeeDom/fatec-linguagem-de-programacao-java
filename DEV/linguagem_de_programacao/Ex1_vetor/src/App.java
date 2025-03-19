public class App {
    public static void main(String[] args) throws Exception {
        
        String[] meses = {"janeiro", "fevereiro","março",
                            "abril","maio","junho",
                            "julho","agosto","setembro",
                            "outubro","novembro","dezembro"};

        System.out.println("impressão com for");
        for (int indice = 0; indice < meses.length;indice++){
            System.out.println(meses[indice]);
        }
        System.out.println("impressão com for-each");
        for (String indice : meses){
            System.out.println(indice);
        }

    }
}
