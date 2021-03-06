package expression.basicOperation;

import expression.exceptions.ExpressionsException;

/**
 * @author Georgiy Korneev (kgeorgiy@kgeorgiy.info)
 */
public interface TripleExpression<T> extends ToMiniString {
    T evaluate(T x, T y, T z) throws ExpressionsException;
}