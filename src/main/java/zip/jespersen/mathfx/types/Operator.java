package zip.jespersen.mathfx.types;

/**
 * The operators supported in math expressions.
 * <p>
 * Each constant has a symbol, an implementation of the operation and a
 * precedence. Multiplication and division bind stronger than addition and
 * subtraction.
 */
public enum Operator implements IOperator {

    /**
     * Addition, symbol {@code +}, precedence 1.
     */
    PLUS('+') {
        @Override
        public double math(double a, double b) {
            return a + b;
        }

        @Override
        public int precedence() {
            return 1;
        }

    },

    /**
     * Subtraction, symbol {@code -}, precedence 1.
     */
    MINUS('-') {
        @Override
        public double math(double a, double b) {
            return a - b;
        }

        @Override
        public int precedence() {
            return 1;
        }
    },

    /**
     * Multiplication, symbol {@code *}, precedence 2.
     */
    MULTI('*') {
        @Override
        public double math(double a, double b) {
            return a * b;
        }

        @Override
        public int precedence() {
            return 2;
        }

    },

    /**
     * Division, symbol {@code :}, precedence 2.
     * <p>
     * Division by zero follows IEEE 754 for {@code double} and yields
     * infinity or NaN instead of throwing an exception.
     */
    DIVIDE(':') {
        @Override
        public double math(double a, double b) {
            return a / b;
        }

        @Override
        public int precedence() {
            return 2;
        }
    };

    private final Character operator;

    Operator(Character op) {
        this.operator = op;
    }

    /**
     * Returns the operator for the given symbol.
     *
     * @param cha the operator symbol, e.g. {@code '+'}
     * @return the matching operator
     * @throws IllegalArgumentException if no operator has this symbol
     */
    public static Operator fromChar(Character cha) {
        for (Operator value : Operator.values()) {
            if (value.getOperator().equals(cha))
                return value;
        }
        throw new IllegalArgumentException("No operator found for " + cha);
    }

    /**
     * Returns the symbol of this operator.
     *
     * @return the operator symbol, e.g. {@code '+'}
     */
    public Character getOperator() {
        return operator;
    }
}