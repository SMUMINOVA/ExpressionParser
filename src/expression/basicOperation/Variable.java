package expression.basicOperation;

import java.util.Objects;

public class Variable<T> implements ExpressionAndTripleExpression<T> {

    private final String val;

    public Variable(String s) {
        val = s;
    }

    @Override
    public T evaluate(T x, T y, T z) {
        return switch (val) {
            case "x" -> x;
            case "y" -> y;
            default -> z;
        };
    }

    @Override
    public T evaluate(T x) {
        return x;
    }

    @Override
    public String toString() {
        return val;
    }

    public boolean equals(Object obj) {
        if (obj != null && getClass() == obj.getClass()) {
            Variable<T> that = (Variable<T>) obj;
            return this.val.equals(that.val);
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(val, getClass());
    }
}
