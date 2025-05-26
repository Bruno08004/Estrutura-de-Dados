package src.Lista_Dinamica;

public class UnderflowException extends RuntimeException{
    @Override
    public UnderflowException(){
        super();
    }

    @Override
    public UnderflowException(String msg){
        super(msg);
    }
}
