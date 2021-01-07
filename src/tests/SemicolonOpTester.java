package tests;

import java.io.IOException;
import java.util.Random;

import org.junit.jupiter.api.Test;

import dataTypes.TypeErrorException;
import environment.exceptions.IDDeclaredTwiceException;
import environment.exceptions.UndeclaredIdentifierException;
import parser.ParseException;

import static tests.GenericTester.MAX_RAND;
import static tests.GenericTester.writeToToken;

public interface SemicolonOpTester {
	
	@Test
	void testArithmeticSeq()
			throws ParseException, IDDeclaredTwiceException,
			UndeclaredIdentifierException, TypeErrorException, 
			IOException, InterruptedException;
	
	static String getExpectedTestArithmeticSeq() {
		Random r = new Random();
		int first = r.nextInt(MAX_RAND), second = r.nextInt(MAX_RAND);
		String exp = String.format("%d - %d;%d + %d", first, second, first, second);
		writeToToken(exp);
		return String.valueOf(first + second);
	}

	@Test
	void testAritmeticSeq2()
			throws ParseException, IDDeclaredTwiceException,
			UndeclaredIdentifierException, TypeErrorException, 
			IOException, InterruptedException;
	
	static String getExpectedTestAritmeticSeq2() {
		Random r = new Random();
		int first = r.nextInt(MAX_RAND), second = r.nextInt(MAX_RAND);
		int third = r.nextInt(MAX_RAND), fourth = r.nextInt(MAX_RAND);
		String exp = String.format("%d - %d;%d * %d", first, second, third, fourth);
		writeToToken(exp);
		return String.valueOf(third * fourth);
	}
	
	@Test
	void testTripleAritmeticSeq()
			throws ParseException, IDDeclaredTwiceException,
			UndeclaredIdentifierException, TypeErrorException, 
			IOException, InterruptedException;
	
	static String getExpectedTestTripleAritmeticSeq() {
		Random r = new Random();
		int first = r.nextInt(MAX_RAND), second = r.nextInt(MAX_RAND);
		int third = r.nextInt(MAX_RAND), fourth = r.nextInt(MAX_RAND);
		int fifth = r.nextInt(MAX_RAND), sixth = r.nextInt(MAX_RAND);
		String exp = String.format("%d - %d;%d + %d;%d - %d", first, second, third, fourth, fifth, sixth);
		writeToToken(exp);
		return String.valueOf(fifth - sixth);
	}
	
	@Test
	void testBracketsSeq()
			throws ParseException, IDDeclaredTwiceException,
			UndeclaredIdentifierException, TypeErrorException, 
			IOException, InterruptedException;
	
	static String getExpectedTestBracketsSeq() {
		String exp = "2 * (3 + 4 * (5 + 6) - 1 * (2)); 5 * (4 - 6 * (9 + 1) - 3 * (0))";
		int val = 5 * (4 - 6 * (9 + 1) - 3 * (0));
		writeToToken(exp);
		return String.valueOf(val);
	}
	
	@Test
	void testDefSeq()
			throws ParseException, IDDeclaredTwiceException,
			UndeclaredIdentifierException, TypeErrorException, 
			IOException, InterruptedException;
	
	static String getExpectedTestDefSeq() {
		Random r = new Random();
		int attr = r.nextInt(MAX_RAND);
		int attr1 = r.nextInt(MAX_RAND), attr2 = r.nextInt(MAX_RAND);
		int[] nums = new int[3];
		for (int i = 0; i < nums.length; i++)
			nums[i] = r.nextInt(MAX_RAND);
		String exp = String.format(
				"def x = %d in def y = %d in x * (-y + x) end end; def x = %d in %d * (-x + %d * (x - %d)) end", attr1,
				attr2, attr, nums[0], nums[1], nums[2]);
		writeToToken(exp);
		int expected = nums[0] * (-attr + nums[1] * (attr - nums[2]));
		return String.valueOf(expected);
	}
	
	@Test
	void testDoubleFramesSameScopeSeq()
			throws ParseException, IDDeclaredTwiceException,
			UndeclaredIdentifierException, TypeErrorException, 
			IOException, InterruptedException;
	
