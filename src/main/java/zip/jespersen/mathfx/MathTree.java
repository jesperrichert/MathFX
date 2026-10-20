package zip.jespersen.mathfx;

import zip.jespersen.mathfx.nodes.INode;

public class MathTree {

    private final INode node;

    public MathTree(INode node) {
        this.node = node;
    }

    public double calculate() {
        return node.calculate();
    }

}
