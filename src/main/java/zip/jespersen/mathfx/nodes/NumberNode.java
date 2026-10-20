package zip.jespersen.mathfx.nodes;

public class NumberNode implements INode {

    private final double number;

    public NumberNode(double number) {
        this.number = number;
    }

    public double getNumber() {
        return number;
    }

    @Override
    public double calculate() {
        return number;
    }

}
