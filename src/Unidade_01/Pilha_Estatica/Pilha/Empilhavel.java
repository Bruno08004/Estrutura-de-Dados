package Unidade_01.Pilha_Estatica.Pilha;


public interface Empilhavel {
    //operações principais
    void empilhar(Object dado); //push
    Object desempilhar(); //pop
    Object espiar();  //peek
    void atualizar(Object dado); //update

    //operações auxiliares
    boolean estaCheia(); //isFull  //overflow
    boolean estaVazia(); //isEmpty  //underflow
    String imprimir();  //print

}
