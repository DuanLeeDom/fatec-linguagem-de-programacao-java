import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Chama o CreateProcessor para gerenciar cadastros
        CreateProcessor.main(new String[0]);

        // Processa os dados
        Path arquivoEntrada = Paths.get("src/cadastro/entrada.txt");
        Path arquivoSaida = Paths.get("src/cadastro/saida.txt");

        try {
            // Lê todas as linhas do arquivo de entrada
            List<String> linhas = Files.readAllLines(arquivoEntrada, StandardCharsets.UTF_8);

            // StringBuilder para o conteúdo do arquivo de saída
            StringBuilder conteudoSaida = new StringBuilder();

            // Processa as linhas em grupos de 3 (nome, horas, valor da hora)
            for (int i = 0; i < linhas.size(); i += 3) {
                if (i + 2 >= linhas.size()) {
                    System.out.println("Erro: Dados incompletos em entrada.txt.");
                    break;
                }

                String nome = linhas.get(i).trim();
                int horasTrabalhadas = Integer.parseInt(linhas.get(i + 1).trim());
                double valorHora = Double.parseDouble(linhas.get(i + 2).trim());
                double salarioBruto = horasTrabalhadas * valorHora;

                conteudoSaida.append("Nome: ").append(nome).append("\n");
                conteudoSaida.append("Horas Trabalhadas: ").append(horasTrabalhadas).append("\n");
                conteudoSaida.append("Valor da Hora: ").append(String.format("%.2f", valorHora)).append("\n");
                conteudoSaida.append("Salário Bruto: ").append(String.format("%.2f", salarioBruto)).append("\n");
                conteudoSaida.append("---\n");
            }

            // Garante que a pasta cadastro existe
            Files.createDirectories(arquivoSaida.getParent());

            // Grava o conteúdo no arquivo de saída
            Files.write(arquivoSaida, 
                        conteudoSaida.toString().getBytes(StandardCharsets.UTF_8),
                        StandardOpenOption.CREATE, 
                        StandardOpenOption.TRUNCATE_EXISTING);

            // Relatório de alterações, apenas se houver
            StringBuilder relatorio = new StringBuilder();
            if (CreateProcessor.cadastrosCriados > 0) {
                relatorio.append("Criados ").append(CreateProcessor.cadastrosCriados).append(" cadastro(s): ")
                         .append(String.join(", ", CreateProcessor.nomesCriados)).append("\n");
            }
            if (CreateProcessor.cadastrosModificados > 0) {
                relatorio.append("Modificados ").append(CreateProcessor.cadastrosModificados).append(" cadastro(s): ")
                         .append(String.join(", ", CreateProcessor.nomesModificados)).append("\n");
            }
            if (relatorio.length() > 0) {
                System.out.println("\n=== Relatório de Alterações ===");
                System.out.print(relatorio.toString());
            }

        } catch (NumberFormatException e) {
            System.out.println("Erro: Formato inválido nos dados de entrada.txt.");
        } catch (Exception e) {
            System.out.println("Erro ao processar arquivo: " + e.getMessage());
        }
    }
}