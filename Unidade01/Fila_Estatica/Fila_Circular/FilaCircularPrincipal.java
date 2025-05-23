package Fila_Estatica.Fila_Circular;

import Fila_Estatica.Fila.Enfileravel;

public class FilaCircularPrincipal {
    public static void main(String[] args) {
        Enfileravel fila = new FilaEstaticaCircular();
        fila.enfileirar("A");
        System.out.println(fila.frente());
        fila.enfileirar("B");
        fila.enfileirar("C");
        fila.enfileirar("D");
        fila.desenfileirar();
        fila.enfileirar("E");
        Object conteudo = fila.desenfileirar();
        fila.enfileirar("F");
        System.out.println(fila.frente());
        System.out.println(fila.frente());
        fila.enfileirar("G");
        fila.enfileirar(conteudo);
        fila.enfileirar("I");
        fila.enfileirar("J");
        fila.enfileirar("K");
        System.out.println("Fila: " + fila.imprimir());
    }
}
