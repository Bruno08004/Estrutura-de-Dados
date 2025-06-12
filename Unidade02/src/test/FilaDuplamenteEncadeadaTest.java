package src.test;

import org.junit.Test;
import src.Fila_Dinamica.Enfileiravel;
import src.Fila_Dinamica.FilaDinamicaDuplamenteEncadeadaGenerica;

import static org.junit.Assert.*;

public class FilaDuplamenteEncadeadaTest {
    @Test
    public void testEnfileirarInicio() {
        Enfileiravel<String> fila = new FilaDinamicaDuplamenteEncadeadaGenerica<>();
        fila.enfileirarInicio("Instituto");
        fila.enfileirarInicio("Maria");
        assertEquals("Maria", fila.frente());
    }

    @Test
    public void testEnfileirarFim() {
        Enfileiravel<String> fila = new FilaDinamicaDuplamenteEncadeadaGenerica<>();
        fila.enfileirarFim("Instituto");
        fila.enfileirarFim("Maria");
        assertEquals("Maria", fila.tras());
    }

    @Test
    public void testDesenfileirarInicio() {
        Enfileiravel<String> fila = new FilaDinamicaDuplamenteEncadeadaGenerica<>();
        fila.enfileirarInicio("Instituto");
        fila.enfileirarInicio("Maria");
        assertEquals("Maria", fila.desenfileirarInicio());
    }

    @Test
    public void testDesenfileirarFim() {
        Enfileiravel<String> fila = new FilaDinamicaDuplamenteEncadeadaGenerica<>();
        fila.enfileirarInicio("Instituto");
        fila.enfileirarInicio("Maria");
        assertEquals("Instituto", fila.desenfileirarFim());
    }

    @Test
    public void testAtualizarInicio() {
        Enfileiravel<String> fila = new FilaDinamicaDuplamenteEncadeadaGenerica<>();
        fila.enfileirarInicio("Instituto");
        fila.enfileirarInicio("Federal");
        fila.atualizarInicio("Maria");
        assertEquals("Maria", fila.frente());
    }

     @Test
    public void testAtualizarIFim() {
        Enfileiravel<String> fila = new FilaDinamicaDuplamenteEncadeadaGenerica<>();
        fila.enfileirarFim("Instituto");
        fila.enfileirarFim("Federal");
        fila.atualizarFim("Maria");
        assertEquals("Maria", fila.tras());
    }

    @Test
    public void testFrente() {
        Enfileiravel<String> fila = new FilaDinamicaDuplamenteEncadeadaGenerica<>();
        fila.enfileirarInicio("Instituto");
        fila.enfileirarInicio("Maria");
        String conteudo = fila.frente();
        assertEquals("Maria", conteudo);
    }

    @Test
    public void testTras() {
        Enfileiravel<String> fila = new FilaDinamicaDuplamenteEncadeadaGenerica<>();
        fila.enfileirarInicio("Instituto");
        fila.enfileirarInicio("Maria");
        String conteudo = fila.tras();
        assertEquals("Instituto", conteudo);
    }
}
