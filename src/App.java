import java.util.Scanner;

public class App {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int opcao;
        int qtdMedicos = 3; // pode mudar
        UnidadeAtendimento ua = new UnidadeAtendimento(qtdMedicos);
        Atendimento[] atendimentosAtivos = new Atendimento[qtdMedicos];

        do{
            System.out.println("\n1 - Cadastrar Paciente");
            System.out.println("2 - Listar Pacientes");
            System.out.println("3 - Registrar Chegada");
            System.out.println("4 - Exibir fila");
            System.out.println("5 - Chamar próximo");
            System.out.println("6 - Finalizar atendimento");
            System.out.println("7 - Histórico");
            System.out.println("8 - Exibir ordem de atendimento");
            System.out.println("9 - Ver prontuário atual");
            System.out.println("10 - Próximo prontuário");
            System.out.println("11 - Prontuário anterior");
            System.out.println("12 - Ver atendimentos em andamento");
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

                    System.out.print("Sintomas: ");
                    String sintomas = sc.nextLine();

                    Paciente p = new Paciente(nome, idade, cpf, 0, sintomas);
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

                    int prioridade_case;
                    do {
                        System.out.print("Nova prioridade (1-baixa, 2-media, 3-alta): ");
                        prioridade_case = sc.nextInt();
                    } while (prioridade_case < 1 || prioridade_case > 3);

                    ua.registrarChegada(idBusca, prioridade_case);
                    break;

                case 4:
                    ua.exibirFilaGeral();
                    break;

                case 5:
                    boolean temEspaco = false;

                    for (int i = 0; i < atendimentosAtivos.length; i++) {
                        if (atendimentosAtivos[i] == null) {
                            temEspaco = true;
                            break;
                        }
                    }

                    if (!temEspaco) {
                        System.out.println("Todos os médicos estão ocupados!");
                        break;
                    }

                    Atendimento novo = ua.chamarProximo();

                    if (novo != null) {
                        for (int i = 0; i < atendimentosAtivos.length; i++) {
                            if (atendimentosAtivos[i] == null) {
                                atendimentosAtivos[i] = novo;
                                break;
                            }
                        }
                    }
                    break;

                case 6:
                    System.out.println("Digite o ID do atendimento para finalizar:");
                    int idFinalizar = sc.nextInt();
                    sc.nextLine(); 

                    boolean encontrou = false;

                    for (int i = 0; i < atendimentosAtivos.length; i++) {
                        if (atendimentosAtivos[i] != null &&
                            atendimentosAtivos[i].id == idFinalizar) {


                            System.out.print("Diagnóstico: ");
                            String diagnostico = sc.nextLine();

                            System.out.print("Medicamento: ");
                            String medicamento = sc.nextLine();

                            ua.finalizarAtendimento(atendimentosAtivos[i], diagnostico, medicamento);

                            atendimentosAtivos[i] = null;
                            encontrou = true;
                            break;
                        }
                    }

                    if (!encontrou) {
                        System.out.println("Atendimento não encontrado!");
                    }
                    break;

                case 7:
                    ua.historico.exibirHistorico();
                    break;

                case 8:
                    ua.atendimentosDoDia.exibirOrdem();
                    break;

                case 9:
                    ua.prontuarios.exibirAtual();
                    break;

                case 10:
                    ua.prontuarios.proximo();
                    break;

                case 11:
                    ua.prontuarios.anterior();
                    break;

                case 12:
                    System.out.println("=== ATENDIMENTOS EM ANDAMENTO ===");

                    boolean vazio = true;

                    for (Atendimento a : atendimentosAtivos) {
                        if (a != null) {
                           System.out.println(
                                "ID: " + a.id +
                                " | Paciente: " + a.paciente.nome +
                                " | Médico: " + a.medico.nome +
                                " | Sintoma: " + a.paciente.sintomas
                            );
                            vazio = false;
                        }
                    }

                    if (vazio) {
                        System.out.println("Nenhum atendimento em andamento.");
                    }
                    break;
            }

        } while (opcao != 0);

        sc.close();
    }
}
