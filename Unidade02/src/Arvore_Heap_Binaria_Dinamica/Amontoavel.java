package src.Arvore_Heap_Binaria_Dinamica;
//Heap = monte
// Heapify = Organizar dados na forma de uma Heap
//Heapifiable = Amontoavel
public interface Amontoavel<T> {
    void inserir(T dado);
    T obterRaiz();
    T extrair();

    String imprmir();
    boolean estaCheia();
    boolean estaVazia();
}
