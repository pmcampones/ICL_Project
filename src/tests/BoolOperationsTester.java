package tests;

import static tests.GenericTester.MAX_RAND;
import static tests.GenericTester.writeToToken;

import java.io.IOException;
import java.util.Random;

import dataTypes.TypeErrorException;
import environment.exceptions.IDDeclaredTwiceException;
import environment.exceptions.UndeclaredIdentifierException;
import parser.ParseException;

public interface BoolOperationsTester {
	
	void testBoolConstTrue() 
			throws TypeErrorException, UndeclaredIdentifierException, 
			ParseException, IDDeclaredTwiceException,
			IOException, InterruptedException;
	
	static String getExpectedTestBoolConstTrue() {
		writeToToken("true");
		return "true";
	}
	
	void testBoolConstFalse()
			throws TypeErrorException, UndeclaredIdentifierException, 
			ParseException, IDDeclaredTwiceException, 
			IOException, InterruptedException;
	
	static String getExpectedTestBoolConstFalse() {
		writeToToken("false");
		return "false";
	}
	
	void testDefBool() 
			throws TypeErrorException, UndeclaredIdentifierException, 
			ParseException, IDDeclaredTwiceException,
			IOException, InterruptedException;
	
	static String getExpectedTestDefBool() {
		writeToToken("def x = true in x end");
		return "true";
	}

	void testAttrBool() 
			throws TypeErrorException, UndeclaredIdentifierException, 
			ParseException, IDDeclaredTwiceException,
			IOException, InterruptedException;
	
	static String getExpectedTestAttrBool() {
		writeToToken("def x = new true in !x end");
		return "true";
	}
	
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
	
	void testTrueEqualityBool() 
			throws TypeErrorException, UndeclaredIdentifierException,
			ParseException, IDDeclaredTwiceException, 
			IOException, InterruptedException;
	
	static String getExpectedTestTrueEqualityBool() {
        writeToToken("true == true");
        return "true";
	}
	
	void testFalseEqualityBool()
			throws TypeErrorException, UndeclaredIdentifierException, 
			ParseException, IDDeclaredTwiceException, 
			IOException, InterruptedException;
	
	static String getExpectedTestFalseEqualityBool() {
		writeToToken("true == false");
		return "false";
	}
	
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
	
	void testGreaterTrue() 
			throws TypeErrorException, UndeclaredIdentifierException, 
			ParseException, IDDeclaredTwiceException,
			IOException, InterruptedException;
	
	static String getExpectedTestGreaterTrue() {
		writeToToken("100 > 10");
		return "true";
	}
	
	void testGreaterFalse()
			throws TypeErrorException, UndeclaredIdentifierException,
			ParseException, IDDeclaredTwiceException, 
			IOException, InterruptedException;
	
	static String getExpectedTestGreaterFalse() {
		writeToToken("10 > 100");
		return "false";
	}
	
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
	
	void testGreaterEqBigger() 
			throws TypeErrorException, UndeclaredIdentifierException, 
			ParseException, IDDeclaredTwiceException, 
			IOException, InterruptedException;
	
	static String getExpectedTestGreaterEqBigger() {
		writeToToken("100 >= 10");
		return "true";
	}
	
	void testGreaterEqSame() 
			throws TypeErrorException, UndeclaredIdentifierException, 
			ParseException, IDDeclaredTwiceException,
			IOException, InterruptedException;
	
	static String getExpectedTestGreaterEqSame() {
		writeToToken("100 >= 100");
		return "true";
	}
	
	void testGreaterEqSmaller()
			throws TypeErrorException, UndeclaredIdentifierException, 
			ParseException, IDDeclaredTwiceException, 
			IOException, InterruptedException;
	
	static String getExpectedTestGreaterEqSmaller() {
		writeToToken("10 >= 100");
		return "false";
	}
	
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
	
	void testSmallerWhenBigger()
			throws TypeErrorException, UndeclaredIdentifierException, 
			ParseException, IDDeclaredTwiceException, 
			IOException, InterruptedException;
	
	static String getExpectedTestSmallerWhenBigger() {
		writeToToken("100 < 10");
		return "false";
	}
	
	void testSmallerWhenEquals() 
			throws TypeErrorException, UndeclaredIdentifierException, 
			ParseException, IDDeclaredTwiceException, 
			IOException, InterruptedException;
	
	static String getExpectedTestSmallerWhenEquals() {
		writeToToken("100 < 100");
		return "false";
	}
	
	void testSmallerWhenSmaller()
			throws TypeErrorException, UndeclaredIdentifierException, 
			ParseException, IDDeclaredTwiceException, 
			IOException, InterruptedException;
	
	static String getExpectedTestSmallerWhenSmaller() {
		writeToToken("10 < 100");
		return "true";
	}
	
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
	
	void testSmallerAttr() 
			throws TypeErrorException, UndeclaredIdentifierException, 
			ParseException, IDDeclaredTwiceException,
			IOException, InterruptedException;
	
	static String getExpectedTestSmallerAttr() {
		int n1 = 100, n2 = 10;
        String exp = String.format("def x = new false in x := %d < %d end", n1, n2);
        writeToToken(exp);
        return String.valueOf(n1 < n2);
	}
	
	void testSmallerEqWhenBigger()
			throws TypeErrorException, UndeclaredIdentifierException, 
			ParseException, IDDeclaredTwiceException,
			IOException, InterruptedException;
	
	static String getExpectedTestSmallerEqWhenBigger() {
		writeToToken("100 <= 10");
		return "false";
	}
	
	void testSmallerEqWhenSame() 
			throws TypeErrorException, UndeclaredIdentifierException, 
			ParseException, IDDeclaredTwiceException, 
			IOException, InterruptedException;
	
	static String getExpectedTestSmallerEqWhenSame() {
        writeToToken("100 <= 100");
        return "true";
	}
	
	void testSmallerEqWhenSmaller()
            throws TypeErrorException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException,
            IOException, InterruptedException;
	
	static String getExpectedTestSmallerEqWhenSmaller() {
		writeToToken("10 <= 100");
		return "true";
	}
	
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
