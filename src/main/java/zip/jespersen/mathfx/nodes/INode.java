package zip.jespersen.mathfx.nodes;

/**
 * A node in a calculation tree that can be evaluated to a numeric result.
 */
public interface INode {

    /**
     * Evaluates this node.
     *
     * @return the result of the calculation
     */
    double calculate();

}