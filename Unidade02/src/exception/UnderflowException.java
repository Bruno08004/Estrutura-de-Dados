package src.exception;

/**
 * Classe que representa uma exceção de subfluxo (underflow) em uma lista dinâmica.
 * Esta exceção é lançada quando se tenta remover um elemento de uma lista que já está vazia.
 */
public class UnderflowException extends RuntimeException {
    /**
     * Construtor padrão que cria uma nova instância de UnderflowException sem mensagem.
     */
    public UnderflowException() {
        super();
    }

    /**
     * Construtor que cria uma nova instância de UnderflowException com uma mensagem específica.
     *
     * @param msg A mensagem de erro a ser associada à exceção.
     */
    public UnderflowException(String msg) {
        super(msg);
    }
}
