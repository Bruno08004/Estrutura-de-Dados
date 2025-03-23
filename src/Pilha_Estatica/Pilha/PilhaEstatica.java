package Pilha_Estatica.Pilha;


public class PilhaEstatica implements Empilhavel {

        //variáveis de instância
        private Object[] dados;
        private int ponteiroTopo;

        //construtores
        public PilhaEstatica() {
            this(10); //toda vez que chamamos outro construtor dentro deste construtor utilizamos o this()
        }

        public PilhaEstatica(int tamanho) {
            dados = new Object[tamanho];
            ponteiroTopo = -1;
        }

        //métodos principais
        @Override
        public void empilhar(Object dado) {
            if (!estaCheia()) {
                ponteiroTopo++;
                dados[ponteiroTopo] = dado;
            } else {
                System.err.println("Stack is full!");
            }
        }

        @Override
        public Object desempilhar() {
            Object aux = null;
            if (!estaVazia()) {
                aux = dados[ponteiroTopo];
                dados[ponteiroTopo] = null;
                ponteiroTopo--;
            } else {
                System.err.println("Stack is empty!");
            }
            return aux;
        }

        @Override
        public Object espiar() {
            Object aux = null;
            if (!estaVazia()) {
                aux = dados[ponteiroTopo];
            } else {
                System.out.println("Stack is empty!");
            }
            return aux;
        }

        @Override
        public void atualizar(Object dado) {
            if (!estaVazia()) {
                dados[ponteiroTopo] = dado;
            } else {
                System.err.println("Stack is empty!");
            }
        }

        //métodos auxiliares
        @Override
        public boolean estaCheia() {
            return (ponteiroTopo == dados.length - 1);
        }

        @Override
        public boolean estaVazia() {
            return (ponteiroTopo == -1);
        }

        @Override
        public String imprimir() {
            String aux = "[";
            for (int i = ponteiroTopo; i >= 0; i--) {
                if (i == 0)
                    aux += dados[i];
                else
                    aux += dados[i] + ",";
            }
            return aux + "]";
        }
    }

