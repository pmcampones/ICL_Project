package tests.interpreter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static tests.StaticTypecheckerOpTester.getExpectedTestChainedTypes;
import static tests.StaticTypecheckerOpTester.getExpectedTestDifferentScopesStatic;
import static tests.StaticTypecheckerOpTester.getExpectedTestDifferentScopesStaticAndDynamic;
import static tests.StaticTypecheckerOpTester.getExpectedTestSeveralExp;
import static tests.StaticTypecheckerOpTester.getExpectedTestSimpleBoolExp;
import static tests.StaticTypecheckerOpTester.getExpectedTestSimpleIntExp;
import static tests.StaticTypecheckerOpTester.getExpectedTestSimpleRefExp;
import static tests.StaticTypecheckerOpTester.getExpectedTestStaticAndDynamic;

import org.junit.jupiter.api.Test;

import dataTypes.TypeErrorException;
import environment.exceptions.IDDeclaredTwiceException;
import environment.exceptions.UndeclaredIdentifierException;
import parser.ParseException;
import tests.StaticTypecheckerOpTester;

public class StaticTypecheckerOpInterpreterTester extends InterpreterTester implements StaticTypecheckerOpTester {

	@Override
    @Test
    public void testSimpleIntExp()
            throws TypeErrorException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        assertEquals(getExpectedTestSimpleIntExp(), run());
    }

	@Override
    @Test
    public void testSimpleBoolExp()
            throws TypeErrorException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        assertEquals(getExpectedTestSimpleBoolExp(), run());
    }

	@Override
    @Test
    public void testSimpleRefExp()
            throws TypeErrorException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        assertEquals(getExpectedTestSimpleRefExp(), run());
    }

	@Override
    @Test
    public void testSeveralExp()
            throws TypeErrorException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        assertEquals(getExpectedTestSeveralExp(), run());
    }

	@Override
    @Test
    public void testChainedTypes()
            throws TypeErrorException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        assertEquals(getExpectedTestChainedTypes(), run());
    }

	@Override
    @Test
    public void testStaticAndDynamic()
            throws TypeErrorException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        assertEquals(getExpectedTestStaticAndDynamic(), run());
    }

	@Override
    @Test
    public void testDifferentScopesStatic()
            throws TypeErrorException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        assertEquals(getExpectedTestDifferentScopesStatic(), run());
    }

	@Override
    @Test
    public void testDifferentScopesStaticAndDynamic()
            throws TypeErrorException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        assertEquals(getExpectedTestDifferentScopesStaticAndDynamic(), run());
    }

}
