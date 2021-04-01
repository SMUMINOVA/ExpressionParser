package expression.genericOperation;

import expression.exceptions.*;

public interface Operation<T> {
    T getNum(String num) throws InvalidNumberException;

    T add(T first, T second) throws OverflowException;

    T subtract(T first, T second) throws OverflowException;

    T multiply(T first, T second) throws OverflowException;

    T divide(T first, T second) throws ExpressionsException;

    T negate(T first) throws OverflowException;

    T abs(T first) throws OverflowException;

    T square(T first) throws OverflowException;

    T mod(T first, T second);
}
