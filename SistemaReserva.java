import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class SistemaReserva {
    public static void main(String[] args) {
        System.out.println("Sistema de Reserva de Quartos");
        System.out.println("Vinícius Macuco Leite Carvalhaes");
        System.out.println("Matricula: 202365213AC");
        System.out.println(" ");
        System.out.println(" ");

        List<Reserva> reservas = new ArrayList<>();
        List<Quarto> quartos = new ArrayList<>();
        List<Cliente> clientes = new ArrayList<>();
        // Adicionando alguns quartos ao sistema
        quartos.add(new Comum(101,100.00));
        quartos.add(new Comum(201,100.00));
        quartos.add(new Presidencial(501,200.00));

        // Adicionando alguns clientes ao sistema
        clientes.add(new PessoaFisica("Vinícius Macuco Leite Carvalhaes", "cpf", "macuco.vinicius@estudante.ufjf.br", "endereço"));

        // Adicionando algumas reservas ao sistema
        reservas.add(new Reserva(01, quartos.get(0), new GregorianCalendar(2025, 03, 04), new GregorianCalendar(2025, 03, 06)));
        Cliente c1 = clientes.get(0);
        c1.setReserva(reservas.get(0));
        c1.imprimeDados();

        System.out.println(" ");
        System.out.println(" ");

        //novo cliente e nova reserva, mas está querendo o mesmo quarto que o anterior dentro do mesmo intervalo de tempo
        clientes.add(new PessoaFisica("Fulano", "cpf", "fulano@gmail.com", "endereço"));
        reservas.add(new Reserva(02, quartos.get(0), new GregorianCalendar(2025, 03, 03), new GregorianCalendar(2025, 03, 05)));

        System.out.println(" ");
        System.out.println(" ");

        //novo cliente PJ num quarto diferente
        clientes.add(new PessoaJuridica("Empresa SA","cnpj","Beltrano the CEO", "cpf","contato@empresa.com","endereço"));
        reservas.add(new Reserva(03, quartos.get(2), new GregorianCalendar(2025, 03, 02), new GregorianCalendar(2025, 03, 10)));
        Cliente c2 = clientes.get(2);
        c2.setReserva(reservas.get(2));
        c2.imprimeDados();

        System.out.println(" ");
        System.out.println(" ");

        //Clienta c1 chega no dia 04 e sai no dia 06, mas quer fazer check-in no dia 03. Ele faz o check-out no dia 06 e faz o pagamento em PIX.
        c1.Checkin(new GregorianCalendar(2025,03,04));
        c1.imprimeDados();

        System.out.println(" ");
        System.out.println(" ");

        c1.Checkout(new GregorianCalendar(2025,03,06), new Pix());
        //Como chegou antes do dia marcado, o cliente pagou a estadia normal, mas teve que pagar o valor da diária do dia 03, já que o quarto estava disponível.
        //Felizmente o Hotel da 5% de desconto para pagamentos via Pix.
        c1.pagar(new Pix());

        System.out.println(" ");
        System.out.println(" ");

        //Cliente c2 chega no dia 02 e sai no dia 10, mas quer fazer check-in no dia 03. Ele faz o check-out no dia 11 e faz o pagamento no cartão de crédito.
        c2.Checkin(new GregorianCalendar(2025,03,03));
        c2.imprimeDados();

        System.out.println(" ");
        System.out.println(" ");
        

        c2.Checkout(new GregorianCalendar(2025,03,11), new Credito());
        //Ele chegou atrasado para sua reserva e saiu um dia depois d dia marcado, o quarto estava disponivel, mas ele teve que pagar uma multa pelo atraso.
        //o Hotel também cobra uma taxa d 5% para pagamentos via cartão de crédito.
        c2.pagar(new Credito());

        System.out.println(" ");
        System.out.println(" ");

        //Por fim um novo cliente vai fazer uma reserva no quarto 201, mas vai cancelar a reserva antes de fazer o check-in. Esse hotel não cobra taxa de cancelamento.
        clientes.add(new PessoaFisica("nome", "cpf", "email", "enderaço"));
        reservas.add(new Reserva(04, quartos.get(1), new GregorianCalendar(2025, 03, 01), new GregorianCalendar(2025, 03, 02)));
        Cliente c3 = clientes.get(3);
        c3.setReserva(reservas.get(3));
        c3.imprimeDados();

        System.out.println(" ");
        System.out.println(" ");
        
        c3.CancelarReserva();

        System.out.println(" ");
        System.out.println(" ");

        //Agora um novo cliente quer fazer a reserva no quarto 201 para os mesmos dias
        clientes.add(new PessoaFisica("outro nome", "outro cpf", "outro email", "outro enderaço"));
        reservas.add(new Reserva(05, quartos.get(1), new GregorianCalendar(2025, 03, 01), new GregorianCalendar(2025, 03, 02)));
        Cliente c4 = clientes.get(4);
        c4.setReserva(reservas.get(4));
        c4.imprimeDados();

    }
}

