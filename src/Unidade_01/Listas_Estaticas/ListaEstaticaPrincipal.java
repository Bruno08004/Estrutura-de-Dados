package Unidade_01.Listas_Estaticas;

public class ListaEstaticaPrincipal {
    public static void main(String[] args) {
        Listavel lista = new ListaEstaticaCircular(12);

        lista.anexar("A");
        lista.anexar("B");
        lista.anexar("C");
        System.out.println(lista.imprimir());
        lista.selecionarTodos();
    }
}
