//A classe PessoaJuridica herda a classe Cliente e representa um cliente do tipo pessoa jurídica.
//Nessa classe temos os atributos para o cnpj da PJ e o nome e cpf do hospede que está representando a empresa.

public class PessoaJuridica extends Cliente{
    private String cnpj;
    private String nomeRepresentane;//nome do representante que está fazendo a reserva em nome da PJ.
    private String cpfRepresentante;//cpf do representante
//construtores da classe PessoaJuridica
    public PessoaJuridica(String nome, String cnpj, String nomeRepresentante, String cpfRepresentante, String email, String endereco) {
        super(nome, email, endereco);
        this.cnpj = cnpj;
        this.nomeRepresentane = nomeRepresentante;
        this.cpfRepresentante = cpfRepresentante;
    }
    public PessoaJuridica(String nome, String cnpj, String nomeRepresentante, String cpfRepresentante, String email, String endereco, Reserva reserva) {
        super(nome, email, endereco, reserva);
        this.cnpj = cnpj;
        this.nomeRepresentane = nomeRepresentante;
        this.cpfRepresentante = cpfRepresentante;
    }
//gets e sets para os atributos cnpj, nomeRepresentante e cpfRepresentante
    public String getCnpj() {
        return cnpj;
    }
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    public String getNomeRepresentante() {
        return nomeRepresentane;
    }
    public void setNomeRepresentante(String nomeRepresentante) {
        this.nomeRepresentane = nomeRepresentante;
    }
    public String getCpfRepresentante() {
        return cpfRepresentante;
    }
    public void setCpfRepresentante(String cpfRepresentante) {
        this.cpfRepresentante = cpfRepresentante;
    }
//implementação do método abstrato imprimir da classe Cliente, imprime seus dados, o ID da reserva e informa se o check-in foi feito ou não.
    @Override
    public void imprimeDados(){
        System.out.println("Nome: " + getNome());
        System.out.println("CNPJ: " + getCnpj());
        System.out.println("Nome do Representante: " + getNomeRepresentante());
        System.out.println("CPF do Representante: " + getCpfRepresentante());
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
