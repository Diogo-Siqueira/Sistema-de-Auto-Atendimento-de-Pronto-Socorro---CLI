public class PilhaAtendimentos {
    private NoAtendimento topo;

    public void push(Atendimento a){
        NoAtendimento novo = new NoAtendimento(a);
        novo.proximo = topo;
        topo = novo;
    }
    public Atendimento pop(){
        if (topo == null ) {
            return null;
        }

        Atendimento a = topo.dado;
        topo = topo.proximo;
        return a;
    }

    public void exibirHistorico(){
        NoAtendimento atual = topo;

        System.out.println("====================================");
        if (atual == null) {
            System.out.println("Todos ja foram atendidos ou nenhum atendimento foi cadastrado");
            return;
        }
        

        while (atual != null) {
            System.out.println("Atendimento: " + atual.dado.id);
            atual = atual.proximo;
        }
        System.out.println("====================================");
    }

}
