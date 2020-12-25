package tests;

import static tests.GenericTester.MAX_RAND;
import static tests.GenericTester.writeToToken;

import java.io.IOException;
import java.util.Random;

import dataTypes.TypeErrorException;
import environment.exceptions.IDDeclaredTwiceException;
import environment.exceptions.UndeclaredIdentifierException;
import org.junit.jupiter.api.Test;
import parser.ParseException;

public interface BoolOperationsTester {

	@Test
	void testBoolConstTrue() 
			throws TypeErrorException, UndeclaredIdentifierException, 
			ParseException, IDDeclaredTwiceException,
			IOException, InterruptedException;
	
	static String getExpectedTestBoolConstTrue() {
		writeToToken("true");
		return "true";
	}

	@Test
	void testBoolConstFalse()
			throws TypeErrorException, UndeclaredIdentifierException, 
			ParseException, IDDeclaredTwiceException, 
			IOException, InterruptedException;
	
	static String getExpectedTestBoolConstFalse() {
		writeToToken("false");
		return "false";
	}

	@Test
	void testDefBool() 
			throws TypeErrorException, UndeclaredIdentifierException, 
			ParseException, IDDeclaredTwiceException,
			IOException, InterruptedException;
	
	static String getExpectedTestDefBool() {
		writeToToken("def x = true in x end");
		return "true";
	}

	@Test
	void testAttrBool() 
			throws TypeErrorException, UndeclaredIdentifierException, 
			ParseException, IDDeclaredTwiceException,
			IOException, InterruptedException;
	
	static String getExpectedTestAttrBool() {
		writeToToken("def x = new true in !x end");
		return "true";
	}

	@Test
	void testTrueEqualityInteger()
			throws TypeErrorException, UndeclaredIdentifierException,
			ParseException, IDDeclaredTwiceException,
			IOException, InterruptedException;

	static String getExpectedTestTrueEqualityInteger() {
		int num = new Random().nextInt(MAX_RAND);
        String exp = String.format("%d == %d", num, num);
        writeToToken(exp);
        return "true";
	}

	@Test
	void testFalseEqualityInteger() 
			throws TypeErrorException, UndeclaredIdentifierException,
			ParseException, IDDeclaredTwiceException,
			IOException, InterruptedException;
	
	static String getExpectedTestFalseEqualityInteger() {
		Random r = new Random();
        int n1 = r.nextInt(MAX_RAND), n2 = r.nextInt(MAX_RAND);
        String exp = String.format("%d == %d", n1, n2);
        writeToToken(exp);
        return String.valueOf(n1 == n2);
	}

	@Test
	void testTrueEqualityBool() 
			throws TypeErrorException, UndeclaredIdentifierException,
			ParseException, IDDeclaredTwiceException, 
			IOException, InterruptedException;
	
	static String getExpectedTestTrueEqualityBool() {
        writeToToken("true == true");
        return "true";
	}

	@Test
	void testFalseEqualityBool()
			throws TypeErrorException, UndeclaredIdentifierException, 
			ParseException, IDDeclaredTwiceException, 
			IOException, InterruptedException;
	
	static String getExpectedTestFalseEqualityBool() {
		writeToToken("true == false");
		return "false";
	}

	@Test
	void testDefEquality()
			throws TypeErrorException, UndeclaredIdentifierException,
			ParseException, IDDeclaredTwiceException,
			IOException, InterruptedException;
	
	static String getExpectedTestDefEquality() {
		int num = new Random().nextInt(MAX_RAND);
        String exp = String.format("def x = %d == %d in x end", num, num);
        writeToToken(exp);
        return "true";
	}

	@Test
	void testAttrEquality() 
			throws TypeErrorException, UndeclaredIdentifierException, 
			ParseException, IDDeclaredTwiceException, 
			IOException, InterruptedException;
	
	static String getExpectedTestAttrEquality() {
		int num = new Random().nextInt(MAX_RAND);
        String exp = String.format("def x = new false in x := %d == %d end", num, num);
        writeToToken(exp);
        return "true";
	}

	@Test
	void testGreaterTrue() 
			throws TypeErrorException, UndeclaredIdentifierException, 
			ParseException, IDDeclaredTwiceException,
			IOException, InterruptedException;
	
	static String getExpectedTestGreaterTrue() {
		writeToToken("100 > 10");
		return "true";
	}

	@Test
	void testGreaterFalse()
			throws TypeErrorException, UndeclaredIdentifierException,
			ParseException, IDDeclaredTwiceException, 
			IOException, InterruptedException;
	
