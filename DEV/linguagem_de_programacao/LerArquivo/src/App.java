import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Execução de leitura e gravação em arquivos");
        Path arquivoEntrada = null;
        Path arquivoSaida = null;
        
        List<String> dados;
        String mensagemSaida = "";
        try {
            // define o local do arquivo de entrada de dados
            arquivoEntrada = Paths.get("src/entrada.txt");
            // le todo o arquivo e guarda o conteúdo na lista de dados
            dados = Files.readAllLines(arquivoEntrada);
            // percorre toda a lista, posicao por posicao
            for (String texto : dados) {
                //insere na mensagem o conteudo da lista de forma invertida
                mensagemSaida = texto + "\n" + mensagemSaida;
            }
            // define o local do arquivo de saida
            arquivoSaida = Paths.get("src/saida.txt");
            // grava os dados no arquivo
            Files.write(arquivoSaida, 
                        mensagemSaida.getBytes(StandardCharsets.UTF_8),
                        StandardOpenOption.CREATE);
            /*StandardOpenOption.CREATE - sobresceve arquivo existe 
                                            ou cria um novo se naão existir 
                StandardOpenOption.CREATE_NEW = Criar um arquivo novo e provoga erro
                                            se o arquivo já existir
                StandardOpenOption.APPEND = adiciona o conteudo ao fina do arquivo
                                            se este já existir
                StandardOpenOption.DELETE_ON_CLOSE = apaga o arquivo no fina do processo.
            */
            

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            // TODO: handle exception
        }
    }
}
