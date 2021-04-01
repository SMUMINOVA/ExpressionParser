package expression.basicOperation;

import expression.exceptions.ExpressionsException;
import expression.genericOperation.Operation;

import java.util.Objects;

public class Negate<T> implements ExpressionAndTripleExpression<T> {
    private final ExpressionAndTripleExpression<T> exp;
    private final Operation<T> operation;

    public Negate(Operation<T> op, ExpressionAndTripleExpression<T> exp) {
        this.exp = exp;
        operation = op;
    }

    @Override
    public T evaluate(T x) throws ExpressionsException {
        return operation.negate(x);
    }

    @Override
    public T evaluate(T x, T y, T z) throws ExpressionsException {
        return operation.negate(x);
    }

    public String toString() {
        return "-(" + exp.toString() + ")";
    }

    public boolean equals(Object obj) {
        if (obj != null && getClass() == obj.getClass()) {
            Negate<T> that = (Negate<T>) obj;
            return this.exp.equals(that.exp);
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash("-(", exp, getClass(), ")");
    }
}