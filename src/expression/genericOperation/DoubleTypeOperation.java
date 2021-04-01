package expression.genericOperation;

import expression.exceptions.ExpressionsException;
import expression.exceptions.InvalidNumberException;
import expression.exceptions.OverflowException;

public class DoubleTypeOperation implements Operation<Double> {
    @Override
    public Double getNum(String num) throws InvalidNumberException {
        try {
            return Double.parseDouble(num);
        } catch (NumberFormatException ex) {
            throw new InvalidNumberException("Incorrect Double: " + num + " " + ex);
        }
    }

    @Override
    public Double add(Double first, Double second) {
        return first + second;
    }

    @Override
    public Double subtract(Double first, Double second) {
        return first - second;
    }

    @Override
    public Double multiply(Double first, Double second) {
        return first * second;
    }

    @Override
    public Double divide(Double first, Double second) {
        return first / second;
    }

    @Override
    public Double negate(Double first) {
        return -first;
    }

    @Override
    public Double abs(Double first){
        if (first > 0) {
            return first;
        } else {
            return negate(first);
        }
    }

    @Override
    public Double square(Double first){
        return multiply(first, first);
    }

    @Override
    public Double mod(Double first, Double second){
        return first % second;
    }
}
