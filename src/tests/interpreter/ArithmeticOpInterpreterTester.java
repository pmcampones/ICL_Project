package tests.interpreter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import dataTypes.TypeErrorException;
import environment.exceptions.IDDeclaredTwiceException;
import environment.exceptions.UndeclaredIdentifierException;
import parser.ParseException;
import tests.ArithmeticOpTester;

import static tests.ArithmeticOpTester.*;

/**
* MIEI
* @author Ana Josefa Matos - 49938
* @author Pedro Campon�s - 50051
**/
public class ArithmeticOpInterpreterTester extends InterpreterTester implements ArithmeticOpTester {

	@Override
    @Test
    public void testNumber()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException {
        assertEquals(getExpectedTestNumber(), run());
    }

	@Override
    @Test
    public void testSum()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException {
        assertEquals(getExpectedTestSum(), run());
    }

	@Override
    @Test
    public void testSub()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException {
        assertEquals(getExpectedTestSub(), run());
    }

	@Override
    @Test
    public void testMult()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException {
        assertEquals(getExpectedTestMult(), run());
    }

	@Override
    @Test
    public void testDiv()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException {
        assertEquals(getExpectedTestDiv(), run());
    }

	@Override
    @Test
    public void testManySums()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException {
        assertEquals(getExpectedTestManySums(), run());
    }

	@Override
    @Test
    public void testManySubs()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException {
        assertEquals(getExpectedTestManySubs(), run());
    }

	@Override
    @Test
    public void testManyMults()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException {
        assertEquals(getExpectedTestManyMults(), run());
    }

	@Override
    @Test
    public void testManyDivs()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException {
        assertEquals(getExpectedTestManyDivs(), run());
    }

	@Override
    @Test
    public void testBrackets()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException {
        assertEquals(getExpectedTestBrackets(), run());
    }

	@Override
    @Test
    public void testBracketsSum()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException {
        assertEquals(getExpectedTestBracketsSum(), run());
    }

	@Override
    @Test
    public void testSumsAndMultBrackets()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException {
        assertEquals(getExpectedTestSumsAndMultsBrackets(), run());
    }

	@Override
    @Test
    public void testMinusSingle()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException {
        assertEquals(getExpectedTestMinusSingle(), run());
    }

	@Override
    @Test
    public void testMinusTwo()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException {
        assertEquals(getExpectedTestMinusTwo(), run());
    }

	@Override
    @Test
    public void testMinusExpression()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException {
        assertEquals(getExpectedTestMinusExpression(), run());
    }

}
