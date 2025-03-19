public class App {
    public static void main(String[] args) throws Throwable {
       Teclado teclado = new Teclado();
        String nome;
        int idade;
        float peso;
        float altura;

        nome = teclado.texto("Digite seu nome");
        idade = teclado.numeroInteiro("Digite a sua idade");
        peso = teclado.numeroDecimal("Digite o seu peso");
        altura = teclado.numeroDecimal("Digite a sua altura");

        System.out.println("resultados");
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        teclado.close();
        System.out.println("Seu IMC é: " + imc(peso, altura));
        
        System.out.println(	"fim");
        System.exit(0);
        
    }
}
