package Arvore_Binaria_De_Pesquisa;


public class ABP<T extends Comparable<T>> implements Arborizavel<T> {

    private NoTriplo<T> raiz;


    public ABP() {
        this.raiz = null;
    }

    @Override
    public NoTriplo<T> getRaiz() {
        return raiz;
    }

    @Override
    public void inserir(T dado) {
        NoTriplo<T> novoNo = new NoTriplo<>();
        novoNo.setDado(dado);

        if (raiz == null) {
            raiz = novoNo;
        } else {
            NoTriplo<T> noAuxiliar = raiz;
            while (true) {
                int comparacao = dado.compareTo(noAuxiliar.getDado());
                if (comparacao <= 0) {
                    if (noAuxiliar.getEsquerda() == null) {
                        noAuxiliar.setEsquerda(novoNo);
                        novoNo.setGenitor(noAuxiliar);
                        break;
                    }
                    noAuxiliar = noAuxiliar.getEsquerda();
                } else {
                    if (noAuxiliar.getDireita() == null) {
                        noAuxiliar.setDireita(novoNo);
                        novoNo.setGenitor(noAuxiliar);
                        break;
                    }
                    noAuxiliar = noAuxiliar.getDireita();
                }
            }
        }
    }

    @Override
    public T apagar(T dado) {
        NoTriplo<T> noAuxiliar = buscar(dado);

        if (noAuxiliar == null) {
            return null;
        }
        // Caso 1: Nó sem filhos
        if (noAuxiliar.getEsquerda() == null &&
                noAuxiliar.getDireita() == null) {
            apagarNoFolha(noAuxiliar);
            // Caso 2: Nó com um filho
        }else if (noAuxiliar.getEsquerda() == null ||
                noAuxiliar.getDireita() == null) {
            apagarComUmFilho(noAuxiliar);
            // Caso 3: Nó com dois filhos
        }else {
            apagarComDoisFilhos(noAuxiliar);
        }
        return dado;
    }

    private void apagarNoFolha(NoTriplo<T> no) {
        NoTriplo<T> auxPai = no.getGenitor();
        if (auxPai == null) {
            raiz = null;
        } else {
            if (no.equals(auxPai.getEsquerda())) {
                auxPai.setEsquerda(null);
            }else {
                auxPai.setDireita(null);
            }
        }

    }

    private void apagarComUmFilho(NoTriplo<T> nodo) {
        NoTriplo<T> avo = nodo.getGenitor();
        NoTriplo<T> neto = ((nodo.getEsquerda() != null) ? nodo.getEsquerda() : nodo.getDireita());
        if (avo == null) {
            raiz = neto;
            raiz.setGenitor(null);
        } else {
            neto.setGenitor(avo);
            if (nodo.equals(avo.getEsquerda())) {
                avo.setEsquerda(neto);
            } else {
                avo.setDireita(neto);
            }
        }
    }

    private void apagarComDoisFilhos(NoTriplo<T> nodo) {
        //sucessor pode ser o menor a direita ou o maior a esquerda
        NoTriplo<T> noSucessor = encontraMenorDireita(nodo);
        //NoTriplo<T> sucessor = encontraMaiorEsquerda(nodo);

        //copia o conteúdo do sucessor para o nodo
        nodo.setDado(noSucessor.getDado());

        // Remove o dado duplicado a direita
        if (noSucessor.getEsquerda() == null &&
                noSucessor.getDireita() == null) {
            apagarNoFolha(noSucessor);
        } else {
            apagarComUmFilho(noSucessor);
        }
    }

    @Override
    public void limpar() {
        raiz = null;
    }

    private NoTriplo<T> encontraMenorDireita(NoTriplo<T> nodo) {
        NoTriplo<T> noAuxiliar = nodo.getDireita();
        while (noAuxiliar.getEsquerda() != null) {
            noAuxiliar = noAuxiliar.getEsquerda();
        }
        return noAuxiliar;
    }
    private NoTriplo<T> encontraMaiorEsquerda(NoTriplo<T> nodo) {
        NoTriplo<T> noAuxiliar = nodo.getEsquerda();
        while (noAuxiliar.getDireita() != null) {
            noAuxiliar = noAuxiliar.getDireita();
        }
        return noAuxiliar;
    }

    @Override
    public boolean existe(T dado) {
        return buscar(dado) != null;
    }

    private NoTriplo<T> buscar(T dado) {
        NoTriplo<T> noAuxiliar = raiz;
        while (noAuxiliar != null) {
            int comparacao = dado.compareTo(noAuxiliar.getDado());
            if (comparacao == 0) {
                return noAuxiliar;
            }
            noAuxiliar = ((comparacao <= 0) ? noAuxiliar.getEsquerda() : noAuxiliar.getDireita());
        }
        return null;
    }


    private String imprimirPreOrdemRec(NoTriplo<T> raizAtual) {
        if (raizAtual == null) {
            return "";   //caso base
        }
        return raizAtual.getDado() + " " +
                imprimirPreOrdemRec(raizAtual.getEsquerda()) +  " " +
                imprimirPreOrdemRec(raizAtual.getDireita());
    }

    private String imprimirEmOrdemRec(NoTriplo<T> raizAtual) {
        if (raizAtual == null){
            return "";   //caso base
        }
        return imprimirEmOrdemRec(raizAtual.getEsquerda()) + " " +
                raizAtual.getDado() + " " +
                imprimirEmOrdemRec(raizAtual.getDireita());
    }

    private String imprimirPosOrdemRec(NoTriplo<T> raiz) {
        if (raiz == null){
            return "";   //caso base
        }
        return  imprimirPosOrdemRec(raiz.getEsquerda()) + " " +
                    imprimirPosOrdemRec(raiz.getDireita()) +  " " +
                    raiz.getDado();

    }

    @Override
    public String imprimirPreOrdem() {
        return formataSaida(imprimirPreOrdemRec(raiz));
    }

    @Override
    public String imprimirEmOrdem() {
        return formataSaida(imprimirEmOrdemRec(raiz));
    }

    @Override
    public String imprimirPosOrdem() {
        return formataSaida(imprimirPosOrdemRec(raiz));
    }


    private String formataSaida(String msg) {
        // Substitui um ou mais espaços em branco por uma vírgula, após remover espaços das bordas
        msg = msg.trim().replaceAll("\\s+", ",");
        return "[" + msg + "]";
    }


}
