package src.test;

import org.junit.Assert;
import org.junit.Test;
import src.Pilha_Dinamica.Empilhavel;
import src.Pilha_Dinamica.PilhaDinamincaGenerica;

import static org.junit.Assert.assertEquals;

public class PilhaDinamicaTest {
    @Test
    public void testEmpilhar() {
        Empilhavel<String> pilha = new PilhaDinamincaGenerica<>(1);
        pilha.empilhar("dado");
        assertEquals("dado", pilha.espiar());
    }

    @Test
    public void testDesempilhar() {
        Empilhavel<String> pilha = new PilhaDinamincaGenerica<>(2);
        pilha.empilhar("dado");
        pilha.empilhar("instituto");
        String conteudo = pilha.desempilhar();
        assertEquals("instituto", conteudo);
    }

    @Test
    public void testAtualizar() {
        Empilhavel<String> pilha = new PilhaDinamincaGenerica<>(2);
        pilha.empilhar("instituto");
        pilha.atualizar("federal");
        assertEquals("federal", pilha.espiar());
    }

    @Test
    public void testEspiar(){
        Empilhavel<String> pilha = new PilhaDinamincaGenerica<>(2);
        pilha.empilhar("federal");
        pilha.empilhar("instituto");
        assertEquals("instituto", pilha.espiar());
    }



}
