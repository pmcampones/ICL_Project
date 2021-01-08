package tests.interpreter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static tests.StaticTypecheckerOpTester.*;

import org.junit.jupiter.api.Test;

import dataTypes.TypeErrorException;
import environment.exceptions.*;
import parser.ParseException;
import tests.StaticTypecheckerOpTester;

/**
* MIEI
* @author Ana Josefa Matos - 49938
* @author Pedro Campones - 50051
**/

public class StaticTypecheckerOpInterpreterTester extends InterpreterTester implements StaticTypecheckerOpTester {

	@Override
    @Test
    public void testSimpleIntExp()
            throws TypeErrorException, NotEnoughArgumentsException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        assertEquals(getExpectedTestSimpleIntExp(), run());
    }

	@Override
    @Test
    public void testSimpleBoolExp()
            throws TypeErrorException, NotEnoughArgumentsException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        assertEquals(getExpectedTestSimpleBoolExp(), run());
    }

	@Override
    @Test
    public void testSimpleRefExp()
            throws TypeErrorException, NotEnoughArgumentsException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        assertEquals(getExpectedTestSimpleRefExp(), run());
    }

	@Override
    @Test
    public void testSeveralExp()
            throws TypeErrorException, NotEnoughArgumentsException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        assertEquals(getExpectedTestSeveralExp(), run());
    }

	@Override
    @Test
    public void testChainedTypes()
            throws TypeErrorException, NotEnoughArgumentsException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        assertEquals(getExpectedTestChainedTypes(), run());
    }

	@Override
    @Test
    public void testStaticAndDynamic()
            throws TypeErrorException, NotEnoughArgumentsException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        assertEquals(getExpectedTestStaticAndDynamic(), run());
    }

	@Override
    @Test
    public void testDifferentScopesStatic()
            throws TypeErrorException, NotEnoughArgumentsException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        assertEquals(getExpectedTestDifferentScopesStatic(), run());
    }

	@Override
    @Test
    public void testDifferentScopesStaticAndDynamic()
            throws TypeErrorException, NotEnoughArgumentsException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        assertEquals(getExpectedTestDifferentScopesStaticAndDynamic(), run());
    }

}
