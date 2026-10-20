package zip.jespersen.mathfx;

import java.util.List;
import java.util.Stack;
import zip.jespersen.mathfx.tokens.BracketToken;
import zip.jespersen.mathfx.tokens.MathToken;
import zip.jespersen.mathfx.tokens.OperationToken;

public final class ShuntingYardStack {

    private final Stack<MathToken> storage = new Stack<>();

    public ShuntingYardStack() {
    }

    public void push(MathToken token) {
        storage.push(token);
    }

    public MathToken pop() {
        return storage.pop();
    }

    public MathToken peek() {
        return storage.peek();
    }

    public boolean isEmpty() {
        return storage.isEmpty();
    }

    public List<MathToken> flushOpToOutput(List<MathToken> output, MathToken token) {
        List<MathToken> list = output;
        while (!storage.isEmpty() &&
                token instanceof OperationToken ot &&
                (storage.peek() instanceof OperationToken pot) &&
                ot.getOperator().precedence() <= pot.getOperator().precedence()) {
            list.add(storage.pop());
        }
        storage.push(token);
        return list;
    }

    public List<MathToken> flushToNextBracet(List<MathToken> output) {
        List<MathToken> list = output;
        while (!storage.isEmpty() && (!(storage.peek() instanceof BracketToken) ||
                !(storage.peek() instanceof BracketToken st && st.isOpen())))
            list.add(storage.pop());

        storage.pop();
        return list;
    }

    public List<MathToken> flush(List<MathToken> output) throws IllegalArgumentException {
        List<MathToken> list = output;
        while (!storage.isEmpty()) {
            if (storage.peek() instanceof BracketToken bracketToken && bracketToken.isOpen())
                throw new IllegalArgumentException("Invalid notation!");
            list.add(storage.pop());
        }
        return list;
    }

}
