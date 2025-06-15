package src.test;

import org.junit.Test;
import src.Lista_Dinamica.ListaDinamicaGenerica;
import src.Lista_Dinamica.Listavel;

import static org.junit.Assert.*;

public class ListaDinamicaGenericaTest {

    @Test
    public void testAnexar() {
        Listavel<String> lista = new ListaDinamicaGenerica<>();
        lista.anexar("A");
        lista.anexar("B");
        assertEquals("A", lista.selecionar(0));
        assertEquals("B", lista.selecionar(1));
    }

    @Test
    public void testInserir() {
        Listavel<String> lista = new ListaDinamicaGenerica<>();
        lista.inserir(0, "A");
        lista.inserir(1, "B");
        lista.inserir(1, "C");
        assertEquals("A", lista.selecionar(0));
        assertEquals("C", lista.selecionar(1));
        assertEquals("B", lista.selecionar(2));
    }

    @Test
    public void testSelecionarTodos() {
        Listavel<String> lista = new ListaDinamicaGenerica<>();
        lista.anexar("A");
        lista.anexar("B");
        lista.anexar("C");
        String[] elementos = lista.selecionarTodos();
        assertEquals(3, elementos.length);
        assertEquals("A", elementos[0]);
        assertEquals("B", elementos[1]);
        assertEquals("C", elementos[2]);
    }

    @Test
    public void testAtualizar() {
        Listavel<String> lista = new ListaDinamicaGenerica<>();
        lista.anexar("A");
        lista.anexar("B");
        lista.atualizar(1, "C");
        assertEquals("A", lista.selecionar(0));
        assertEquals("C", lista.selecionar(1));
    }

    @Test
    public void testApagar() {
        Listavel<String> lista = new ListaDinamicaGenerica<>();
        lista.anexar("A");
        lista.anexar("B");
        String dadoApagado = lista.apagar(0);
        assertEquals("A", dadoApagado);
    }

    @Test
    public void testEstaVazia () {
        Listavel<String> lista = new ListaDinamicaGenerica<>();
        assertTrue(lista.estaVazia());
        lista.anexar("A");
        assertFalse(lista.estaVazia());
    }

    @Test
    public void testEstaCheia(){
        Listavel<String> lista = new ListaDinamicaGenerica<>(3);
        assertFalse(lista.estaCheia());
        lista.anexar("A");
        lista.anexar("B");
        lista.anexar("C");
        assertTrue(lista.estaCheia());
    }

    @Test
    public void testImprimir(){
        Listavel<String> lista = new ListaDinamicaGenerica<>();
        lista.anexar("A");
        lista.anexar("B");
        lista.anexar("C");
        assertEquals("[A, B, C]", lista.imprimir());
    }
}
