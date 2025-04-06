import java.util.GregorianCalendar;//usando Gregorian Calendar para representar datas ao invés de Date, pois o GregorianCalendar é mais flexível e fácil de usar.

//A CLasse Cliente é uma classe abstrata que representa um cliente de um sistema de reservas.
// Ela contém informações básicas sobre o cliente, como nome, email e endereço.
// Além disso, ela possui um objeto Reserva que representa a reserva associada ao cliente.

public abstract class Cliente {
    private String nome;
    private String email;
    private String endereco;
    private Reserva reserva;
    private GregorianCalendar dataCheckIn;
    private GregorianCalendar dataCheckOut;

//Construtores da classe Cliente
    public Cliente(String nome, String email, String endereco, Reserva reserva) {
        this.nome = nome;
        this.email = email;
        this.endereco = endereco;
        this.reserva = reserva;
    }
    //Construtor sem reserva
    public Cliente (String nome, String email, String endereco) {
        this.nome = nome;
        this.email = email;
        this.endereco = endereco;
    }
//Gets e Sets para os atributos de Cliente
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setCpf(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Reserva getReserva() {
        return reserva;
    }
    public void setReserva(Reserva reserva) {
        if (reserva.getID() == -1)
            System.out.println("ERRO: Reserva ivalida.");
        else
            this.reserva = reserva;
    }

    public GregorianCalendar getDataCheckIn() {
        return dataCheckIn;
    }

    public void setDataCheckIn(GregorianCalendar dataCheckIn) {
        this.dataCheckIn = dataCheckIn;
    }

    public GregorianCalendar getDataCheckOut() {
        return dataCheckOut;
    }

    public void setDataCheckOut(GregorianCalendar dataCheckOut) {
        this.dataCheckOut = dataCheckOut;
    }
    
//Método para cancelar a reserva do cliente, chama o método homonimo da classe Reserva e depois limpa a reserva do cliente.
    public void CancelarReserva() {
        if (this.reserva != null) {
            this.reserva.cancelarReserva();
            System.out.println("Reserva cancelada com sucesso.");
            this.reserva = null; // Limpa a reserva após o cancelamento
        } else {
            System.out.println("Nenhuma reserva encontrada para cancelar.");
        }
    }
//Método para fazer o check-in do cliente, setando a data de check-in e colocando o cliente no quarto de sua reserva.
    public void Checkin(GregorianCalendar checkIn){
        if (this.reserva != null){
            this.dataCheckIn = checkIn;
            this.reserva.getQuarto().setClienteAtual(this);
            System.out.println("Check-in realizado com sucesso.");
        }
        else {
            System.out.println("Nenhuma reserva encontrada para check-in.");
        }
    }
//Método para fazer o check-out do cliente, calculando o valor final do pagamento da hospedagem de acordo com a forma de pagamento escolhida.
    public void Checkout(GregorianCalendar checkOut, Pagamento forma){
        if (this.reserva != null){
            this.dataCheckOut = checkOut;
            forma.setDataCheckIn(this.dataCheckIn);
            forma.setDataCheckOut(checkOut);
            forma.setReserva(reserva);
            double valor  =  forma.valorTotal();
            this.imprimeDados();
            System.out.println("Valor total a Pagar: R$ " + valor);
            this.reserva.setValorTotal(valor);
        }
        else {
            System.out.println("Nenhuma reserva encontrada para checkout.");
        }
    }
//médoto para fazer o pagamento da reserva do cliente, chamando o método pagar da classe Pagamento.
    public void pagar(Pagamento forma){
        forma.pagar(this.reserva.getValorTotal());
    }


//Método abstrato Imprimir que imprime as informações do cliente
    public abstract void imprimeDados();

}   
