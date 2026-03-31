class ListaProntuarios {
    NoProntuario inicio;
    NoProntuario atual;

    public void adicionar(Prontuario p) {
        NoProntuario novo = new NoProntuario(p);

        if (inicio == null) {
            inicio = atual = novo;
        } else {
            NoProntuario temp = inicio;
            while (temp.proximo != null) {
                temp = temp.proximo;
            }
            temp.proximo = novo;
            novo.anterior = temp;
        }
    }

    public void exibirAtual() {
        if (atual != null) {
            atual.dado.exibir();
        } else {
            System.out.println("Nenhum prontuário.");
        }
    }

    public void proximo() {
        if (atual != null && atual.proximo != null) {
            atual = atual.proximo;
            atual.dado.exibir();
        } else {
            System.out.println("Não há próximo.");
        }
    }

    public void anterior() {
        if (atual != null && atual.anterior != null) {
            atual = atual.anterior;
            atual.dado.exibir();
        } else {
            System.out.println("Não há anterior.");
        }
    }
}