//A classe Presidencial herda a classe Quarto e representa um quarto tipo Suite Presidencial, 
//pelo luxo ofercido o quarto possui um adicional no preço a cada dois dias de reserva, além de uma taxa de serviço de 10% sobre o valor total da estadia

import java.util.GregorianCalendar;

public class Presidencial extends Quarto{
    private double precoAdicional;
    private double taxaServico;
    
    public Presidencial(int numero, double precoDiaria) {
        super(numero, precoDiaria);
        this.precoAdicional = 20.00;
        this.taxaServico = 0.1; // 10% de taxa de serviço   
    }

    //gets e sets para os atributos de Presidencial
    public double getPrecoAdicional() {
        return precoAdicional;
    }
    public void setPrecoAdicional(double precoAdicional) {
        this.precoAdicional = precoAdicional;
    }
    public double getTaxaServico() {
        return taxaServico;
    }
    public void setTaxaServico(double taxaServico) {
        this.taxaServico = taxaServico;
    }
    //Método para calcular o preço total da estadia
    @Override
    public double CalcularEstadia(GregorianCalendar dataEntrada, GregorianCalendar dataSaida) {
        int diasReservados = (int) ((dataSaida.getTimeInMillis() - dataEntrada.getTimeInMillis()) / (1000 * 60 * 60 * 24));
        double adicional = diasReservados / 2 * precoAdicional; // Adicional a cada dois dias
        double precoTotal = (getPrecoDiaria() + adicional) * diasReservados;
        precoTotal += precoTotal * taxaServico; // Adiciona a taxa de serviço
        return precoTotal;
    }
}
