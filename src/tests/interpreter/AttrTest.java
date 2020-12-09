package tests.interpreter;

import dataTypes.TypeErrorException;
import environment.exceptions.IDDeclaredTwiceException;
import environment.exceptions.UndeclaredIdentifierException;
import org.junit.jupiter.api.Test;
import parser.ParseException;
import parser.Parser;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static tests.TestUtils.MAX_RAND;
import static tests.TestUtils.writeToToken;

public class AttrTest extends InterpreterTests {

    @Test
    public void testSimpleAttr()
            throws TypeErrorException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        int num = new Random().nextInt(MAX_RAND);
        String exp = String.format("def x = new 5 in x := %d end", num);
        writeToToken(exp);
        assertEquals(num, run());
    }

    @Test
    public void testAttrSum()
            throws TypeErrorException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        Random r = new Random();
        int num1 = r.nextInt(MAX_RAND), num2 = r.nextInt(MAX_RAND);
        String exp = String.format("def x = new %d in !x + x := %d end", num1, num2);
        writeToToken(exp);
        assertEquals(num1 + num2, run());
    }

    @Test
    public void testAttrTerm()
            throws TypeErrorException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        Random r = new Random();
        int num1 = r.nextInt(MAX_RAND), num2 = r.nextInt(MAX_RAND);
        String exp = String.format("def x = new %d in !x * x := %d end", num1, num2);
        writeToToken(exp);
        assertEquals(num1 * num2, run());
    }

    @Test
    public void testAttrExpressionAfter()
            throws TypeErrorException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        Random r = new Random();
        int num1 = r.nextInt(MAX_RAND), num2 = r.nextInt(MAX_RAND);
        String exp = String.format("def x = new %d in !x + x := !x + def y = %d in !x * y end end", num1, num2);
        writeToToken(exp);
        assertEquals(num1 + (num1 + num1 * num2), run());
    }

    @Test
    public void testNestedAttr()
            throws TypeErrorException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        Random r = new Random();
        int num1 = r.nextInt(MAX_RAND), num2 = r.nextInt(MAX_RAND);
        String exp = String.format("def x = new %d in x := !x + x := %d end", num1, num2);
        writeToToken(exp);
        assertEquals(num1 + num2, run());
    }

    @Test
    public void testIdentity()
            throws TypeErrorException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        int num = new Random().nextInt(MAX_RAND);
        String exp = String.format("def x = new %d in x := !x end", num);
        writeToToken(exp);
        assertEquals(num, run());
    }

    @Test
    public void testNestedWithExpression()
            throws TypeErrorException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        Random r = new Random();
        int x1 = r.nextInt(MAX_RAND), x2 = r.nextInt(MAX_RAND);
        int y = r.nextInt(MAX_RAND);
        String exp = String.format("def x = new %d y = new %d in x := !x + y := !y + x := !x + y := !x * !y + def x = %d in x * !y end end", x1, y, x2);
        writeToToken(exp);
        int fourthY = x1 * y + x2 * y;
        int thirdX = x1 + fourthY;
        int secondY = y + thirdX;
        int secondX = x1 + secondY;
        assertEquals(secondX, run());
    }

    @Test
    public void testMutabilityOrder()
            throws TypeErrorException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        Random r = new Random();
        int num1 = r.nextInt(MAX_RAND), num2 = r.nextInt(MAX_RAND);
        String exp = String.format("def x = new %d in !x + (x := %d) + !x end", num1, num2);
        writeToToken(exp);
        assertEquals(num1 + num2 + num2, run());
    }

}
