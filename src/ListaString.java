class ListaString {
    NoString inicio;

    public void adicionar(String valor) {
        NoString novo = new NoString(valor);

        if (inicio == null) {
            inicio = novo;
        } else {
            NoString atual = inicio;
            while (atual.proximo != null) {
                atual = atual.proximo;
            }
            atual.proximo = novo;
        }
    }

    public void exibir() {
        if (inicio == null) {
            System.out.println("Nenhum medicamento.");
            return;
        }

        NoString atual = inicio;

        while (atual != null) {
            System.out.println("- " + atual.dado);
            atual = atual.proximo;
        }
    }
}