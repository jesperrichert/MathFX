package zip.jespersen.mathfx.notations;

import java.util.List;

import zip.jespersen.mathfx.MathTree;
import zip.jespersen.mathfx.parser.NodeParser;
import zip.jespersen.mathfx.parser.TokenParser;
import zip.jespersen.mathfx.tokens.MathToken;

/**
 * A math expression in infix notation, e.g. {@code 3 + 4 * 2}.
 */
public final class Infixnotation extends AbstractNotation {

    private final String notation;

    /**
     * Creates a new infix notation and tokenizes the given expression.
     *
     * @param notation the expression in infix notation
     */
    public Infixnotation(String notation) {
        super(TokenParser.parseMathTokens(notation));
        this.notation = notation;
    }

    /**
     * Returns the original expression string.
     *
     * @return the expression in infix notation
     */
    @Override
    public String toNotation() {
        return notation;
    }

    /**
     * Returns the tokens of this expression.
     *
     * @return the list of tokens
     */
    @Override
    public List<MathToken> toTokens() {
        return tokens;
    }

    /**
     * Parses the tokens into a calculation tree.
     *
     * @return the resulting {@link MathTree}
     * @throws Exception if the tokens cannot be parsed into a valid tree
     */
    @Override
    public MathTree toTree() throws Exception {
        return new MathTree(new NodeParser(tokens).computeNodeRecursive());
    }

}