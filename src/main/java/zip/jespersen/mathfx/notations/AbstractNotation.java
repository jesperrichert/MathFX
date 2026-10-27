package zip.jespersen.mathfx.notations;

import java.util.List;
import zip.jespersen.mathfx.tokens.MathToken;

/**
 * Base class for notations that work on a list of {@link MathToken}s.
 */
public abstract class AbstractNotation implements INotation {

    /**
     * The tokens this notation operates on.
     */
    protected List<MathToken> tokens;

    /**
     * Creates a new notation for the given tokens.
     *
     * @param tokens the tokens to operate on
     */
    protected AbstractNotation(List<MathToken> tokens) {
        this.tokens = tokens;
    }

}