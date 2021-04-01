package expression.generic;

import expression.basicOperation.ExpressionAndTripleExpression;
import expression.exceptions.ExpressionsException;
import expression.genericOperation.*;
import expression.parser.ExpressionParser;
import expression.parser.Parser;
import expression.parser.ParserException;

public class GenericTabulator implements Tabulator {
    @Override
    public Object[][][] tabulate(String mode, String expression, int x1, int x2, int y1, int y2, int z1, int z2) {
        Operation<?> op;
        switch (mode) {
            case "i" -> op = new IntegerTypeOperation(true);
            case "d" -> op = new DoubleTypeOperation();
            case "bi" -> op = new BigIntegerTypeOperation();
            case "u" -> op = new IntegerTypeOperation(false);
            case "l" -> op = new LongTypeOperation();
            case "s" -> op = new ShortTypeOperation();
            default -> throw new IllegalStateException("Unexpected value: " + mode);
        }
        return getResult(op, expression, x1, x2, y1, y2, z1, z2);
    }

    private <T> Object[][][] getResult(Operation<T> op, String expression, int x1, int x2, int y1, int y2, int z1, int z2) {
        Object[][][] res = new Object[x2 - x1 + 1][y2 - y1 + 1][z2 - z1 + 1];
        Parser<T> parser = new ExpressionParser<>(op);
        ExpressionAndTripleExpression<T> ex = parser.parse(expression);
        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y2; j++) {
                for (int k = z1; k <= z2; k++) {
                    try {
                        res[i - x1][j - y1][k - z1] = ex.evaluate(op.getNum(Integer.toString(i)), op.getNum(Integer.toString(j)), op.getNum(Integer.toString(k)));
                    } catch (ExpressionsException | ParserException e) {
                        res[i - x1][j - y1][k - z1] = null;
                    }
                }
            }
        }
        return res;
    }
}
