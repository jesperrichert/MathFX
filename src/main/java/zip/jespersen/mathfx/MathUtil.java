package zip.jespersen.mathfx;

import zip.jespersen.mathfx.tokens.MathToken;

public class MathUtil {

    @SuppressWarnings("UnnecessaryTemporaryOnConversionFromString")
    public static boolean isDouble(String string) {
        try {
            Double.parseDouble(string);
            return true;
        } catch (NumberFormatException eFormatException) {
            return false;
        }
    }

    public static <T extends MathToken> boolean isToken(Class<T> T, MathToken obj) {
        return obj.getClass() == T;
    }

    public static <T extends MathToken> T toToken(Class<T> T, MathToken obj) {
        if (isToken(T, obj))
            return ((T) obj);
        throw new ClassCastException();
    }

    public static boolean isDouble(Character cha) {
        return isDouble(cha.toString());
    }
}
