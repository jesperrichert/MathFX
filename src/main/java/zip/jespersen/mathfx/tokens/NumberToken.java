package zip.jespersen.mathfx.tokens;

import java.util.UUID;

/**
 * A token representing a numeric value.
 * <p>
 * Every instance has its own unique identifier, so two number tokens with the
 * same value are still distinguishable from each other.
 */
public final class NumberToken extends MathToken {
    private final String numberIdentifier = UUID.randomUUID().toString();
    private final double number;

    /**
     * Creates a new number token.
     *
     * @param number the numeric value of this token
     */
    public NumberToken(double number) {
        this.number = number;
    }

    /**
     * Returns the numeric value of this token.
     *
     * @return the number
     */
    public double getNumber() {
        return number;
    }

    /**
     * Returns the numeric value as a string.
     *
     * @return the string representation of the number, e.g. {@code "3.5"}
     */
    @Override
    public String toString() {
        return Double.toString(number);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((numberIdentifier == null) ? 0 : numberIdentifier.hashCode());
        result = prime * result + Double.hashCode(number);
        return result;
    }

    /**
     * Compares this token to another object. Two number tokens are only equal
     * if they have the same value <em>and</em> the same internal identifier,
     * so in practice only an instance is equal to itself.
     *
     * @param obj the object to compare with
     * @return {@code true} if both tokens are equal
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        NumberToken other = (NumberToken) obj;
        if (numberIdentifier == null) {
            if (other.numberIdentifier != null)
                return false;
        } else if (!numberIdentifier.equals(other.numberIdentifier))
            return false;
        return Double.doubleToLongBits(number) == Double.doubleToLongBits(other.number);
    }

}