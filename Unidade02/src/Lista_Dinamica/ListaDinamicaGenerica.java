package src.Lista_Dinamica;

import src.exception.OverflowException;
import src.exception.UnderflowException;

/**
 * Classe que implementa uma lista dinâmica genérica com nós duplamente encadeados.
 * Permite operações de inserção, remoção, atualização e seleção de elementos.
 *
 * @param <T> Tipo genérico dos elementos da lista.
 * @author Bruno Campos Penha
 * @since 14/06/2025
 * @version 1.0
 */

public class ListaDinamicaGenerica<T> implements Listavel<T> {

    private NodoDuplo<T> ponteiroInicio;
    private NodoDuplo<T> ponteiroFim;
    private int quantidade;
    private int tamanho;

    /**
     * Construtor padrão que inicializa a lista com capacidade para 10 elementos.
     */
    public ListaDinamicaGenerica() {
        this(10);
    }

    /**
     * Construtor que permite definir o tamanho máximo da lista.
     *
     * @param tamanho O número máximo de elementos que a lista pode conter.
     */
    public ListaDinamicaGenerica(int tamanho) {
        this.ponteiroInicio = null;
        this.ponteiroFim = null;
        this.quantidade = 0;
        this.tamanho = tamanho;
    }


    /**
     * Adiciona um novo elemento ao início da lista.
     *
     * @param dado O dado a ser adicionado.
     * @throws OverflowException Se a lista já estiver cheia.
     */
    @Override
    public void anexar(T dado) {
        if (estaCheia()) {
            throw new OverflowException("Lista Cheia!");
        }
        NodoDuplo<T> noTemp = new NodoDuplo<>();
        noTemp.setDado(dado);
        noTemp.setAnterior(ponteiroFim);
        if (!estaVazia()) {
            ponteiroFim.setProximo(noTemp);
        } else {
            ponteiroInicio = noTemp;
        }
        ponteiroFim = noTemp;
        quantidade++;
    }

    /**
     * Adiciona um novo elemento ao início da lista.
     *
     * @param dado O dado a ser adicionado.
     * @throws OverflowException Se a lista já estiver cheia.
     */
    @Override
    public void inserir(int posicao, T dado) {
        if (estaVazia()) {
            throw new UnderflowException("Lista Vazia!");
        }
        if (posicao < 0 || posicao > quantidade) {
            throw new IndexOutOfBoundsException("Posicao Invalida!");
        }
        NodoDuplo<T> noTemp = new NodoDuplo<>();
        noTemp.setDado(dado);

        NodoDuplo<T> ponteiroAnterior = null;
        NodoDuplo<T> ponteiroProximo = ponteiroInicio;

        NodoDuplo<T> ponteiroAuxiliar = ponteiroInicio;
        for (int i = 0; i < posicao; i++) {
            ponteiroAnterior = ponteiroProximo;
            ponteiroAuxiliar = ponteiroAuxiliar.getProximo();
        }

        if (ponteiroAnterior != null) {
            ponteiroAnterior.setProximo(noTemp);
        } else {
            ponteiroInicio = noTemp;
        }

        if (ponteiroProximo != null) {
            ponteiroProximo.setAnterior(noTemp);
        } else {
            ponteiroFim = noTemp;
        }

        noTemp.setAnterior(ponteiroAnterior);
        noTemp.setProximo(ponteiroProximo);
        quantidade++;
    }

    /**
     * Seleciona todos os elementos da lista e os retorna em um array.
     *
     * @return Um array contendo todos os elementos da lista.
     * @throws UnderflowException Se a lista estiver vazia.
     */
    @Override
    public T[] selecionarTodos() {
        if (estaVazia()) {
            throw new OverflowException("Lista Vazia!");
        }
        T[] dados = (T[]) new Object[quantidade];
        NodoDuplo<T> ponteiroAuxiliar = ponteiroInicio;
        for (int i = 0; i < quantidade; i++) {
            dados[i] = ponteiroAuxiliar.getDado();
            ponteiroAuxiliar = ponteiroAuxiliar.getProximo();
        }
        return dados;
    }

