package expression.parser;

import expression.basicOperation.*;
import expression.exceptions.InvalidNumberException;
import expression.genericOperation.Operation;

public class ExpressionParser<T> implements Parser<T> {
    private enum Value {
        NUMBER, ADD, MINUS, MUL, DIV, LP, RP, Mod, SQUARE, VARIABLE, SUB, PRINT, ABS, OPERATION
    }

    private static Value current;
    private static String expression;
    private int index;
    private final Operation<T> operation;

    public ExpressionParser(Operation<T> op) {
        operation = op;
    }

    public ExpressionAndTripleExpression<T> parse(final String source) {
        index = 0;
        expression = source;
        current = Value.PRINT;
        return plusMinus();
    }

    private ExpressionAndTripleExpression<T> parseElement() {
        parseValue();
        ExpressionAndTripleExpression<T> ex;
        switch (current) {
            case NUMBER -> {
                ex = parseNumber();
                parseValue();
            }
            case VARIABLE -> {
                ex = parseVariable();
                parseValue();
            }
            case MINUS -> ex = minus();
            case ABS -> ex = abs();
            case SQUARE -> ex = square();
            case LP -> {
                ex = plusMinus();
                parseValue();
            }
            default -> throw new ParserException("primary expected");
        }
        return ex;
    }

    private void parseValue() {
        skipWhitespace();
        if (eof())
            return;
        if (test('(')) {
            current = Value.LP;
        } else if (test(')')) {
            current = Value.RP;
        } else if (test('+')) {
            current = Value.ADD;
        } else if (test('-')) {
            if (current == Value.NUMBER || current == Value.VARIABLE || current == Value.RP) {
                current = Value.SUB;
            } else {
                if (between('0', '9')) {
                    index--;
                    current = Value.NUMBER;
                } else {
                    current = Value.MINUS;
                }
            }
        } else if (test('*')) {
            current = Value.MUL;
        } else if (test('/')) {
            current = Value.DIV;
        } else if (between('0', '9')) {
            current = Value.NUMBER;
        } else if (between('x', 'z')) {
            current = Value.VARIABLE;
        } else if (between('a', 'z')) {
            parseOp();
        } else {
            throw new ParserException("Unexpected token");
        }
    }

    private void parseOp() {
        StringBuilder sb = new StringBuilder();
        while (between('a', 'z')) {
            sb.append(expression.charAt(index));
            index++;
        }
        switch (sb.toString()) {
            case "abs" -> current = Value.ABS;
            case "square" -> current = Value.SQUARE;
            case "mod" -> current = Value.Mod;
            default -> throw new ParserException("No such operation");
        }
    }

    private ExpressionAndTripleExpression<T> parseVariable() {
        StringBuilder sb = new StringBuilder();
        while (between('a', 'z')) {
            sb.append(expression.charAt(index));
            index++;
        }
        if (!sb.toString().equals("x") && !sb.toString().equals("y") && !sb.toString().equals("z"))
            throw new ParserException("No such variable");
        return new Variable<T>(sb.toString());
    }

    private ExpressionAndTripleExpression<T> parseNumber() {
        final StringBuilder sb = new StringBuilder();
        if (test('-')) {
            sb.append('-');
        }
        if (test('0')) {
            sb.append('0');
        } else if (between('1', '9')) {
            while (between('0', '9')) {
                sb.append(expression.charAt(index));
                index++;
            }
        } else {
            throw new ParserException("Invalid number");
        }
        try {
            return new Const<T>(operation.getNum(sb.toString()));
        } catch (NumberFormatException | InvalidNumberException e) {
            throw new ParserException("Invalid number " + sb);
        }
    }

    private ExpressionAndTripleExpression<T> plusMinus() {
        ExpressionAndTripleExpression<T> el = mulDivMod();
        while (true) {
            if (current == Value.ADD) {
                el = new Add<T>(operation, el, mulDivMod());
            } else if (current == Value.SUB) {
                el = new Subtract<T>(operation, el, mulDivMod());
            } else {
                return el;
            }
        }
    }

    private ExpressionAndTripleExpression<T> mulDivMod() {
        ExpressionAndTripleExpression<T> el = parseElement();
        while (true) {
            if (current == Value.MUL) {
                el = new Multiply<T>(operation, el, parseElement());
            } else if (current == Value.DIV) {
                el = new Divide<T>(operation, el, parseElement());
            } else if (current == Value.Mod) {
                el = new Mod<T>(operation, el, parseElement());
            } else {
                return el;
            }
        }
    }

    private ExpressionAndTripleExpression<T> abs() {
        return new Abs<T>(operation, parseElement());
    }

    private ExpressionAndTripleExpression<T> square() {
        return new Square<T>(operation, parseElement());
    }

    private ExpressionAndTripleExpression<T> minus() {
        return new Negate<T>(operation, parseElement());
    }

    private void skipWhitespace() {
        while (test(' ') || test('\r') || test('\n') || test('\t')) {
            // skip
        }
    }

    private boolean test(char expected) {
        if (!eof() && expression.charAt(index) == expected) {
            index++;
            return true;
        }
        return false;
    }

    private boolean eof() {
        return index >= expression.length();
    }

    private boolean between(final char from, final char to) {
        return !eof() && from <= expression.charAt(index) && expression.charAt(index) <= to;
    }
}
