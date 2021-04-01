package expression.basicOperation;

import expression.exceptions.OverflowException;
import expression.genericOperation.Operation;

public class Abs<T> extends Unary<T> {

    public Abs(Operation<T> op, ExpressionAndTripleExpression<T> exp1) {
        super(op, exp1);
    }

    @Override
    protected T apply(T first) throws OverflowException {
        return operation.abs(first);
    }


}
