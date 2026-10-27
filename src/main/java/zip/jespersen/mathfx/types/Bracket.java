package zip.jespersen.mathfx.types;

/**
 * The bracket types supported in math expressions.
 */
public enum Bracket {

    /**
     * The opening bracket {@code (}.
     */
    OPEN('('),

    /**
     * The closing bracket {@code )}.
     */
    CLOSED(')');

    private final Character bracket;

    Bracket(Character bracket) {
        this.bracket = bracket;
    }

    /**
     * Returns the character of this bracket.
     *
     * @return {@code '('} or {@code ')'}
     */
    public Character getBracket() {
        return bracket;
    }
}