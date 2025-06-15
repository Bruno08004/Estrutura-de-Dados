package src.Arvore_Heap_Binaria_Máxima;
//Heap = monte
// Heapify = Organizar dados na forma de uma Heap
//Heapifiable = Amontoavel
/**
 * Interface que define as operações básicas para uma estrutura de dados do tipo heap (montículo).
 *
 * @param <T> o tipo de elemento armazenado na heap.
 * @author Bruno Campos Penha
 * @since 15/06/2024
 * @version 1.0
 */
public interface Amontoavel<T> {

    /**
     * Insere um novo dado na heap.
     *
     * @param dado o elemento a ser inserido.
     */
    void inserir(T dado);

    /**
     * Retorna a raiz da heap (o maior ou menor elemento, dependendo do tipo de heap),
     * sem removê-la da estrutura.
     *
     * @return o elemento na raiz da heap.
     */
    T obterRaiz();

    /**
     * Remove e retorna a raiz da heap, reorganizando a estrutura para manter suas propriedades.
     *
     * @return o elemento removido da raiz da heap.
     */
    T extrair();

    /**
     * Retorna uma representação textual da heap.
     *
     * @return uma string contendo os elementos da heap.
     */
    String imprmir();

    /**
     * Verifica se a heap está cheia (caso um limite de capacidade tenha sido definido).
     *
     * @return {@code true} se a heap estiver cheia, {@code false} caso contrário.
     */
    boolean estaCheia();

    /**
     * Verifica se a heap está vazia.
     *
     * @return {@code true} se a heap estiver vazia, {@code false} caso contrário.
     */
    boolean estaVazia();
}

