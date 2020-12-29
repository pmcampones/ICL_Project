package tests.interpreter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static tests.IfThenElseOpTester.getExpectedTestElseExpressionFalse;
import static tests.IfThenElseOpTester.getExpectedTestElseExpressionTrue;
import static tests.IfThenElseOpTester.getExpectedTestExpressionScopeIf;
import static tests.IfThenElseOpTester.getExpectedTestRunningExpressionIf;
import static tests.IfThenElseOpTester.getExpectedTestSimpleExpressionFalse;
import static tests.IfThenElseOpTester.getExpectedTestSimpleExpressionTrue;

import org.junit.jupiter.api.Test;

import dataTypes.TypeErrorException;
import environment.exceptions.IDDeclaredTwiceException;
import environment.exceptions.UndeclaredIdentifierException;
import parser.ParseException;
import tests.IfThenElseOpTester;

public class IfThenElseOpInterpreterTester extends InterpreterTester implements IfThenElseOpTester {

	@Override
    @Test
    public void testSimpleExpressionTrue()
            throws TypeErrorException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        assertEquals(getExpectedTestSimpleExpressionTrue(), run());
    }

	@Override
    @Test
    public void testSimpleExpressionFalse()
            throws TypeErrorException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        assertEquals(getExpectedTestSimpleExpressionFalse(), run());
    }

	@Override
    @Test
    public void testElseExpressionTrue()
            throws TypeErrorException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        assertEquals(getExpectedTestElseExpressionTrue(), run());
    }

	@Override
    @Test
    public void testElseExpressionFalse()
            throws TypeErrorException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        assertEquals(getExpectedTestElseExpressionFalse(), run());
    }

	@Override
    @Test
    public void testExpressionScopeIf()
            throws TypeErrorException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        assertEquals(getExpectedTestExpressionScopeIf(), run());
    }

	@Override
    @Test
    public void testRunningExpressionIf()
            throws TypeErrorException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        assertEquals(getExpectedTestRunningExpressionIf(), run());
    }

}
