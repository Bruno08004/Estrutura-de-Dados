package Fila_Estatica.Fila_Circular;

import Fila_Estatica.Fila.Enfileravel;

public class FilaEstaticaCircular implements Enfileravel {

    private Object[] dados;
    private int ponteiroInicio; //cabeça = head
    private int ponteiroFim; //cauda = tail
    private int quantidade;

    public FilaEstaticaCircular() {
        this(10);
    }

    public FilaEstaticaCircular(int tamanho) {
        this.dados = new Object[tamanho];
        this.ponteiroInicio = 0;
        this.ponteiroFim = -1;
        this.quantidade = 0;
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
        if (!estaCheia()) {
            ponteiroFim = (ponteiroFim + 1) % dados.length; //Mesma condição realizada no método desenfileirar()
            dados[ponteiroFim] = dado;
            quantidade++;
        } else {
            System.err.println("Queue is empty!");
        }

    }

    @Override
    public Object desenfileirar() {
        Object aux = null;
        if (!estaVazia()) {
            aux = dados[ponteiroInicio];
            ponteiroInicio = (ponteiroInicio + 1) % dados.length; //Forma para garantir a condição de que o ponteiroInicio seja diferente do tamanho da fila e funcionar de forma circular
            /*
            if (ponteiro == dados.length)  ----> Forma menos usual
               ponteiroInicio == 0
             */
            quantidade--;
        } else {
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
        return (quantidade == dados.length);
    }

    @Override
    public boolean estaVazia() {
        return (quantidade == 0);
    }

    @Override
    public String imprimir() {
        String retorno = "[";

        for (int i = ponteiroInicio; i < quantidade + ponteiroInicio; i++) {
          /*
           if (i == dados.length){ ---> Forma menos usual para o cenário, mas serve da mesma forma.
                i = 0;
            }
            */
            if (i == quantidade + ponteiroInicio - 1) {
                retorno += dados[i % dados.length];
            } else {
                retorno += dados[i % dados.length] + ",";
            }
        }

        return retorno + "]";
    }
}
