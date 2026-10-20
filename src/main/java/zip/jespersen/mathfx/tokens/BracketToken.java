package zip.jespersen.mathfx.tokens;

import java.util.Arrays;
import java.util.List;
import zip.jespersen.mathfx.types.Bracket;

public final class BracketToken extends MathToken {
    private final Character bracket;
    private final String matchId;

    public BracketToken(Character bracket, String matchId) {
        if (!Arrays.asList(validOperators).contains(bracket))
            throw new IllegalArgumentException("Valid operators are " + Arrays.toString(validOperators));
        this.bracket = bracket;
        this.matchId = matchId;
    }

     public BracketToken(Bracket bracket, String matchId) {
        this.bracket = bracket.getBracket();
        this.matchId = matchId;
    }

    public static final Character[] validOperators = new Character[] { '(', ')' };
    public static final List<Character> validOperatorsAsList = Arrays.asList(validOperators);

    public char getOperator() {
        return bracket;
    }

    public String getMatchId() {
        return matchId;
    }

    public boolean isOpen() {
        return bracket == '(';
    }

    @Override
    public String toString() {
        return bracket.toString();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + this.bracket;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final BracketToken other = (BracketToken) obj;
        return this.bracket.equals(other.bracket);
    }
}