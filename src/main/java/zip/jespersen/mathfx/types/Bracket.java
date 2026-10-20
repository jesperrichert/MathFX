package zip.jespersen.mathfx.types;

public enum Bracket {
    OPEN('('),
    CLOSED(')');

    private final Character bracket;

    Bracket(Character bracket) {
        this.bracket = bracket;
    }

    public Character getBracket() {
        return bracket;
    }
}
