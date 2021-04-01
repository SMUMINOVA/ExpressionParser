package expression.genericOperation;

import expression.exceptions.*;

public class ShortTypeOperation implements Operation<Short> {

    @Override
    public Short getNum(String num) throws InvalidNumberException {
        try {
            return (short)Integer.parseInt(num);
        } catch (NumberFormatException ex) {
            throw new InvalidNumberException("Incorrect short: " + num + " " + ex);
        }
    }

    @Override
    public Short add(Short first, Short second) throws OverflowException {
        return (short) (first + second);
    }

    @Override
    public Short subtract(Short first, Short second){
        return (short) (first - second);
    }

    @Override
    public Short multiply(Short first, Short second) {
        return (short) (first * second);
    }

    @Override
    public Short divide(Short first, Short second) {
        return (short) (first / second);
    }

    @Override
    public Short negate(Short first) {
        return (short) -first;
    }

    @Override
    public Short abs(Short first) {
        if (first > 0) {
            return first;
        } else {
            return negate(first);
        }
    }

    @Override
    public Short square(Short first) {
        return multiply(first, first);
    }

    @Override
    public Short mod(Short first, Short second) {
        return (short) (first % second);
    }
}