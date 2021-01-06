package tests;

import java.io.IOException;
import java.util.Random;

import org.junit.jupiter.api.Test;

import dataTypes.TypeErrorException;
import environment.exceptions.*;
import parser.ParseException;

import static tests.GenericTester.MAX_RAND;
import static tests.GenericTester.writeToToken;

public interface NewOpTester {
	
	@Test
	void testNewVarTestNotUsing()
            throws TypeErrorException, NotEnoughArgumentsException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException, 
            IOException, InterruptedException;
	
	static String getExpectedTestNewVarTestNotUsing() {
		int number = new Random().nextInt(MAX_RAND);
        String exp = String.format("def x = new 5 in %d end", number);
        writeToToken(exp);
        return String.valueOf(number);
	}
	
	@Test
	void testNewVarUsing()
            throws TypeErrorException, NotEnoughArgumentsException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException,
            IOException, InterruptedException;
	
	static String getExpectedTestNewVarUsing() {
		int number = new Random().nextInt(MAX_RAND);
        String exp = String.format("def x = new %d in !x end", number);
        writeToToken(exp);
        return String.valueOf(number);
	}
	
	@Test
	void testNewNoDef()
            throws TypeErrorException, NotEnoughArgumentsException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException, 
            IOException, InterruptedException;
	
	static String getExpectedTestNewNoDef() {
		int number = new Random().nextInt(MAX_RAND);
        String exp = String.format("!new %d", number);
        writeToToken(exp);
        return String.valueOf(number);
	}

	@Test
	void testNewComplexExpression() 
    		throws TypeErrorException, NotEnoughArgumentsException, UndeclaredIdentifierException, 
    		ParseException, IDDeclaredTwiceException, 
    		IOException, InterruptedException;
	
	static String getExpectedTestNewComplexExpression() {
		Random r = new Random();
        int x = r.nextInt(MAX_RAND), y = r.nextInt(MAX_RAND);
        String exp = String.format("!new def x = %d y = %d in y + def x = x + y in x * y end + x end", x, y);
        writeToToken(exp);
        return String.valueOf(y + (x + y) * y + x);
	}
	
	@Test
	void testNewSums()
            throws TypeErrorException, NotEnoughArgumentsException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException, 
            IOException, InterruptedException;
	
	static String getExpectedTestNewSums() {
		Random r = new Random();
        int num1 = r.nextInt(MAX_RAND), num2 = r.nextInt(MAX_RAND);
        String exp = String.format("!new !new %d + !new %d", num1, num2);
        writeToToken(exp);
        return String.valueOf(num1 + num2);
	}
	
	@Test
	void testSumNewVarFirst()
            throws TypeErrorException, NotEnoughArgumentsException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException,
            IOException, InterruptedException;
	
	static String getExpectedTestSumNewVarFirst() {
		Random r = new Random();
        int x = r.nextInt(MAX_RAND), y = r.nextInt(MAX_RAND);
        String exp = String.format("def x = new %d in !x + !new %d end", x, y);
        writeToToken(exp);
        return String.valueOf(x + y);
	}
	
	@Test
	void testSumNewVarBoth()
            throws TypeErrorException, NotEnoughArgumentsException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException,
            IOException, InterruptedException;
	
	static String getExpectedTestSumNewVarBoth() {
		Random r = new Random();
        int x = r.nextInt(MAX_RAND), y = r.nextInt(MAX_RAND);
        String exp = String.format("def x = new %d y = new %d in !x + !y end", x, y);
        writeToToken(exp);
        return String.valueOf(x + y);
	}
	
	@Test
	void testRedefineNew()
            throws TypeErrorException, NotEnoughArgumentsException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException,
            IOException, InterruptedException;
	
	static String getExpectedTestRedefineNew() {
		Random r = new Random();
        int x = r.nextInt(MAX_RAND), y = r.nextInt(MAX_RAND);
        String exp = String.format("def x = new %d y = new %d in !x + !y + def x = new !x + !y in !x * !y end end"
                , x, y);
        writeToToken(exp);
        return String.valueOf(x + y + (x + y) * y);
	}
	
	@Test
	void testAlias()
            throws TypeErrorException, NotEnoughArgumentsException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException, 
            IOException, InterruptedException;
	
	static String getExpectedTestAlias() {
		Random r = new Random();
        int num1 = r.nextInt(MAX_RAND), num2 = r.nextInt(MAX_RAND);
        String exp = String.format("def x = new %d y = x in def x = %d in x + !y end end", num1, num2);
        writeToToken(exp);
        return String.valueOf(num1 + num2);
	}
	
}
