package tests.interpreter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static tests.AttrOpTester.getExpectedTestAttrExpressionAfter;
import static tests.AttrOpTester.getExpectedTestAttrSum;
import static tests.AttrOpTester.getExpectedTestAttrTerm;
import static tests.AttrOpTester.getExpectedTestIdentity;
import static tests.AttrOpTester.getExpectedTestMutabilityOrder;
import static tests.AttrOpTester.getExpectedTestNestedAttr;
import static tests.AttrOpTester.getExpectedTestNestedWithExpression;
import static tests.AttrOpTester.getExpectedTestSimpleAttr;

import org.junit.jupiter.api.Test;

import dataTypes.TypeErrorException;
import environment.exceptions.IDDeclaredTwiceException;
import environment.exceptions.UndeclaredIdentifierException;
import parser.ParseException;
import tests.AttrOpTester;

public class AttrInterpreterTester extends InterpreterTester implements AttrOpTester {

	@Override
    @Test
    public void testSimpleAttr()
            throws TypeErrorException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        assertEquals(getExpectedTestSimpleAttr(), run());
    }

	@Override
    @Test
    public void testAttrSum()
            throws TypeErrorException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        assertEquals(getExpectedTestAttrSum(), run());
    }

	@Override
    @Test
    public void testAttrTerm()
            throws TypeErrorException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        assertEquals(getExpectedTestAttrTerm(), run());
    }

	@Override
    @Test
    public void testAttrExpressionAfter()
            throws TypeErrorException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        assertEquals(getExpectedTestAttrExpressionAfter(), run());
    }

	@Override
    @Test
    public void testNestedAttr()
            throws TypeErrorException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        assertEquals(getExpectedTestNestedAttr(), run());
    }

	@Override
    @Test
    public void testIdentity()
            throws TypeErrorException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        assertEquals(getExpectedTestIdentity(), run());
    }

	@Override
    @Test
    public void testNestedWithExpression()
            throws TypeErrorException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        assertEquals(getExpectedTestNestedWithExpression(), run());
    }

	@Override
    @Test
    public void testMutabilityOrder()
            throws TypeErrorException, UndeclaredIdentifierException,
            ParseException, IDDeclaredTwiceException {
        assertEquals(getExpectedTestMutabilityOrder(), run());
    }

}
