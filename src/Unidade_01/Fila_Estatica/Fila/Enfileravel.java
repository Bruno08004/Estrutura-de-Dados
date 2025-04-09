package Unidade_01.Fila_Estatica.Fila;

/*
Fila (Queue)
Fila Circular (Cycle Queue)
Fila com Dupla Terminação (DeQUE) Double Ended Queue
 */

public interface Enfileravel {

    void enfileirar(Object dado);     //Creat - enqueue

    Object frente();       //Read  - front

    void atualizarInicio(Object dado);    //Update - update

    void atualizarFim(Object dado);    //Update - update

    Object desenfileirar();   //Remove - dequeue

    boolean estaCheia();

    boolean estaVazia();

    String imprimir();


}
