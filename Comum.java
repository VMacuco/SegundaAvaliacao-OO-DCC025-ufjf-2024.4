//A classe Comum herda Quarto e representa um quarto comum de um hotel, sem nehuma peculiaridade.
import java.util.GregorianCalendar;

public class Comum extends Quarto {
    
    public Comum(int numero, double precoDiaria) {
        super(numero, precoDiaria);
    }
    //Método que implementa o metodo abstrato de Quarto para calcular o valor total da hospedagem, dado as datas de entrada e saída.
    @Override
    public double CalcularEstadia(GregorianCalendar dataEntrada, GregorianCalendar dataSaida) {
        long dias = (dataSaida.getTimeInMillis() - dataEntrada.getTimeInMillis()) / (1000 * 60 * 60 * 24);
        return dias * getPrecoDiaria();
    }
}
