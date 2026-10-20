package zip.jespersen.mathfx.notations;

import java.util.List;
import zip.jespersen.mathfx.MathTree;
import zip.jespersen.mathfx.NodeParser;
import zip.jespersen.mathfx.TokenParser;
import zip.jespersen.mathfx.tokens.MathToken;
import zip.jespersen.mathfx.types.ParserMode;

public final class Infixnotation extends AbstractNotation {
    private final String notation;

    public Infixnotation(String notation) {
        super(TokenParser.parseMathTokens(notation));
        this.notation = notation;
    }

    @Override
    public String toNotation() {
        return notation;
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

}
