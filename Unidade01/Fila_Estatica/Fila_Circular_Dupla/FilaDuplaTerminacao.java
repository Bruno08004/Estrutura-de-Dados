package Fila_Estatica.Fila_Circular_Dupla;

//Implementação de DeQueue - Double Ended Queue

public class FilaDuplaTerminacao implements DuplamenteEnfileiravel {

    private Object[] dados;
    private int ponteiroInicio; //cabeça = head
    private int ponteiroFim; //cauda = tail
    private int quantidade;

    public FilaDuplaTerminacao() {
        this(10);
    }

    public FilaDuplaTerminacao(int tamanho) {
        this.dados = new Object[tamanho];
        this.ponteiroInicio = 0;
        this.ponteiroFim = -1;
        this.quantidade = 0;
    }

    @Override
    public Object frente() {
        Object aux = null;
        if (!estaVazia()) {
            aux = dados[ponteiroInicio];
        } else {
            System.err.println("Queue is empty!");
        }
        return aux;
    }

    @Override
    public Object tras() {
        Object aux = null;
        if (!estaVazia()) {
            aux = dados[ponteiroFim];
        } else {
            System.err.println("Queue is empty!");
        }
        return aux;
    }

    @Override
    public Object desenfileirarInicio() {
        Object aux = null;
        if (!estaVazia()) {
            aux = dados[ponteiroInicio];
            ponteiroInicio = avancar(ponteiroInicio);
            quantidade--;
        } else {
            System.err.println("Queue is empty!");
        }

        return aux;
    }

    public Object desenfileirarFim() {
        Object aux = null;
        if (!estaVazia()) {
            aux = dados[ponteiroFim];
            ponteiroFim = retroceder(ponteiroFim);
            quantidade--;
        } else {
            System.err.println("Queue is empty!");
        }
        return aux;
    }

    @Override
    public void enfileirarInicio(Object dado) {
        if (!estaCheia()) {
            ponteiroInicio = retroceder(ponteiroInicio);
            dados[ponteiroInicio] = dado;
            quantidade++;
        } else {
            System.err.println("Queue is full!");
        }
    }

    @Override
    public void enfileirarFim(Object dado) {
        if (!estaCheia()) {
            ponteiroFim = avancar(ponteiroFim); //Mesma condição realizada no método desenfileirar()
            dados[ponteiroFim] = dado;
            quantidade++;
        } else {
            System.err.println("Queue is full!");
        }

    }

    @Override
    public void atualizarInicio(Object dado) {
        if (!estaVazia()) {
            dados[ponteiroInicio] = dado;
        } else {
            System.err.println("Queue is empty!");
        }
    }

    @Override
    public void atualizarFim(Object dado) {
        if (!estaVazia()) {
            dados[ponteiroFim] = dado;
        } else {
            System.err.println("Queue is empty!");
        }
    }

    @Override
    public boolean estaCheia() {
        return (quantidade == dados.length);
    }

    @Override
    public boolean estaVazia() {
        return (quantidade == 0);
    }

    @Override
    public String imprimirFrenteTras() {
        String retorno = "[";
        int ponteiroAux = ponteiroInicio;

        for (int i = 0; i < quantidade; i++) {
            if (i == quantidade - 1) {
                retorno += dados[ponteiroAux];
            } else {
                retorno += dados[ponteiroAux] + ",";

                ponteiroAux = avancar(ponteiroAux);
            }
        }

        return retorno + "]";
    }

    @Override
    public String imprimirTrasFrente() {
        String retorno = "[";
        int ponteiroAux = ponteiroFim;

        for (int i = 0; i < quantidade; i++) {
            if (i == quantidade - 1) {
                retorno += dados[ponteiroAux];
            } else {
                retorno += dados[ponteiroAux] + ",";

                ponteiroAux = retroceder(ponteiroAux);
            }
        }

        return retorno + "]";
    }

    public int avancar(int ponteiro) {
        return (ponteiro + 1) % dados.length;
    }

    public int retroceder(int ponteiro){
        return ((ponteiro - 1)+ dados.length) % dados.length;
    }

}
