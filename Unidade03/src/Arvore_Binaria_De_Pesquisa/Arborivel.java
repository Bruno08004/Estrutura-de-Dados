package Arvore_Binaria_De_Pesquisa;

public interface Arborivel<T> {
    void inserir(T dado);

    void apagar(T dado);

    boolean existe(T dado);

    void limpar();

}
