
import java.util.GregorianCalendar;

public abstract class Pagamento {
    private GregorianCalendar checkInCliente;
    private GregorianCalendar checkOutCliente;
    private Reserva reserva;

    //Construtores da classe Pagamento
    public Pagamento(GregorianCalendar checkInCLiente, GregorianCalendar checkOutCliente, Reserva reserva) {
        this.checkInCliente = checkInCLiente;
        this.checkOutCliente = checkOutCliente;
        this.reserva = reserva;
    }
    public Pagamento(){} //Construtor vazio apenas para efetuar o pagamento


    //gets e sets
    public GregorianCalendar getDataCheckIn(){
        return this.checkInCliente;
    }

    public GregorianCalendar getDataCheckOut(){
        return this.checkOutCliente;
    }

    public Reserva getReserva(){
        return this.reserva;
    }

    public void setDataCheckIn(GregorianCalendar checkIn){
        this.checkInCliente = checkIn;
    }

    public void setDataCheckOut(GregorianCalendar checkOut){
        this.checkOutCliente = checkOut;
    }

    public void setReserva(Reserva reserva){
        this.reserva = reserva;
    }

    public abstract void pagar(double valor);
    
    public abstract double valorTotal();
}
