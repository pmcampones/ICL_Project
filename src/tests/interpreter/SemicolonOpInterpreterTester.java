package tests.interpreter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static tests.SemicolonOpTester.*;

import org.junit.jupiter.api.Test;

import dataTypes.TypeErrorException;
import environment.exceptions.*;
import parser.ParseException;
import tests.SemicolonOpTester;

/**
 * MIEI
 * 
 * @author Ana Josefa Matos - 49938
 * @author Pedro Campon�s - 50051
 **/

public class SemicolonOpInterpreterTester extends InterpreterTester implements SemicolonOpTester{

	@Override
	@Test
	public void testArithmeticSeq()
			throws ParseException, IDDeclaredTwiceException,
			UndeclaredIdentifierException, TypeErrorException, NotEnoughArgumentsException {
		assertEquals(getExpectedTestArithmeticSeq(), run());
	}

	@Override
	@Test
	public void testAritmeticSeq2()
			throws ParseException, IDDeclaredTwiceException, 
			UndeclaredIdentifierException, TypeErrorException, NotEnoughArgumentsException {
		assertEquals(getExpectedTestAritmeticSeq2(), run());
	}

	@Override
	@Test
	public void testTripleAritmeticSeq()
			throws ParseException, IDDeclaredTwiceException, 
			UndeclaredIdentifierException, TypeErrorException, NotEnoughArgumentsException {
		assertEquals(getExpectedTestTripleAritmeticSeq(), run());
	}

	@Override
	@Test
	public void testBracketsSeq()
			throws ParseException, IDDeclaredTwiceException,
			UndeclaredIdentifierException, TypeErrorException, NotEnoughArgumentsException {
		assertEquals(getExpectedTestBracketsSeq(), run());
	}

	@Override
	@Test
	public void testDefSeq()
			throws ParseException, IDDeclaredTwiceException, 
			UndeclaredIdentifierException, TypeErrorException, NotEnoughArgumentsException {
		assertEquals(getExpectedTestDefSeq(), run());
	}

	@Override
	@Test
	public void testDoubleFramesSameScopeSeq()
			throws ParseException, IDDeclaredTwiceException, 
			UndeclaredIdentifierException, TypeErrorException, NotEnoughArgumentsException {
		assertEquals(getExpectedTestDoubleFramesSameScopeSeq(), run());
	}
	
	@Override
	@Test
    public void testNewSeq()
            throws TypeErrorException, NotEnoughArgumentsException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        assertEquals(getExpectedTestNewSeq(), run());
    }
    
	@Override
	@Test
    public void testNewSeq2()
            throws TypeErrorException, NotEnoughArgumentsException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        assertEquals(getExpectedTestNewSeq2(), run());
    }
    
	@Override
	@Test
    public void testMultipleSemicolonsBegin()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException, NotEnoughArgumentsException {
        assertEquals(getExpectedTestMultipleSemicolonsBegin(), run());
    }

	@Override
	@Test
    public void testMultipleSemicolonsEnd()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException, NotEnoughArgumentsException {
        assertEquals(getExpectedTestMultipleSemicolonsEnd(), run());
    }
    
	@Override
	@Test
	public void testMultipleSemicolonsMiddle()
			throws ParseException, IDDeclaredTwiceException, 
			UndeclaredIdentifierException, TypeErrorException, NotEnoughArgumentsException {
		assertEquals(getExpectedTestMultipleSemicolonsMiddle(), run());
	}

	@Override
	@Test
	public void testVariableDifferentSemicolon()
			throws TypeErrorException, NotEnoughArgumentsException, UndeclaredIdentifierException,
			ParseException, IDDeclaredTwiceException {
		assertEquals(getExpectedTestVariableDifferentSemicolon(), run());
	}

	@Override
	@Test
	public void testChangeVarScope()
			throws TypeErrorException, NotEnoughArgumentsException, UndeclaredIdentifierException,
			ParseException, IDDeclaredTwiceException {
		assertEquals(getExpectedTestChangeVarScope(), run());
	}

}