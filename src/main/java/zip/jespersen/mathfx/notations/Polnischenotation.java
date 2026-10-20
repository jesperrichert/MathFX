package zip.jespersen.mathfx.notations;

import java.util.List;
import zip.jespersen.mathfx.MathTree;
import zip.jespersen.mathfx.NodeParser;
import zip.jespersen.mathfx.TokenParser;
import zip.jespersen.mathfx.tokens.MathToken;
import zip.jespersen.mathfx.types.ParserMode;

public final class Polnischenotation extends AbstractNotation {

    public Polnischenotation(Infixnotation infixnotation) {
        super(TokenParser.parseMathTokens(infixnotation.toNotation()));
    }

    @Override
    public List<MathToken> toTokens() {
        return tokens;
    }

    @Override
    public MathTree toTree(ParserMode mode) throws Exception {
        switch (mode) {
            case SHUNTING_YARD -> {
                return new MathTree(new NodeParser(tokens).computeNodeWithShuntingYard());
            }
            case RECURSIV -> {
                return new MathTree(new NodeParser(tokens).computeNodeRecursive());
            }
            default -> throw new AssertionError();
        }
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