import java.util.GregorianCalendar;

//A classe reserva aramzena os dados de uma reserva de um cliente em um quarto.
public class Reserva {
    private final int ID;
    private final Quarto quarto;
    private GregorianCalendar dataEntrada;
    private GregorianCalendar dataSaida;
    private double valorTotal;
    private double valorEsperado;

    //Construtores da classe Reserva
    public Reserva(int ID, Quarto quarto, GregorianCalendar dataEntrada, GregorianCalendar dataSaida) {
    
        // Verifica datas válidas primeiro
        if (!dataEntrada.before(dataSaida)) {
            System.out.println("Data de saída deve ser após data de entrada!");
            this.ID = -1;
            this.quarto = null;
            return;
        }
            
        // Depois verifica disponibilidade
        if (!quarto.estaDisponivel(dataEntrada, dataSaida)) {
            System.out.println("Quarto não disponível para as datas informadas.");
            this.ID = -1;
            this.quarto = null;
            return;
        }
            
        // Se passou nas verificações, cria a reserva
        this.ID = ID;
        this.quarto = quarto;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
            
        // Reserva as datas
        GregorianCalendar data = (GregorianCalendar) dataEntrada.clone();
        while (data.before(dataSaida)) {
            quarto.adicionarDataReservada(data);
            data.add(GregorianCalendar.DAY_OF_MONTH, 1);
        }
            
        this.valorEsperado = quarto.CalcularEstadia(dataEntrada, dataSaida);
        this.valorTotal = this.valorEsperado;
        
    }
    //gets e sets para os atributos de Reserva, nem todos os atributos possuem gets e sets, pois não são necessários, o hotel não altera reservas, ele as cancela e faz cria uma nova.
    public int getID() {
        return ID;
    }
    public Quarto getQuarto() {
        return quarto;
    }
    public GregorianCalendar getDataEntrada() {
        return dataEntrada;
    }
    public GregorianCalendar getDataSaida() {
        return dataSaida;
    }
    public double getValorTotal() {
        return valorTotal;
    }
    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
    public double getValorEsperado() {
        return valorEsperado;
    }
    //Método para cancelar a reserva, remove as datas da reserva do quarto e altera o cliente atual do quarto para null.
    //O método é chamado pelo Cliente quando o cliente cancela a reserva, aqui encapsulamos a lógica de cancelamento da reserva, apagando as datas do quarto e limpando o cliente atual, se este já tiver realizad  o check-in.
    public void cancelarReserva() {
        if (this.quarto.getDatasReservadas() != null) {
            for (GregorianCalendar d = dataEntrada; d.before(dataSaida); d.add(GregorianCalendar.DAY_OF_MONTH, 1)) {
                this.quarto.getDatasReservadas().remove(d);
            }
        }
        if (this.quarto.getClienteAtual() != null) {
            this.quarto.setClienteAtual(null);
        }
    }

}
