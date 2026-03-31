class Prontuario {
    int id;
    Paciente paciente;
    String diagnostico;

    public Prontuario(int id, Paciente paciente) {
        this.id = id;
        this.paciente = paciente;
    }

    public void exibir() {
        System.out.println("Prontuário ID: " + id);
        System.out.println("Paciente: " + paciente.nome);
        System.out.println("Diagnóstico: " + diagnostico);
    }
}