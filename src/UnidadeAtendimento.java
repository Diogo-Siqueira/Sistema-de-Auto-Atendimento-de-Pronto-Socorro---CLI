public class UnidadeAtendimento {
    ListaPacientes pacientes = new ListaPacientes();
    FilaPacientes fila = new FilaPacientes();
    PilhaAtendimentos historico = new PilhaAtendimentos();

    int contadorAtendimento = 1;

    public void cadastrarPaciente(Paciente p){
        pacientes.adicionar(p);
    }

    public void listarPacientes(){
        pacientes.listar();
    }

    public void registrarChegada(int idPaciente){
        Paciente p = pacientes.buscarPorId(idPaciente);

        if (p != null) {
            fila.enfileirar(p);
            System.out.println("Paciente entrou na Fila!");
            
        }else{
            System.out.println("Paciente nao encontrado");
        }
    }

    public Atendimento chamarProximo(){
        Paciente p = fila.desenfileirar();

        if (p == null) {
            System.out.println("Fila Vazia!");
            return null;
        }
        Atendimento a = new Atendimento(p, "Dr. Joao");
        System.out.println("chamando: " + p.nome);
        return a;
    }

    public void finalizarAtendimento(Atendimento a){
        if (a != null) {
            a.finalizar();
            historico.push(a);
            System.out.println("Atendimento Finalizado!");
        }
    }

}
