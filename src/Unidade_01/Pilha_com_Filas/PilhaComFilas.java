package Unidade_01.Pilha_com_Filas;

import Unidade_01.Fila_Estatica.Fila.Enfileravel;
import Unidade_01.Fila_Estatica.Fila_Circular.FilaEstaticaCircular;
import Unidade_01.Pilha_Estatica.Pilha.Empilhavel;


public class PilhaComFilas implements Empilhavel {

    Enfileravel f1;
    Enfileravel f2;


    public PilhaComFilas() {
        this(10);
    }

    public PilhaComFilas(int tamanho) {
        this.f1 = new FilaEstaticaCircular(tamanho);
        this.f2 = new FilaEstaticaCircular(tamanho);
    }


    @Override
    public void empilhar(Object dado) {
        if (!estaCheia()) {
            while (!f1.estaVazia()) {
                f2.enfileirar(f1.desenfileirar());
            }
            f1.enfileirar(dado);
            while (!f2.estaVazia()) {
                f1.enfileirar(f2.desenfileirar());
            }
        } else {
            System.err.println("Stack is full!");
        }
    }

    @Override
    public Object desempilhar() {
        Object aux = null;
        if (!estaVazia()) {
            aux = f1.desenfileirar();
        } else {
            System.err.println("Stack is empty!");
        }

        return aux;
    }

    @Override
    public Object espiar() {
        Object aux = null;
        if (!estaVazia()) {
            aux = f1.frente();
        } else {
            System.err.println("Stack is empty!");
        }

        return aux;
    }

    @Override
    public void atualizar(Object dado) {
        if (!estaCheia()) {
            f1.atualizarInicio(dado);
        } else {
            System.err.println("Stack is full!");
        }
    }

    @Override
    public boolean estaCheia() {
        return f1.estaCheia();
    }

    @Override
    public boolean estaVazia() {
        return f1.estaVazia();
    }

    @Override
    public String imprimir() {
        return f1.imprimir();
    }
}
