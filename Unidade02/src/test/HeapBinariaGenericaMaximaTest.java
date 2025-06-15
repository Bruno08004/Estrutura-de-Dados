package src.test;

import org.junit.Test;
import src.Arvore_Heap_Binaria_Máxima.Amontoavel;
import src.Arvore_Heap_Binaria_Máxima.ArvoreBinariaHeapMaximo;

import static org.junit.Assert.*;

public class HeapBinariaGenericaMaximaTest {

    @Test
    public void testInserir() {
        Amontoavel<Integer> heap = new ArvoreBinariaHeapMaximo<>();
        heap.inserir(10);
        heap.inserir(20);
        heap.inserir(5);
        assertEquals("[20, 10, 5]", heap.imprmir());

    }

    @Test
    public void testObterRaiz() {
        Amontoavel<Integer> heap = new ArvoreBinariaHeapMaximo<>();
        heap.inserir(10);
        heap.inserir(20);
        heap.inserir(5);
        assertEquals(20, heap.obterRaiz().intValue());
    }

    @Test
    public void testExtrair() {
        Amontoavel<Integer> heap = new ArvoreBinariaHeapMaximo<>();
        heap.inserir(10);
        heap.inserir(20);
        heap.inserir(5);
        int dado = heap.extrair();
        assertEquals(20, dado);

    }

    @Test
    public void testAjustarAcima() {
        Amontoavel<Integer> heap = new ArvoreBinariaHeapMaximo<>();
        heap.inserir(10);
        heap.inserir(20);
        heap.inserir(5);
        heap.extrair();
        assertEquals(10, heap.obterRaiz().intValue());
    }

    @Test
    public void testAjustarAbaixo() {
        Amontoavel<Integer> heap = new ArvoreBinariaHeapMaximo<>();
        heap.inserir(10);
        heap.inserir(20);
        heap.inserir(50);
        assertEquals(50, heap.obterRaiz().intValue());
    }

    @Test
    public void testEstaCheia() {
        Amontoavel <Integer> heap = new ArvoreBinariaHeapMaximo<>(3);
        assertFalse(heap.estaCheia());
        heap.inserir(10);
        heap.inserir(20);
        heap.inserir(30);
        assertTrue(heap.estaCheia());
    }

    @Test
    public void testEstaVazia() {
        Amontoavel <Integer> heap = new ArvoreBinariaHeapMaximo<>(3);
        assertTrue(heap.estaVazia());
        heap.inserir(10);
        heap.inserir(20);
        heap.inserir(30);
        assertFalse(heap.estaVazia());
    }
}
