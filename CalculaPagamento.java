import java.util.GregorianCalendar;

interface CalculaPagamento{
    public double calcularValorTotal(GregorianCalendar checkInCliente, GregorianCalendar checkOutCliente, Reserva reserva);
}
