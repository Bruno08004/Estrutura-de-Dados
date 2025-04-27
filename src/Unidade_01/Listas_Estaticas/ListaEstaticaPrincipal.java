package Unidade_01.Listas_Estaticas;

public class ListaEstaticaPrincipal {
    public static void main(String[] args) {
        Listavel lista = new ListaEstaticaCircular(12);

        lista.anexar("A");
        lista.anexar("B");
        lista.anexar("C");
        System.out.println(lista.imprimir());
        lista.inserir("D",1);
        System.out.println(lista.imprimir());
        System.out.println("Contém? " +lista.contem("D"));
        System.out.println("Elemento da posição 2:" + lista.selecionar(0));
        System.out.println(lista.imprimir());
        lista.apagar(0);
        System.out.println(lista.imprimir());
        lista.atualizar("E", 3);
        System.out.println(lista.imprimir());
        lista.anexar("B");
        System.out.println("Primeira ocorrência: "+lista.primeiraOcorrencia("B"));

        Object[] todos = lista.selecionarTodos();
        System.out.print("Todos os Elementos: ");
        for (Object t: todos){
            System.out.print(t + " ");
        }
        System.out.println();

        lista.limpar();
        System.out.println("Lista Limpa: " + lista.imprimir());
    }
}
