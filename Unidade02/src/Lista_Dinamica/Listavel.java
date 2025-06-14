package src.Lista_Dinamica;

/**
 * Interface que define as operações básicas de uma lista dinâmica genérica.
 * Permite a manipulação de elementos de forma genérica, sem restrição de tipo.
 *
 * @param <T> Tipo genérico dos elementos da lista.
 */
public interface Listavel<T> {

    /**
     * Adiciona um novo elemento ao final da lista.
     *
     * @param dado O dado a ser adicionado.
     */
    void anexar(T dado);

    /**
     * Insere um novo elemento em uma posição específica da lista.
     *
     * @param posicao A posição onde o dado deve ser inserido.
     * @param dado O dado a ser inserido.
     */
    void inserir(int posicao, T dado);

    /**
     * Seleciona um elemento em uma posição específica da lista.
     *
     * @param posicao A posição do elemento a ser selecionado.
     * @return O elemento na posição especificada.
     */
    T selecionar(int posicao);

    /**
     * Seleciona todos os elementos da lista.
     *
     * @return Um array contendo todos os elementos da lista.
     */
    T[] selecionarTodos();

    /**
     * Atualiza o elemento na posição especificada com um novo dado.
     *
     * @param posicao A posição do elemento a ser atualizado.
     * @param novoDado O novo dado a ser inserido.
     */
    void atualizar(int posicao, T novoDado);

    /**
     * Remove o elemento na posição especificada da lista.
     *
     * @param posicao A posição do elemento a ser removido.
     * @return O elemento removido.
     */
    T apagar(int posicao);

    /**
     * Remove o primeiro elemento da lista.
     *
     * @return O primeiro elemento removido.
     */
    boolean estaCheia();

    /**
     * Verifica se a lista está vazia.
     *
     * @return true se a lista estiver vazia, false caso contrário.
     */
    boolean estaVazia();

    /**
     * Imprime os elementos da lista em formato de string.
     *
     * @return Uma string representando os elementos da lista.
     */
    String imprimir();

}
