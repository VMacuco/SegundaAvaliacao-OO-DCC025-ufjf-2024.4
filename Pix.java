import java.util.Calendar;
import java.util.GregorianCalendar; 

//O Hotel da 5% de desconto para pagamentos via Pix

public class Pix extends Pagamento implements CalculaPagamento {
    
    //Construtores da classe Pix
    public Pix(GregorianCalendar checkInCLiente, GregorianCalendar checkOutCliente, Reserva reserva) {
        super(checkInCLiente, checkOutCliente, reserva);
    }
    public Pix(){}
    //Método para realizar o pagamento, imprime na tela que o pagamento foi realizado com sucesso.
    @Override
    public void pagar(double valor){
        System.out.println("Pagamento via Pix realizado com sucesso.");
    }
    @Override
    public double valorTotal(){
        return this.calcularValorTotal(this.getDataCheckIn(), this.getDataCheckOut(), this.getReserva());
    }
    //Método para calcular o valor total do pagamento, retorna o valor total da reserva.
    @Override
    public double calcularValorTotal(GregorianCalendar checkInCliente, GregorianCalendar checkOutCliente, Reserva reserva){
        //pega o valor calculado pela reserva
        double valor = reserva.getValorEsperado();
        //Verifica se o cliente fez o Check-in fora do dia marcado na reserva
        if (reserva.getDataEntrada().compareTo(checkInCliente) != 0) {
            //Se o cliente chegou atrasado, adiciona uma multa de 10% do valor da diária por dia de atraso
            if (checkInCliente.compareTo(reserva.getDataEntrada()) > 0) {
                int dias = (int) ((checkOutCliente.getTimeInMillis() - reserva.getDataEntrada().getTimeInMillis()) / (1000 * 60 * 60 * 24));
                valor += (reserva.getQuarto().getPrecoDiaria() * 0.10 * dias);
            }
            //Se chegou adiantado, verifica se o quarto reservado está disponível
            else {
                GregorianCalendar diaAntes = reserva.getDataEntrada();
                diaAntes.add(Calendar.DAY_OF_MONTH, -1);
                //Se sim, Calcula o valor da nova estadia, sem nenhum custo adicional, afinal o quarto está disponível
                if (reserva.getQuarto().estaDisponivel(checkInCliente, diaAntes))
                    valor += (reserva.getQuarto().CalcularEstadia(checkInCliente, diaAntes));
                //Se não possuir disponibilidade, o cliente terá que ficar em outro quarto, e o valor será calculado separadamente
                else 
                    System.out.println("Quarto da reserva não disponível, cliente precisará ficar em outro quarto. Valor calculado separadamente para cada reserva");
            }
        }
        //Verifica se o cliente fez o Check-out fora do dia marcado na reserva
        if (reserva.getDataSaida().compareTo(checkOutCliente) != 0) {
            //Se o cliente saiu antes do dia marcado na reserva, ele pagara o valor esperado, menos 40% do valor da diária por dia de antecipação (multa de 60% no valor da diária/dia)
            if (checkOutCliente.compareTo(reserva.getDataSaida()) < 0) {
                int dias = (int) ((reserva.getDataSaida().getTimeInMillis() - checkInCliente.getTimeInMillis()) / (1000 * 60 * 60 * 24));
                valor -= (reserva.getQuarto().getPrecoDiaria() * 0.40 * dias) ;
            }
            //Se o cliente saiu depois do dia marcado na reserva, verifica-se se o quarto estava diponivel
            else{
                GregorianCalendar diaDepois = reserva.getDataSaida();
                diaDepois.add(Calendar.DAY_OF_MONTH, +1);
                //Se sim, Calcula o valor da nova estadia, sem nenhum custo adicional, afinal o quarto está disponível
                if (reserva.getQuarto().estaDisponivel(diaDepois, checkOutCliente))
                    valor += (reserva.getQuarto().CalcularEstadia(checkOutCliente, diaDepois));
                //Se não possuir disponibilidade, o cliente terá que ficar em outro quarto, e o valor será calculado separadamente
                else 
                    System.out.println("Quarto da reserva não disponível, cliente precisará ficar em outro quarto. Valor calculado separadamente para cada reserva");
                
            }
        }   
        return valor - valor * 0.05; //Desconto de 5% para pagamento via Pix
    }

}
