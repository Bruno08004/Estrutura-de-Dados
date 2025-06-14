package src.Lista_Dinamica;

/**
 * Interface que define as operações básicas de uma lista dinâmica genérica.
 * Permite a manipulação de elementos de forma genérica, sem restrição de tipo.
 *
 * @param <T> Tipo genérico dos elementos da lista.
 */
public class NodoDuplo<T> {

    private NodoDuplo<T> anterior;
    private NodoDuplo<T> proximo;
    private T dado;


    /**
     * Construtor padrão que inicializa um nodo duplo.
     */
    public NodoDuplo<T> getAnterior() {
        return anterior;
    }

    /**
     * Construtor padrão que inicializa um nodo duplo.
     */
    public void setAnterior(NodoDuplo<T> anterior) {
        this.anterior = anterior;
    }

    /**
     * Construtor padrão que inicializa um nodo duplo.
     */
    public NodoDuplo<T> getProximo() {
        return proximo;
    }

    /**
     * Construtor padrão que inicializa um nodo duplo.
     */
    public void setProximo(NodoDuplo<T> proximo) {
        this.proximo = proximo;
    }

    /**
     * Construtor padrão que inicializa um nodo duplo.
     */
    public T getDado() {
        return dado;
    }

    /**
     * Construtor padrão que inicializa um nodo duplo.
     */
    public void setDado(T dado) {
        this.dado = dado;
    }
}
