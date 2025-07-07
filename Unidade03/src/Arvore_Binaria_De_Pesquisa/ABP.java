package Arvore_Binaria_De_Pesquisa;

import src.Lista_Dinamica.NodoDuplo;

public class ABP<T> implements Arborivel<T> {

    private NoTriplo<T> raiz;

    public ABP() {
        this.raiz = null;
    }

    public NoTriplo<T> getRaiz() {
        return raiz;
    }

    @Override
    public void inserir(T dado) {
        NoTriplo<T> novoNo = new NoTriplo<>();
        novoNo.setDado(dado);

        NoTriplo<T> auxiliar = raiz;

        while (auxiliar != null) {
            if ((Integer) dado <= (Integer) auxiliar.getDado()) {
                if (auxiliar.getEsquerda() != null) {
                    auxiliar = auxiliar.getEsquerda();
                } else {
                    auxiliar.setEsquerda(novoNo);
                    novoNo.setGenitor(auxiliar);
                    break;
                }

            } else {
                if (auxiliar.getDireita() != null) {
                    auxiliar = auxiliar.getDireita();
                } else {
                    auxiliar.setDireita(novoNo);
                    novoNo.setGenitor(auxiliar);
                    break;
                }
            }
        }
    }

    @Override
    public void apagar(T dado) {
        NoTriplo<T> auxiliar = raiz;
        while (true) {
            if (dado == auxiliar.getDado()) {
                //Apago, mas antes preciso decidir qual método de apagar deverá ser chamado
                if (auxiliar.getEsquerda() == null && auxiliar.getDireita() == null) {
                    apagarNoFolha(auxiliar);
                } else if (auxiliar.getEsquerda() == null && auxiliar.getDireita() != null) {
                    apagarComUmFilho(auxiliar);
                } else {
                    apagarComDoisFilhos(auxiliar);
                }

            } else if (dado <= auxiliar.getDado()) {
                if (auxiliar.getEsquerda() != null) {
                    auxiliar = auxiliar.getEsquerda();
                }
            } else {
                if (auxiliar.getDireita() == null) {
                    auxiliar = auxiliar.getDireita();
                }
            }
        }
    }

    private void apagarNoFolha(NoTriplo<T> no) {
        NoTriplo<T> auxPai = no.getGenitor();

    }
    private void apagarComUmFilho(NoTriplo<T> no) {}
    private void apagarComDoisFilhos(NoTriplo<T> no) {}

    @Override
    public boolean existe(T dado) {
        NoTriplo<T> auxiliar = raiz;
        boolean existe = false;

        while (true) {
            if ((Integer) dado <= (Integer) auxiliar.getDado()) {
                existe = true;
                break;
            } else {

            }
        }
    }

    @Override
    public void limpar() {
        raiz = null;
    }
}
