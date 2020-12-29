package tests.interpreter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static tests.SemicolonOpTester.getExpectedTestArithmeticSeq;
import static tests.SemicolonOpTester.getExpectedTestAritmeticSeq2;
import static tests.SemicolonOpTester.getExpectedTestBracketsSeq;
import static tests.SemicolonOpTester.getExpectedTestChangeVarScope;
import static tests.SemicolonOpTester.getExpectedTestDefSeq;
import static tests.SemicolonOpTester.getExpectedTestDoubleFramesSameScopeSeq;
import static tests.SemicolonOpTester.getExpectedTestMultipleSemicolonsBegin;
import static tests.SemicolonOpTester.getExpectedTestMultipleSemicolonsEnd;
import static tests.SemicolonOpTester.getExpectedTestMultipleSemicolonsMiddle;
import static tests.SemicolonOpTester.getExpectedTestNewSeq;
import static tests.SemicolonOpTester.getExpectedTestNewSeq2;
import static tests.SemicolonOpTester.getExpectedTestTripleAritmeticSeq;
import static tests.SemicolonOpTester.getExpectedTestVariableDifferentSemicolon;

import org.junit.jupiter.api.Test;

import dataTypes.TypeErrorException;
import environment.exceptions.IDDeclaredTwiceException;
import environment.exceptions.UndeclaredIdentifierException;
import parser.ParseException;
import tests.SemicolonOpTester;

/**
 * MIEI
 * 
 * @author Ana Josefa Matos - 49938
 * @author Pedro Campon�s - 50051
 **/

public class SemicolonInterpreterTester extends InterpreterTester implements SemicolonOpTester{

	@Override
	@Test
	public void testArithmeticSeq()
			throws ParseException, IDDeclaredTwiceException,
			UndeclaredIdentifierException, TypeErrorException {
		assertEquals(getExpectedTestArithmeticSeq(), run());
	}

	@Override
	@Test
	public void testAritmeticSeq2()
			throws ParseException, IDDeclaredTwiceException, 
			UndeclaredIdentifierException, TypeErrorException {
		assertEquals(getExpectedTestAritmeticSeq2(), run());
	}

	@Override
	@Test
	public void testTripleAritmeticSeq()
			throws ParseException, IDDeclaredTwiceException, 
			UndeclaredIdentifierException, TypeErrorException {
		assertEquals(getExpectedTestTripleAritmeticSeq(), run());
	}

	@Override
	@Test
	public void testBracketsSeq()
			throws ParseException, IDDeclaredTwiceException,
			UndeclaredIdentifierException, TypeErrorException {
		assertEquals(getExpectedTestBracketsSeq(), run());
	}

	@Override
	@Test
	public void testDefSeq()
			throws ParseException, IDDeclaredTwiceException, 
			UndeclaredIdentifierException, TypeErrorException {
		assertEquals(getExpectedTestDefSeq(), run());
	}

	@Override
	@Test
	public void testDoubleFramesSameScopeSeq()
			throws ParseException, IDDeclaredTwiceException, 
			UndeclaredIdentifierException, TypeErrorException {
		assertEquals(getExpectedTestDoubleFramesSameScopeSeq(), run());
	}
	
	@Override
	@Test
    public void testNewSeq()
            throws TypeErrorException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        assertEquals(getExpectedTestNewSeq(), run());
    }
    
	@Override
	@Test
    public void testNewSeq2()
            throws TypeErrorException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        assertEquals(getExpectedTestNewSeq2(), run());
    }
    
	@Override
	@Test
    public void testMultipleSemicolonsBegin()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException {
        assertEquals(getExpectedTestMultipleSemicolonsBegin(), run());
    }

	@Override
	@Test
    public void testMultipleSemicolonsEnd()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException {
        assertEquals(getExpectedTestMultipleSemicolonsEnd(), run());
    }
    
	@Override
	@Test
	public void testMultipleSemicolonsMiddle()
			throws ParseException, IDDeclaredTwiceException, 
			UndeclaredIdentifierException, TypeErrorException {
		assertEquals(getExpectedTestMultipleSemicolonsMiddle(), run());
	}

	@Override
	@Test
	public void testVariableDifferentSemicolon()
			throws TypeErrorException, UndeclaredIdentifierException,
			ParseException, IDDeclaredTwiceException {
		assertEquals(getExpectedTestVariableDifferentSemicolon(), run());
	}

	@Override
	@Test
	public void testChangeVarScope()
			throws TypeErrorException, UndeclaredIdentifierException,
			ParseException, IDDeclaredTwiceException {
		assertEquals(getExpectedTestChangeVarScope(), run());
	}

}