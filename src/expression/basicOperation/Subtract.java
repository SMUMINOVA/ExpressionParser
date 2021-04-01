package expression.basicOperation;

import expression.exceptions.OverflowException;
import expression.genericOperation.Operation;

public class Subtract<T> extends Binary<T> {
    public Subtract(Operation<T> op, ExpressionAndTripleExpression<T> exp1, ExpressionAndTripleExpression<T> exp2) {
        super(op, exp1, exp2);
    }

    @Override
    protected T apply(T first, T second) throws OverflowException {
        return operation.subtract(first, second);
    }
}