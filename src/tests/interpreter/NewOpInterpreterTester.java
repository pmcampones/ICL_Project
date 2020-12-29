package tests.interpreter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static tests.NewOpTester.getExpectedTestAlias;
import static tests.NewOpTester.getExpectedTestNewComplexExpression;
import static tests.NewOpTester.getExpectedTestNewNoDef;
import static tests.NewOpTester.getExpectedTestNewSums;
import static tests.NewOpTester.getExpectedTestNewVarTestNotUsing;
import static tests.NewOpTester.getExpectedTestNewVarUsing;
import static tests.NewOpTester.getExpectedTestRedefineNew;
import static tests.NewOpTester.getExpectedTestSumNewVarBoth;
import static tests.NewOpTester.getExpectedTestSumNewVarFirst;

import org.junit.jupiter.api.Test;

import dataTypes.TypeErrorException;
import environment.exceptions.IDDeclaredTwiceException;
import environment.exceptions.UndeclaredIdentifierException;
import parser.ParseException;
import tests.NewOpTester;

public class NewOpInterpreterTester extends InterpreterTester implements NewOpTester{

	@Override
    @Test
    public void testNewVarTestNotUsing()
            throws TypeErrorException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        assertEquals(getExpectedTestNewVarTestNotUsing(), run());
    }

	@Override
    @Test
    public void testNewVarUsing()
            throws TypeErrorException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        assertEquals(getExpectedTestNewVarUsing(), run());
    }
	
	@Override
    @Test
    public void testNewNoDef()
            throws TypeErrorException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        assertEquals(getExpectedTestNewNoDef(), run());
    }

	@Override
    @Test
    public void testNewComplexExpression() 
    		throws TypeErrorException, UndeclaredIdentifierException, 
    		ParseException, IDDeclaredTwiceException {
        assertEquals(getExpectedTestNewComplexExpression(), run());
    }

	@Override
    @Test
    public void testNewSums()
            throws TypeErrorException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        assertEquals(getExpectedTestNewSums(), run());
    }

	@Override
    @Test
    public void testSumNewVarFirst()
            throws TypeErrorException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        assertEquals(getExpectedTestSumNewVarFirst(), run());
    }

	@Override
    @Test
    public void testSumNewVarBoth()
            throws TypeErrorException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        assertEquals(getExpectedTestSumNewVarBoth(), run());
    }

	@Override
    @Test
    public void testRedefineNew()
            throws TypeErrorException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        assertEquals(getExpectedTestRedefineNew(), run());
    }

	@Override
    @Test
    public void testAlias()
            throws TypeErrorException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        assertEquals(getExpectedTestAlias(), run());
    }
}
