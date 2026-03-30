class Prontuario {
    private int idProntuario;
    private String paciente;
    private ListaEncadeada sintomas;
    private ListaEncadeada medicamentos;
    private String diagnostico;
    private String observacoes;

    public Prontuario(int idProntuario, String paciente) {
        this.idProntuario = idProntuario;
        this.paciente = paciente;
        this.sintomas = new ListaEncadeada();
        this.medicamentos = new ListaEncadeada();
        this.diagnostico = "";
        this.observacoes = "";
    }

    public void adicionarSintoma(String sintoma) {
        sintomas.adicionar(sintoma);
    }

    public void adicionarMedicamento(String medicamento) {
        medicamentos.adicionar(medicamento);
    }

    public void registrarDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public void adicionarObservacao(String observacao) {
        this.observacoes += observacao + "\n";
    }

    public void exibirProntuario() {
        System.out.println("ID: " + idProntuario);
        System.out.println("Paciente: " + paciente);

        System.out.println("\nSintomas:");
        sintomas.exibir();

        System.out.println("\nMedicamentos:");
        medicamentos.exibir();

        System.out.println("\nDiagnóstico:");
        System.out.println(diagnostico);

        System.out.println("\nObservações:");
        System.out.println(observacoes);
    }
}