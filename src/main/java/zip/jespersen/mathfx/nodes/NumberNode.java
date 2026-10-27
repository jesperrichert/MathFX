package zip.jespersen.mathfx.nodes;

/**
 * A leaf node that holds a constant number.
 */
public class NumberNode implements INode {

    private final double number;

    /**
     * Creates a new number node.
     *
     * @param number the number to hold
     */
    public NumberNode(double number) {
        this.number = number;
    }

    /**
     * Returns the number held by this node.
     *
     * @return the number
     */
    public double getNumber() {
        return number;
    }

    /**
     * Returns the held number.
     *
     * @return the number held by this node
     */
    @Override
    public double calculate() {
        return number;
    }

}