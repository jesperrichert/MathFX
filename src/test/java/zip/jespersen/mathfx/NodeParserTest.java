package zip.jespersen.mathfx;

import org.junit.jupiter.api.Test;
import zip.jespersen.mathfx.notations.Infixnotation;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NodeParserTest {

    private final Infixnotation ix = new Infixnotation("(+2-1 + (3000,34 + 2.001)) * 3 + 122.2");
    private final Infixnotation ix2 = new Infixnotation("(+2-1 + (3000,34 + 2.001)) * -3 + 122.2");
    private final Infixnotation ix3 = new Infixnotation("(+2-1) * 3 + 122.2");
    private final Infixnotation ix4 = new Infixnotation("18 + 6 * (12 - 7) : -3");
    private final Infixnotation ix5 = new Infixnotation("24 - 8 : (2 + 2) * 3");
    private final Infixnotation ix6 = new Infixnotation("18 + 6 : (3 + 3) * 4");
    private final Infixnotation ix7 = new Infixnotation("35 - 15 : (3 + 2) * 4");
    private final Infixnotation ix8 = new Infixnotation("12 + 6 * (4 - 2)");
    private final Infixnotation ix9 = new Infixnotation("40 : (5 + 3) + 7");
    private final Infixnotation ix10 = new Infixnotation("25 - 9 : 3 * 2");
    private final Infixnotation ix11 = new Infixnotation("8 * (6 + 4) : 5");
    private final Infixnotation ix12 = new Infixnotation("50 : (2 + 3) - 4 * 2");
    private final Infixnotation ix13 = new Infixnotation("14 + 6 * 3");
    private final Infixnotation ix14 = new Infixnotation("30 - 12 : 4");
    private final Infixnotation ix15 = new Infixnotation("8 * (5 + 2)");
    private final Infixnotation ix16 = new Infixnotation("45 : (3 + 6)");
    private final Infixnotation ix17 = new Infixnotation("20 + 16 : 4 * 2");
    private final Infixnotation ix18 = new Infixnotation("50 - 5 * (6 + 2)");
    private final Infixnotation ix19 = new Infixnotation("7 * 4 + 18 : 3");
    private final Infixnotation ix20 = new Infixnotation("36 : 6 + 9 * 2");
    private final Infixnotation ix21 = new Infixnotation("25 + 15 : (2 + 3)");
    private final Infixnotation ix22 = new Infixnotation("60 - 8 * 5 + 4");
    private final Infixnotation ix23 = new Infixnotation("48 : (6 + 2) * (5 - 2) + 7");
    private final Infixnotation ix24 = new Infixnotation("72 - 8 * (3 + 2) : 4");
    private final Infixnotation ix25 = new Infixnotation("(15 + 9) : 3 * (8 - 5) + 6");
    private final Infixnotation ix26 = new Infixnotation("100 - (24 : (2 + 4)) * 5");
    private final Infixnotation ix27 = new Infixnotation("(36 - 12) : (2 + 4) * (7 + 3)");
    private static final Infixnotation ix28 = new Infixnotation("10 + 5 * 4 - 6");
    private static final Infixnotation ix29 = new Infixnotation("(20 - 8) : 3 + 7");
    private final Infixnotation ix30 = new Infixnotation("5 * (12 - 4) : 2");
    private static final Infixnotation ix31 = new Infixnotation("100 : (5 * 4) + 15");
    private final Infixnotation ix32 = new Infixnotation("7 + 3 * (10 - 6) : 2");
    private static final Infixnotation ix33 = new Infixnotation("(18 + 6) : (3 * 2)");
    private final Infixnotation ix34 = new Infixnotation("50 - (8 + 2) * 3");
    private final Infixnotation ix35 = new Infixnotation("(40 - 16) : 4 * 5");
    private final Infixnotation ix36 = new Infixnotation("-5 + 3 * 7");
    private final Infixnotation ix37 = new Infixnotation("20 + (-4) * 5");
    private final Infixnotation ix38 = new Infixnotation("(-12 + 4) : -2");
    private final Infixnotation ix39 = new Infixnotation("6 * (-3 + 8) - 4");
    private final Infixnotation ix40 = new Infixnotation("(15 - 3 * 2) : 3 + 9");
    private final Infixnotation ix41 = new Infixnotation("80 : (4 + 4) * (6 - 2)");
    private final Infixnotation ix42 = new Infixnotation("(7 + 5) * (9 - 6) : 2");
    private final Infixnotation ix43 = new Infixnotation("100 - 20 : (2 + 3) * 4");
    private static final Infixnotation ix44 = new Infixnotation("(50 + 10) : (2 * (3 + 2))");
    private final Infixnotation ix45 = new Infixnotation("3.5 * 4 + 2.5");
    private final Infixnotation ix46 = new Infixnotation("(10.5 - 2.5) * 3 : 4");
    private final Infixnotation ix47 = new Infixnotation("25 + (6 : 2) * (4 - 1)");
    
    @Test
    public void testComputeNodeRECURSIV() throws Exception {
        assertEquals(24.0, ix28.toTree().calculate(), 0.0);
        assertEquals(11.0, ix29.toTree().calculate(), 0.0);
        assertEquals(20.0, ix30.toTree().calculate(), 0.0);
        assertEquals(20.0, ix31.toTree().calculate(), 0.0);
        assertEquals(13.0, ix32.toTree().calculate(), 0.0);
        assertEquals(4.0, ix33.toTree().calculate(), 0.0);
        assertEquals(20.0, ix34.toTree().calculate(), 0.0);
        assertEquals(30.0, ix35.toTree().calculate(), 0.0);
        assertEquals(16.0, ix36.toTree().calculate(), 0.0);
        assertEquals(0.0, ix37.toTree().calculate(), 0.0);
        assertEquals(4.0, ix38.toTree().calculate(), 0.0);
        assertEquals(26.0, ix39.toTree().calculate(), 0.0);
        assertEquals(12.0, ix40.toTree().calculate(), 0.0);
        assertEquals(40.0, ix41.toTree().calculate(), 0.0);
        assertEquals(18.0, ix42.toTree().calculate(), 0.0);
        assertEquals(84.0, ix43.toTree().calculate(), 0.0);
        assertEquals(6.0, ix44.toTree().calculate(), 0.0);
        assertEquals(16.5, ix45.toTree().calculate(), 0.0);
        assertEquals(6.0, ix46.toTree().calculate(), 0.0);
        assertEquals(34.0, ix47.toTree().calculate(), 0.0);
        assertEquals(25.0, ix23.toTree().calculate(), 0.0);
        assertEquals(62.0, ix24.toTree().calculate(), 0.0);
        assertEquals(30.0, ix25.toTree().calculate(), 0.0);
        assertEquals(80.0, ix26.toTree().calculate(), 0.0);
        assertEquals(40.0, ix27.toTree().calculate(), 0.0);
        assertEquals(32.0, ix13.toTree().calculate(), 0.0);
        assertEquals(27.0, ix14.toTree().calculate(), 0.0);
        assertEquals(56.0, ix15.toTree().calculate(), 0.0);
        assertEquals(5.0, ix16.toTree().calculate(), 0.0);
        assertEquals(28.0, ix17.toTree().calculate(), 0.0);
        assertEquals(10.0, ix18.toTree().calculate(), 0.0);
        assertEquals(34.0, ix19.toTree().calculate(), 0.0);
        assertEquals(24.0, ix20.toTree().calculate(), 0.0);
        assertEquals(28.0, ix21.toTree().calculate(), 0.0);
        assertEquals(24.0, ix22.toTree().calculate(), 0.0);
        assertEquals(2.0, ix12.toTree().calculate(), 0.0);
        assertEquals(24.0, ix8.toTree().calculate(), 0.0);
        assertEquals(12.0, ix9.toTree().calculate(), 0.0);
        assertEquals(19.0, ix10.toTree().calculate(), 0.0);
        assertEquals(16.0, ix11.toTree().calculate(), 0.0);
        assertEquals(18, ix5.toTree().calculate(), 0.0);
        assertEquals(-8887.823, ix2.toTree().calculate(), 0.0);
        assertEquals(8, ix4.toTree().calculate(), 0.0);
        assertEquals(125.2, ix3.toTree().calculate(), 0.0);
        assertEquals(9132.223, Math.round(ix.toTree().calculate() * 1000.0) / 1000.0, 0.0);
        assertEquals(22.0, ix6.toTree().calculate(), 0.0);
        assertEquals(23.0, ix7.toTree().calculate(), 0.0);
    }
}
