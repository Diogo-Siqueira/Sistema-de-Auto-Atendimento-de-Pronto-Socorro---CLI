public class UnidadeAtendimento {
    ListaPacientes pacientes = new ListaPacientes();
    FilaPacientes filaAlta = new FilaPacientes();
    FilaPacientes filaMedia = new FilaPacientes();
    FilaPacientes filaBaixa = new FilaPacientes();
    ListaMedicos medicos;
    PilhaAtendimentos historico = new PilhaAtendimentos();
    ListaAtendimentos atendimentosDoDia = new ListaAtendimentos();
    ListaProntuarios prontuarios = new ListaProntuarios();
    int contadorProntuario = 1;

    public UnidadeAtendimento(int qtdMedicos) {
    medicos = new ListaMedicos(qtdMedicos);

    for (int i = 0; i < qtdMedicos; i++) {
        medicos.adicionar(new Medico(i+1, "Medico " + (i+1)));
    }
}
    
    

    int contadorAtendimento = 1;

    public void cadastrarPaciente(Paciente p){
        pacientes.adicionar(p);
    }

    public void listarPacientes(){
        pacientes.listar();
    }

    public void registrarChegada(int idPaciente) {
    Paciente p = pacientes.buscarPorId(idPaciente);

    if (p == null) {
        System.out.println("Paciente não encontrado.");
        return;
    }

    if (p.prioridade == 3) {
        filaAlta.enfileirar(p);
    } else if (p.prioridade == 2) {
        filaMedia.enfileirar(p);
    } else {
        filaBaixa.enfileirar(p);
    }

    System.out.println(p.nome + " entrou na fila!");
    }

    public Atendimento chamarProximo() {
    Medico medico = medicos.getDisponivel();

    if (medico == null) {
        System.out.println("Não há médicos disponíveis no momento!");
        return null;
    }

    Paciente p;

    if ((p = filaAlta.desenfileirar()) != null) {
    } else if ((p = filaMedia.desenfileirar()) != null) {
    } else {
        p = filaBaixa.desenfileirar();
    }

    if (p == null) {
        System.out.println("Fila vazia!");
        return null;
    }

    medico.disponivel = false;

    Atendimento a = new Atendimento(p, medico);

    System.out.println(
        "Chamando: " + p.nome +
        " | Médico: " + medico.nome +
        " | Sintoma: " + p.sintomas
    );

    return a;
}

    public void exibirFilaGeral() {
        System.out.println("=== ALTA PRIORIDADE ===");
        filaAlta.exibirFila();

        System.out.println("=== MÉDIA PRIORIDADE ===");
        filaMedia.exibirFila();

        System.out.println("=== BAIXA PRIORIDADE ===");
        filaBaixa.exibirFila();
    }

    public void finalizarAtendimento(Atendimento a) {
    if (a != null) {
        a.finalizar();

        historico.push(a);
        atendimentosDoDia.adicionar(a);

        a.paciente.statusAtendimento = "Finalizado";

        Prontuario p = new Prontuario(contadorProntuario++, a.paciente);
        prontuarios.adicionar(p);

        System.out.println("Adicionando atendimento ID: " + a.id + " na lista do dia");
    } else {
        System.out.println("Nenhum atendimento em andamento.");
    }
}

}
