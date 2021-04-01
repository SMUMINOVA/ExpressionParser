package expression.genericOperation;

import expression.exceptions.InvalidNumberException;
import expression.exceptions.OverflowException;

import java.math.BigInteger;

public class BigIntegerTypeOperation implements Operation<BigInteger> {
    public BigInteger getNum(String num) throws InvalidNumberException {
        try {
            return new BigInteger(num);
        } catch (NumberFormatException ex) {
            throw new InvalidNumberException("Incorrect BigInteger: " + num + " " + ex);
        }
    }

    @Override
    public BigInteger add(BigInteger first, BigInteger second) {
        return first.add(second);
    }

    @Override
    public BigInteger subtract(BigInteger first, BigInteger second) {
        return first.subtract(second);
    }

    @Override
    public BigInteger multiply(BigInteger first, BigInteger second) {
        return first.multiply(second);
    }

    @Override
    public BigInteger divide(BigInteger first, BigInteger second) {
        return first.divide(second);
    }

    @Override
    public BigInteger negate(BigInteger first) {
        return first.negate();
    }

    @Override
    public BigInteger abs(BigInteger first) throws OverflowException {
        if (first.compareTo(BigInteger.valueOf(0)) > 0) {
            return first;
        } else {
            return negate(first);
        }
    }

    @Override
    public BigInteger square(BigInteger first) throws OverflowException {
        return multiply(first, first);
    }

    @Override
    public BigInteger mod(BigInteger first, BigInteger second) {
        return first.mod(second);
    }
}
