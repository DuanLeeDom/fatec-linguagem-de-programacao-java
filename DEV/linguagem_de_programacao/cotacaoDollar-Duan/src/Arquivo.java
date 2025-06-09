import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Arquivo {
    private String nomeArquivo;
    private Path caminho;
    
    public void NomeArquivo(String nome) {
        nomeArquivo = nome;
        caminho = Paths.get(nome);
    }
    public void grava(String conteudo) throws IOException{
        Files.deleteIfExists(caminho);
        Files.write(caminho, conteudo.getBytes(), StandardOpenOption.CREATE);
    }
}
