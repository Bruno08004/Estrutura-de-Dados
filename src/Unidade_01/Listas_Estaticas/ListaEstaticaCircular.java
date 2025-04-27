package Unidade_01.Listas_Estaticas;

public class ListaEstaticaCircular implements Listavel {
    private Object[] dados;
    private int ponteiroInicio; //cabeça = head
    private int ponteiroFim; //cauda = tail
    private int quantidade;

    public ListaEstaticaCircular() {
        this(10);
    }

    public ListaEstaticaCircular(int tamanho) {
        this.dados = new Object[tamanho];
        this.ponteiroInicio = 0;
        this.ponteiroFim = -1;
        this.quantidade = 0;
    }


    @Override
    public void inserir(Object dado, int posicao) {
        if (!estaCheia()){
            if (posicao >= 0 && posicao <= quantidade){
                int posicaoFisica = mapeamento(posicao);
                int origem = ponteiroFim;
                int destino = avancar(origem);
                for ( int i = 0; i< quantidade - posicao; i++){
                    dados[destino] = dados[origem];
                    origem = retroceder(origem);
                    destino = retroceder(destino);
                }
                dados[posicaoFisica] = dado;
                quantidade++;
                ponteiroFim = avancar(ponteiroFim);
            }
        }
    }

    @Override
    public void anexar(Object dado) {
        if (!estaCheia()) {
            ponteiroFim = avancar(ponteiroFim);
            dados[ponteiroFim] = dado;
            quantidade++;
        } else {
            System.err.println("List is full!");
        }
    }

    @Override
    public Object selecionar(int posicao) {
        Object aux = null;
        if (!estaVazia()) {
            if (posicao >= 0 && posicao < quantidade) {
                int posicaoFisica = mapeamento(posicao);
                aux = dados[posicaoFisica];
            } else {
                System.err.println("Invalid index!");
            }
        } else {
            System.err.println("List is empty!");
        }
        return aux;
    }

    @Override
    public Object[] selecionarTodos() {
        Object[] dadosAux = null;
        if (!estaVazia()) {
            dadosAux = new Object[quantidade];
            int ponteiroAux = ponteiroInicio;
            for (int i = 0; i < quantidade; i++) {
                dadosAux[i] = dados[ponteiroAux];
                ponteiroAux = avancar(ponteiroAux);
            }
        } else {
            System.out.println("List is empty!");
        }
        return dadosAux;
    }

    @Override
    public void atualizar(Object dado, int posicao) {
        if (!estaVazia()) {
            if (posicao >= 0 && posicao < quantidade) {
                int posicoFisica = mapeamento(posicao);
                dados[posicoFisica] = dado;
            } else {
                System.err.println("Invalid index!");
            }
        } else {
            System.err.println("List is empty!");
        }
    }

    @Override
    public Object apagar(int posicao) {
        Object dadoAux = null;
        if (!estaVazia()) {
            if (posicao >= 0 && posicao < quantidade) {
                int posicaoFisica = mapeamento(posicao);
                dadoAux = dados[posicaoFisica];
                int x = posicaoFisica;
                int y = avancar(x);
                for (int i = 0; i< quantidade - posicao - 1; i++) {
                    dados[x] = dados[y];
                    x= avancar(x);
                    y = avancar(y);
                }
                quantidade --;
                ponteiroFim = retroceder(ponteiroFim);
            } else{
                System.err.println("Invalid Index!");
            }
        } else {
            System.err.println("List is empty!");
        }
         return dadoAux;
    }

    @Override
    public void limpar() {
        quantidade = 0;
        ponteiroInicio = 0;
        ponteiroFim = -1;

    }

    @Override
    public boolean contem(Object dado) {
        if (!estaVazia()) {
            int ponteiroAux = ponteiroInicio;
            for (int i = 0; i < quantidade; i++) {
                if (dados[ponteiroAux] != null && dados[ponteiroAux].equals(dado)) {
                    return true;
                }
                ponteiroAux = avancar(ponteiroAux);
            }
        }
        return false;
    }

    @Override
    public int primeiraOcorrencia(Object dado) {
        if (!estaVazia()) {
            int ponteiroAux = ponteiroInicio;
            for (int i = 0; i < quantidade; i++) {
                if (dados[ponteiroAux] != null && dados[ponteiroAux].equals(dado)) {
                    return i; // posição lógica
                }
                ponteiroAux = avancar(ponteiroAux);
            }
        }
        return -1;
    }


    @Override
    public boolean estaCheia() {
        return (quantidade == dados.length);
    }

    @Override
    public boolean estaVazia() {
        return (quantidade == 0);

    }

    @Override
    public String imprimir() {
        String retorno = "[";
        int ponteiroAux = ponteiroInicio;

        for (int i = 0; i < quantidade; i++) {

            if (i == quantidade - 1) {
                retorno += dados[ponteiroAux];
            } else {
                retorno += dados[ponteiroAux] + ",";
                ponteiroAux = avancar(ponteiroAux);
            }
        }

        return retorno + "]";
    }

    public int avancar(int ponteiro) {
        return (ponteiro + 1) % dados.length;
    }

    public int retroceder (int ponteiro){
        return ((ponteiro - 1) + dados.length) % dados.length;
    }

    private int mapeamento(int logica) {
        return (logica + ponteiroInicio) % dados.length;
    }
}
