package Unidade_01.Pilha_Estatica.Pilha_Dupla;

public class PilhaDupla implements EmpilhavelDupla{

    private int ponteiroTopo1;
    private int ponteiroTopo2;
    private Object[] dados;

    public PilhaDupla() {
        this(10);
    }

    public PilhaDupla(int tamanho) {
        this.dados = new Object[tamanho];
        this.ponteiroTopo1 = -1;
        this.ponteiroTopo2 = tamanho;
    }

    @Override
    public void empilhar1(Object dado) {
        if (!estaCheia1()) {
            ponteiroTopo1++;
            dados[ponteiroTopo1] = dado;
        } else {
            System.err.println("Stack is full!");
        }
    }

    @Override
    public void empilhar2(Object dado) {
        if (!estaCheia2()) {
            ponteiroTopo2--;
            dados[ponteiroTopo2] = dado;
        } else {
            System.err.println("Stack is full!");
        }
    }


    @Override
    public Object desempilhar1() {
        Object aux = null;
        if (!estaVazia1()) {
            aux = dados[ponteiroTopo1];
            //dados[ponteiroTopo1] = null; Opcional
            ponteiroTopo1--;
        } else {
            System.err.println("Stack is empty!");
        }
        return aux;
    }

    @Override
    public Object desempilhar2() {
        Object aux = null;
        if (!estaVazia2()) {
            aux = dados[ponteiroTopo2];
            //dados[ponteiroTopo2] = null; Opcional
            ponteiroTopo2++;
        } else {
            System.err.println("Stack is empty!");
        }
        return aux;
    }

    @Override
    public Object espiar1() {
        Object aux = null;
        if (!estaVazia1()) {
            aux = dados[ponteiroTopo1];
        } else {
            System.out.println("Stack is empty!");
        }
        return aux;
    }

    @Override
    public Object espiar2() {
        Object aux = null;
        if (!estaVazia2()) {
            aux = dados[ponteiroTopo2];
        } else {
            System.out.println("Stack is empty!");
        }
        return aux;
    }

    @Override
    public void atualizar1(Object dado) {
        if (!estaVazia1()) {
            dados[ponteiroTopo1] = dado;
        } else {
            System.err.println("Stack is empty!");
        }
    }

    @Override
    public void atualizar2(Object dado) {
        if (!estaVazia2()) {
            dados[ponteiroTopo2] = dado;
        } else {
            System.err.println("Stack is empty!");
        }
    }

    //métodos auxiliares
    @Override
    public boolean estaCheia1() {
        return (ponteiroTopo1 == ponteiroTopo2 - 1);
    }

    @Override
    public boolean estaCheia2() {
        return estaCheia1();
    }

    @Override
    public boolean estaVazia1() {
        return (ponteiroTopo1 == -1);
    }

    @Override
    public boolean estaVazia2() {
        return (ponteiroTopo2 == dados.length);
    }

    @Override
    public String imprimir1() {
        String aux = "[";
        for (int i = ponteiroTopo1; i >= 0; i--) {
            if (i == 0)
                aux += dados[i];
            else
                aux += dados[i] + ",";
        }
        return aux + "]";
    }

    @Override
    public String imprimir2() {
        String aux = "[";
        for (int i = ponteiroTopo2; i < dados.length; i++) {
            if (i == dados.length - 1)
                aux += dados[i];
            else
                aux += dados[i] + ",";
        }
        return aux + "]";
    }
}




