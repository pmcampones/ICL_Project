package tests;

import static tests.GenericTester.MAX_RAND;
import static tests.GenericTester.writeToToken;

import java.io.IOException;
import java.util.Random;

import org.junit.jupiter.api.Test;

import dataTypes.TypeErrorException;
import environment.exceptions.*;
import parser.ParseException;

/**
* MIEI
* @author Ana Josefa Matos - 49938
* @author Pedro Campones - 50051
**/

public interface IfThenElseOpTester {
	
	@Test
	void testSimpleExpressionTrue() 
			throws TypeErrorException, NotEnoughArgumentsException, UndeclaredIdentifierException, 
			ParseException, IDDeclaredTwiceException, 
			IOException, InterruptedException;
	
	static String getExpectedTestSimpleExpressionTrue() {
		int num = new Random().nextInt(MAX_RAND);
        String exp = String.format("def x = new 0 in if true then x := %d end; !x end", num);
        writeToToken(exp);
        return String.valueOf(num);
	}

	@Test
	void testSimpleExpressionFalse() 
			throws TypeErrorException, NotEnoughArgumentsException, UndeclaredIdentifierException, 
			ParseException, IDDeclaredTwiceException, 
			IOException, InterruptedException;
	
	static String getExpectedTestSimpleExpressionFalse() {
		int num = new Random().nextInt(MAX_RAND);
        String exp = String.format("def x = new 0 in if false then x := %d end; !x end", num);
        writeToToken(exp);
        return "0";
	}
	
	@Test
	void testElseExpressionTrue() 
			throws TypeErrorException, NotEnoughArgumentsException, UndeclaredIdentifierException, 
			ParseException, IDDeclaredTwiceException, 
			IOException, InterruptedException;
	
	static String getExpectedTestElseExpressionTrue() {
		Random r = new Random();
        int n1 = r.nextInt(MAX_RAND), n2 = r.nextInt(MAX_RAND);
        String exp = String.format("def x = new 0 in if true then x := %d else x := %d end; !x end", n1, n2);
        writeToToken(exp);
        return String.valueOf(n1);
	}
	
	@Test
	void testElseExpressionFalse() 
			throws TypeErrorException, NotEnoughArgumentsException, UndeclaredIdentifierException, 
			ParseException, IDDeclaredTwiceException, 
			IOException, InterruptedException;
	
	static String getExpectedTestElseExpressionFalse() {
		Random r = new Random();
        int n1 = r.nextInt(MAX_RAND), n2 = r.nextInt(MAX_RAND);
        String exp = String.format("def x = new 0 in if false then x := %d else x := %d end; !x end", n1, n2);
        writeToToken(exp);
        return String.valueOf(n2);
	}
	
	@Test
	void testExpressionScopeIf() 
			throws TypeErrorException, NotEnoughArgumentsException, UndeclaredIdentifierException, 
			ParseException, IDDeclaredTwiceException,
			IOException, InterruptedException;
	
	static String getExpectedTestExpressionScopeIf() {
		Random r = new Random();
        int n1 = r.nextInt(MAX_RAND), n2 = r.nextInt(MAX_RAND);
        int thenV = r.nextInt(MAX_RAND), elseV = r.nextInt(MAX_RAND);
        String exp = String.format("def x = new (%d < %d) y = new 2 in if !x then y := %d else y := %d end; !y + 1 end",
                n1, n2, thenV, elseV);
        writeToToken(exp);
        int val = n1 < n2 ? thenV + 1 : elseV + 1;
        return String.valueOf(val);
	}
	
	@Test
	void testRunningExpressionIf() 
			throws TypeErrorException, NotEnoughArgumentsException, UndeclaredIdentifierException, 
			ParseException, IDDeclaredTwiceException, 
			IOException, InterruptedException;
	
	static String getExpectedTestRunningExpressionIf() {
		int mid = MAX_RAND / 2;
        Random r = new Random();
        int ifVal = r.nextInt(MAX_RAND);
        int thenVal = r.nextInt(MAX_RAND), elseVal = r.nextInt(MAX_RAND);
        String exp = String.format("def x = new 0 in if %d < %d then x := %d else x := %d end; !x end", ifVal, mid, thenVal, elseVal);
        writeToToken(exp);
        return String.valueOf(ifVal < mid ? thenVal : elseVal);
	}
}
