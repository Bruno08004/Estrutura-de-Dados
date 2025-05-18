package Pilha_Estatica.Pilha_Invertida;

public interface EmpilhavelInvertida {

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
