package tests;

import java.io.IOException;
import java.util.Random;

import org.junit.jupiter.api.Test;

import dataTypes.TypeErrorException;
import environment.exceptions.*;
import parser.ParseException;

import static tests.GenericTester.MAX_RAND;
import static tests.GenericTester.writeToToken;

/**
* MIEI
* @author Ana Josefa Matos - 49938
* @author Pedro Campones - 50051
**/

public interface AttrOpTester {
	
	@Test
	void testSimpleAttr()
            throws TypeErrorException, NotEnoughArgumentsException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException, 
            IOException, InterruptedException;
	
	static String getExpectedTestSimpleAttr() {
		int num = new Random().nextInt(MAX_RAND);
        String exp = String.format("def x = new 5 in x := %d end", num);
        writeToToken(exp);
        return String.valueOf(num);
	}
	
	@Test
	void testAttrSum()
            throws TypeErrorException, NotEnoughArgumentsException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException, 
            IOException, InterruptedException;
	
	static String getExpectedTestAttrSum() {
		Random r = new Random();
        int num1 = r.nextInt(MAX_RAND), num2 = r.nextInt(MAX_RAND);
        String exp = String.format("def x = new %d in !x + (x := %d) end", num1, num2);
        writeToToken(exp);
        return String.valueOf(num1 + num2);
	}
	
	@Test
	void testAttrTerm()
            throws TypeErrorException, NotEnoughArgumentsException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException,
            IOException, InterruptedException;
	
	static String getExpectedTestAttrTerm() {
		Random r = new Random();
        int num1 = r.nextInt(MAX_RAND), num2 = r.nextInt(MAX_RAND);
        String exp = String.format("def x = new %d in !x * (x := %d) end", num1, num2);
        writeToToken(exp);
        return String.valueOf(num1 * num2);
	}
	
	@Test
	void testAttrExpressionAfter()
			throws TypeErrorException, NotEnoughArgumentsException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException,
            IOException, InterruptedException;
	
	static String getExpectedTestAttrExpressionAfter() {
		Random r = new Random();
        int num1 = r.nextInt(MAX_RAND), num2 = r.nextInt(MAX_RAND);
        String exp = String.format("def x = new %d in !x + (x := !x + def y = %d in !x * y end) end", num1, num2);
        writeToToken(exp);
        return String.valueOf(num1 + (num1 + num1 * num2));
	}

	@Test
	void testNestedAttr()
			throws TypeErrorException, NotEnoughArgumentsException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException,
            IOException, InterruptedException;
	
	static String getExpectedTestNestedAttr() {
		Random r = new Random();
        int num1 = r.nextInt(MAX_RAND), num2 = r.nextInt(MAX_RAND);
        String exp = String.format("def x = new %d in x := !x + (x := %d) end", num1, num2);
        writeToToken(exp);
        return String.valueOf(num1 + num2);
	}
	
	@Test
	void testIdentity()
			throws TypeErrorException, NotEnoughArgumentsException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException,
            IOException, InterruptedException;
	
	static String getExpectedTestIdentity() {
		int num = new Random().nextInt(MAX_RAND);
        String exp = String.format("def x = new %d in x := !x end", num);
        writeToToken(exp);
        return String.valueOf(num);
	}
	
	@Test
	void testNestedWithExpression()
			throws TypeErrorException, NotEnoughArgumentsException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException,
            IOException, InterruptedException;
	
	static String getExpectedTestNestedWithExpression() {
		Random r = new Random();
        int x1 = r.nextInt(MAX_RAND), x2 = r.nextInt(MAX_RAND);
        int y = r.nextInt(MAX_RAND);
        String exp = String.format("def x = new %d y = new %d in x := !x + (y := !y + (x := !x + (y := !x * !y + def x = %d in x * !y end))) end", x1, y, x2);
        writeToToken(exp);
        int fourthY = x1 * y + x2 * y;
        int thirdX = x1 + fourthY;
        int secondY = y + thirdX;
        int secondX = x1 + secondY;
        return String.valueOf(secondX);
	}
	
	@Test
	void testMutabilityOrder()
			throws TypeErrorException, NotEnoughArgumentsException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException,
            IOException, InterruptedException;
	
	static String getExpectedTestMutabilityOrder() {
		Random r = new Random();
        int num1 = r.nextInt(MAX_RAND), num2 = r.nextInt(MAX_RAND);
        String exp = String.format("def x = new %d in !x + (x := %d) + !x end", num1, num2);
        writeToToken(exp);
        return String.valueOf(num1 + num2 + num2);
	}
	
}
