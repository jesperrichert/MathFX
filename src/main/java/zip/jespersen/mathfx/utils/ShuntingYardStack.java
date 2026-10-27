package zip.jespersen.mathfx.utils;

import java.util.List;
import java.util.Stack;
import zip.jespersen.mathfx.tokens.BracketToken;
import zip.jespersen.mathfx.tokens.MathToken;
import zip.jespersen.mathfx.tokens.OperationToken;

/**
 * A stack of {@link MathToken}s used by the shunting-yard algorithm to hold
 * operators and opening brackets until they are moved to the output.
 */
public final class ShuntingYardStack {

    private final Stack<MathToken> storage = new Stack<>();

    /**
     * Creates a new, empty stack.
     */
    public ShuntingYardStack() {
    }

    /**
     * Pushes a token onto the stack.
     *
     * @param token the token to push
     */
    public void push(MathToken token) {
        storage.push(token);
    }

    /**
     * Removes and returns the token on top of the stack.
     *
     * @return the top token
     * @throws java.util.EmptyStackException if the stack is empty
     */
    public MathToken pop() {
        return storage.pop();
    }

    /**
     * Returns the token on top of the stack without removing it.
     *
     * @return the top token
     * @throws java.util.EmptyStackException if the stack is empty
     */
    public MathToken peek() {
        return storage.peek();
    }

    /**
     * Checks whether the stack is empty.
     *
     * @return {@code true} if the stack contains no tokens
     */
    public boolean isEmpty() {
        return storage.isEmpty();
    }

    /**
     * Handles an incoming operator.
     * <p>
     * Operators on top of the stack with the same or a higher precedence are
     * moved to the output first, then the incoming token is pushed onto the
     * stack.
     *
     * @param output the output list that popped operators are appended to
     * @param token  the incoming operator token
     * @return the given output list, with the moved operators appended
     */
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

    /**
     * Handles a closing bracket.
     * <p>
     * Moves tokens from the stack to the output until an opening bracket is
     * found, then removes that bracket from the stack.
     *
     * @param output the output list that popped tokens are appended to
     * @return the given output list, with the moved tokens appended
     * @throws java.util.EmptyStackException if there is no matching opening bracket
     */
    public List<MathToken> flushToNextBracet(List<MathToken> output) {
        List<MathToken> list = output;
        while (!storage.isEmpty() && (!(storage.peek() instanceof BracketToken) ||
                !(storage.peek() instanceof BracketToken st && st.isOpen())))
            list.add(storage.pop());

        storage.pop();
        return list;
    }

    /**
     * Moves all remaining tokens from the stack to the output.
     *
     * @param output the output list that the remaining tokens are appended to
     * @return the given output list, with the remaining tokens appended
     * @throws IllegalArgumentException if an opening bracket is still on the
     *                                  stack, i.e. the brackets are unbalanced
     */
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