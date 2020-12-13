package tests.interpreter;

import dataTypes.TypeErrorException;
import environment.exceptions.IDDeclaredTwiceException;
import environment.exceptions.UndeclaredIdentifierException;
import org.junit.jupiter.api.Test;
import parser.ParseException;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IfThenElseTester extends InterpreterTester {

    @Test
    public void testSimpleExpressionTrue()
            throws TypeErrorException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        int num = new Random().nextInt(MAX_RAND);
        String exp = String.format("if true then %d end", num);
        writeToToken(exp);
        assertEquals(String.valueOf(num), run());
    }

    @Test
    public void testSimpleExpressionFalse()
            throws TypeErrorException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        writeToToken("if false then 10 end");
        assertEquals("", run());
    }

    @Test
    public void testElseExpressionTrue()
            throws TypeErrorException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        Random r = new Random();
        int n1 = r.nextInt(MAX_RAND), n2 = r.nextInt(MAX_RAND);
        String exp = String.format("if true then %d else %d end", n1, n2);
        writeToToken(exp);
        assertEquals(String.valueOf(n1), run());
    }

    @Test
    public void testElseExpressionFalse()
            throws TypeErrorException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        Random r = new Random();
        int n1 = r.nextInt(MAX_RAND), n2 = r.nextInt(MAX_RAND);
        String exp = String.format("if false then %d else %d end", n1, n2);
        writeToToken(exp);
        assertEquals(String.valueOf(n2), run());
    }

    @Test
    public void testExpressionScopeIf()
            throws TypeErrorException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        Random r = new Random();
        int n1 = r.nextInt(MAX_RAND), n2 = r.nextInt(MAX_RAND);
        int thenV = r.nextInt(MAX_RAND), elseV = r.nextInt(MAX_RAND);
        String exp = String.format("def x = new (%d < %d) y = new 2 in if !x then y := %d else y := %d end; !y + 1 end",
                n1, n2, thenV, elseV);
        writeToToken(exp);
        int val = n1 < n2 ? thenV + 1 : elseV + 1;
        assertEquals(String.valueOf(val), run());
    }

}
