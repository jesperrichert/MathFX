package zip.jespersen.mathfx.notations;

import java.util.List;

import zip.jespersen.mathfx.MathTree;
import zip.jespersen.mathfx.parser.NodeParser;
import zip.jespersen.mathfx.parser.TokenParser;
import zip.jespersen.mathfx.tokens.MathToken;

public final class Polnischenotation extends AbstractNotation {

    public Polnischenotation(Infixnotation infixnotation) {
        super(TokenParser.parseMathTokens(infixnotation.toNotation()));
    }

    @Override
    public List<MathToken> toTokens() {
        return tokens;
    }

    @Override
    public MathTree toTree() throws Exception {
        return new MathTree(new NodeParser(tokens).computeNodeRecursive());
    }

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