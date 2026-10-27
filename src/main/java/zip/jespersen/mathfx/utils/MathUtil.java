package zip.jespersen.mathfx.utils;

import zip.jespersen.mathfx.tokens.MathToken;

/**
 * Utility methods for checking numbers and casting {@link MathToken}s.
 */
public class MathUtil {

    /**
     * Checks whether a string can be parsed as a {@code double}.
     *
     * @param string the string to check
     * @return {@code true} if {@link Double#parseDouble(String)} accepts the string,
     *         otherwise {@code false}
     */
    @SuppressWarnings("UnnecessaryTemporaryOnConversionFromString")
    public static boolean isDouble(String string) {
        try {
            Double.parseDouble(string);
            return true;
        } catch (NumberFormatException eFormatException) {
            return false;
        }
    }

    /**
     * Checks whether a token is exactly an instance of the given class.
     * <p>
     * Subclasses do not match, only the exact class.
     *
     * @param <T> the token type
     * @param T   the class to check against
     * @param obj the token to check
     * @return {@code true} if the token's class is exactly {@code T}
     */
    public static <T extends MathToken> boolean isToken(Class<T> T, MathToken obj) {
        return obj.getClass() == T;
    }

    /**
     * Casts a token to the given class.
     *
     * @param <T> the token type
     * @param T   the class to cast to
     * @param obj the token to cast
     * @return the token as type {@code T}
     * @throws ClassCastException if the token is not exactly of type {@code T}
     */
    public static <T extends MathToken> T toToken(Class<T> T, MathToken obj) {
        if (isToken(T, obj))
            return ((T) obj);
        throw new ClassCastException();
    }

    /**
     * Checks whether a character can be parsed as a {@code double}, i.e.
     * whether it is a digit.
     *
     * @param cha the character to check
     * @return {@code true} if the character is a valid number, otherwise {@code false}
     */
    public static boolean isDouble(Character cha) {
        return isDouble(cha.toString());
    }
}