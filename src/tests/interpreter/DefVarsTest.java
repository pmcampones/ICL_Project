package tests.interpreter;

import environment.exceptions.IDDeclaredTwiceException;
import environment.exceptions.UndeclaredIdentifierException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import parser.ParseException;
import parser.Parser;

import java.io.ByteArrayInputStream;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import static tests.TestUtils.*;
import static tests.interpreter.InterpreterTestUtil.run;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DefVarsTest {

    public DefVarsTest() {
        new Parser(new ByteArrayInputStream(new byte[0]));
    }

    @Test
    public void testDefWithoutUsingSimple()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException {
        Random r = new Random();
        int first = r.nextInt(MAX_RAND), second = r.nextInt(MAX_RAND);
        String exp = String.format("def x = 1 in %d + %d end", first, second);
        writeToToken(exp);
        assertEquals(first + second, run());
    }

    @Test
    public void testDefWithoutUsingComplex()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException {
        Random r = new Random();
        int[] nums = new int[5];
        for(int i = 0; i < nums.length; i++)
            nums[i] = r.nextInt(MAX_RAND);
        String exp = String.format("def x = 1 in %d * (-%d + %d * (%d - %d)) end",
                nums[0], nums[1], nums[2], nums[3], nums[4]);
        writeToToken(exp);
        int expected = nums[0] * (-nums[1] + nums[2] * (nums[3] - nums[4]));
        assertEquals(expected, run());
    }

    @Test
    public void testDefUsingSimple() throws ParseException, IDDeclaredTwiceException, UndeclaredIdentifierException {
        Random r = new Random();
        int attr = r.nextInt(MAX_RAND);
        int num = r.nextInt(MAX_RAND);
        String exp = String.format("def x = %d in x * %d end",
                attr, num);
        writeToToken(exp);
        assertEquals(attr * num, run());
    }

    @Test
    public void testDefUsingComplex()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException {
        Random r = new Random();
        int attr = r.nextInt(MAX_RAND);
        int[] nums = new int[3];
        for (int i = 0; i < nums.length; i++)
            nums[i] = r.nextInt(MAX_RAND);
        String exp = String.format("def x = %d in %d * (-x + %d * (x - %d)) end",
                attr, nums[0], nums[1], nums[2]);
        writeToToken(exp);
        int expected = nums[0] * (-attr + nums[1] * (attr  - nums[2]));
        assertEquals(expected, run());
    }

    @Test
    public void testDefNestedSimple()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException {
        Random r = new Random();
        int attr1 = r.nextInt(MAX_RAND), attr2 = r.nextInt(MAX_RAND);
        String exp = String.format("def x = %d in def y = %d in x * (-y + x) end end",
                attr1, attr2);
        writeToToken(exp);
        int expected = attr1 * (-attr2 + attr1);
        assertEquals(expected, run());
    }

    @Test
    public void testDefNestedCaires1()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException {
        String exp = "def x = 1 in def y = x + x in x + y end end";
        writeToToken(exp);
        assertEquals(3, run());
    }

    @Test
    public void testDefNestedCaires2()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException {
        int x = 2, z = x + 1, y = z + z;
        String exp = "def x = 2 in def y = def z = x + 1 in z + z end in x * y end end";
        writeToToken(exp);
        assertEquals(x * y, run());
    }

    @Test
    public void testDefSameVarDifferentScopesSimple()
            throws ParseException,
            IDDeclaredTwiceException, UndeclaredIdentifierException {
        String exp = "def x = 2 in def x = 1 in x end end";
        writeToToken(exp);
        assertEquals(1, run());
    }

    @Test
    public void testDefSameVarDifferentScopesComplex()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException {
        String exp = "def x = 2 in def y = def x = x+1 in x+x end in x * y end end";
        writeToToken(exp);
        assertEquals(12, run());
    }

    @Test
    public void testDefDifferentVarsSameScope()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException {
        String exp = "def x = 2 y = x+2 in def z = 3 in def y = x+1 in x + y + z end end end";
        writeToToken(exp);
        assertEquals(8, run());
    }

}
