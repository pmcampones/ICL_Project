package tests.interpreter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import dataTypes.TypeErrorException;
import environment.exceptions.*;
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
            UndeclaredIdentifierException, TypeErrorException, NotEnoughArgumentsException {
        assertEquals(getExpectedTestNumber(), run());
    }

	@Override
    @Test
    public void testSum()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException, NotEnoughArgumentsException {
        assertEquals(getExpectedTestSum(), run());
    }

	@Override
    @Test
    public void testSub()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException, NotEnoughArgumentsException {
        assertEquals(getExpectedTestSub(), run());
    }

	@Override
    @Test
    public void testMult()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException, NotEnoughArgumentsException {
        assertEquals(getExpectedTestMult(), run());
    }

	@Override
    @Test
    public void testDiv()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException, NotEnoughArgumentsException {
        assertEquals(getExpectedTestDiv(), run());
    }

	@Override
    @Test
    public void testManySums()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException, NotEnoughArgumentsException {
        assertEquals(getExpectedTestManySums(), run());
    }

	@Override
    @Test
    public void testManySubs()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException, NotEnoughArgumentsException {
        assertEquals(getExpectedTestManySubs(), run());
    }

	@Override
    @Test
    public void testManyMults()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException, NotEnoughArgumentsException {
        assertEquals(getExpectedTestManyMults(), run());
    }

	@Override
    @Test
    public void testManyDivs()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException, NotEnoughArgumentsException {
        assertEquals(getExpectedTestManyDivs(), run());
    }

	@Override
    @Test
    public void testBrackets()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException, NotEnoughArgumentsException {
        assertEquals(getExpectedTestBrackets(), run());
    }

	@Override
    @Test
    public void testBracketsSum()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException, NotEnoughArgumentsException {
        assertEquals(getExpectedTestBracketsSum(), run());
    }

	@Override
    @Test
    public void testSumsAndMultBrackets()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException, NotEnoughArgumentsException {
        assertEquals(getExpectedTestSumsAndMultsBrackets(), run());
    }

	@Override
    @Test
    public void testMinusSingle()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException, NotEnoughArgumentsException {
        assertEquals(getExpectedTestMinusSingle(), run());
    }

	@Override
    @Test
    public void testMinusTwo()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException, NotEnoughArgumentsException {
        assertEquals(getExpectedTestMinusTwo(), run());
    }

	@Override
    @Test
    public void testMinusExpression()
            throws ParseException, IDDeclaredTwiceException,
            UndeclaredIdentifierException, TypeErrorException, NotEnoughArgumentsException {
        assertEquals(getExpectedTestMinusExpression(), run());
    }

}
