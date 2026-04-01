public class ListaAtendimentos {
    NoAtendimentoDuplo inicio;
    NoAtendimentoDuplo fim;

    public void adicionar(Atendimento a) {
        NoAtendimentoDuplo novo = new NoAtendimentoDuplo(a);

        if (inicio == null) {
            inicio = fim = novo;
        } else {
            fim.proximo = novo;
            novo.anterior = fim;
            fim = novo;
        }
    }

    public void exibirOrdem() {
        if (inicio == null) {
            System.out.println("Nenhum atendimento realizado.");
            return;
        }

        NoAtendimentoDuplo atual = inicio;

        while (atual != null) {
            System.out.println(
                "ID: " + atual.dado.id +
                "ID do Paciente: " + atual.dado.paciente.idPaciente +
                " | Paciente: " + atual.dado.paciente.nome
            );
            atual = atual.proximo;
        }
    }

}
