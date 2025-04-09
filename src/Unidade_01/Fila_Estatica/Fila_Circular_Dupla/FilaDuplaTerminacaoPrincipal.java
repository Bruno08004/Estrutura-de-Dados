package Unidade_01.Fila_Estatica.Fila_Circular_Dupla;

public class FilaDuplaTerminacaoPrincipal {
    public static void main(String[] args) {
        DuplamenteEnfileiravel fila = new FilaDuplaTerminacao(30);
        fila.enfileirarInicio("A");
        System.out.println(fila.imprimirFrenteTras()); //[A]
        fila.enfileirarFim("B");
        System.out.println(fila.imprimirTrasFrente());
        System.out.println(fila.tras()); //B
        System.out.println(fila.frente()); //A
        fila.enfileirarInicio("C");
        fila.desenfileirarFim();
        fila.enfileirarFim("D");
        fila.desenfileirarInicio();
        fila.enfileirarInicio("E");
        System.out.println(fila.imprimirTrasFrente()); //[D,A,E]
        System.out.println(fila.imprimirFrenteTras()); //[E,A,D]
        System.out.println(fila.frente());//E
        fila.desenfileirarFim();
        System.out.println(fila.tras()); //A
        fila.enfileirarInicio("F");
        System.out.println(fila.imprimirFrenteTras());//[F,E,A]
        System.out.println(fila.imprimirTrasFrente());//[A,E,F]
        fila.enfileirarFim("G");
        fila.desenfileirarInicio();
        fila.enfileirarFim("H");
        System.out.println(fila.tras()); //H
        fila.enfileirarInicio("I");
        fila.desenfileirarFim();
        fila.enfileirarFim("J");
        System.out.println(fila.imprimirFrenteTras()); //[I,E,A,G,J]
        System.out.println(fila.imprimirTrasFrente()); //[J,G,A,E,I]
        fila.enfileirarInicio("K");
        fila.enfileirarFim("L");
        fila.enfileirarFim("M");
        System.out.println(fila.frente()); //K
        fila.desenfileirarInicio();
        System.out.println(fila.imprimirFrenteTras()); //[I,E,A,G,J,L,M]
        System.out.println(fila.imprimirTrasFrente()); //[M,L,J,G,A,E,I]

    }
}
