package expression.basicOperation;

import expression.exceptions.ExpressionsException;

public interface Expression<T> extends ToMiniString {
    T evaluate(T x) throws ExpressionsException;
}
