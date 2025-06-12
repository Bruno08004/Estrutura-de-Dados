package src.Fila_Dinamica;

import src.exception.OverflowException;
import src.exception.UnderflowException;

/**
 * Implementação de uma Fila Dinâmica Genérica.
 *
 * <p>Essa fila armazena dados genéricos do tipo {@code T} e oferece operações
 * como {@link #enfileirarInicio(Object)}, {@link #enfileirarFim(Object)},
 * {@link #desenfileirarInicio()}, {@link #desenfileirarFim()}, entre outras.
 * Ela faz uso da classe {@link NodoDuplo<T>} para representar os elementos
 * encadeados da fila.</p>
 *
 * @param <T> o tipo de elemento armazenado na fila
 * @author Bruno Campos Penha
 * @version 1.0
 * @since 2025-05-19
 */

public class FilaDinamicaDuplamenteEncadeadaGenerica<T> implements Enfileiravel<T> {
    private NodoDuplo<T> ponteiroInicio;
    private NodoDuplo<T> ponteiroFim;
    private int quantidade;
    private int tamanho;

    /**
     * Construtor padrão. Inicializa a fila com capacidade para 10 elementos.
     */
    public FilaDinamicaDuplamenteEncadeadaGenerica() {
        this(10);
    }

    /**
     * Construtor que permite definir o tamanho máximo da fila.
     *
     * @param tamanho o número máximo de elementos que a fila pode conter
     */
    public FilaDinamicaDuplamenteEncadeadaGenerica(int tamanho) {
        this.ponteiroInicio = null;
        this.ponteiroFim = null;
        this.quantidade = 0;
        this.tamanho = tamanho;
    }

    /**
     * Adiciona um novo elemento no início da fila.
     *
     * @param dado o dado a ser enfileirado
     * @throws OverflowException se a fila estiver cheia
     */
    @Override
    public void enfileirarInicio(T dado) {
        if (estaCheia()) {
            throw new OverflowException("Fila cheia!");
        }
        NodoDuplo<T> novoNodo = new NodoDuplo<>();
        novoNodo.setDado(dado);
        novoNodo.setProximo(ponteiroInicio);
        if (!estaVazia()) {
            ponteiroInicio.setAnterior(novoNodo);
        } else {
            ponteiroFim = novoNodo;
        }
        ponteiroInicio = novoNodo;
        quantidade++;

    }

    /**
     * Remove e retorna o elemento do início da fila.
     *
     * @return o dado removido do início da fila
     * @throws UnderflowException se a fila estiver vazia
     */
    @Override
    public void enfileirarFim(T dado) {
        if (estaCheia()) {
            throw new OverflowException("Fila cheia!");
        }
        NodoDuplo<T> novoNodo = new NodoDuplo<>();
        novoNodo.setDado(dado);
        novoNodo.setAnterior(ponteiroFim);
        if (!estaVazia()) {
            ponteiroFim.setProximo(novoNodo);
        } else {
            ponteiroInicio = novoNodo;
        }
        ponteiroFim = novoNodo;
        quantidade++;

    }

    /**
     * Remove e retorna o elemento do fim da fila.
     *
     * @return o dado removido do fim da fila
     * @throws UnderflowException se a fila estiver vazia
     */
    @Override
    public T desenfileirarFim() {
        if (estaVazia()) {
            throw new UnderflowException("Fila vazia!");
        }
        T elementoFim = ponteiroFim.getDado();
        ponteiroFim = ponteiroFim.getAnterior();
        quantidade--;
        if (!estaVazia()) {
            ponteiroFim.setProximo(null);
        } else {
            ponteiroInicio = null;
        }
        return elementoFim;
    }

    /**
     * Remove e retorna o elemento do início da fila.
     *
     * @return o dado removido do início da fila
     * @throws UnderflowException se a fila estiver vazia
     */
    @Override
    public T desenfileirarInicio() {
        if (estaVazia()) {
            throw new UnderflowException("Fila vazia!");
        }

        T dadoInicio = ponteiroInicio.getDado();
        ponteiroInicio = ponteiroInicio.getProximo();
        quantidade--;
        if (!estaVazia()) {
            ponteiroInicio.setAnterior(null);
        } else {
            ponteiroFim = null;
        }
        return dadoInicio;
    }

    /**
     * Retorna o elemento do fim da fila sem removê-lo.
     *
     * @return o elemento do fim da fila
     * @throws UnderflowException se a fila estiver vazia
     */
    @Override
    public T tras() {
        if (estaVazia()) {
            throw new UnderflowException("Fila vazia!");
        }
        return ponteiroFim.getDado();
    }

    /**
     * Retorna o elemento do início da fila sem removê-lo.
     *
     * @return o elemento do início da fila
     * @throws UnderflowException se a fila estiver vazia
     */
    @Override
    public T frente() {
        if (estaVazia()) {
            throw new UnderflowException("Fila vazia!");
        }
        return ponteiroInicio.getDado();
    }

    /**
     * Atualiza o elemento do início da fila com um novo dado.
     *
     * @param dado o novo dado a ser colocado no início da fila
     * @throws UnderflowException se a fila estiver vazia
     */
    @Override
    public void atualizarInicio(T dado) {
        if (estaVazia()) {
            throw new UnderflowException("Fila vazia!");
        }
        ponteiroInicio.setDado(dado);
    }

    /**
     * Atualiza o elemento do fim da fila com um novo dado.
     *
     * @param dado o novo dado a ser colocado no fim da fila
     * @throws UnderflowException se a fila estiver vazia
     */
    @Override
    public void atualizarFim(T dado) {
        if (estaVazia()) {
            throw new UnderflowException("Fila vazia!");
        }
        ponteiroFim.setDado(dado);
    }

    /**
     * Verifica se a fila está cheia.
     *
     * @return {@code true} se a fila estiver cheia, {@code false} caso contrário
     */
    @Override
    public boolean estaCheia() {
        return quantidade == tamanho;
    }

    /**
     * Verifica se a fila está vazia.
     *
     * @return {@code true} se a fila estiver vazia, {@code false} caso contrário
     */
    @Override
    public boolean estaVazia() {
        return quantidade == 0;
    }

    /**
     * Imprime os elementos da fila do início para o fim.
     *
     * @return uma representação em string dos elementos da fila
     */
    @Override
    public String imprimirDeFrentePraTras() {
        String aux = "[";
        NodoDuplo<T> ponteiroAux = ponteiroInicio;
        for (int i = 0; i < quantidade; i++) {
            aux += ponteiroAux.getDado();

            if (i != quantidade - 1) {
                aux += ",";
            }

            ponteiroAux = ponteiroAux.getProximo();
        }
        return aux + "]";
    }

    /**
     * Imprime os elementos da fila do fim para o início.
     *
     * @return uma representação em string dos elementos da fila
     */
    @Override
    public String imprimirDeTrasPraFrente() {
        String aux = "[";
        NodoDuplo<T> ponteiroAux = ponteiroFim;
        for (int i = 0; i < quantidade; i++) {
            aux += ponteiroAux.getDado();

            if (i != quantidade - 1) {
                aux += ",";
            }

            ponteiroAux = ponteiroAux.getProximo();
        }
        return aux + "]";
    }
}
