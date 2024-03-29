package tests.interpreter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static tests.NewOpTester.*;

import org.junit.jupiter.api.Test;

import dataTypes.TypeErrorException;
import environment.exceptions.*;
import parser.ParseException;
import tests.NewOpTester;

/**
* MIEI
* @author Ana Josefa Matos - 49938
* @author Pedro Campones - 50051
**/

public class NewOpInterpreterTester extends InterpreterTester implements NewOpTester{

	@Override
    @Test
    public void testNewVarTestNotUsing()
            throws TypeErrorException, NotEnoughArgumentsException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        assertEquals(getExpectedTestNewVarTestNotUsing(), run());
    }

	@Override
    @Test
    public void testNewVarUsing()
            throws TypeErrorException, NotEnoughArgumentsException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        assertEquals(getExpectedTestNewVarUsing(), run());
    }
	
	@Override
    @Test
    public void testNewNoDef()
            throws TypeErrorException, NotEnoughArgumentsException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        assertEquals(getExpectedTestNewNoDef(), run());
    }

	@Override
    @Test
    public void testNewComplexExpression() 
    		throws TypeErrorException, NotEnoughArgumentsException, UndeclaredIdentifierException, 
    		ParseException, IDDeclaredTwiceException {
        assertEquals(getExpectedTestNewComplexExpression(), run());
    }

	@Override
    @Test
    public void testNewSums()
            throws TypeErrorException, NotEnoughArgumentsException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        assertEquals(getExpectedTestNewSums(), run());
    }

	@Override
    @Test
    public void testSumNewVarFirst()
            throws TypeErrorException, NotEnoughArgumentsException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        assertEquals(getExpectedTestSumNewVarFirst(), run());
    }

	@Override
    @Test
    public void testSumNewVarBoth()
            throws TypeErrorException, NotEnoughArgumentsException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        assertEquals(getExpectedTestSumNewVarBoth(), run());
    }

	@Override
    @Test
    public void testRedefineNew()
            throws TypeErrorException, NotEnoughArgumentsException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        assertEquals(getExpectedTestRedefineNew(), run());
    }

	@Override
    @Test
    public void testAlias()
            throws TypeErrorException, NotEnoughArgumentsException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        assertEquals(getExpectedTestAlias(), run());
    }
}
