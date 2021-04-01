package expression.genericOperation;

import expression.exceptions.*;

public class IntegerTypeOperation implements Operation<Integer> {
    private final boolean needChek;

    public IntegerTypeOperation(boolean check) {
        needChek = check;
    }

    @Override
    public Integer getNum(String num) throws InvalidNumberException {
        try {
            return Integer.parseInt(num);
        } catch (NumberFormatException ex) {
            throw new InvalidNumberException("Incorrect Integer: " + num + " " + ex);
        }
    }

    @Override
    public Integer add(Integer first, Integer second) throws OverflowException {
        if (needChek && ((first > 0 && second > Integer.MAX_VALUE - first) || (first < 0 && second < Integer.MIN_VALUE - first)))
            throw new OverflowException("overflow");
        return first + second;
    }

    @Override
    public Integer subtract(Integer first, Integer second) throws OverflowException {
        if (needChek && ((first >= 0 && second <= 0 && first > Integer.MAX_VALUE + second) || (first <= 0 && second >= 0 && first < Integer.MIN_VALUE + second)))
            throw new OverflowException("overflow");
        return first - second;
    }

    @Override
    public Integer multiply(Integer first, Integer second) throws OverflowException {
        if (needChek && (first > 0 && second > 0 && first > Integer.MAX_VALUE / second ||
                first > 0 && second < 0 && second != -1 && first > Integer.MIN_VALUE / second ||
                first < 0 && second > 0 && first < Integer.MIN_VALUE / second ||
                first < 0 && second < 0 && first < Integer.MAX_VALUE / second))
            throw new OverflowException("overflow");
        return first * second;
    }

    @Override
    public Integer divide(Integer first, Integer second) throws ExpressionsException {
        if (needChek && second == 0)
            throw new DivideByZeroException("Divide by zero");
        if (needChek && first == Integer.MIN_VALUE && second == -1)
            throw new OverflowException("overflow");
        return first / second;
    }

    @Override
    public Integer negate(Integer first) throws OverflowException {
        if (needChek && first == Integer.MIN_VALUE){
            throw new OverflowException("overflow");
        }
        return -first;
    }

    @Override
    public Integer abs(Integer first) throws OverflowException {
        if (first > 0) {
            return first;
        } else {
            return negate(first);
        }
    }

    @Override
    public Integer square(Integer first) throws OverflowException {
        return multiply(first, first);
    }

    @Override
    public Integer mod(Integer first, Integer second) {
        return first % second;
    }
}