	static String getExpectedTestGreaterFalse() {
		writeToToken("10 > 100");
		return "false";
	}

	@Test
	void testGreaterComplex() 
			throws TypeErrorException, UndeclaredIdentifierException, 
			ParseException, IDDeclaredTwiceException, 
			IOException, InterruptedException;
	
	static String getExpectedTestGreaterComplex() {
		Random r = new Random();
        int x1 = r.nextInt(MAX_RAND), x2 = r.nextInt(MAX_RAND);
        String exp = String.format("def x = new %d in !x > (x := !x - %d) end", x1, x2);
        writeToToken(exp);
        return "true";
	}

	@Test
	void testGreaterDef() 
			throws TypeErrorException, UndeclaredIdentifierException, 
			ParseException, IDDeclaredTwiceException, 
			IOException, InterruptedException;
	
	static String getExpectedTestGreaterDef() {
		Random r = new Random();
        int n1 = r.nextInt(MAX_RAND), n2 = r.nextInt(MAX_RAND);
        String exp = String.format("def x = %d > %d in x end", n1, n2);
        writeToToken(exp);
        return String.valueOf(n1 > n2);
	}

	@Test
	void testGreaterAttr()
			throws TypeErrorException, UndeclaredIdentifierException,
			ParseException, IDDeclaredTwiceException,
			IOException, InterruptedException;
	
	static String getExpectedTestGreaterAttr() {
		Random r = new Random();
        int n1 = r.nextInt(MAX_RAND), n2 = r.nextInt(MAX_RAND);
        String exp = String.format("def x = new false in x := %d > %d end", n1, n2);
        writeToToken(exp);
        return String.valueOf(n1 > n2);
	}

	@Test
	void testGreaterEqBigger() 
			throws TypeErrorException, UndeclaredIdentifierException, 
			ParseException, IDDeclaredTwiceException, 
			IOException, InterruptedException;
	
	static String getExpectedTestGreaterEqBigger() {
		writeToToken("100 >= 10");
		return "true";
	}

	@Test
	void testGreaterEqSame() 
			throws TypeErrorException, UndeclaredIdentifierException, 
			ParseException, IDDeclaredTwiceException,
			IOException, InterruptedException;
	
	static String getExpectedTestGreaterEqSame() {
		writeToToken("100 >= 100");
		return "true";
	}

	@Test
	void testGreaterEqSmaller()
			throws TypeErrorException, UndeclaredIdentifierException, 
			ParseException, IDDeclaredTwiceException, 
			IOException, InterruptedException;
	
	static String getExpectedTestGreaterEqSmaller() {
		writeToToken("10 >= 100");
		return "false";
	}

	@Test
	void testGreaterEqComplex() 
			throws TypeErrorException, UndeclaredIdentifierException, 
			ParseException, IDDeclaredTwiceException, 
			IOException, InterruptedException;
	
	static String getExpectedTestGreaterEqComplex() {
		int num = new Random().nextInt(MAX_RAND);
        String exp = String.format("def x = new %d in !x >= (x := %d) end", num, num);
        writeToToken(exp);
        return "true";
	}

	@Test
	void testGreaterEqDef() 
			throws TypeErrorException, UndeclaredIdentifierException, 
			ParseException, IDDeclaredTwiceException, 
			IOException, InterruptedException;
	
	static String getExpectedTestGreaterEqDef() {
		Random r = new Random();
        int n1 = r.nextInt(MAX_RAND), n2 = r.nextInt(MAX_RAND);
        String exp = String.format("def x = %d >= %d in x end", n1, n2);
        writeToToken(exp);
        return String.valueOf(n1 >= n2);
	}

	@Test
	void testGreaterEqAttr() 
			throws TypeErrorException, UndeclaredIdentifierException, 
			ParseException, IDDeclaredTwiceException,
			IOException, InterruptedException;
	
	static String getExpectedTestGreaterEqAttr() {
		Random r = new Random();
        int n1 = r.nextInt(MAX_RAND), n2 = r.nextInt(MAX_RAND);
        String exp = String.format("def x = new false in x := %d >= %d end", n1, n2);
        writeToToken(exp);
        return String.valueOf(n1 >= n2);
	}

	@Test
	void testSmallerWhenBigger()
			throws TypeErrorException, UndeclaredIdentifierException, 
			ParseException, IDDeclaredTwiceException, 
			IOException, InterruptedException;
	
