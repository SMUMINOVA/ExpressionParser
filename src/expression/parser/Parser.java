package expression.parser;

import expression.basicOperation.ExpressionAndTripleExpression;

/**
 * @author Georgiy Korneev (kgeorgiy@kgeorgiy.info)
 */
public interface Parser<T> {
    ExpressionAndTripleExpression<T> parse(String expression);
}