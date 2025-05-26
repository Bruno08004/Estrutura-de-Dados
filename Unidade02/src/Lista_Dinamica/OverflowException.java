package src.Lista_Dinamica;

public class OverflowException extends RuntimeException {

    @Override
    public OverflowException(){
        super();
    }

    @Override
    public UnderflowException(String msg){
        super(msg);
    }
}
