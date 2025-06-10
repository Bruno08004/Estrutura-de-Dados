package src.Arvore_Heap_Binaria_Dinamica;

import src.Lista_Dinamica.OverflowException;
import src.Lista_Dinamica.UnderflowException;

import java.util.NoSuchElementException;

public class ArvoreBinariaHeapMaximo<T> implements Amontoavel<T>{
    private T[] dados;
    private  int ponteiroFim;

    public ArvoreBinariaHeapMaximo(int tamanho) {
        this.dados = (T[]) new Object[tamanho];
        this.ponteiroFim = -1;
    }

    public ArvoreBinariaHeapMaximo() {
        this(10);
    }

    @Override
    public void inserir(T dado) {
        if (estaCheia()){
            throw new OverflowException("Heap Cheia");
        }
        ponteiroFim++;
        dados[ponteiroFim] = dado;
        ajustarAcima(ponteiroFim);
    }

    @Override
    public T obterRaiz() {
        if(estaVazia()) {
            throw new NoSuchElementException("Heap está vazia!");
        }
        return (T)dados[0];
    }

    @Override
    public T extrair() {
        if(estaVazia()) {
            throw new UnderflowException("Heap vazia");
        }
        T dadoRaiz = dados[0];
        dados[0] = dados[ponteiroFim];
        ponteiroFim--;
        return dadoRaiz;
    }



    @Override
    public String imprmir() {
        return "";
    }

    @Override
    public boolean estaCheia() {
        return ();
    }

    @Override
    public boolean estaVazia() {
        return false;
    }

}
