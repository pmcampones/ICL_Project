package tests.interpreter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static tests.AttrOpTester.*;

import org.junit.jupiter.api.Test;

import dataTypes.TypeErrorException;
import environment.exceptions.*;
import parser.ParseException;
import tests.AttrOpTester;

public class AttrInterpreterOpTester extends InterpreterTester implements AttrOpTester {

	@Override
    @Test
    public void testSimpleAttr()
            throws TypeErrorException, NotEnoughArgumentsException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        assertEquals(getExpectedTestSimpleAttr(), run());
    }

	@Override
    @Test
    public void testAttrSum()
            throws TypeErrorException, NotEnoughArgumentsException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        assertEquals(getExpectedTestAttrSum(), run());
    }

	@Override
    @Test
    public void testAttrTerm()
            throws TypeErrorException, NotEnoughArgumentsException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        assertEquals(getExpectedTestAttrTerm(), run());
    }

	@Override
    @Test
    public void testAttrExpressionAfter()
            throws TypeErrorException, NotEnoughArgumentsException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        assertEquals(getExpectedTestAttrExpressionAfter(), run());
    }

	@Override
    @Test
    public void testNestedAttr()
            throws TypeErrorException, NotEnoughArgumentsException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        assertEquals(getExpectedTestNestedAttr(), run());
    }

	@Override
    @Test
    public void testIdentity()
            throws TypeErrorException, NotEnoughArgumentsException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        assertEquals(getExpectedTestIdentity(), run());
    }

	@Override
    @Test
    public void testNestedWithExpression()
            throws TypeErrorException, NotEnoughArgumentsException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        assertEquals(getExpectedTestNestedWithExpression(), run());
    }

	@Override
    @Test
    public void testMutabilityOrder()
            throws TypeErrorException, NotEnoughArgumentsException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        assertEquals(getExpectedTestMutabilityOrder(), run());
    }

}
