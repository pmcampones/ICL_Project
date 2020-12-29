package tests.interpreter;

import dataTypes.TypeErrorException;
import environment.exceptions.IDDeclaredTwiceException;
import environment.exceptions.UndeclaredIdentifierException;
import org.junit.jupiter.api.Test;
import parser.ParseException;
import tests.StaticTypecheckerTester;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StaticTypecheckerInterpreterTester extends InterpreterTester implements StaticTypecheckerTester {

    @Test
    public void testSimpleIntExp()
            throws TypeErrorException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        int num = new Random().nextInt(MAX_RAND);
        String exp = String.format("def x: int = %d in x end", num);
        writeToToken(exp);
        assertEquals(String.valueOf(num), run());
    }

    @Test
    public void testSimpleBoolExp()
            throws TypeErrorException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        writeToToken("def x: bool = true in x end");
        assertEquals("true", run());
    }

    @Test
    public void testSimpleRefExp()
            throws TypeErrorException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        int num = new Random().nextInt(MAX_RAND);
        String exp = String.format("def x: ref int = new %d in !x end", num);
        writeToToken(exp);
        assertEquals(String.valueOf(num), run());
    }

    @Test
    public void testSeveralExp()
            throws TypeErrorException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        Random r = new Random();
        int n1 = r.nextInt(MAX_RAND), n2 = r.nextInt(MAX_RAND);
        String exp = String.format("def x: int = %d y: bool = true z: ref int = new %d in x + !z end", n1, n2);
        writeToToken(exp);
        assertEquals(String.valueOf(n1 + n2), run());
    }

    @Test
    public void testChainedTypes()
            throws TypeErrorException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        int num = new Random().nextInt(MAX_RAND);
        String exp = String.format("def x: ref int = new %d y: ref ref ref int = new new x in !!!y end", num);
        writeToToken(exp);
        assertEquals(String.valueOf(num), run());
    }

    @Test
    public void testStaticAndDynamic()
            throws TypeErrorException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        Random r = new Random();
        int n1 = r.nextInt(MAX_RAND), n2 = r.nextInt(MAX_RAND);
        String exp = String.format("def x = %d y: int = %d in x + y end", n1, n2);
        writeToToken(exp);
        assertEquals(String.valueOf(n1 + n2), run());
    }

    @Test
    public void testDifferentScopesStatic()
            throws TypeErrorException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        Random r = new Random();
        int n1 = r.nextInt(MAX_RAND), n2 = r.nextInt(MAX_RAND);
        String exp = String.format("def x: int = %d in def x: ref int = new (x + %d) in !x end end", n1, n2);
        writeToToken(exp);
        assertEquals(String.valueOf(n1 + n2), run());
    }

    @Test
    public void testDifferentScopesStaticAndDynamic()
            throws TypeErrorException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        Random r = new Random();
        int n1 = r.nextInt(MAX_RAND), n2 = r.nextInt(MAX_RAND);
        String exp = String.format("def x: int = %d in def x = new (x + %d) in !x end end", n1, n2);
        writeToToken(exp);
        assertEquals(String.valueOf(n1 + n2), run());
    }

}
