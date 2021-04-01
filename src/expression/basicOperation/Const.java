package expression.basicOperation;

import java.util.Objects;

public class Const<T> implements ExpressionAndTripleExpression<T> {

    private final T number;

    public Const(T x) {
        number = x;
    }

    @Override
    public T evaluate(T x, T y, T z) {
        return number;
    }

    @Override
    public T evaluate(T x) {
        return number;
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }

    public boolean equals(Object obj) {
        if (obj != null && getClass() == obj.getClass()) {
            Const<T> that = (Const<T>) obj;
            return this.number == that.number;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(number, getClass());
    }
}