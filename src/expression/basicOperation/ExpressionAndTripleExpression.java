package expression.basicOperation;

public interface ExpressionAndTripleExpression<T> extends TripleExpression<T>, Expression<T> {
    int hashCode();

    String toString();
}
