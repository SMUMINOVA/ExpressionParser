package expression.basicOperation;

import expression.exceptions.ExpressionsException;
import expression.genericOperation.Operation;

import java.util.Objects;

public abstract class Binary<T> implements ExpressionAndTripleExpression<T> {
    protected ExpressionAndTripleExpression<T> first, second;
    protected Operation<T> operation;

    public Binary(Operation<T> op, ExpressionAndTripleExpression<T> exp1, ExpressionAndTripleExpression<T> exp2) {
        first = exp1;
        second = exp2;
        operation = op;
    }

    public T evaluate(T x) throws ExpressionsException {
        return apply(first.evaluate(x), second.evaluate(x));
    }

    public T evaluate(T x, T y, T z) throws ExpressionsException {
        return apply(first.evaluate(x, y, z), second.evaluate(x, y, z));
    }

    protected abstract T apply(T first, T second) throws ExpressionsException;

    @Override
    public String toString() {
        return "(" + first.toString() + " " + operation + " " + second.toString() + ")";
    }

    public boolean equals(Object obj) {
        if (obj != null && getClass() == obj.getClass()) {
            Binary<T> that = (Binary<T>) obj;
            return this.first.equals(that.first) && this.second.equals(that.second);
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash("(", first, getClass(), second, ")");
    }
}
