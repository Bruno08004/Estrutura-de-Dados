package src.Arvore_Heap_Binaria_Máxima;

import src.exception.OverflowException;
import src.exception.UnderflowException;

/**
 * Classe que implementa uma árvore binária do tipo heap máximo.
 * Esta estrutura de dados é utilizada para armazenar elementos de forma que o maior elemento esteja sempre na raiz.
 *
 * @param <T> Tipo dos elementos a serem armazenados na árvore.
 * @author Bruno Campos Penha
 * @since 15/06/2025
 * @version 1.0
 */

public class ArvoreBinariaHeapMaximo<T> implements Amontoavel<T> {
    private T[] dados;
    private int ponteiroFim;

    /**
     * Construtor que inicializa a árvore binária heap máximo com um tamanho específico.
     *
     * @param tamanho Tamanho máximo da árvore.
     */
    public ArvoreBinariaHeapMaximo(int tamanho) {
        this.dados = (T[]) new Object[tamanho];
        this.ponteiroFim = -1;
    }

    /**
     * Construtor que inicializa a árvore binária heap máximo com um tamanho padrão de 10.
     */
    public ArvoreBinariaHeapMaximo() {
        this(10);
    }

    /**
     * Construtor que inicializa a árvore binária heap máximo com um array de dados.
     *
     * @param dado Array de dados a serem armazenados na árvore.
     */
    @Override
    public void inserir(T dado) {
        if (estaCheia()) {
            throw new OverflowException("Heap Cheia");
        }
        ponteiroFim++;
        dados[ponteiroFim] = dado;
        ajustarAcima(ponteiroFim);
    }

    /**
     * Obtém o elemento raiz da árvore.
     *
     * @return O elemento na raiz da árvore.
     * @throws UnderflowException Se a árvore estiver vazia.
     */
    @Override
    public T obterRaiz() {
        if (estaVazia()) {
            throw new UnderflowException("Heap está vazia!");
        }
        T dadoRaiz = dados[0];
        return dadoRaiz;
    }

    /**
     * Extrai o elemento raiz da árvore, removendo-o e reestruturando a árvore.
     *
     * @return O elemento na raiz da árvore.
     * @throws UnderflowException Se a árvore estiver vazia.
     */
    @Override
    public T extrair() {
        if (estaVazia()) {
            throw new UnderflowException("Heap vazia");
        }
        T dadoRaiz = dados[0];
        dados[0] = dados[ponteiroFim];
        ponteiroFim--;
        ajustarAbaixo(0);
        return dadoRaiz;
    }

    /**
     * Método auxiliar para obter o índice do pai de um nó.
     *
     * @param filho Índice do nó filho.
     * @return Índice do nó pai.
     */
    private int indicePai(int filho) {
        return (filho - 1) / 2;
    }

    /**
     * Método auxiliar para obter o índice do filho esquerdo de um nó.
     *
     * @param pai Índice do nó pai.
     * @return Índice do filho esquerdo.
     */
    private int indiceFilhoEsquerdo(int pai) {
        return (pai * 2) + 1;
    }

    /**
     * Método auxiliar para obter o índice do filho direito de um nó.
     *
     * @param pai Índice do nó pai.
     * @return Índice do filho direito.
     */
    private int indiceFilhoDireito(int pai) {
        return (pai * 2) + 2;
    }

    /**
     * Método auxiliar para trocar dois elementos na árvore.
     *
     * @param i Índice do primeiro elemento.
     * @param j Índice do segundo elemento.
     */
    private void trocar(int i, int j) {
        T temp = dados[i];
        dados[i] = dados[j];
        dados[j] = temp;
    }

    /**
     * Método auxiliar para ajustar a posição de um nó após inserção ou extração.
     *
     * @param indice Índice do nó a ser ajustado.
     */
    private void ajustarAcima(int indice) {
        while (indice > 0) {
            if ((Integer) dados[indice] > (Integer) dados[indicePai(indice)]) {
                trocar(indice, indicePai(indice));
                indice = indicePai(indice);
            } else {
                break;
            }
        }
    }

    /**
     * Método auxiliar para ajustar a posição de um nó após extração.
     *
     * @param indice Índice do nó a ser ajustado.
     */
    private void ajustarAbaixo(int indice) {
        int filhoEsquerdo = indiceFilhoEsquerdo(indice);
        int filhoDireito = indiceFilhoDireito(indice);
        int maior = indice;

        if (filhoEsquerdo <= ponteiroFim && (Integer) dados[filhoEsquerdo] > (Integer) dados[maior]) {
            maior = filhoEsquerdo;
        }
        if (filhoDireito <= ponteiroFim && (Integer) dados[filhoDireito] > (Integer) dados[maior]) {
            maior = filhoDireito;
        }
        if (maior != indice) {
            trocar(indice, maior);
            ajustarAbaixo(maior);
        }
    }

    /**
     * Verifica se a árvore está cheia.
     *
     * @return true se a árvore estiver cheia, false caso contrário.
     */
    @Override
    public boolean estaCheia() {
        return (ponteiroFim == dados.length - 1);
    }

    /**
     * Verifica se a árvore está vazia.
     *
     * @return true se a árvore estiver vazia, false caso contrário.
     */
    @Override
    public boolean estaVazia() {
        return (ponteiroFim == -1);
    }

    /**
     * Imprime os elementos da árvore em uma representação de string.
     *
     * @return String representando os elementos da árvore.
     */
    @Override
    public String imprmir() {
        String resultado = "[";
        for (int i = 0; i <= ponteiroFim; i++) {
            resultado += dados[i];
            if (i != ponteiroFim) {
                resultado += ", ";
            }
        }
        return resultado + "]";
    }

}
