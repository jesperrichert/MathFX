package zip.jespersen.mathfx.types;

public class Pair<A, B> {
    private final A fist;
    private final B second;

    public Pair(A fist, B second) {
        this.fist = fist;
        this.second = second;
    }

    public A getFist() {
        return fist;
    }

    public B getSecond() {
        return second;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((fist == null) ? 0 : fist.hashCode());
        result = prime * result + ((second == null) ? 0 : second.hashCode());
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
        Pair other = (Pair) obj;
        if (fist == null) {
            if (other.fist != null)
                return false;
        } else if (!fist.equals(other.fist))
            return false;
        if (second == null) {
            if (other.second != null)
                return false;
        } else if (!second.equals(other.second))
            return false;
        return true;
    }

}
