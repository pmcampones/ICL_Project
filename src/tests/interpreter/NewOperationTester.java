package tests.interpreter;

import dataTypes.TypeErrorException;
import environment.exceptions.IDDeclaredTwiceException;
import environment.exceptions.UndeclaredIdentifierException;
import org.junit.jupiter.api.Test;
import parser.ParseException;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NewOperationTester extends InterpreterTester {

    @Test
    public void testNewVarTestNotUsing()
            throws TypeErrorException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        int number = new Random().nextInt(MAX_RAND);
        String exp = String.format("def x = new 5 in %d end", number);
        writeToToken(exp);
        assertEquals(String.valueOf(number), run());
    }

    @Test
    public void testNewVarUsing()
            throws TypeErrorException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        int number = new Random().nextInt(MAX_RAND);
        String exp = String.format("def x = new %d in !x end", number);
        writeToToken(exp);
        assertEquals(String.valueOf(number), run());
    }
    @Test
    public void testNewNoDef()
            throws TypeErrorException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        int number = new Random().nextInt(MAX_RAND);
        String exp = String.format("!new %d", number);
        writeToToken(exp);
        assertEquals(String.valueOf(number), run());
    }

    @Test
    public void testNewComplexExpression() throws TypeErrorException, UndeclaredIdentifierException, ParseException, IDDeclaredTwiceException {
        Random r = new Random();
        int x = r.nextInt(MAX_RAND), y = r.nextInt(MAX_RAND);
        String exp = String.format("!new def x = %d y = %d in y + def x = x + y in x * y end + x end", x, y);
        writeToToken(exp);
        assertEquals(String.valueOf(y + (x + y) * y + x), run());
    }

    @Test
    public void testNewSums()
            throws TypeErrorException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        Random r = new Random();
        int num1 = r.nextInt(MAX_RAND), num2 = r.nextInt(MAX_RAND);
        String exp = String.format("!new !new %d + !new %d", num1, num2);
        writeToToken(exp);
        assertEquals(String.valueOf(num1 + num2), run());
    }

    @Test
    public void testSumNewVarFirst()
            throws TypeErrorException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        Random r = new Random();
        int x = r.nextInt(MAX_RAND), y = r.nextInt(MAX_RAND);
        String exp = String.format("def x = new %d in !x + !new %d end", x, y);
        writeToToken(exp);
        assertEquals(String.valueOf(x + y), run());
    }

    @Test
    public void testSumNewVarBoth()
            throws TypeErrorException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        Random r = new Random();
        int x = r.nextInt(MAX_RAND), y = r.nextInt(MAX_RAND);
        String exp = String.format("def x = new %d y = new %d in !x + !y end", x, y);
        writeToToken(exp);
        assertEquals(String.valueOf(x + y), run());
    }

    @Test
    public void testRedefineNew()
            throws TypeErrorException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        Random r = new Random();
        int x = r.nextInt(MAX_RAND), y = r.nextInt(MAX_RAND);
        String exp = String.format("def x = new %d y = new %d in !x + !y + def x = new !x + !y in !x * !y end end"
                , x, y);
        writeToToken(exp);
        assertEquals(String.valueOf(x + y + (x + y) * y), run());
    }

    @Test
    public void testAlias()
            throws TypeErrorException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        Random r = new Random();
        int num1 = r.nextInt(MAX_RAND), num2 = r.nextInt(MAX_RAND);
        String exp = String.format("def x = new %d y = x in def x = %d in x + !y end end", num1, num2);
        writeToToken(exp);
        assertEquals(String.valueOf(num1 + num2), run());
    }
}
