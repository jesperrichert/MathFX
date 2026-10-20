package zip.jespersen.mathfx.nodes;

import zip.jespersen.mathfx.types.Operator;

public class OperationNode implements INode {

    private final Operator operator;
    private INode leftNode;
    private INode rightNode;

    public OperationNode(Operator operator) {
        this.operator = operator;
    }

    public OperationNode setLeftNode(INode node) {
        this.leftNode = node;
        return this;
    }

    public OperationNode setRightNode(INode node) {
        this.rightNode = node;
        return this;
    }

    @Override
    public double calculate() {
        return operator.math(leftNode.calculate(), rightNode.calculate());
    }

}
