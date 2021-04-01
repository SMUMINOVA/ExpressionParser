package expression.basicOperation;

import expression.exceptions.OverflowException;
import expression.genericOperation.Operation;

public class Multiply<T> extends Binary<T> {

    public Multiply(Operation<T> op, ExpressionAndTripleExpression<T> exp1, ExpressionAndTripleExpression<T> exp2) {
        super(op, exp1, exp2);
    }

    @Override
    protected T apply(T first, T second) throws OverflowException {
        return operation.multiply(first, second);
    }
}