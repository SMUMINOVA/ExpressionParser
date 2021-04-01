package expression.basicOperation;

import expression.exceptions.OverflowException;
import expression.genericOperation.Operation;

public class Add<T> extends Binary<T> {

    public Add(Operation<T> op, ExpressionAndTripleExpression<T> exp1, ExpressionAndTripleExpression<T> exp2) {
        super(op, exp1, exp2);
    }

    @Override
    protected T apply(T first, T second) throws OverflowException {
        return operation.add(first, second);
    }
}
