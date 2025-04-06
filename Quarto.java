import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;


//A classe Quarto representa um quarto de um hotel.
public abstract class Quarto {
    private int numero;
    private List<GregorianCalendar> datasReservadas;
    private double precoDiaria;
    private Cliente clienteAtual;

    //Construtores da classe Quarto
    public Quarto(int numero, double precoDiaria) {
        this.numero = numero;
        this.precoDiaria = precoDiaria;
        this.datasReservadas = new ArrayList<>();
    }
    //gets e sets para os atributos de Quarto
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public List<GregorianCalendar> getDatasReservadas() {
        return datasReservadas;
    }

    public void setDatasReservadas(List<GregorianCalendar> datasReservadas) {
        this.datasReservadas = datasReservadas;
    }

    public double getPrecoDiaria() {
        return precoDiaria;
    }

    public void setPrecoDiaria(double precoDiaria) {
        this.precoDiaria = precoDiaria;
    }

    public Cliente getClienteAtual() {
        return clienteAtual;
    }

    public void setClienteAtual(Cliente clienteAtual) {
        this.clienteAtual = clienteAtual;
    }

//Métodos concretos da classe Quarto

    //Método para escrevar as datas que o quarto está reservado
    public void adicionarDataReservada(GregorianCalendar data) {
        // Verifica se já não está na lista
        for (GregorianCalendar d : datasReservadas) {
            if (mesmoDia(d, data)) {
                return; // Já está reservado
            }
        }
        datasReservadas.add((GregorianCalendar) data.clone());
    }

    //Método para verificar se o quarto está disponível em uma determinada data
    public boolean estaDisponivel(GregorianCalendar dataEntrada, GregorianCalendar dataSaida) {
    // Cria uma cópia para iterar
    GregorianCalendar data = (GregorianCalendar) dataEntrada.clone();
    
    // Verifica cada dia do período solicitado
    while (data.before(dataSaida)) {
        // Compara com cada data reservada
        for (GregorianCalendar dataReservada : datasReservadas) {
            if (mesmoDia(data, dataReservada)) {
                return false;
            }
        }
        data.add(GregorianCalendar.DAY_OF_MONTH, 1);
    }
    return true;
}

// Método auxiliar para comparar apenas dia/mês/ano
    private boolean mesmoDia(GregorianCalendar data1, GregorianCalendar data2) {
        if (data1.get(Calendar.YEAR) == data2.get(Calendar.YEAR) &&
            data1.get(Calendar.MONTH) == data2.get(Calendar.MONTH) &&
            data1.get(Calendar.DAY_OF_MONTH) == data2.get(Calendar.DAY_OF_MONTH)) {
            return true;
        }
        return false;
    }

    //Método abstrato para calcular o preço total da estadia
    public abstract double CalcularEstadia(GregorianCalendar dataEntrada, GregorianCalendar dataSaida);

}
