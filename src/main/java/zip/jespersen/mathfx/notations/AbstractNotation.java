package zip.jespersen.mathfx.notations;

import java.util.List;
import zip.jespersen.mathfx.tokens.MathToken;

public abstract class AbstractNotation implements INotation {
    protected List<MathToken> tokens;

    protected AbstractNotation(List<MathToken> tokens) {
        this.tokens = tokens;
    }

}
