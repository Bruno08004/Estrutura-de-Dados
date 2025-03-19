package Pilha_Estatica.Pilha_Invertida;

public interface Empilhavel {

    //operações principais
    void empilhar(Object dado); //push
    Object desempilhar(); //pop
    Object espiar();  //peek
    void atualizar(Object dado);

    //operações auxiliares
    boolean estaCheia(); //isFull  //overflow
    boolean estaVazia(); //isEmpty  //underflow
    String imprimir();  //print

}