    /**
     * Atualiza o elemento na posição especificada com um novo dado.
     *
     * @param posicao  A posição do elemento a ser atualizado.
     * @param novoDado O novo dado a ser inserido.
     * @throws UnderflowException        Se a lista estiver vazia.
     * @throws IndexOutOfBoundsException Se a posição for inválida.
     */
    @Override
    public void atualizar(int posicao, T novoDado) {
        if (estaVazia()) {
            throw new UnderflowException("Lista Vazia!");
        }
        if (posicao < 0 || posicao >= quantidade) {
            throw new IndexOutOfBoundsException("Posição Inválida!");
        }
        NodoDuplo<T> ponteiroAuxiliar = ponteiroInicio;
        for (int i = 0; i < posicao; i++) {
            ponteiroAuxiliar = ponteiroAuxiliar.getProximo();
        }
        ponteiroAuxiliar.setDado(novoDado);
    }

    /**
     * Seleciona um elemento na posição especificada.
     *
     * @param posicao A posição do elemento a ser selecionado.
     * @return O elemento na posição especificada.
     * @throws UnderflowException        Se a lista estiver vazia.
     * @throws IndexOutOfBoundsException Se a posição for inválida.
     */
    @Override
    public T selecionar(int posicao) {
        if (estaVazia()) {
            throw new UnderflowException("Lista Vazia!");
        }
        if (posicao < 0 || posicao >= quantidade) {
            throw new IndexOutOfBoundsException("Índice fora dos limites");
        }
        NodoDuplo<T> ponteiroAuxiliar = ponteiroInicio;
        for (int i = 0; i < posicao; i++) {
            ponteiroAuxiliar = ponteiroAuxiliar.getProximo();
        }
        return ponteiroAuxiliar.getDado();
    }

    /**
     * Remove e retorna o elemento na posição especificada.
     *
     * @param posicao A posição do elemento a ser removido.
     * @return O elemento removido.
     * @throws UnderflowException        Se a lista estiver vazia.
     * @throws IndexOutOfBoundsException Se a posição for inválida.
     */
    @Override
    public T apagar(int posicao) {
        if (estaVazia()) {
            throw new UnderflowException("Lista Vazia!");
        }
        if (posicao < 0 || posicao > quantidade) {
            throw new IndexOutOfBoundsException("Posição Inválida!");
        }
        NodoDuplo<T> ponteiroAuxiliar = ponteiroInicio;
        for (int i = 0; i < posicao; i++) {
            ponteiroAuxiliar = ponteiroAuxiliar.getProximo();
        }
        NodoDuplo<T> ponteiroAnterior = ponteiroAuxiliar.getAnterior();
        NodoDuplo<T> ponteiroProximo = ponteiroAuxiliar.getProximo();

        if (ponteiroAnterior != null) {
            ponteiroAnterior.setProximo(ponteiroProximo);
        } else {
            ponteiroInicio = ponteiroProximo;
        }

        if (ponteiroProximo != null) {
            ponteiroProximo.setAnterior(ponteiroAnterior);
        } else {
            ponteiroFim = ponteiroAnterior;
        }

        quantidade--;
        return ponteiroAuxiliar.getDado();
    }

    /**
     * Verifica se a lista está cheia.
     *
     * @return {@code true} se a lista estiver cheia; caso contrário, {@code false}.
     */
    @Override
    public boolean estaCheia() {
        return quantidade == tamanho;
    }

    /**
     * Verifica se a lista está vazia.
     *
     * @return {@code true} se a lista estiver vazia; caso contrário, {@code false}.
     */
    @Override
    public boolean estaVazia() {
        return quantidade == 0;
    }

    /**
     * Retorna o número de elementos na lista.
     *
     * @return O número de elementos na lista.
     */
    @Override
    public String imprimir() {
        String retorno = "[";
        NodoDuplo<T> aux = ponteiroInicio;
        for (int i = 0; i < quantidade; i++) {
            retorno += aux.getDado();

            if (i < quantidade - 1) {
                retorno += ", ";
            }
            aux = aux.getProximo();
        }
        return retorno + "]";
    }
}
