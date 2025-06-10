package src.test;

import org.junit.Assert;
import org.junit.Test;
import src.Pilha_Dinamica.Empilhavel;
import src.Pilha_Dinamica.PilhaDinamincaGenerica;

public class PilhaDinamicaTest {
    @Test
    public void testEmpilhar() {
        Empilhavel<String> pilha = new PilhaDinamincaGenerica<>(1);
        pilha.empilhar("dado");
        Assert.assertEquals("dado", pilha.espiar());
    }

    @Test
    public void testDesempilhar() {
        Empilhavel<String> pilha = new PilhaDinamincaGenerica<>(2);
        pilha.empilhar("dado");
        pilha.empilhar("instituto");
        String conteudo = pilha.desempilhar();
        Assert.assertEquals("instituto", conteudo);
    }

    @Test
    public void testAtualizar() {
        Empilhavel<String> pilha = new PilhaDinamincaGenerica<>(2);
        pilha.empilhar("instituto");
        pilha.atualizar("federal");
        Assert.assertEquals("federal", pilha.espiar());
    }

    @Test
    public void testEspiar(){
        Empilhavel<String> pilha = new PilhaDinamincaGenerica<>(2);
        pilha.empilhar("federal");
        pilha.empilhar("instituto");
        Assert.assertEquals("instituto", pilha.espiar());
    }



}
