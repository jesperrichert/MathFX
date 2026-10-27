package zip.jespersen.mathfx.nodes;

import zip.jespersen.mathfx.types.Operator;

/**
 * A node that applies an {@link Operator} to two child nodes.
 */
public class OperationNode implements INode {

    private final Operator operator;
    private INode leftNode;
    private INode rightNode;

    /**
     * Creates a new operation node.
     *
     * @param operator the operator to apply to the two operands
     */
    public OperationNode(Operator operator) {
        this.operator = operator;
    }

    /**
     * Sets the left operand.
     *
     * @param node the left operand
     * @return this node, for chaining
     */
    public OperationNode setLeftNode(INode node) {
        this.leftNode = node;
        return this;
    }

    /**
     * Sets the right operand.
     *
     * @param node the right operand
     * @return this node, for chaining
     */
    public OperationNode setRightNode(INode node) {
        this.rightNode = node;
        return this;
    }

    /**
     * Evaluates both operands and applies the operator to them.
     *
     * @return the result of the operation
     * @throws NullPointerException if an operand has not been set
     */
    @Override
    public double calculate() {
        return operator.math(leftNode.calculate(), rightNode.calculate());
    }

}