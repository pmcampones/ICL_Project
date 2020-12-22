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
        String exp = String.format("def x = new 0 in if true then x := %d end; !x end", num);
        writeToToken(exp);
        assertEquals(String.valueOf(num), run());
    }

    @Test
    public void testSimpleExpressionFalse()
            throws TypeErrorException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        int num = new Random().nextInt(MAX_RAND);
        String exp = String.format("def x = new 0 in if false then x := %d end; !x end", num);
        writeToToken(exp);
        assertEquals("0", run());
    }

    @Test
    public void testElseExpressionTrue()
            throws TypeErrorException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        Random r = new Random();
        int n1 = r.nextInt(MAX_RAND), n2 = r.nextInt(MAX_RAND);
        String exp = String.format("def x = new 0 in if true then x := %d else x := %d end; !x end", n1, n2);
        writeToToken(exp);
        assertEquals(String.valueOf(n1), run());
    }

    @Test
    public void testElseExpressionFalse()
            throws TypeErrorException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        Random r = new Random();
        int n1 = r.nextInt(MAX_RAND), n2 = r.nextInt(MAX_RAND);
        String exp = String.format("def x = new 0 in if false then x := %d else x := %d end; !x end", n1, n2);
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

    @Test
    public void testRunningExpressionIf()
            throws TypeErrorException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        int mid = MAX_RAND / 2;
        Random r = new Random();
        int ifVal = r.nextInt(MAX_RAND);
        int thenVal = r.nextInt(MAX_RAND), elseVal = r.nextInt(MAX_RAND);
        String exp = String.format("def x = new 0 in if %d < %d then x := %d else x := %d end; !x end", ifVal, mid, thenVal, elseVal);
        writeToToken(exp);
        assertEquals(String.valueOf(ifVal < mid ? thenVal : elseVal), run());
    }

}
