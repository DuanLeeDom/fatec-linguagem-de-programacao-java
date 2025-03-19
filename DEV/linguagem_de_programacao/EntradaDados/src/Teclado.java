import java.util.Scanner;
/*
 *  Este programa fica responsável pelo acesso 
 *  ao teclado do computador
 */
public class Teclado {
    /* Scanner é um tipo de dados que permite acessar diversos
    *   tipos de dispositivos.
    * ao utilizar System.in, indicamos o dispostivo padrão 
    * que é o teclado
    */ 
    private Scanner t ;

    // função para iniciar o conteudo da variavel "t"
    // esta funcao é executada automaticamente
    // quando utilizamos o comando " new Teclado()"
    public Teclado() {
        t = new Scanner(System.in);
    }
    
    /*
     * função para exibir um texto na tela a partir do conteudo que for
     * fornecido na variavel "mensagem"
     * A função fica aguardado o usuario do programa digitar
     * alguma informação e então pressionar "Enter"
     * 
     */
    public String texto(String mensagem) {
        System.out.println(mensagem);

        return t.nextLine();
    }

    /*
     * A funcao numeroInteiro recebe um conteudo para ser exibido
     * e aguardar o recebimento de dados
     * nesta funcao, é utilizada a função texto como funcao auxiliar
     * na execução desta função
     * faz-se uso do comand try... catch para resolver problemas com 
     * a conversao de dados.
     */
    public int numeroInteiro(String mensagem){
        int x = 0;
        String aux ; 
        boolean erro;
        do{
            aux = texto(mensagem);
            try{
                x = Integer.parseInt(aux);
                erro = false;
            }
            catch(NumberFormatException e){
                erro = true;
                System.out.println("Erro. Por favor digite um valor numérico inteiro.");

            }
        } while (erro);
        
        return x;
    }
    public void close(){
        t.close();
    }      
    
    public float numeroDecimal(String mensagem){
        String aux = texto(mensagem);
        Float x = Float.parseFloat(aux);
        boolean erro = false;
        do {
            try{
                x = Float.parseFloat(aux);
            }
            catch(NumberFormatException e){
                // aqui fica o código que será executado caso ocorra um erro
                // quando um erro de NumberFormatException ocorrer 
                erro = true;
                System.out.println("Erro. Por favor digite um valor numérico decimal.");
            }
        } while (erro);
        return x;
    }
}