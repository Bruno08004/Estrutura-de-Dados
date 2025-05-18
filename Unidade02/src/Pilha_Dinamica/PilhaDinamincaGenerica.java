package src.Pilha_Dinamica;

import java.util.NoSuchElementException;

/**
 * O que faz?
 *
 * @param
 * @autor
 * @return
 * @throws nome da exceção
 * @since Documentar cada método com
 * o que faz?
 */
public class PilhaDinamincaGenerica<T> implements Empilhavel<T> {
    private NodoDuplo<T> ponteiroTopo;
    private int quantidade;
    private int tamanho;

    public PilhaDinamincaGenerica() {
        this(10);
    }

    public PilhaDinamincaGenerica(int tamanho) {
        this.ponteiroTopo = null;
        this.tamanho = tamanho;
        this.quantidade = 0;
    }

    @Override
    public void empilhar(T dado) {
        if (estaCheia()){
            throw new NoSuchElementException("Pilha Cheia!");
        }

        NodoDuplo<T> novoNodo = new NodoDuplo<>();
        novoNodo.setDado(dado);
        novoNodo.setAnterior(ponteiroTopo);
        ponteiroTopo.setProximo(novoNodo);
        ponteiroTopo = novoNodo;
        quantidade++;


    }

    @Override
    public T desempilhar() {
        if (estaVazia()){
            throw new NoSuchElementException("Pilha Vazia!");
        }

        T aux = ponteiroTopo.getDado();
        ponteiroTopo = ponteiroTopo.getAnterior();
        ponteiroTopo.setProximo(null);
        quantidade--;
        return aux;

    }

    @Override
    public T espiar() {
        if (estaVazia()){
            throw new NoSuchElementException("Pilha Vazia!");
        }
        return ponteiroTopo.getDado();
    }

    @Override
    public void atualizar(T dado) {
        if (estaVazia()){
            throw new NoSuchElementException("Pilha Vazia!");
        }
        ponteiroTopo.setDado(dado);
    }

    @Override
    public boolean estaVazia() {
        return quantidade == 0;
    }

    @Override
    public boolean estaCheia() {
        return quantidade == tamanho;
    }

    @Override
    public String imprimir() {
        String aux = "[";
        NodoDuplo<T> ponteiroAux = ponteiroTopo;

        for (int i = 0; i < quantidade; i++) {
            aux += ponteiroAux.getDado();

            if (i != quantidade - 1) {
                aux += ",";
                ponteiroAux = ponteiroAux.getAnterior();
            }
        }
        return aux += "]";

    }


}
