import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class App {
    public static void main(String[] args) throws Exception {
        Entrada entrada = new Entrada();
        Arquivo arquivo = new Arquivo();
        String inicio = entrada.texto("Data inicial: ");
        String fim = entrada.texto("Data final: ");
        String urlbase = "https://olinda.bcb.gov.br/olinda/servico/PTAX/versao/v1/odata/CotacaoDolarPeriodo(dataInicial=@dataInicial,dataFinalCotacao=@dataFinalCotacao)?@dataInicial='{inicio}'&@dataFinalCotacao='{fim}'&$top=100&$skip=0&$format=text/csv&$select=cotacaoCompra,cotacaoVenda,dataHoraCotacao";
        String url = urlbase.replace("{inicio}", inicio);
        url = url.replace("{fim}", fim);
        url = url.replaceAll("\'", "%27");
        URL bc = new URL(url);
        Api apibc = new Api();
        String dados = apibc.ler(bc);

        System.out.println(url);
        System.out.println(dados);
        arquivo.NomeArquivo("cotacoes.csv");
        arquivo.grava(dados);
    }
}}