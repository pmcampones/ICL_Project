package tests.interpreter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static tests.IfThenElseTester.getExpectedTestElseExpressionFalse;
import static tests.IfThenElseTester.getExpectedTestElseExpressionTrue;
import static tests.IfThenElseTester.getExpectedTestExpressionScopeIf;
import static tests.IfThenElseTester.getExpectedTestRunningExpressionIf;
import static tests.IfThenElseTester.getExpectedTestSimpleExpressionFalse;
import static tests.IfThenElseTester.getExpectedTestSimpleExpressionTrue;

import org.junit.jupiter.api.Test;

import dataTypes.TypeErrorException;
import environment.exceptions.IDDeclaredTwiceException;
import environment.exceptions.UndeclaredIdentifierException;
import parser.ParseException;
import tests.IfThenElseTester;

public class IfThenElseInterpreterTester extends InterpreterTester implements IfThenElseTester {

    @Test
    public void testSimpleExpressionTrue()
            throws TypeErrorException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        assertEquals(getExpectedTestSimpleExpressionTrue(), run());
    }

    @Test
    public void testSimpleExpressionFalse()
            throws TypeErrorException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        assertEquals(getExpectedTestSimpleExpressionFalse(), run());
    }

    @Test
    public void testElseExpressionTrue()
            throws TypeErrorException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        assertEquals(getExpectedTestElseExpressionTrue(), run());
    }

    @Test
    public void testElseExpressionFalse()
            throws TypeErrorException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        assertEquals(getExpectedTestElseExpressionFalse(), run());
    }

    @Test
    public void testExpressionScopeIf()
            throws TypeErrorException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        assertEquals(getExpectedTestExpressionScopeIf(), run());
    }

    @Test
    public void testRunningExpressionIf()
            throws TypeErrorException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        assertEquals(getExpectedTestRunningExpressionIf(), run());
    }

}
