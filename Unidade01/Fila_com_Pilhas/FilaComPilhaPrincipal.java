package Fila_com_Pilhas;

import Fila_Estatica.Fila.Enfileravel;

public class FilaComPilhaPrincipal {
    public static void main(String[] args) {
        Enfileravel filaPilha = new FilaComPilha(13);

        filaPilha.enfileirar("A");
        filaPilha.enfileirar("B");
        System.out.println(filaPilha.imprimir());
        filaPilha.atualizarInicio("C");
        System.out.println(filaPilha.imprimir());
        filaPilha.atualizarFim("D");
        System.out.println(filaPilha.imprimir());
        System.out.println(filaPilha.frente());
    }
}
