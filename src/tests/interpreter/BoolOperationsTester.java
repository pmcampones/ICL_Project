package tests.interpreter;

import dataTypes.TypeErrorException;
import environment.exceptions.IDDeclaredTwiceException;
import environment.exceptions.UndeclaredIdentifierException;
import org.junit.jupiter.api.Test;
import parser.ParseException;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoolOperationsTester extends InterpreterTester {

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

}
