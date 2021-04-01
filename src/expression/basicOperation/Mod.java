package expression.basicOperation;

import expression.genericOperation.Operation;

public class Mod<T> extends Binary<T> {

    public Mod(Operation<T> op, ExpressionAndTripleExpression<T> exp1, ExpressionAndTripleExpression<T> exp2) {
        super(op, exp1, exp2);
    }

    @Override
    protected T apply(T first, T second) {
        return operation.mod(first, second);
    }
}
