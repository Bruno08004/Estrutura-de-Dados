package Pilha_com_Filas;

import Pilha_Estatica.Pilha.Empilhavel;

public class PilhaComFilasPrincipal {
    public static void main(String[] args) {
        Empilhavel p1 = new PilhaComFilas(20);
        p1.empilhar("A");
        p1.empilhar("B");
        p1.empilhar("C");
        System.out.println(p1.imprimir());
        p1.desempilhar();
        System.out.println(p1.imprimir());
        p1.atualizar("D");
        System.out.println(p1.imprimir());
        System.out.println(p1.espiar());
    }
}
