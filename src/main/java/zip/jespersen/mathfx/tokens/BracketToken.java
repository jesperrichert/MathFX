package zip.jespersen.mathfx.tokens;

import java.util.Arrays;
import java.util.List;
import zip.jespersen.mathfx.types.Bracket;

/**
 * A token representing an opening or closing bracket.
 * <p>
 * Matching bracket pairs share the same match id.
 */
public final class BracketToken extends MathToken {
    private final Character bracket;

    /**
     * Creates a bracket token from a character.
     *
     * @param bracket the bracket character, either {@code (} or {@code )}
     * @param matchId the id shared with the matching bracket
     * @throws IllegalArgumentException if the character is not a valid bracket
     */
    public BracketToken(Character bracket, String matchId) {
        if (!Arrays.asList(validOperators).contains(bracket))
            throw new IllegalArgumentException("Valid operators are " + Arrays.toString(validOperators));
        this.bracket = bracket;
    }

    /**
     * Creates a bracket token from a {@link Bracket} constant.
     *
     * @param bracket the bracket type
     * @param matchId the id shared with the matching bracket
     */
    public BracketToken(Bracket bracket, String matchId) {
        this.bracket = bracket.getBracket();
    }

    /**
     * The characters accepted as brackets.
     */
    public static final Character[] validOperators = new Character[] { '(', ')' };

    
    /**
     * Returns the bracket character of this token.
     *
     * @return {@code (} or {@code )}
     */
    public char getOperator() {
        return bracket;
    }
    
    /**
     * Checks whether this is an opening bracket.
     *
     * @return {@code true} if this is {@code (}, {@code false} if it is {@code )}
     */
    public boolean isOpen() {
        return bracket == '(';
    }

    /**
     * Returns the bracket character as a string.
     *
     * @return {@code "("} or {@code ")"}
     */
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

    /**
     * Compares this token to another object. Two bracket tokens are equal if
     * they have the same bracket character; the match id is ignored.
     *
     * @param obj the object to compare with
     * @return {@code true} if both tokens have the same bracket character
     */
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