package zip.jespersen.mathfx.tokens;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import zip.jespersen.mathfx.types.Operator;

public final class OperationToken extends MathToken {
    private final String numberIdentifier = UUID.randomUUID().toString();
    private final Character operatorChar;
    private final Operator operator;

    public OperationToken(Character operator) {
        this.operatorChar = operator;
        this.operator = Operator.fromChar(operator);
    }

    public OperationToken(Operator operator) {
        this.operatorChar = operator.getOperator();
        this.operator = operator;
    }

    public static final Character[] validOperators = new Character[] { '+', '-', '*', ':' };
    public static final List<Character> validOperatorsAsList = Arrays.asList(validOperators);

    public Operator getOperator() {
        return operator;
    }

    public char getOperatorSymbol() {
        return operatorChar;
    }

    @Override
    public String toString() {
        return operatorChar.toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((numberIdentifier == null) ? 0 : numberIdentifier.hashCode());
        result = prime * result + ((operatorChar == null) ? 0 : operatorChar.hashCode());
        result = prime * result + ((operator == null) ? 0 : operator.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        OperationToken other = (OperationToken) obj;
        if (numberIdentifier == null) {
            if (other.numberIdentifier != null)
                return false;
        } else if (!numberIdentifier.equals(other.numberIdentifier))
            return false;
        if (operatorChar == null) {
            if (other.operatorChar != null)
                return false;
        } else if (!operatorChar.equals(other.operatorChar))
            return false;
        if (operator != other.operator)
            return false;
        return true;
    }

}