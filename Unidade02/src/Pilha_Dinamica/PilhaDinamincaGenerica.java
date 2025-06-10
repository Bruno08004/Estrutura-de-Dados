package src.Pilha_Dinamica;

import java.util.NoSuchElementException;

/**
 * Implementação de uma Pilha Dinâmica Genérica.
 *
 * <p>Essa pilha armazena dados genéricos do tipo {@code T} e oferece operações
 * como {@link #empilhar(Object)}, {@link #desempilhar()}, {@link #espiar()},
 * {@link #atualizar(Object)}, entre outras. Ela faz uso da classe {@link NodoDuplo<T>}
 * para representar os elementos encadeados da pilha.</p>
 *
 * @param <T> o tipo de elemento armazenado na pilha
 *
 * @author Bruno Campos Penha
 * @since 2025-05-19
 * @version 1.0
 */
public class PilhaDinamincaGenerica<T> implements Empilhavel<T> {

    private NodoDuplo<T> ponteiroTopo;
    private int quantidade;
    private int tamanho;

    /**
     * Construtor padrão. Inicializa a pilha com capacidade para 10 elementos.
     */
    public PilhaDinamincaGenerica() {
        this(10);
    }

    /**
     * Construtor que permite definir o tamanho máximo da pilha.
     *
     * @param tamanho o número máximo de elementos que a pilha pode conter
     */
    public PilhaDinamincaGenerica(int tamanho) {
        this.ponteiroTopo = null;
        this.tamanho = tamanho;
        this.quantidade = 0;
    }

    /**
     * Adiciona um novo elemento ao topo da pilha.
     *
     * @param dado o dado a ser empilhado
     * @throws NoSuchElementException se a pilha estiver cheia
     */
    @Override
    public void empilhar(T dado) {
        if (estaCheia()) {
            throw new NoSuchElementException("Pilha Cheia!");
        }

        NodoDuplo<T> novoNodo = new NodoDuplo<>();
        novoNodo.setDado(dado);
        novoNodo.setAnterior(ponteiroTopo);
        novoNodo.setProximo(null);

        if (ponteiroTopo != null) {
            ponteiroTopo.setProximo(novoNodo);
        }

        ponteiroTopo = novoNodo;
        quantidade++;
    }

    /**
     * Remove e retorna o elemento do topo da pilha.
     *
     * @return o elemento removido do topo
     * @throws NoSuchElementException se a pilha estiver vazia
     */
    @Override
    public T desempilhar() {
        if (estaVazia()) {
            throw new NoSuchElementException("Pilha Vazia!");
        }

        T aux = ponteiroTopo.getDado();
        ponteiroTopo = ponteiroTopo.getAnterior();

        if (ponteiroTopo != null) {
            ponteiroTopo.setProximo(null);
        }

        quantidade--;
        return aux;
    }

    /**
     * Retorna o elemento do topo da pilha sem removê-lo.
     *
     * @return o elemento do topo da pilha
     * @throws NoSuchElementException se a pilha estiver vazia
     */
    @Override
    public T espiar() {
        if (estaVazia()) {
            throw new NoSuchElementException("Pilha Vazia!");
        }
        return ponteiroTopo.getDado();
    }

    /**
     * Atualiza o valor do topo da pilha com o novo dado fornecido.
     *
     * @param dado o novo valor a ser atribuído ao topo da pilha
     * @throws NoSuchElementException se a pilha estiver vazia
     */
    @Override
    public void atualizar(T dado) {
        if (estaVazia()) {
            throw new NoSuchElementException("Pilha Vazia!");
        }
        ponteiroTopo.setDado(dado);
    }

    /**
     * Verifica se a pilha está vazia.
     *
     * @return {@code true} se a pilha estiver vazia; {@code false} caso contrário
     */
    @Override
    public boolean estaVazia() {
        return quantidade == 0;
    }

    /**
     * Verifica se a pilha está cheia.
     *
     * @return {@code true} se a pilha estiver cheia; {@code false} caso contrário
     */
    @Override
    public boolean estaCheia() {
        return quantidade == tamanho;
    }

    /**
     * Retorna uma representação textual da pilha, do topo até a base.
     *
     * @return uma string no formato "[elemTopo,...,elemBase]"
     */
    @Override
    public String imprimir() {
        String aux = "[";
        NodoDuplo<T> ponteiroAux = ponteiroTopo;

        for (int i = 0; i < quantidade; i++) {
            aux += ponteiroAux.getDado();

            if (i != quantidade - 1) {
                aux += ",";
                ponteiroAux = ponteiroAux.getAnterior();
            }
        }

        return aux + "]";
    }
}
