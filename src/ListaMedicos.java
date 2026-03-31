class ListaMedicos {
    Medico[] medicos;
    int tamanho;

    public ListaMedicos(int capacidade) {
        medicos = new Medico[capacidade];
        tamanho = 0;
    }

    public void adicionar(Medico m) {
        medicos[tamanho++] = m;
    }

    public Medico getDisponivel() {
        for (int i = 0; i < tamanho; i++) {
            if (medicos[i].disponivel) {
                return medicos[i];
            }
        }
        return null;
    }
}