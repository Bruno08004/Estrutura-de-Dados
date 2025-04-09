package Unidade_01.Pilha_Estatica.Pilha_Dupla;

public interface EmpilhavelDupla {

    //operações principais1
    void empilhar1(Object dado); //push
    Object desempilhar1(); //pop
    Object espiar1();  //peek
    void atualizar1(Object dado); //update

    //operações auxiliares1
    boolean estaCheia1(); //isFull  //overflow
    boolean estaVazia1(); //isEmpty  //underflow
    String imprimir1();  //print


   //operações principais2
    void empilhar2(Object dado); //push
    Object desempilhar2(); //pop
    Object espiar2();  //peek
    void atualizar2(Object dado); //update

    //operações auxiliares2
    boolean estaCheia2(); //isFull  //overflow
    boolean estaVazia2(); //isEmpty  //underflow
    String imprimir2();  //print
}
