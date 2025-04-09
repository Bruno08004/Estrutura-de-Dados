package Unidade_01.Fila_com_Pilhas;

import Unidade_01.Fila_Estatica.Fila.Enfileravel;
import Unidade_01.Pilha_Estatica.Pilha.Empilhavel;
import Unidade_01.Pilha_Estatica.Pilha.PilhaEstatica;


public class FilaComPilha implements Enfileravel {

    private Empilhavel p1;
    private Empilhavel p2;

    public FilaComPilha() {
        this(10);
    }

    public FilaComPilha(int tamannho) {
        this.p1 = new PilhaEstatica(tamannho);
        this.p2 = new PilhaEstatica(tamannho);
    }


    @Override
    public void enfileirar(Object dado) {
        if (!estaCheia()) {
            p1.empilhar(dado);
        }
    }

    @Override
    public Object frente() {
        Object dadoInicio = null;
        while (!p1.estaVazia()) {
            p2.empilhar(p1.desempilhar());
            dadoInicio = p2.espiar();
        }
        while (!p2.estaVazia()) {
            p1.empilhar(p2.desempilhar());
        }

        return dadoInicio;
    }

    @Override
    public Object desenfileirar() {
        Object dadoInicio = null;
        while (!p1.estaVazia()) {
            p2.empilhar(p1.desempilhar());
            dadoInicio = p2.desempilhar();
        }
        while (!p2.estaVazia()) {
            p1.empilhar(p2.desempilhar());
        }

        return dadoInicio;
    }

    @Override
    public void atualizarInicio(Object dado) {
        while (!p1.estaVazia()) {
            p2.empilhar(p1.desempilhar());
        }

        p2.atualizar(dado);

        while (!p2.estaVazia()) {
            p1.empilhar(p2.desempilhar());
        }

    }

    @Override
    public void atualizarFim(Object dado) {
        if (!p1.estaVazia()) {
            p1.atualizar(dado);
        }

    }

    @Override
    public boolean estaCheia() {
        return p1.estaCheia();
    }

    @Override
    public boolean estaVazia() {
        return p1.estaVazia();
    }

    @Override
    public String imprimir() {
        String retorno = "[";
        while (!p1.estaVazia()) {
            p2.empilhar(p1.desempilhar());
        }
        while (!p2.estaVazia()) {
            retorno += p2.espiar() + ",";
            p1.empilhar(p2.desempilhar());
        }
        return retorno + "]";
    }
}
