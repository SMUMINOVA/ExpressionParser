package expression.basicOperation;

import expression.exceptions.ExpressionsException;
import expression.genericOperation.Operation;

public class Divide<T> extends Binary<T> {
    public Divide(Operation<T> op, ExpressionAndTripleExpression<T> exp1, ExpressionAndTripleExpression<T> exp2) {
        super(op, exp1, exp2);
    }

    @Override
    protected T apply(T first, T second) throws ExpressionsException {
        return operation.divide(first, second);
    }
}
