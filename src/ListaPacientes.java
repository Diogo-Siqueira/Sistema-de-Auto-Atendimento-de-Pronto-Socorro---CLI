public class ListaPacientes {
    private NoPaciente inicio;

    public void adicionar( Paciente p){
        NoPaciente novo = new NoPaciente(p);

        if (inicio == null) {
            inicio = novo;
        } else {
            NoPaciente atual = inicio;
            while (atual.proximo != null) {
                atual = atual.proximo;
            }
            atual.proximo = novo;
        }
    }

    public void listar(){
        NoPaciente atual  = inicio;

        while (atual != inicio) {
            atual.dado.exibirDados();
            atual = atual.proximo;
        }
    }

    public Paciente buscarPorId(int id){
        NoPaciente atual = inicio;

        while (atual != null) {
            if (atual.dado.idPaciente == id) {
                return atual.dado;
            }
            atual = atual.proximo;
        }
        return null;
    }

}
