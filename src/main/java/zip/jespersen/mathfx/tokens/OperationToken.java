package zip.jespersen.mathfx.tokens;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import zip.jespersen.mathfx.types.Operator;

/**
 * A token representing a mathematical operator such as {@code +}, {@code -},
 * {@code *} or {@code :}.
 * <p>
 * Every instance has its own unique identifier, so two operation tokens with
 * the same operator are still distinguishable from each other.
 */
public final class OperationToken extends MathToken {
    private final String numberIdentifier = UUID.randomUUID().toString();
    private final Character operatorChar;
    private final Operator operator;

    /**
     * Creates an operation token from a character.
     *
     * @param operator the operator character, one of {@link #validOperators}
     */
    public OperationToken(Character operator) {
        this.operatorChar = operator;
        this.operator = Operator.fromChar(operator);
    }

    /**
     * Creates an operation token from an {@link Operator} constant.
     *
     * @param operator the operator
     */
    public OperationToken(Operator operator) {
        this.operatorChar = operator.getOperator();
        this.operator = operator;
    }

    /**
     * The characters accepted as operators.
     */
    public static final Character[] validOperators = new Character[] { '+', '-', '*', ':' };

    /**
     * The characters accepted as operators, as a fixed-size list view
     * of {@link #validOperators}.
     */
    public static final List<Character> validOperatorsAsList = Arrays.asList(validOperators);

    /**
     * Returns the {@link Operator} of this token.
     *
     * @return the operator
     */
    public Operator getOperator() {
        return operator;
    }

    /**
     * Returns the character of this operator.
     *
     * @return the operator symbol, e.g. {@code '+'}
     */
    public char getOperatorSymbol() {
        return operatorChar;
    }

    /**
     * Returns the operator symbol as a string.
     *
     * @return the operator symbol, e.g. {@code "+"}
     */
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

    /**
     * Compares this token to another object. Because of the per-instance
     * identifier, only an instance is equal to itself.
     *
     * @param obj the object to compare with
     * @return {@code true} if both tokens are equal
     */
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