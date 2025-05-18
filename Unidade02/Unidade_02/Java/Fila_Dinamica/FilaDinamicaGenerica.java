package Unidade_02.Java.Fila_Dinamica;

import java.util.NoSuchElementException;

public class FilaDinamicaGenerica<T> implements Enfileiravel<T> {
    private NodoDuplo<T> ponteiroInicio;
    private NodoDuplo<T> ponteiroFim;
    private int quantidade;
    private int tamanho;

    public FilaDinamicaGenerica() {
        this(10);
    }

    public FilaDinamicaGenerica(int tamanho) {
        this.ponteiroInicio = null;
        this.ponteiroFim = null;
        this.quantidade = 0;
        this.tamanho = tamanho;
    }

    @Override
    public void enfileirarInicio(T dado) {
        throw new UnsupportedOperationException("Operação não suportada!");
    }

    @Override
    public T tras() {
        throw new UnsupportedOperationException("Operação não suportada!");

    }

    @Override
    public T desenfileirarFim() {
        throw new UnsupportedOperationException("Operação não suportada!");

    }

    @Override
    public String imprimirDeTrasPraFrente() {
        throw new UnsupportedOperationException("Operação não suportada!");

    }

    @Override
    public void enfileirarFim(T dado) {
        if (estaCheia()) {
            throw new NoSuchElementException("Fila cheia!");
        }
        NodoDuplo<T> novoNodo = new NodoDuplo<>();
        novoNodo.setDado(dado);
        novoNodo.setAnterior(ponteiroFim);
        if (!estaVazia()) {
            ponteiroFim.setProximo(novoNodo);
        } else {
            ponteiroInicio = novoNodo;
        }
        ponteiroFim = novoNodo;
        quantidade++;

    }

    @Override
    public T frente() {
        if (estaVazia()) {
            throw new NoSuchElementException("Fila vazia!");
        }
        return ponteiroInicio.getDado();
    }

    @Override
    public void atualizarInicio(T dado) {
        if (estaVazia()) {
            throw new NoSuchElementException("Fila vazia!");
        }
        ponteiroInicio.setDado(dado);
    }

    @Override
    public void atualizarFim(T dado) {
        if (estaVazia()) {
            throw new NoSuchElementException("Fila vazia!");
        }
        ponteiroFim.setDado(dado);
    }

    @Override
    public T desenfileirarInicio() {
        if (estaVazia()) {
            throw new NoSuchElementException("Fila vazia!");
        }

        T dadoInicio = ponteiroInicio.getDado();
        ponteiroInicio = ponteiroInicio.getProximo();
        ponteiroInicio.setAnterior(null);
        quantidade--;
        return dadoInicio;
    }

    @Override
    public boolean estaCheia() {
        return quantidade == tamanho;
    }

    @Override
    public boolean estaVazia() {
        return quantidade == 0;
    }

    @Override
    public String imprimirDeFrentePraTras() {
        String aux = "[";
        NodoDuplo<T> ponteiroAux = ponteiroInicio;
        for (int i = 0; i < quantidade; i++) {
            aux += ponteiroAux.getDado();

            if (i != quantidade - 1){
                aux += ",";
            }

            ponteiroAux = ponteiroAux.getProximo();
        }
        return aux + "]";
    }
}
