package Pilha_Estatica.Pilha;

public class PilhaEstaticaPrincipal {
    public static void main(String[] args) {
        //PilhaEstatica p1 = new PilhaEstatica(30); - Caso necessite de algum método em específico da classe
        Empilhavel p2 = new PilhaEstatica(30); //instaciar pela interface é uma boa prática, caso não seja necessário usar algum método além das que são implementadas na interface como contrato

        p2.empilhar("Instituto");
        p2.empilhar("Federal");
        System.out.println("Pilha=" + p2.imprimir());
        System.out.println("Espiar:" + p2.espiar());
        p2.empilhar("Educação");
        p2.empilhar("de");
        p2.empilhar("Ciência");
        p2.empilhar("e");
        System.out.println("Espiar:" + p2.espiar());
        Object conteudo = p2.desempilhar();
        p2.desempilhar();
        p2.empilhar("Tecnologia");
        p2.empilhar("da");
        p2.empilhar("Bahia");
        p2.empilhar(p2.desempilhar());
        p2.empilhar(conteudo);
        System.out.println("Pilha=" + p2.imprimir());

    }

}