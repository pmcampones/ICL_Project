package tests;

import static tests.GenericTester.MAX_RAND;
import static tests.GenericTester.writeToToken;

import java.io.IOException;
import java.util.Random;

import org.junit.jupiter.api.Test;

import dataTypes.TypeErrorException;
import environment.exceptions.IDDeclaredTwiceException;
import environment.exceptions.NotEnoughArgumentsException;
import environment.exceptions.UndeclaredIdentifierException;
import parser.ParseException;

public interface PrintlnOpTester {
	
	static int generateGlobalVar() {
		Random r = new Random();
        int val = r.nextInt(MAX_RAND);
        String exp = String.format("def globv:int = %d;;", val);
        writeToToken(exp);
		return val;
	}
	
	static void generateGlobalFunc() {
        String exp = "def foo(n:int):int = n + n end;;";
        writeToToken(exp);
	}
	
	static int generateValue() {
		Random r = new Random();
        int val = r.nextInt(MAX_RAND);
		return val;
	}

    @Test
    void testPrintlnMinusExpression()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException, NotEnoughArgumentsException,
            IOException, InterruptedException;

    static String getExpectedTestPrintlnMinusExpression() {
        Random r = new Random();
        int n1 = r.nextInt(MAX_RAND), n2 = r.nextInt(MAX_RAND),
                n3 = r.nextInt(MAX_RAND), n4 = r.nextInt(MAX_RAND),
                n5 = r.nextInt(MAX_RAND), n6 = r.nextInt(MAX_RAND),
                n7 = r.nextInt(MAX_RAND);
        String exp = String.format("println -(%d * (%d + %d * (%d + %d) - %d * (%d)))",
                n1, n2, n3, n4, n5, n6, n7);
        writeToToken(exp);
        return String.valueOf(-(n1 * (n2 + n3 * (n4 + n5) - n6 * n7)));
    }
    
	@Test
	void testPrintlnMutabilityOrder()
			throws TypeErrorException, NotEnoughArgumentsException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException,
            IOException, InterruptedException;
	
	static String getExpectedTestPrintlnMutabilityOrder() {
		Random r = new Random();
        int num1 = r.nextInt(MAX_RAND), num2 = r.nextInt(MAX_RAND);
        String exp = String.format("println def x = new %d in !x + (x := %d) + !x end", num1, num2);
        writeToToken(exp);
        return String.valueOf(num1 + num2 + num2);
	}
	
	@Test
	void testPrintlnSmallerEqAttr()
            throws TypeErrorException, NotEnoughArgumentsException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException, 
            IOException, InterruptedException;
	
	static String getExpectedTestPrintlnSmallerEqAttr() {
		Random r = new Random();
        int n1 = r.nextInt(MAX_RAND), n2 = r.nextInt(MAX_RAND);
        String exp = String.format("println def x = new false in x := %d < %d end", n1, n2);
        writeToToken(exp);
        return String.valueOf(n1 < n2);
	}
	
    @Test
    void testPrintlnTwoFramesSameScope()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException, NotEnoughArgumentsException,
            IOException, InterruptedException;

    static String getExpectedTestPrintlnTwoFramesSameScope() {
        Random r = new Random();
        int n1 = r.nextInt(MAX_RAND), n2 = r.nextInt(MAX_RAND),
                n3 = r.nextInt(MAX_RAND), n4 = r.nextInt(MAX_RAND),
                n5 = r.nextInt(MAX_RAND);
        String exp = String.format(
                "println %d + def x = %d y = x + %d in x + y + def z = x + y in %d * z end + def w = x - y in w + %d end end",
                n1, n2, n3, n4, n5);
        writeToToken(exp);
        int x = n2;
        int y = x + n3;
        int z = x + y;
        int w = x - y;
        return String.valueOf(n1 + x + y + n4 * z + w + n5);
    }
    
    @Test
    void testPrintlnGlobalFuncSemi()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException, NotEnoughArgumentsException,
            IOException, InterruptedException;
    
    static String getExpectedGlobalFuncSemi(int val) {
		Random r = new Random();
		int x1 = r.nextInt(MAX_RAND), x2 = r.nextInt(MAX_RAND);
		int num = r.nextInt(MAX_RAND);
		String exp = String.format("println def x = new %d in x := (!x + %d); !x + %d + foo(%d) end",
				x1, x2, num, val);
		writeToToken(exp);
		return String.valueOf(x1 + x2 + num + (val + val));
  }
    
    @Test
    void testPrintlnGlobalVarFunc()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException, NotEnoughArgumentsException,
            IOException, InterruptedException;
    
    static String getExpectedGlobalVarFunc(int val) {
        String exp = String.format("println foo(%d);;;", val);
        writeToToken(exp);
    	return String.valueOf(val+val);
  }
    
	@Test
	void testPrintlnRunningExpressionIf() 
			throws TypeErrorException, NotEnoughArgumentsException, UndeclaredIdentifierException, 
			ParseException, IDDeclaredTwiceException, 
			IOException, InterruptedException;
	
	static String getExpectedTestPrintlnRunningExpressionIf() {
		int mid = MAX_RAND / 2;
        Random r = new Random();
        int ifVal = r.nextInt(MAX_RAND);
        int thenVal = r.nextInt(MAX_RAND), elseVal = r.nextInt(MAX_RAND);
        String exp = String.format("println def x = new 0 in if %d < %d then x := %d else x := %d end; !x end", ifVal, mid, thenVal, elseVal);
        writeToToken(exp);
        return String.valueOf(ifVal < mid ? thenVal : elseVal);
	}
	
	@Test
	void testPrintlnAlias()
            throws TypeErrorException, NotEnoughArgumentsException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException, 
            IOException, InterruptedException;
	
	static String getExpectedTestPrintlnAlias() {
		Random r = new Random();
        int num1 = r.nextInt(MAX_RAND), num2 = r.nextInt(MAX_RAND);
        String exp = String.format("println def x = new %d y = x in def x = %d in x + !y end end", num1, num2);
        writeToToken(exp);
        return String.valueOf(num1 + num2);
	}
	
	@Test
	void testPrintlnChangeVarScope()
			throws ParseException, IDDeclaredTwiceException,
			UndeclaredIdentifierException, TypeErrorException, NotEnoughArgumentsException, 
			IOException, InterruptedException;
	
	static String getExpectedTestPrintlnChangeVarScope() {
		Random r = new Random();
		int x1 = r.nextInt(MAX_RAND), x2 = r.nextInt(MAX_RAND);
		String exp = String.format("println def x = %d in def x = %d in x end; x end", x1, x2);
		writeToToken(exp);
		return String.valueOf(x1);
	}
	
	@Test
	void testPrintlnGaussianSum()
			throws TypeErrorException, NotEnoughArgumentsException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException,
            IOException, InterruptedException;
	
	static String getExpectedTestPrintlnGaussianSum() {
		int limit = new Random().nextInt(MAX_RAND);
        String exp = String.format(
                "println def i = new 0 sum = new 0 in " +
                    "while !i < %d do " +
                        "i := !i + 1; " +
                        "sum := !sum + !i " +
                    "end; " +
                    "!sum " +
                "end", limit);
        writeToToken(exp);
        return String.valueOf(computeGaussianSum(limit));
	}
	
	private static int computeGaussianSum(int limit) {
        int sum = 0;
        for (int i = 0; i <= limit; i++)
            sum += i;
        return sum;
    }
}
