package zip.jespersen.mathfx.notations;

import java.util.List;
import zip.jespersen.mathfx.MathTree;
import zip.jespersen.mathfx.tokens.MathToken;

/**
 * A math expression in a specific notation, which can be converted into
 * its string form, its tokens, or a calculation tree.
 */
public interface INotation {

    /**
     * Returns this expression as a string in its notation.
     *
     * @return the expression string
     */
    String toNotation();

    /**
     * Returns the tokens of this expression.
     *
     * @return the list of tokens
     */
    List<MathToken> toTokens();

    /**
     * Parses this expression into a calculation tree.
     *
     * @return the resulting {@link MathTree}
     * @throws Exception if the expression cannot be parsed into a valid tree
     */
    MathTree toTree() throws Exception;

}