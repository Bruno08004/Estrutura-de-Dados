package Pilha_Estatica.Pilha_Invertida;

import Pilha_Estatica.Pilha.Empilhavel;

public class PilhaInvertida implements Empilhavel {

    private Object[] dados;
    private int ponteiroTopo;

    public PilhaInvertida() {
        this(10); //toda vez que chamamos outro construtor dentro deste construtor utilizamos o this()
    }

    public PilhaInvertida(int tamanho) {
        dados = new Object[tamanho];
        ponteiroTopo = tamanho;
    }

    @Override
    public void empilhar(Object dado) {
        if (!estaCheia()) {
            ponteiroTopo--;
            dados[ponteiroTopo] = dado;
        } else {
            System.err.println("Stack is full!");
        }
    }

    @Override
    public Object desempilhar() {
        Object aux = null;
        if (!estaVazia()) {
            aux = dados[ponteiroTopo];
            ponteiroTopo++;
            dados[ponteiroTopo] = null;
        } else {
            System.err.println("Stack is empty!");
        }
        return aux;
    }

    @Override
    public Object espiar() {
        Object aux = null;
        if (!estaVazia()) {
            aux = dados[ponteiroTopo];
        } else {
            System.out.println("Stack is empty!");
        }
        return aux;
    }

    @Override
    public void atualizar(Object dado) {
        if (!estaVazia()) {
            dados[ponteiroTopo] = dado;
        } else {
            System.err.println("Stack is empty!");
        }
    }

    //métodos auxiliares
    @Override
    public boolean estaCheia() {
        return (ponteiroTopo == 0);
    }

    @Override
    public boolean estaVazia() {
        return (ponteiroTopo == dados.length);
    }

    @Override
    public String imprimir() {
        String aux = "´[";
        for (int i = ponteiroTopo; i < dados.length ; i++) {
            if (i == dados.length - 1)
                aux += dados[i];
            else
                aux += dados[i] + ",";
        }
        return aux + "]";
    }
}

