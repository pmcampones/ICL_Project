package tests.interpreter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static tests.IfThenElseOpTester.*;

import org.junit.jupiter.api.Test;

import dataTypes.TypeErrorException;
import environment.exceptions.*;
import parser.ParseException;
import tests.IfThenElseOpTester;

/**
* MIEI
* @author Ana Josefa Matos - 49938
* @author Pedro Campones - 50051
**/

public class IfThenElseOpInterpreterTester extends InterpreterTester implements IfThenElseOpTester {

	@Override
    @Test
    public void testSimpleExpressionTrue()
            throws TypeErrorException, NotEnoughArgumentsException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        assertEquals(getExpectedTestSimpleExpressionTrue(), run());
    }

	@Override
    @Test
    public void testSimpleExpressionFalse()
            throws TypeErrorException, NotEnoughArgumentsException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        assertEquals(getExpectedTestSimpleExpressionFalse(), run());
    }

	@Override
    @Test
    public void testElseExpressionTrue()
            throws TypeErrorException, NotEnoughArgumentsException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        assertEquals(getExpectedTestElseExpressionTrue(), run());
    }

	@Override
    @Test
    public void testElseExpressionFalse()
            throws TypeErrorException, NotEnoughArgumentsException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        assertEquals(getExpectedTestElseExpressionFalse(), run());
    }

	@Override
    @Test
    public void testExpressionScopeIf()
            throws TypeErrorException, NotEnoughArgumentsException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        assertEquals(getExpectedTestExpressionScopeIf(), run());
    }

	@Override
    @Test
    public void testRunningExpressionIf()
            throws TypeErrorException, NotEnoughArgumentsException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        assertEquals(getExpectedTestRunningExpressionIf(), run());
    }

}
