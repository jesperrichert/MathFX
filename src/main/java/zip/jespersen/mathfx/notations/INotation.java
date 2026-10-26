package zip.jespersen.mathfx.notations;

import java.util.List;
import zip.jespersen.mathfx.MathTree;
import zip.jespersen.mathfx.tokens.MathToken;

public interface INotation {
    String toNotation();

    List<MathToken> toTokens();

    MathTree toTree() throws Exception;
}
