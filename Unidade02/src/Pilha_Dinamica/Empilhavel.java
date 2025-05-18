package src.Pilha_Dinamica;

public interface Empilhavel<T> {
    void empilhar(T dado);
    T desempilhar();
    T espiar();
    void atualizar(T dado);

    boolean estaVazia();
    boolean estaCheia();
    String imprimir();

}
