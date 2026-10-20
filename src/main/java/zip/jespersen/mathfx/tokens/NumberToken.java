package zip.jespersen.mathfx.tokens;

import java.util.UUID;

public final class NumberToken extends MathToken {
    private final String numberIdentifier = UUID.randomUUID().toString();
    private final double number;

    public NumberToken(double number) {
        this.number = number;
    }

    public double getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return Double.toString(number);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((numberIdentifier == null) ? 0 : numberIdentifier.hashCode());
        long temp;
        temp = Double.doubleToLongBits(number);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

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
        if (Double.doubleToLongBits(number) != Double.doubleToLongBits(other.number))
            return false;
        return true;
    }

}
