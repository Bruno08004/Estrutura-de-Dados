package src.Fila_Dinamica;


/**
 * Classe que representa um nodo duplo genérico para uso em estruturas de dados
 * como pilhas e filas dinâmicas.
 *
 * @param <T> o tipo de dado armazenado no nodo
 * @author Bruno Campos Penha
 * @version 1.0
 * @since 2025-05-19
 */


public class NodoDuplo<T> {

    private NodoDuplo<T> anterior;
    private T dado;
    private NodoDuplo<T> proximo;


    //getters e setters

    /**
     * Retorna o nodo anterior.
     *
     * @return o nodo anterior
     */
    public NodoDuplo<T> getAnterior() {
        return anterior;
    }

    /**
     * Define o nodo anterior.
     *
     * @param anterior o nodo anterior a ser definido
     */
    public void setAnterior(NodoDuplo<T> anterior) {
        this.anterior = anterior;
    }

    /**
     * Retorna o dado armazenado no nodo.
     *
     * @return o dado armazenado
     */
    public T getDado() {
        return dado;
    }

    /**
     * Define o dado armazenado no nodo.
     *
     * @param dado o dado a ser armazenado
     */
    public void setDado(T dado) {
        this.dado = dado;
    }

    /**
     * Retorna o próximo nodo.
     *
     * @return o próximo nodo
     */
    public NodoDuplo<T> getProximo() {
        return proximo;
    }

    /**
     * Define o próximo nodo.
     *
     * @param proximo o próximo nodo a ser definido
     */
    public void setProximo(NodoDuplo<T> proximo) {
        this.proximo = proximo;
    }
}

