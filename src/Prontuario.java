class Prontuario {
    int id;
    Paciente paciente;
    String diagnostico;

    ListaString medicamentos = new ListaString();

    public Prontuario(int id, Paciente paciente) {
        this.id = id;
        this.paciente = paciente;
    }

    public void registrarDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public void adicionarMedicamento(String medicamento) {
        medicamentos.adicionar(medicamento);
    }

    public void exibir() {
        System.out.println("Prontuário ID: " + id);
        System.out.println("Paciente: " + paciente.nome);
        System.out.println("Diagnóstico: " + diagnostico);

        System.out.println("Medicamentos:");
        medicamentos.exibir();
    }
}