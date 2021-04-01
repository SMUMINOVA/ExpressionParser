package expression.basicOperation;

import expression.exceptions.ExpressionsException;
import expression.genericOperation.Operation;

import java.util.Objects;

public abstract class Unary<T> implements ExpressionAndTripleExpression<T> {
    protected ExpressionAndTripleExpression<T> first;
    protected Operation<T> operation;

    public Unary(Operation<T> op, ExpressionAndTripleExpression<T> exp1) {
        first = exp1;
        operation = op;
    }

    public T evaluate(T x) throws ExpressionsException {
        return apply(first.evaluate(x));
    }

    public T evaluate(T x, T y, T z) throws ExpressionsException {
        return apply(first.evaluate(x, y, z));
    }

    protected abstract T apply(T first) throws ExpressionsException;

    @Override
    public String toString() {
        return "(" + first.toString() + " " + operation + " " + ")";
    }

    public boolean equals(Object obj) {
        if (obj != null && getClass() == obj.getClass()) {
            Unary<T> that = (Unary<T>) obj;
            return this.first.equals(that.first);
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash("(", first, getClass(), ")");
    }
}
