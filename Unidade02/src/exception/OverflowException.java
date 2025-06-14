package src.exception;

/**
 * Classe que representa uma exceção de estouro (overflow) em uma lista dinâmica.
 * Esta exceção é lançada quando se tenta adicionar um elemento a uma lista que já está cheia.
 */
public class OverflowException extends RuntimeException {

    /**
     * Construtor padrão que cria uma nova instância de OverflowException sem mensagem.
     */
    public OverflowException() {
        super();
    }

    /**
     * Construtor que cria uma nova instância de OverflowException com uma mensagem específica.
     *
     * @param msg A mensagem de erro a ser associada à exceção.
     */
    public OverflowException(String msg) {
        super(msg);
    }
}
