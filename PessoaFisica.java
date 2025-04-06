//A classe PessoaFisica herda a classe Cliente e representa um cliente do tipo pessoa física.
//Além do que já existe na classe Cliente, ela possui o atributo cpf da Pessoa Física.

public class PessoaFisica extends Cliente {
    private String cpf;
//Construtores da classe PessoaFisica
    public PessoaFisica(String nome, String cpf, String email, String endereco) {
        super(nome, email, endereco);
        this.cpf = cpf;
    }
    
    public PessoaFisica(String nome, String cpf, String email, String endereco, Reserva reserva) {
        super(nome, email, endereco, reserva);
        this.cpf = cpf;
    }
// gets e sets para o atributo cpf
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
//implementação do método abstrato imprimir da classe Cliente, imprime seus dados, o ID da reserva e informa se o check-in foi feito ou não.
    @Override
    public void imprimeDados(){
        System.out.println("Nome: " + getNome());
        System.out.println("CPF: " + getCpf());
        System.out.println("Email: " + getEmail());
        System.out.println("Endereço: " + getEndereco());
        if (getReserva() != null) {
            System.out.println("Reserva: " + getReserva().getID());
            System.out.println("Quarto: " + getReserva().getQuarto().getNumero());
            System.out.println("Data de Entrada: " + getReserva().getDataEntrada().getTime());
            System.out.println("Data de Saída: " + getReserva().getDataSaida().getTime());
            System.out.println("Valor da Estadia: R$ " + getReserva().getValorEsperado());
            if (this.getDataCheckIn() != null) 
                System.out.println("Data Check-in: " + getDataCheckIn().getTime());
            else 
                System.out.println("O Cliente ainda não fez seu check-in.");
            if (this.getDataCheckOut() != null)
                System.out.println("Data Check-out: " + getDataCheckOut().getTime());
            else 
                System.out.println("O Cliente ainda não fez seu check-out.");
        } else {
            System.out.println("Sem reserva associada.");
        }
    }
      
}
