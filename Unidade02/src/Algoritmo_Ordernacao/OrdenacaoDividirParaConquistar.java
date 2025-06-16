package src.Algoritmo_Ordernacao;

/**
 * Heapsort
 * Quicksort
 * Algoritmos Dividir Para Conquistar
 */

public class OrdenacaoDividirParaConquistar {

    int[] vetor = {6, 8, 3, 1, 9, 0, 2, 5};

    //Heapsort é um algoritmo de ordenação baseado na estrutura de dados heap.
    public void imprimirTela() {
        for (int dado : vetor) {
            System.out.print(dado + " ");
        }
        System.out.println(" ");
    }

    public int[] heapSort() {
        int tamanho = vetor.length;
        for (int i = tamanho / 2 - 1; i >= 0; i--) {
            aplicarHeap(vetor, tamanho, i);
        }

        for (int j = tamanho - 1; j > 0; j--) {
            trocar(j, 0);
            aplicarHeap(vetor, j, 0);
        }


        return vetor;
    }


    public void aplicarHeap(int[] vetor, int tamanho, int posicao) {
        int raiz = posicao;
        int filhoEsquerdo = 2 * posicao + 1;
        int filhoDireito = 2 * posicao + 2;


        if (filhoEsquerdo < tamanho && vetor[filhoEsquerdo] > vetor[raiz]) {
            raiz = filhoEsquerdo;
        }

        if (filhoDireito < tamanho && vetor[filhoDireito] > vetor[raiz]) {
            raiz = filhoDireito;
        }

        if (raiz != posicao) {
            trocar(raiz, posicao);
            aplicarHeap(vetor, tamanho, raiz);
        }
    }

    //Quicksort é um algoritmo de ordenação que utiliza a técnica de dividir e conquistar.
    public int[] quickSort(int esquerda, int direita) {
        if (esquerda < direita) {
            int p = particao(vetor, esquerda, direita);
            quickSort(esquerda, p);
            quickSort(p + 1, direita);
        }
        return vetor;
    }


    public int particao(int[] vetor, int esquerda, int direita) {
        int meio = (esquerda + direita) / 2;
        int pivo = vetor[meio];
        int i = esquerda - 1;
        int j = direita + 1;
        while (true) {
            do {
                i++;
            } while (vetor[i] < pivo);
            do {
                j--;
            } while (vetor[j] > pivo);
            if (i >= j) {
                return j;
            }
            trocar(i, j);
        }
    }

    public void trocar(int posicao1, int posicao2) {
        int temp = vetor[posicao1];
        vetor[posicao1] = vetor[posicao2];
        vetor[posicao2] = temp;
    }

    public static void main(String[] args) {
        OrdenacaoDividirParaConquistar ordenacao = new OrdenacaoDividirParaConquistar();
        ordenacao.imprimirTela();
        ordenacao.heapSort();
        ordenacao.quickSort(0, ordenacao.vetor.length - 1);
        System.out.println("Depois...");
        ordenacao.imprimirTela();
    }


}