	static String getExpectedTestSmallerWhenBigger() {
		writeToToken("100 < 10");
		return "false";
	}

	@Test
	void testSmallerWhenEquals() 
			throws TypeErrorException, UndeclaredIdentifierException, 
			ParseException, IDDeclaredTwiceException, 
			IOException, InterruptedException;
	
	static String getExpectedTestSmallerWhenEquals() {
		writeToToken("100 < 100");
		return "false";
	}

	@Test
	void testSmallerWhenSmaller()
			throws TypeErrorException, UndeclaredIdentifierException, 
			ParseException, IDDeclaredTwiceException, 
			IOException, InterruptedException;
	
	static String getExpectedTestSmallerWhenSmaller() {
		writeToToken("10 < 100");
		return "true";
	}

	@Test
	void testSmallerComplex() 
			throws TypeErrorException, UndeclaredIdentifierException, 
			ParseException, IDDeclaredTwiceException,
			IOException, InterruptedException;
	
	static String getExpectedTestSmallerComplex() {
		Random r = new Random();
        int x1 = r.nextInt(MAX_RAND), x2 = r.nextInt(MAX_RAND);
        String exp = String.format("def x = new %d in !x < (x := !x + %d) end", x1, x2);
        writeToToken(exp);
        return "true";
	}

	@Test
	void testSmallerDef() 
			throws TypeErrorException, UndeclaredIdentifierException,
			ParseException, IDDeclaredTwiceException, 
			IOException, InterruptedException;
	
	static String getExpectedTestSmallerDef() {
		Random r = new Random();
        int n1 = r.nextInt(MAX_RAND), n2 = r.nextInt(MAX_RAND);
        String exp = String.format("def x = %d < %d in x end", n1, n2);
        writeToToken(exp);
        return String.valueOf(n1 < n2);
	}

	@Test
	void testSmallerAttr() 
			throws TypeErrorException, UndeclaredIdentifierException, 
			ParseException, IDDeclaredTwiceException,
			IOException, InterruptedException;
	
	static String getExpectedTestSmallerAttr() {
		int n1 = 100, n2 = 10;
        String exp = String.format("def x = new false in x := %d < %d end", n1, n2);
        writeToToken(exp);
        return "false";
	}

	@Test
	void testSmallerEqWhenBigger()
			throws TypeErrorException, UndeclaredIdentifierException, 
			ParseException, IDDeclaredTwiceException,
			IOException, InterruptedException;
	
	static String getExpectedTestSmallerEqWhenBigger() {
		writeToToken("100 <= 10");
		return "false";
	}

	@Test
	void testSmallerEqWhenSame() 
			throws TypeErrorException, UndeclaredIdentifierException, 
			ParseException, IDDeclaredTwiceException, 
			IOException, InterruptedException;
	
	static String getExpectedTestSmallerEqWhenSame() {
        writeToToken("100 <= 100");
        return "true";
	}

	@Test
	void testSmallerEqWhenSmaller()
            throws TypeErrorException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException,
            IOException, InterruptedException;
	
	static String getExpectedTestSmallerEqWhenSmaller() {
		writeToToken("10 <= 100");
		return "true";
	}

	@Test
	void testSmallerEqComplex()
            throws TypeErrorException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException, 
            IOException, InterruptedException;
	
	static String getExpectedTestSmallerEqComplex() {
		int num = new Random().nextInt(MAX_RAND);
        String exp = String.format("def x = new %d in !x <= (x := %d) end", num, num);
        writeToToken(exp);
        return "true";
	}

	@Test
	void testSmallerEqDef()
            throws TypeErrorException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException, 
            IOException, InterruptedException;
	
	static String getExpectedTestSmallerEqDef() {
		Random r = new Random();
        int n1 = r.nextInt(MAX_RAND), n2 = r.nextInt(MAX_RAND);
        String exp = String.format("def x = %d <= %d in x end", n1, n2);
        writeToToken(exp);
        return String.valueOf(n1 <= n2);
	}

	@Test
	void testSmallerEqAttr()
            throws TypeErrorException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException, 
            IOException, InterruptedException;
	
	static String getExpectedTestSmallerEqAttr() {
		Random r = new Random();
        int n1 = r.nextInt(MAX_RAND), n2 = r.nextInt(MAX_RAND);
        String exp = String.format("def x = new false in x := %d < %d end", n1, n2);
        writeToToken(exp);
        return String.valueOf(n1 < n2);
	}
	
}
