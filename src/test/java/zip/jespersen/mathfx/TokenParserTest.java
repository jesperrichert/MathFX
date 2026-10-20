package zip.jespersen.mathfx;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import zip.jespersen.mathfx.tokens.MathToken;
import zip.jespersen.mathfx.notations.Infixnotation;
import zip.jespersen.mathfx.tokens.NumberToken;
import zip.jespersen.mathfx.tokens.OperationToken;
import zip.jespersen.mathfx.tokens.BracketToken;
import zip.jespersen.mathfx.types.Bracket;
import zip.jespersen.mathfx.types.Operator;

public class TokenParserTest {

    private final Infixnotation ix = new Infixnotation("(+2-1 + (3000,34 + 2.001)) * 3 + 122.2");

    @Test
    public void testParseMathTokens() {
        ArrayList<MathToken> mt1 = new ArrayList<>();
        mt1.add(new BracketToken(Bracket.OPEN, ""));
        mt1.add(new NumberToken(2));
        mt1.add(new OperationToken(Operator.MINUS));
        mt1.add(new NumberToken(1.0));
        mt1.add(new OperationToken(Operator.PLUS));
        mt1.add(new BracketToken(Bracket.OPEN, ""));
        mt1.add(new NumberToken(3000.34));
        mt1.add(new OperationToken(Operator.PLUS));
        mt1.add(new NumberToken(2.001));
        mt1.add(new BracketToken(Bracket.CLOSED, ""));
        mt1.add(new BracketToken(Bracket.CLOSED, ""));
        mt1.add(new OperationToken(Operator.MULTI));
        mt1.add(new NumberToken(3));
        mt1.add(new OperationToken(Operator.PLUS));
        mt1.add(new NumberToken(122.2));

        assertEquals(mt1, TokenParser.parseMathTokens(ix.toNotation()));
    }

    @Test
    public void testComputeShuntingYard() throws Exception {
        List<MathToken> tokensList = new ArrayList<>();
        tokensList.add(new NumberToken(2));
        tokensList.add(new NumberToken(1));
        tokensList.add(new OperationToken(Operator.MINUS));
        tokensList.add(new NumberToken(3000.34));
        tokensList.add(new NumberToken(2.001));
        tokensList.add(new OperationToken(Operator.PLUS));
        tokensList.add(new OperationToken(Operator.PLUS));
        tokensList.add(new NumberToken(3));
        tokensList.add(new OperationToken(Operator.MULTI));
        tokensList.add(new NumberToken(122.2));
        tokensList.add(new OperationToken(Operator.PLUS));

        assertEquals(tokensList, TokenParser.computeShuntingYard(ix.toTokens()));
    }

}
