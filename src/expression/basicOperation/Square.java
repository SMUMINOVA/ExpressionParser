package expression.basicOperation;

import expression.exceptions.OverflowException;
import expression.genericOperation.Operation;

public class Square<T> extends Unary<T> {

    public Square(Operation<T> op, ExpressionAndTripleExpression<T> exp1) {
        super(op, exp1);
    }

    @Override
    protected T apply(T first) throws OverflowException {
        return operation.square(first);
    }
}
