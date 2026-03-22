public class FilaPacientes {
    private NoPaciente inicio;
    private NoPaciente fim;

    public void enfileirar(Paciente p){
        NoPaciente novo = new NoPaciente(p);

        if (fim != null) {
            fim.proximo = novo;
        }
        fim = novo;

        if (inicio == null) {
            inicio = novo;
        }
    }

    public Paciente desenfileirar(){
        if (inicio == null) {
            return null;
        }

        Paciente p = inicio.dado;
        inicio = inicio.proximo;

        if (inicio == null) {
            fim = null;
        }
        return p;
    }

    public void exibirFila(){
        NoPaciente atual = inicio;

        while (atual != null) {
            System.out.println(atual.dado.nome);
            atual = atual.proximo;
        }
    }

}
