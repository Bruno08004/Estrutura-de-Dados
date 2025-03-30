package Fila_Estatica.Fila;

public class FilaEstatica implements Enfileravel {

    private Object[] dados;
    private int ponteiroInicio; //cabeça = head
    private int ponteiroFim; //cauda = tail

    public FilaEstatica() {
        this(10);
    }

    public FilaEstatica(int tamanho) {
        this.dados = new Object[tamanho];
        this.ponteiroInicio = 0;
        this.ponteiroFim = -1;
    }

    @Override
    public void atualizarInicio(Object dado) {
        if (!estaVazia()) {
            dados[ponteiroInicio] = dado;
        } else {
            System.err.println("A fila está vazia!");
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
    public void enfileirar(Object dado) {
        if (!estaCheia()){
            ponteiroFim++;
            dados[ponteiroFim] = dado;
        } else {
            System.err.println("Queue is empty!");
        }

    }

    @Override
    public Object desenfileirar() {
        Object aux = null;
        if (!estaVazia()) {
            aux = dados[ponteiroInicio];
            ponteiroInicio++;
        }else{
            System.err.println("Queue is empty!");
        }

        return aux;
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
    public boolean estaCheia() {
        return (ponteiroFim == dados.length - 1);
    }

    @Override
    public boolean estaVazia() {
        return (ponteiroFim == ponteiroInicio - 1);
    }

    @Override
    public String imprimir() {
        String retorno = "[";

        for (int i = ponteiroInicio; i <= ponteiroFim; i++) {
            if (i == ponteiroFim) {
                retorno += dados[i];
            } else {
                retorno += dados[i] + ",";
            }
        }

        return retorno + "]";
    }
}
