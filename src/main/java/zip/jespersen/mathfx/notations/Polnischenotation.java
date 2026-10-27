package zip.jespersen.mathfx.notations;

import java.util.List;

import zip.jespersen.mathfx.MathTree;
import zip.jespersen.mathfx.parser.NodeParser;
import zip.jespersen.mathfx.parser.TokenParser;
import zip.jespersen.mathfx.tokens.MathToken;

/**
 * A math expression converted from {@link Infixnotation} to Polish notation
 * using the shunting-yard algorithm.
 */
public final class Polnischenotation extends AbstractNotation {

    /**
     * Creates a new Polish notation from an infix expression.
     *
     * @param infixnotation the infix expression to convert
     */
    public Polnischenotation(Infixnotation infixnotation) {
        super(TokenParser.parseMathTokens(infixnotation.toNotation()));
    }

    /**
     * Returns the tokens of the original expression.
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

    /**
     * Returns the expression in Polish notation.
     * <p>
     * If the conversion fails, the error message is returned instead.
     *
     * @return the converted expression, or the error message if the
     *         expression is invalid
     */
    @Override
    public String toNotation() {
        try {
            StringBuilder sb = new StringBuilder();
            for (MathToken token : TokenParser.computeShuntingYard(tokens)) {
                sb.append(token.toString());
            }
            return sb.toString();
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
    }
}