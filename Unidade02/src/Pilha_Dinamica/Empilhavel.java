package src.Pilha_Dinamica;

/**
 * Interface que define as operações básicas para estruturas de dados do tipo pilha.
 *
 * <p>Implementações dessa interface devem garantir a manipulação dos elementos conforme o
 * comportamento LIFO (Last-In, First-Out). Ou seja, o último elemento inserido é o primeiro a ser removido.</p>
 *
 * @param <T> o tipo de dado armazenado na pilha
 *
 * @author Bruno Campos Penha
 * @since 2025-05-19
 * @version 1.0
 */
public interface Empilhavel<T> {

    /**
     * Adiciona um elemento ao topo da pilha.
     *
     * @param dado o dado a ser empilhado
     */
    void empilhar(T dado);

    /**
     * Remove e retorna o elemento do topo da pilha.
     *
     * @return o dado removido do topo da pilha
     */
    T desempilhar();

    /**
     * Retorna o elemento do topo da pilha sem removê-lo.
     *
     * @return o dado do topo da pilha
     */
    T espiar();

    /**
     * Atualiza o valor armazenado no topo da pilha.
     *
     * @param dado o novo valor a ser atribuído ao topo
     */
    void atualizar(T dado);

    /**
     * Verifica se a pilha está vazia.
     *
     * @return {@code true} se não houver elementos na pilha; caso contrário, {@code false}
     */
    boolean estaVazia();

    /**
     * Verifica se a pilha atingiu sua capacidade máxima.
     *
     * @return {@code true} se a pilha estiver cheia; caso contrário, {@code false}
     */
    boolean estaCheia();

    /**
     * Retorna uma representação textual dos elementos da pilha.
     *
     * @return uma {@code String} com os elementos empilhados
     */
    String imprimir();
}
