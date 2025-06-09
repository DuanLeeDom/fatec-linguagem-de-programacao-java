import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Api {

    private String dados ;

    public String ler(URL bc) throws IOException {
        dados = "";
        HttpURLConnection con = (HttpURLConnection) bc.openConnection();
        con.setRequestMethod("GET");
        int codigoResposta = con.getResponseCode();
        
        if (codigoResposta == 200){
            BufferedReader br = new BufferedReader(
                      new InputStreamReader(con.getInputStream()));
            String linhaEntrada ;
            while ((linhaEntrada = br.readLine()) != null){;
                linhaEntrada = linhaEntrada.replaceAll("\",", "\";");
                linhaEntrada = linhaEntrada.replaceAll("\"", "");
                linhaEntrada = linhaEntrada.replaceAll(",", ".");
                
                dados += linhaEntrada + "\n";
            }
        }
        else{
            throw new RuntimeException("Erro: " + codigoResposta);
            
        }
        return dados;
    }

}
