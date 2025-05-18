package Listas_Estaticas;

/*
LISTAS ESTÁTICAS
TODA PILHA É UMA LISTA
TODA FILA É UMA LISTA
MAS O CONTRÁRIO NÃO!!
 */
public interface Listavel {
    void inserir(Object dado, int posicao);//C  - inserir

    void anexar(Object dado); //C  - append

    Object selecionar(int posicao); //R  - select

    Object[] selecionarTodos(); //R - selectAll

    void atualizar(Object dado, int posicao); //U - update

    Object apagar(int posicao); // D - delete

    void limpar();  //D

    boolean contem(Object dado); //R


    int primeiraOcorrencia(Object dado);


    boolean estaCheia();

    boolean estaVazia();

    String imprimir();
}