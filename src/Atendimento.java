class Atendimento {
    private static int contador = 1;

    int id;
    Paciente paciente;
    Medico medico;
    String status;

    public Atendimento(Paciente paciente, Medico medico) {
        this.id = contador++;
        this.paciente = paciente;
        this.medico = medico;
        this.status = "Em andamento";
    }

    public void finalizar() {
        status = "Finalizado";
        medico.disponivel = true;
    }
}