package tests.interpreter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static tests.BoolOpTester.*;

import java.util.Random;

import org.junit.jupiter.api.Test;

import dataTypes.TypeErrorException;
import environment.exceptions.*;
import parser.ParseException;
import tests.BoolOpTester;

/**
* MIEI
* @author Ana Josefa Matos - 49938
* @author Pedro Campones - 50051
**/

public class BoolOpInterpreterTester extends InterpreterTester implements BoolOpTester {

	@Override
    @Test
    public void testBoolConstTrue()
            throws TypeErrorException, NotEnoughArgumentsException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        assertEquals(getExpectedTestBoolConstTrue(), run());
    }

	@Override
    @Test
    public void testBoolConstFalse()
            throws TypeErrorException, NotEnoughArgumentsException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        assertEquals(getExpectedTestBoolConstFalse(), run());
    }

	@Override
    @Test
    public void testDefBool()
            throws TypeErrorException, NotEnoughArgumentsException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        assertEquals(getExpectedTestDefBool(), run());
    }

	@Override
    @Test
    public void testAttrBool() 
    		throws TypeErrorException, NotEnoughArgumentsException, UndeclaredIdentifierException, 
    		ParseException, IDDeclaredTwiceException {
        assertEquals(getExpectedTestAttrBool(), run());
    }

	@Override
    @Test
    public void testTrueEqualityInteger()
            throws TypeErrorException, NotEnoughArgumentsException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        assertEquals(getExpectedTestTrueEqualityInteger(), run());
    }

	@Override
    @Test
    public void testFalseEqualityInteger()
            throws TypeErrorException, NotEnoughArgumentsException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        assertEquals(getExpectedTestFalseEqualityInteger(), run());
    }

	@Override
    @Test
    public void testTrueEqualityBool()
            throws TypeErrorException, NotEnoughArgumentsException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        assertEquals(getExpectedTestTrueEqualityBool(), run());
    }

	@Override
    @Test
    public void testFalseEqualityBool()
            throws TypeErrorException, NotEnoughArgumentsException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        assertEquals(getExpectedTestFalseEqualityBool(), run());
    }

	@Override
    @Test
    public void testDefEquality()
            throws TypeErrorException, NotEnoughArgumentsException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        assertEquals(getExpectedTestDefEquality(), run());
    }

	@Override
    @Test
    public void testAttrEquality()
            throws TypeErrorException, NotEnoughArgumentsException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        assertEquals(getExpectedTestAttrEquality(), run());
    }

	@Override
    @Test
    public void testGreaterTrue()
            throws TypeErrorException, NotEnoughArgumentsException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        assertEquals(getExpectedTestGreaterTrue(), run());
    }

	@Override
    @Test
    public void testGreaterFalse()
            throws TypeErrorException, NotEnoughArgumentsException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        assertEquals(getExpectedTestGreaterFalse(), run());
    }

	@Override
    @Test
    public void testGreaterComplex()
            throws TypeErrorException, NotEnoughArgumentsException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        assertEquals(getExpectedTestGreaterComplex(), run());
    }

	@Override
    @Test
    public void testGreaterDef()
            throws TypeErrorException, NotEnoughArgumentsException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        assertEquals(getExpectedTestGreaterDef(), run());
    }

	@Override
    @Test
    public void testGreaterAttr()
            throws TypeErrorException, NotEnoughArgumentsException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        Random r = new Random();
        int n1 = r.nextInt(MAX_RAND), n2 = r.nextInt(MAX_RAND);
        String exp = String.format("def x = new false in x := %d > %d end", n1, n2);
        writeToToken(exp);
        assertEquals(String.valueOf(n1 > n2), run());
    }

	@Override
    @Test
    public void testGreaterEqBigger()
            throws TypeErrorException, NotEnoughArgumentsException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        assertEquals(getExpectedTestGreaterEqBigger(), run());
    }

	@Override
    @Test
    public void testGreaterEqSame()
            throws TypeErrorException, NotEnoughArgumentsException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        assertEquals(getExpectedTestGreaterEqSame(), run());
    }

	@Override
    @Test
    public void testGreaterEqSmaller()
            throws TypeErrorException, NotEnoughArgumentsException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        assertEquals(getExpectedTestGreaterEqSmaller(), run());
    }

	@Override
    @Test
    public void testGreaterEqComplex()
            throws TypeErrorException, NotEnoughArgumentsException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        assertEquals(getExpectedTestGreaterEqComplex(), run());
    }

	@Override
    @Test
    public void testGreaterEqDef()
            throws TypeErrorException, NotEnoughArgumentsException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        assertEquals(getExpectedTestGreaterEqDef(), run());
    }

	@Override
    @Test
    public void testGreaterEqAttr()
            throws TypeErrorException, NotEnoughArgumentsException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        assertEquals(getExpectedTestGreaterEqAttr(), run());
    }

	@Override
    @Test
    public void testSmallerWhenBigger()
            throws TypeErrorException, NotEnoughArgumentsException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        assertEquals(getExpectedTestSmallerWhenBigger(), run());
    }

	@Override
    @Test
    public void testSmallerWhenEquals()
            throws TypeErrorException, NotEnoughArgumentsException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        assertEquals(getExpectedTestSmallerWhenEquals(), run());
    }
	
	@Override
	@Test
	public void testSmallerWhenSmaller() 
			throws ParseException, IDDeclaredTwiceException,
			UndeclaredIdentifierException, TypeErrorException, NotEnoughArgumentsException {
		assertEquals(getExpectedTestSmallerWhenSmaller(), run());
	}

	@Override
    @Test
    public void testSmallerComplex()
            throws TypeErrorException, NotEnoughArgumentsException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        assertEquals(getExpectedTestSmallerComplex(), run());
    }

	@Override
    @Test
    public void testSmallerDef()
            throws TypeErrorException, NotEnoughArgumentsException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        assertEquals(getExpectedTestSmallerDef(), run());
    }

	@Override
    @Test
    public void testSmallerAttr()
            throws TypeErrorException, NotEnoughArgumentsException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        assertEquals(getExpectedTestSmallerAttr(), run());
    }

	@Override
    @Test
    public void testSmallerEqWhenBigger()
            throws TypeErrorException, NotEnoughArgumentsException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        assertEquals(getExpectedTestSmallerEqWhenBigger(), run());
    }

	@Override
    @Test
    public void testSmallerEqWhenSame()
            throws TypeErrorException, NotEnoughArgumentsException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        assertEquals(getExpectedTestSmallerEqWhenSame(), run());
    }

	@Override
    @Test
    public void testSmallerEqWhenSmaller()
            throws TypeErrorException, NotEnoughArgumentsException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        assertEquals(getExpectedTestSmallerEqWhenSmaller(), run());
    }

	@Override
    @Test
    public void testSmallerEqComplex()
            throws TypeErrorException, NotEnoughArgumentsException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        assertEquals(getExpectedTestSmallerEqComplex(), run());
    }

	@Override
    @Test
    public void testSmallerEqDef()
            throws TypeErrorException, NotEnoughArgumentsException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        assertEquals(getExpectedTestSmallerEqDef(), run());
    }

	@Override
    @Test
    public void testSmallerEqAttr()
            throws TypeErrorException, NotEnoughArgumentsException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        assertEquals(getExpectedTestSmallerEqAttr(), run());
    }

}
