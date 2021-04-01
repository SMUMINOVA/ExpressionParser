package expression.genericOperation;

import expression.exceptions.OverflowException;

public class LongTypeOperation implements Operation<Long>{
    @Override
    public Long getNum(String num) {
        return Long.parseLong(num);
    }

    @Override
    public Long add(Long first, Long second) {
        return first + second;
    }

    @Override
    public Long subtract(Long first, Long second){
        return first - second;
    }

    @Override
    public Long multiply(Long first, Long second){
        return first * second;
    }

    @Override
    public Long divide(Long first, Long second){
        return first / second;
    }

    @Override
    public Long negate(Long first){
        return -first;
    }

    @Override
    public Long abs(Long first) {
        if (first > 0) {
            return first;
        } else {
            return negate(first);
        }
    }

    @Override
    public Long square(Long first)  {
        return multiply(first, first);
    }

    @Override
    public Long mod(Long first, Long second) {
        return first % second;
    }
}
