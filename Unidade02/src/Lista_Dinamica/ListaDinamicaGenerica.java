package src.Lista_Dinamica;

public class ListaDinamicaGenerica<T> implements Listavel<T> {

    private NodoDuplo<T> ponteiroInicio;
    private NodoDuplo<T> ponteiroFim;
    private int quantidade;
    private int tamanho;

    public ListaDinamicaGenerica() {
        this(10);
    }

    public ListaDinamicaGenerica(int tamanho) {
        this.ponteiroInicio = null;
        this.ponteiroFim = null;
        this.quantidade = 0;
        this.tamanho = tamanho;
    }


    @Override
    public void anexar(T dado) {
        if (estaCheia()) {
            throw new OverflowException("Lista Cheia!");
        }
        NodoDuplo<T> noTemp = new NodoDuplo<>();
        noTemp.setDado(dado);
        noTemp.setAnterior(ponteiroFim);
        if (!estaVazia()) {
            ponteiroFim.setProximo(noTemp);
        } else {
            ponteiroInicio = noTemp;
        }
        ponteiroFim = noTemp;
        quantidade++;
    }

    @Override
    public void inserir(int posicao, T dado) {
        if (estaVazia()) {

        }
        if (posicao < 0 || posicao > quantidade){

        }
        NodoDuplo<T> ponteiroAuxiliar = ponteiroInicio;
        for (int i = 0; i< posicao; i++){
            ponteiroAuxiliar = ponteiroAuxiliar.getProximo();
        }
        NodoDuplo<T> noTemp = new NodoDuplo<>();
        noTemp.setDado(dado);
        noTemp.setProximo(ponteiroAuxiliar);
        noTemp.setAnterior(ponteiroAuxiliar.getAnterior());
        ponteiroAuxiliar.setAnterior(noTemp);
        ponteiroAuxiliar.getAnterior().setProximo(noTemp);
        quantidade++;
    }

    @Override
    public T[] selecionarTodos() {
        if (estaVazia()) {
            throw new OverflowException("Lista Vazia!");
        }
        T[] dados = (T[]) new Object[quantidade];
        NodoDuplo<T> ponteiroAuxiliar = ponteiroInicio;
        for (int i = 0; i < quantidade; i++) {
            dados[i] = ponteiroAuxiliar.getDado();
            ponteiroAuxiliar = ponteiroAuxiliar.getProximo();
        }
        return dados;
    }

    @Override
    public void atualizar(int posicao, T novoDado) {
        if (estaVazia()) {
            throw new OverflowException("Lista Vazia!");
        }
        if (posicao < 0 || posicao >= quantidade) {
            throw new OverflowException("Posição Inválida!");
        }
        NodoDuplo<T> ponteiroAuxiliar = ponteiroInicio;
        for (int i = 0; i < posicao; i++) {
            ponteiroAuxiliar = ponteiroAuxiliar.getProximo();
        }
        ponteiroAuxiliar.setDado(novoDado);
    }

    @Override
    public T selecionar(int posicao) {
        if (estaVazia()) {
            throw new OverflowException("Lista Vazia!");
        }
        if (posicao < 0 || posicao >= quantidade) {
            throw new IndexOutOfBoundsException("Índice fora dos limites");
        }
        NodoDuplo<T> ponteiroAuxiliar = ponteiroInicio;
        for (int i = 0; i < posicao; i++) {
            ponteiroAuxiliar = ponteiroAuxiliar.getProximo();
        }
        return ponteiroAuxiliar.getDado();
    }

    @Override
    public T apagar(int posicao) {
        if (estaVazia()) {

        }
        if (posicao < 0 || posicao > quantidade){

        }
        NodoDuplo<T> ponteiroAuxiliar = ponteiroInicio;
        for (int i = 0; i< posicao; i++){
            ponteiroAuxiliar = ponteiroAuxiliar.getProximo();
        }
        NodoDuplo<T> anterior = ponteiroAuxiliar.getAnterior();
        NodoDuplo<T> proximo = ponteiroAuxiliar.getProximo();
        anterior.setProximo(proximo);
        proximo.setAnterior(anterior);
        quantidade--;
        return ponteiroAuxiliar.getDado();
    }

    @Override
    public boolean estaCheia() {
        return quantidade == tamanho;
    }

    @Override
    public boolean estaVazia() {
        return quantidade == 0;
    }

    @Override
    public String imprimir() {
        String retorno = "[";
        NodoDuplo<T> aux = ponteiroInicio;
        for (int i = 0; i < quantidade; i++) {
            retorno += aux.getDado();
        }
         return retorno += "]";
    }
}
