package src.exception;

public class OverflowException extends RuntimeException {

    public OverflowException(){
        super();
    }

    public OverflowException(String msg){
        super(msg);
    }
}
