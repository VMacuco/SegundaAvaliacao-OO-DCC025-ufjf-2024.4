
import java.util.GregorianCalendar;

public abstract class Pagamento {
    private GregorianCalendar checkInCLiente;
    private GregorianCalendar checkOutCliente;
    private Reserva reserva;

    //Construtores da classe Pagamento
    public Pagamento(GregorianCalendar checkInCLiente, GregorianCalendar checkOutCliente, Reserva reserva) {
        this.checkInCLiente = checkInCLiente;
        this.checkOutCliente = checkOutCliente;
        this.reserva = reserva;
    }
    public Pagamento(){} //Construtor vazio apenas para efetuar o pagamento

    public abstract void pagar(double valor);
    
    public abstract double valorTotal(GregorianCalendar checkInCliente, GregorianCalendar checkOutCliente, Reserva reserva);
}