	static String getExpectedTestDoubleFramesSameScopeSeq() {
		Random r = new Random();
		int first = r.nextInt(MAX_RAND), second = r.nextInt(MAX_RAND), third = r.nextInt(MAX_RAND);
		String exp = String.format(
				"(%d + %d) / %d; 4 + def x = 2 y = x + 1 in x + y + def z = x + y in 2 * z end + def w = x - y in w + 2 end end",
				first, second, third);
		writeToToken(exp);
		return "20";
	}
	
	@Test
	void testNewSeq()
			throws ParseException, IDDeclaredTwiceException,
			UndeclaredIdentifierException, TypeErrorException, 
			IOException, InterruptedException;
	
	static String getExpectedTestNewSeq() {
		int number = new Random().nextInt(MAX_RAND);
        int number1 = new Random().nextInt(MAX_RAND);
        String exp = String.format("def x = new 5 in %d end;def x = new %d in !x end", number, number1);
        writeToToken(exp);
        return String.valueOf(number1);
	}
	
	@Test
	void testNewSeq2()
			throws ParseException, IDDeclaredTwiceException,
			UndeclaredIdentifierException, TypeErrorException, 
			IOException, InterruptedException;
	
	static String getExpectedTestNewSeq2() {
		Random r = new Random();
        int x = r.nextInt(MAX_RAND), y = r.nextInt(MAX_RAND);
        int z = r.nextInt(MAX_RAND);
        String exp = String.format("def x = new %d in !x end;def x = new %d y = new %d in !x + !y + def x = new !x + !y in !x * !y end end"
                ,z, x, y);
        writeToToken(exp);
        return String.valueOf(x + y + (x + y) * y);
	}
	
	@Test
	void testMultipleSemicolonsBegin()
			throws ParseException, IDDeclaredTwiceException,
			UndeclaredIdentifierException, TypeErrorException, 
			IOException, InterruptedException;
	
	static String getExpectedTestMultipleSemicolonsBegin() {
        int number = new Random().nextInt(MAX_RAND);
        writeToToken(String.format(";;;;;;;;;;;%d", number));
        return String.valueOf(number);
	}
	
	@Test
	void testMultipleSemicolonsEnd()
			throws ParseException, IDDeclaredTwiceException,
			UndeclaredIdentifierException, TypeErrorException, 
			IOException, InterruptedException;
	
	static String getExpectedTestMultipleSemicolonsEnd() {
        int number = new Random().nextInt(MAX_RAND);
        writeToToken(String.format("%d;;;;;;;;;;;", number));
        return String.valueOf(number);
	}
	
	@Test
	void testMultipleSemicolonsMiddle()
			throws ParseException, IDDeclaredTwiceException,
			UndeclaredIdentifierException, TypeErrorException, 
			IOException, InterruptedException;
	
	static String getExpectedTestMultipleSemicolonsMiddle() {
		Random r = new Random();
		int first = r.nextInt(MAX_RAND), second = r.nextInt(MAX_RAND);
		String exp = String.format("%d - %d;;;;;;;;;;;;%d + %d", first, second, first, second);
		writeToToken(exp);
		return String.valueOf(first + second);
	}
	
	@Test
	void testVariableDifferentSemicolon()
			throws ParseException, IDDeclaredTwiceException,
			UndeclaredIdentifierException, TypeErrorException, 
			IOException, InterruptedException;
	
	static String getExpectedTestVariableDifferentSemicolon() {
		Random r = new Random();
		int x1 = r.nextInt(MAX_RAND), x2 = r.nextInt(MAX_RAND);
		int num = r.nextInt(MAX_RAND);
		String exp = String.format("def x = new %d in x := (!x + %d); !x + %d end",
				x1, x2, num);
		writeToToken(exp);
		return String.valueOf(x1 + x2 + num);
	}
	
	@Test
	void testChangeVarScope()
			throws ParseException, IDDeclaredTwiceException,
			UndeclaredIdentifierException, TypeErrorException, 
			IOException, InterruptedException;
	
	static String getExpectedTestChangeVarScope() {
		Random r = new Random();
		int x1 = r.nextInt(MAX_RAND), x2 = r.nextInt(MAX_RAND);
		String exp = String.format("def x = %d in def x = %d in x end; x end", x1, x2);
		writeToToken(exp);
		return String.valueOf(x1);
	}
	
}
