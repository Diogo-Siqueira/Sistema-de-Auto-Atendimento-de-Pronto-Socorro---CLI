public class Paciente {
    private static int contador = 1;

    int idPaciente;
    String nome;
    int idade;
    String cpf;
    int prioridade;
    String sintomas;
    String statusAtendimento;
    


    public Paciente(String nome, int idade, String cpf, int prioridade, String sintomas) {

        this.idPaciente = contador++;
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.prioridade = prioridade;
        this.sintomas = sintomas;
        this.statusAtendimento = "Aguardando";
    }

    public void exibirDados(){
        System.out.println("ID: " + idPaciente + "| Nome: " + nome + " | Prioridade " + prioridade);
    }

    public String prioridadeToString(){
        if (prioridade == 3) {
            return "Alta";
        }
        if (prioridade == 2) {
            return "Média";
        }
        return "Baixa";
    }
    

}
