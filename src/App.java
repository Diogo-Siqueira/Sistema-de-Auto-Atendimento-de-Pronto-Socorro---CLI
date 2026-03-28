import java.util.Scanner;

public class App {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        UnidadeAtendimento ua = new UnidadeAtendimento();

        int opcao;
        Atendimento atual = null;

        do{
            System.out.println("\n1 - Cadastrar Paciente");
            System.out.println("2 - Listar Pacientes");
            System.out.println("3 - Registrar Chegada");
            System.out.println("4 - Exibir fila");
            System.out.println("5 - Chamar próximo");
            System.out.println("6 - Finalizar atendimento");
            System.out.println("7 - Histórico");
            System.out.println("0 - Sair");

            opcao = sc.nextInt();
            sc.nextLine(); 

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();

                    System.out.print("Idade: ");
                    int idade = sc.nextInt();
                    sc.nextLine();

                    System.out.print("CPF: ");
                    String cpf = sc.nextLine();

                   int prioridade;
                    do {
                        System.out.print("Prioridade (baixa(1), media(2), alta(3)): ");
                        prioridade = sc.nextInt();
                    } while (prioridade < 1 || prioridade > 3);
                    sc.nextLine();

                    System.out.print("Sintomas: ");
                    String sintomas = sc.nextLine();

                    Paciente p = new Paciente(nome, idade, cpf, prioridade, sintomas);
                    ua.cadastrarPaciente(p);

                    System.out.println("Paciente cadastrado com ID: " + p.idPaciente);
                    System.out.println("===============================================");
                    break;

                case 2:
                    ua.listarPacientes();
                    break;

                case 3:
                    System.out.print("ID do paciente: ");
                    int idBusca = sc.nextInt();
                    ua.registrarChegada(idBusca);
                    break;

                case 4:
                    ua.fila.exibirFila();
                    break;

                case 5:
                    atual = ua.chamarProximo();
                    break;

                case 6:
                    ua.finalizarAtendimento(atual);
                    break;

                case 7:
                    ua.historico.exibirHistorico();
                    break;
            }

        } while (opcao != 0);

        sc.close();
    }
}
