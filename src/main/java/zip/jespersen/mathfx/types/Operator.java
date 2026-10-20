package zip.jespersen.mathfx.types;

public enum Operator implements IOperator {
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

    public static Operator fromChar(Character cha) {
        for (Operator value : Operator.values()) {
            if (value.getOperator().equals(cha))
                return value;
        }
        throw new IllegalArgumentException("No operator found for " + cha);
    }

    public Character getOperator() {
        return operator;
    }
}