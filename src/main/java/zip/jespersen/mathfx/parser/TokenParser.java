package zip.jespersen.mathfx.parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import zip.jespersen.mathfx.tokens.BracketToken;
import zip.jespersen.mathfx.tokens.MathToken;
import zip.jespersen.mathfx.tokens.NumberToken;
import zip.jespersen.mathfx.tokens.OperationToken;
import zip.jespersen.mathfx.types.Bracket;
import zip.jespersen.mathfx.types.Operator;
import zip.jespersen.mathfx.utils.ShuntingYardStack;

/**
 * Utility class for converting math expressions into {@link MathToken}s
 * and for reordering tokens with the shunting-yard algorithm.
 */
public final class TokenParser {


    /**
     * Splits an infix expression into tokens.
     * <p>
     * Whitespace is ignored. Matching brackets receive a shared id. A leading
     * {@code +} or {@code -} at the start of the expression or after an opening
     * bracket or operator is treated as the sign of the following number.
     * Both {@code .} and {@code ,} are accepted as decimal separator.
     *
     * @param notation the expression in infix notation
     * @return the list of tokens in the order they appear in the expression
     * @throws NumberFormatException if a number in the expression cannot be parsed
     */
    public static List<MathToken> parseMathTokens(String notation) {
        List<MathToken> tokens = new ArrayList<>();
        HashMap<Integer, String> bracketTokenMatcher = new HashMap<>();
        notation = notation.replaceAll(" ", "");

        for (int i = 0; i < notation.toCharArray().length;) {
            char symbol = notation.toCharArray()[i];
            if (Arrays.asList(OperationToken.validOperators).contains(symbol)) {
                tokens.add(new OperationToken(symbol));
                i++;
            } else if (Arrays.asList(BracketToken.validOperators).contains(symbol)) {
                // Bracket Matcher && Builder
                if (bracketTokenMatcher.containsKey(i)) {
                    String matchId = bracketTokenMatcher.get(i);
                    tokens.add(new BracketToken(symbol, matchId));
                    i++;
                    continue;
                }

                String matchId = UUID.randomUUID().toString();
                int blocker = 1;
                for (int is = i + 1; is < notation.toCharArray().length; is++) {
                    if (notation.toCharArray()[is] == Bracket.OPEN.getBracket()) {
                        blocker++;
                    } else if (notation.toCharArray()[is] == Bracket.CLOSED.getBracket()) {
                        blocker--;
                        if (blocker <= 0) {
                            bracketTokenMatcher.put(is, matchId);
                            tokens.add(new BracketToken(symbol, matchId));
                            i++;
                            break;
                        }
                    }
                }
            } else {
                // PREFIX OPERATOR
                StringBuilder sb = new StringBuilder();
                if (i >= 1 && (notation.toCharArray()[i - 1] == Operator.PLUS.getOperator()
                        || notation.toCharArray()[i - 1] == Operator.MINUS.getOperator())) {

                    if (i == 1 || notation.toCharArray()[i - 2] == Bracket.OPEN.getBracket()
                            || OperationToken.validOperatorsAsList.contains(notation.toCharArray()[i - 2])) {
                        sb.append(notation.toCharArray()[i - 1]);
                        tokens.removeLast();

                    }
                }

                // Number Builder
                Character[] breakChars = new Character[] {
                        '(', ')', '+', '-', '*', ':', ',', '.', ' '
                };

                while (i < notation.toCharArray().length
                        && !Arrays.asList(breakChars).contains(notation.toCharArray()[i])) {

                    sb.append(notation.toCharArray()[i]);
                    i++;

                }

                if (i + 1 < notation.toCharArray().length && (notation.toCharArray()[i] == '.'
                        || notation.toCharArray()[i] == ',')) {
                    sb.append(".");
                    i++;

                    while (i < notation.toCharArray().length
                            && !Arrays.asList(breakChars).contains(notation.toCharArray()[i])) {
                        sb.append(notation.toCharArray()[i]);
                        i++;
                    }
                }

                tokens.add(new NumberToken(Double.parseDouble(sb.toString().trim())));
            }
        }

        return tokens;

    }

    /**
     * Converts tokens from infix order into postfix order
     * using the shunting-yard algorithm.
     *
     * @param tokens the tokens in infix order
     * @return the tokens in postfix order
     * @throws IllegalArgumentException if the expression is invalid,
     *                                  e.g. because of mismatched brackets
     */
    public static List<MathToken> computeShuntingYard(List<MathToken> tokens) throws IllegalArgumentException {
        List<MathToken> output = new ArrayList<>();
        ShuntingYardStack stack = new ShuntingYardStack();

        for (MathToken token : tokens) {
            switch (token) {
                case NumberToken numberToken -> output.add(numberToken);
                case OperationToken operationToken -> output = stack.flushOpToOutput(output, operationToken);
                case BracketToken bracketToken -> {
                    if (bracketToken.isOpen())
                        stack.push(bracketToken);
                    else
                        output = stack.flushToNextBracet(output);
                }
                default -> {
                    // IGNORE
                }
            }
        }

        return stack.flush(output);
    }

}
