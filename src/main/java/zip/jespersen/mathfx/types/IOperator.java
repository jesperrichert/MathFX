package zip.jespersen.mathfx.types;

/**
 * An operator that combines two numbers into a result and has a
 * precedence that determines its evaluation order.
 */
public interface IOperator {

    /**
     * Applies this operator to the two operands.
     *
     * @param a the left operand
     * @param b the right operand
     * @return the result of the operation
     */
    public double math(double a, double b);

    /**
     * Returns the precedence of this operator.
     * <p>
     * Operators with a higher value bind stronger and are evaluated first.
     *
     * @return the precedence value
     */
    public int precedence();
}