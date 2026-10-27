package zip.jespersen.mathfx;

import zip.jespersen.mathfx.nodes.INode;

/**
 * A holder for the root {@link INode} of a calculation tree.
 */
public class MathTree {

    private final INode node;

    /**
     * Creates a new math tree.
     *
     * @param node the root node of the tree
     */
    public MathTree(INode node) {
        this.node = node;
    }

    /**
     * Evaluates the tree by calculating its root node.
     *
     * @return the result of the calculation
     */
    public double calculate() {
        return node.calculate();
    }

}