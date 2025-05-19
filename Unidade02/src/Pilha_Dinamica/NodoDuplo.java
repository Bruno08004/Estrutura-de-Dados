package src.Pilha_Dinamica;

/**
 * Representa um nó de uma estrutura de dados duplamente encadeada.
 *
 * <p>Esse nó armazena um dado genérico do tipo {@code T}, bem como
 * referências para o nó anterior e o próximo na estrutura.</p>
 *
 * @param <T> o tipo de dado armazenado no nó
 *
 * @author Bruno Campos Penha
 * @version 1.0
 * @since 2025-05-19
 */
public class NodoDuplo<T> {

    private NodoDuplo<T> anterior;
    private T dado;
    private NodoDuplo<T> proximo;

    /**
     * Retorna o nó anterior ao atual na estrutura.
     *
     * @return o nó anterior
     */
    public NodoDuplo<T> getAnterior() {
        return anterior;
    }

    /**
     * Define o nó anterior ao atual na estrutura.
     *
     * @param anterior o nó a ser definido como anterior
     */
    public void setAnterior(NodoDuplo<T> anterior) {
        this.anterior = anterior;
    }

    /**
     * Retorna o dado armazenado no nó.
     *
     * @return o dado do nó
     */
    public T getDado() {
        return dado;
    }

    /**
     * Define o dado armazenado no nó.
     *
     * @param dado o dado a ser armazenado
     */
    public void setDado(T dado) {
        this.dado = dado;
    }

    /**
     * Retorna o próximo nó na estrutura.
     *
     * @return o próximo nó
     */
    public NodoDuplo<T> getProximo() {
        return proximo;
    }

    /**
     * Define o próximo nó na estrutura.
     *
     * @param proximo o nó a ser definido como próximo
     */
    public void setProximo(NodoDuplo<T> proximo) {
        this.proximo = proximo;
    }
}
