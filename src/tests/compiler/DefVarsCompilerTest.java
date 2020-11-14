package tests.compiler;

import static org.junit.jupiter.api.Assertions.*;
import static tests.TestUtils.MAX_RAND;
import static tests.TestUtils.writeToToken;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Random;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import environment.exceptions.IDDeclaredTwiceException;
import environment.exceptions.UndeclaredIdentifierException;
import parser.ParseException;
import parser.Parser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static tests.compiler.CompilationUtils.compileAndGetResults;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DefVarsCompilerTest {
	
	public DefVarsCompilerTest() {
        new Parser(new ByteArrayInputStream(new byte[0]));
    }

    @Test
    public void testDefWithoutUsingSimple()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, IOException,
            InterruptedException {
        Random r = new Random();
        int first = r.nextInt(MAX_RAND), second = r.nextInt(MAX_RAND);
        String exp = String.format("def x = 1 in %d + %d end", first, second);
        writeToToken(exp);
        String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
        assertEquals(first + second, compileAndGetResults(methodName, 1));
    }

    @Test
    public void testDefWithoutUsingComplex()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, IOException,
            InterruptedException {
        Random r = new Random();
        int[] nums = new int[5];
        for(int i = 0; i < nums.length; i++)
            nums[i] = r.nextInt(MAX_RAND);
        String exp = String.format("def x = 1 in %d * (-%d + %d * (%d - %d)) end",
                nums[0], nums[1], nums[2], nums[3], nums[4]);
        writeToToken(exp);
        int expected = nums[0] * (-nums[1] + nums[2] * (nums[3] - nums[4]));
        String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
        assertEquals(expected, compileAndGetResults(methodName, 1));
    }

    @Test
    public void testDefUsingSimple() 
    		throws ParseException, IDDeclaredTwiceException, 
    		UndeclaredIdentifierException, IOException,
    		InterruptedException {
        Random r = new Random();
        int attr = r.nextInt(MAX_RAND);
        int num = r.nextInt(MAX_RAND);
        String exp = String.format("def x = %d in x * %d end",
                attr, num);
        writeToToken(exp);
        String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
        assertEquals(attr * num, compileAndGetResults(methodName, 1));
    }

    @Test
    public void testDefUsingComplex()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, IOException,
            InterruptedException {
        Random r = new Random();
        int attr = r.nextInt(MAX_RAND);
        int[] nums = new int[3];
        for (int i = 0; i < nums.length; i++)
            nums[i] = r.nextInt(MAX_RAND);
        String exp = String.format("def x = %d in %d * (-x + %d * (x - %d)) end",
                attr, nums[0], nums[1], nums[2]);
        writeToToken(exp);
        int expected = nums[0] * (-attr + nums[1] * (attr  - nums[2]));
        String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
        assertEquals(expected, compileAndGetResults(methodName, 1));
    }

    @Test
    public void testDefNestedSimple()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, IOException,
            InterruptedException {
        Random r = new Random();
        int attr1 = r.nextInt(MAX_RAND), attr2 = r.nextInt(MAX_RAND);
        String exp = String.format("def x = %d in def y = %d in x * (-y + x) end end",
                attr1, attr2);
        writeToToken(exp);
        int expected = attr1 * (-attr2 + attr1);
        String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
        assertEquals(expected, compileAndGetResults(methodName, 2));
    }

    @Test
    public void testDefNestedCaires1()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, IOException,
            InterruptedException {
        String exp = "def x = 1 in def y = x + x in x + y end end";
        writeToToken(exp);
        String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
        assertEquals(3, compileAndGetResults(methodName, 2));
    }

    @Test
    public void testDefNestedCaires2()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, IOException,
            InterruptedException {
        int x = 2, z = x + 1, y = z + z;
        String exp = "def x = 2 in def y = def z = x + 1 in z + z end in x * y end end";
        writeToToken(exp);
        String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
        assertEquals(x * y, compileAndGetResults(methodName, 3));
    }

    @Test
    public void testDefSameVarDifferentScopesSimple()
            throws ParseException, IDDeclaredTwiceException, 
            UndeclaredIdentifierException, IOException,
            InterruptedException {
        String exp = "def x = 2 in def x = 1 in x end end";
        writeToToken(exp);
        String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
        assertEquals(1, compileAndGetResults(methodName, 2));
    }

    @Test
    public void testDefSameVarDifferentScopesComplex()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, IOException,
            InterruptedException {
        String exp = "def x = 2 in def y = def x = x+1 in x+x end in x * y end end";
        writeToToken(exp);
        String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
        assertEquals(12, compileAndGetResults(methodName, 3));
    }

    @Test
    public void testDefDifferentVarsSameScope()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, IOException,
            InterruptedException {
        String exp = "def x = 2 y = x+2 in def z = 3 in def y = x+1 in x + y + z end end end";
        writeToToken(exp);
        String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
        assertEquals(8, compileAndGetResults(methodName, 3));
    }
    
    @Test
    public void testSameAsTheProjectAssignement() 
    		throws ParseException, IOException, 
    		InterruptedException, IDDeclaredTwiceException, 
    		UndeclaredIdentifierException {
    	String exp = "def x = 2 y = 3 in def k = x+y in x+y+k end end";
    	writeToToken(exp);
    	String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
    	assertEquals(10, compileAndGetResults(methodName, 2));
    }
    
    @Test
    public void testTwoFramesSameScope() 
    		throws ParseException, IOException, 
    		InterruptedException, IDDeclaredTwiceException, 
    		UndeclaredIdentifierException {
    	String exp = "4 + def x = 2 y = x + 1 in x + y + def z = x + y in 2 * z end + def w = x - y in w + 2 end end";
    	writeToToken(exp);
    	String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
    	assertEquals(20, compileAndGetResults(methodName, 3));
    }
}
