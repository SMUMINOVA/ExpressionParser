package expression.exceptions;

public class DivideByZeroException extends OperationException {
    public DivideByZeroException (String m) {
        super(m);
    }
}
