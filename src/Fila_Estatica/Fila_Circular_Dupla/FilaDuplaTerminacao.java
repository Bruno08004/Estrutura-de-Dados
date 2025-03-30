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
            ponteiroInicio = (ponteiroInicio + 1) % dados.length;
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
            ponteiroFim = (ponteiroFim - 1 + dados.length) % dados.length; // Corrigido
            quantidade--;
        } else {
            System.err.println("Queue is empty!");
        }
        return aux;
    }

    @Override
    public void enfileirarInicio(Object dado) {
        if (!estaCheia()) {
            ponteiroInicio = (ponteiroInicio - 1 + dados.length) % dados.length; // Corrigido
            dados[ponteiroInicio] = dado;
            quantidade++;
        } else {
            System.err.println("Queue is full!");
        }
    }

    @Override
    public void enfileirarFim(Object dado) {
        if (!estaCheia()) {
            ponteiroFim = (ponteiroFim + 1) % dados.length;
            dados[ponteiroFim] = dado;
            quantidade++;
        } else {
            System.err.println("Queue is empty!");
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

        for (int i = ponteiroInicio; i < quantidade + ponteiroInicio; i++) {
            if (i == quantidade + ponteiroInicio - 1) {
                retorno += dados[i % dados.length];
            } else {
                retorno += dados[i % dados.length] + ",";
            }
        }

        return retorno + "]";
    }

    @Override
    public String imprimirTrasFrente() {
        String retorno = "[";

        int i = ponteiroFim;
        for (int count = 0; count < quantidade; count++) {
            retorno += dados[i];  // Adiciona o elemento atual

            if (count < quantidade - 1) {
                retorno += ","; // Adiciona vírgula entre os elementos
            }

            i = (i - 1 + dados.length) % dados.length; // Decremento circular
        }

        return retorno + "]";
    }



}
