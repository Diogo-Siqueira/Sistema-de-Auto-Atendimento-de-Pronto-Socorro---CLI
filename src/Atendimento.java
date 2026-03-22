public class Atendimento {

    private static int contador = 1;

    int id;
    Paciente paciente;
    String medico;
    String status;


    public Atendimento(Paciente paciente, String medico) {
        this.id = contador++;
        this.paciente = paciente;
        this.medico = medico;
        this.status = "Em andamento";
    }


    public void finalizar(){
        status = "Finalizado";
    }
    
}
