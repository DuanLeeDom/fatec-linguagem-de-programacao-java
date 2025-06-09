import java.io.*;
import java.net.*;

public class App {
    public static void main(String[] args) throws Exception {
        URL fatec = new URL("https://fatecbpaulista.edu.br");
        HttpURLConnection con = (HttpURLConnection) fatec.openConnection();
        con.setRequestMethod("GET");
        int codigoResposta = con.getResponseCode();
        if (codigoResposta == 200){
            BufferedReader br = new BufferedReader(
                      new InputStreamReader(con.getInputStream()));
            String linhaEntrada ;
            while ((linhaEntrada = br.readLine()) != null){;
                System.out.println(linhaEntrada);
            }
        }
        else{
            System.out.println("Erro: " + codigoResposta);
        }
    }
}
