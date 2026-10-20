package zip.jespersen.mathfx.notations;

import java.util.List;
import zip.jespersen.mathfx.MathTree;
import zip.jespersen.mathfx.tokens.MathToken;
import zip.jespersen.mathfx.types.ParserMode;

public interface INotation {
    public String toNotation();

    public List<MathToken> toTokens();

    public MathTree toTree(ParserMode mode) throws Exception;
}
