public class Financiamento {
    private double valorTotal;
    private double entrada;
    private int parcelas;

    public Financiamento(double valorTotal, double entrada, int parcelas) {

        // throw new RuntimeException usa para lançar uma exceção personalizada quando uma condição não é atendida.
        // Isso é útil para validar os parâmetros de entrada e garantir que o objeto seja criado com valores válidos.
        if (entrada < valorTotal * 0.2) {
            throw new RuntimeException("Entrada deve ser maior que 20% do valor total.");
        } else if (parcelas < 6 ) {
            throw new RuntimeException("O número de parcelas deve ser maior que 6.");       
        }

        this.valorTotal = valorTotal;
        this.entrada = entrada;
        this.parcelas = parcelas;
    }

    public double prestacao() {
        return (valorTotal - entrada) / parcelas;
    }
}