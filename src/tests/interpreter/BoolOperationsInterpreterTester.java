package tests.interpreter;

import dataTypes.TypeErrorException;
import environment.exceptions.IDDeclaredTwiceException;
import environment.exceptions.UndeclaredIdentifierException;
import org.junit.jupiter.api.Test;
import parser.ParseException;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoolOperationsInterpreterTester extends InterpreterTester {

    @Test
    public void testBoolConstTrue()
            throws TypeErrorException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        writeToToken("true");
        assertEquals("true", run());
    }

    @Test
    public void testBoolConstFalse()
            throws TypeErrorException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        writeToToken("false");
        assertEquals("false", run());
    }

    @Test
    public void testDefBool()
            throws TypeErrorException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        writeToToken("def x = true in x end");
        assertEquals("true", run());
    }

    @Test
    public void testAttrBool() throws TypeErrorException, UndeclaredIdentifierException, ParseException, IDDeclaredTwiceException {
        writeToToken("def x = new true in !x end");
        assertEquals("true", run());
    }

    @Test
    public void testTrueEqualityInteger()
            throws TypeErrorException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        int num = new Random().nextInt(MAX_RAND);
        String exp = String.format("%d == %d", num, num);
        writeToToken(exp);
        assertEquals("true", run());
    }

    @Test
    public void testFalseEqualityInteger()
            throws TypeErrorException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        Random r = new Random();
        int n1 = r.nextInt(MAX_RAND), n2 = r.nextInt(MAX_RAND);
        String exp = String.format("%d == %d", n1, n2);
        writeToToken(exp);
        assertEquals(String.valueOf(n1 == n2), run());
    }

    @Test
    public void testTrueEqualityBool()
            throws TypeErrorException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        writeToToken("true == true");
        assertEquals("true", run());
    }

    @Test
    public void testFalseEqualityBool()
            throws TypeErrorException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        writeToToken("true == false");
        assertEquals("false", run());
    }

    @Test
    public void testDefEquality()
            throws TypeErrorException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        int num = new Random().nextInt(MAX_RAND);
        String exp = String.format("def x = %d == %d in x end", num, num);
        writeToToken(exp);
        assertEquals("true", run());
    }

    @Test
    public void testAttrEquality()
            throws TypeErrorException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        int num = new Random().nextInt(MAX_RAND);
        String exp = String.format("def x = new false in x := %d == %d end", num, num);
        writeToToken(exp);
        assertEquals("true", run());
    }

    @Test
    public void testGreaterTrue()
            throws TypeErrorException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        writeToToken("100 > 10");
        assertEquals("true", run());
    }

    @Test
    public void testGreaterFalse()
            throws TypeErrorException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        writeToToken("10 > 100");
        assertEquals("false", run());
    }

    @Test
    public void testGreaterComplex()
            throws TypeErrorException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        Random r = new Random();
        int x1 = r.nextInt(MAX_RAND), x2 = r.nextInt(MAX_RAND);
        String exp = String.format("def x = new %d in !x > (x := !x - %d) end", x1, x2);
        writeToToken(exp);
        assertEquals("true", run());
    }

    @Test
    public void testGreaterDef()
            throws TypeErrorException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        Random r = new Random();
        int n1 = r.nextInt(MAX_RAND), n2 = r.nextInt(MAX_RAND);
        String exp = String.format("def x = %d > %d in x end", n1, n2);
        writeToToken(exp);
        assertEquals(String.valueOf(n1 > n2), run());
    }

    @Test
    public void testGreaterAttr()
            throws TypeErrorException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        Random r = new Random();
        int n1 = r.nextInt(MAX_RAND), n2 = r.nextInt(MAX_RAND);
        String exp = String.format("def x = new false in x := %d > %d end", n1, n2);
        writeToToken(exp);
        assertEquals(String.valueOf(n1 > n2), run());
    }

    @Test
    public void testGreaterEqBigger()
            throws TypeErrorException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        writeToToken("100 >= 10");
        assertEquals("true", run());
    }

    @Test
    public void testGreaterEqSame()
            throws TypeErrorException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        writeToToken("100 >= 100");
        assertEquals("true", run());
    }

    @Test
    public void testGreaterEqSmaller()
            throws TypeErrorException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        writeToToken("10 >= 100");
        assertEquals("false", run());
    }

    @Test
    public void testGreaterEqComplex()
            throws TypeErrorException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        int num = new Random().nextInt(MAX_RAND);
        String exp = String.format("def x = new %d in !x >= (x := %d) end", num, num);
        writeToToken(exp);
        assertEquals("true", run());
    }

    @Test
    public void testGreaterEqDef()
            throws TypeErrorException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        Random r = new Random();
        int n1 = r.nextInt(MAX_RAND), n2 = r.nextInt(MAX_RAND);
        String exp = String.format("def x = %d >= %d in x end", n1, n2);
        writeToToken(exp);
        assertEquals(String.valueOf(n1 >= n2), run());
    }

    @Test
    public void testGreaterEqAttr()
            throws TypeErrorException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        Random r = new Random();
        int n1 = r.nextInt(MAX_RAND), n2 = r.nextInt(MAX_RAND);
        String exp = String.format("def x = new false in x := %d >= %d end", n1, n2);
        writeToToken(exp);
        assertEquals(String.valueOf(n1 >= n2), run());
    }

    @Test
    public void testSmallerWhenBigger()
            throws TypeErrorException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        writeToToken("100 < 10");
        assertEquals("false", run());
    }

    @Test
    public void testSmallerWhenEquals()
            throws TypeErrorException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        writeToToken("100 < 100");
        assertEquals("false", run());
    }

    @Test
    public void testSmallerComplex()
            throws TypeErrorException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        Random r = new Random();
        int x1 = r.nextInt(MAX_RAND), x2 = r.nextInt(MAX_RAND);
        String exp = String.format("def x = new %d in !x < (x := !x + %d) end", x1, x2);
        writeToToken(exp);
        assertEquals("true", run());
    }

    @Test
    public void testSmallerDef()
            throws TypeErrorException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        Random r = new Random();
        int n1 = r.nextInt(MAX_RAND), n2 = r.nextInt(MAX_RAND);
        String exp = String.format("def x = %d < %d in x end", n1, n2);
        writeToToken(exp);
        assertEquals(String.valueOf(n1 < n2), run());
    }

    @Test
    public void testSmallerAttr()
            throws TypeErrorException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        int n1 = 100, n2 = 10;
        String exp = String.format("def x = new false in x := %d < %d end", n1, n2);
        writeToToken(exp);
        assertEquals(String.valueOf(n1 < n2), run());
    }

    @Test
    public void testSmallerEqWhenBigger()
            throws TypeErrorException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        writeToToken("100 <= 10");
        assertEquals("false", run());
    }

    @Test
    public void testSmallerEqWhenSame()
            throws TypeErrorException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        writeToToken("100 <= 100");
        assertEquals("true", run());
    }

    @Test
    public void testSmallerEqWhenSmaller()
            throws TypeErrorException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        writeToToken("10 <= 100");
        assertEquals("true", run());
    }

    @Test
    public void testSmallerEqComplex()
            throws TypeErrorException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        int num = new Random().nextInt(MAX_RAND);
        String exp = String.format("def x = new %d in !x <= (x := %d) end", num, num);
        writeToToken(exp);
        assertEquals("true", run());
    }

    @Test
    public void testSmallerEqDef()
            throws TypeErrorException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        Random r = new Random();
        int n1 = r.nextInt(MAX_RAND), n2 = r.nextInt(MAX_RAND);
        String exp = String.format("def x = %d <= %d in x end", n1, n2);
        writeToToken(exp);
        assertEquals(String.valueOf(n1 <= n2), run());
    }

    @Test
    public void testSmallerEqAttr()
            throws TypeErrorException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        Random r = new Random();
        int n1 = r.nextInt(MAX_RAND), n2 = r.nextInt(MAX_RAND);
        String exp = String.format("def x = new false in x := %d < %d end", n1, n2);
        writeToToken(exp);
        assertEquals(String.valueOf(n1 < n2), run());
    }

}
