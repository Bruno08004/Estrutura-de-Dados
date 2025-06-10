package src.Algoritmo_Ordernacao;

/**
 * Heapsort
 * Quicksort
 * Mergesort
 * Algoritmos Dividir Para Conquistar
 */

public class OrdenacaoDividirParaConquistar {


    public int[] intercala(int[] v1, int[] v2) {
        int[] result = new int[v1.length + v2.length];
        int ponteiro1 = 0;
        int ponteiro2 = 0;
        int ponteiroRetorno = 0;
        while (ponteiro1 < v1.length && ponteiro2 < v2.length) {
            if(v1[ponteiro1] < v2[ponteiro2]) {
                result[ponteiroRetorno] = v1[ponteiro1];
                ponteiro1++;
            }else{
                result[ponteiroRetorno] = v2[ponteiro2];
                ponteiro2++;
            }
            ponteiroRetorno++;
            while (ponteiro1 < v1.length) {
                result[ponteiroRetorno] = v1[ponteiro1];
                ponteiroRetorno++;
                ponteiro1++;
            }
            while (ponteiro2 < v2.length) {
                result[ponteiroRetorno] = v1[ponteiro2];
                ponteiroRetorno++;
                ponteiro2++;
            }
        }
        return result;
    }


}


