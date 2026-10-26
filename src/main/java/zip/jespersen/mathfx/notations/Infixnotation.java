package zip.jespersen.mathfx.notations;

import java.util.List;

import zip.jespersen.mathfx.MathTree;
import zip.jespersen.mathfx.parser.NodeParser;
import zip.jespersen.mathfx.parser.TokenParser;
import zip.jespersen.mathfx.tokens.MathToken;

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
    public MathTree toTree() throws Exception {
        return new MathTree(new NodeParser(tokens).computeNodeRecursive());
    }

}
